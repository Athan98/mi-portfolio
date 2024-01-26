package quantumscript.facturacionelectronicaafip;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertStore;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.Base64;
import org.apache.axis.encoding.XMLType;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.swing.JOptionPane;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class afip_wsaa_client {

    // Método para invocar el servicio web de AFIP para obtener el ticket de acceso
    static String invoke_wsaa(byte[] LoginTicketRequest_xml_cms, String endpoint) throws Exception {
        String LoginTicketResponse = null;
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();

            // Configuración de la llamada al servicio web
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName("loginCms");
            call.addParameter("request", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);

            // Invocación del servicio web y asignación de la respuesta a una cadena
            LoginTicketResponse = (String) call.invoke(new Object[]{
                Base64.encode(LoginTicketRequest_xml_cms)});
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
        return LoginTicketResponse;
    }

    // Método para crear el mensaje CMS (Cryptographic Message Syntax)
    public static byte[] create_cms(String p12file, String p12pass, String signer, String dstDN, String service, Long TicketTime) {
        PrivateKey pKey = null;
        X509Certificate pCertificate = null;
        byte[] asn1_cms = null;
        CertStore cstore = null;
        String LoginTicketRequest_xml;
        String SignerDN = null;

        // Manejo de claves y certificados
        try {
            // Crear un almacén de claves (keystore) utilizando las claves del archivo p12
            KeyStore ks = KeyStore.getInstance("pkcs12");
            FileInputStream p12stream = new FileInputStream(p12file);
            ks.load(p12stream, p12pass.toCharArray());
            p12stream.close();

            // Obtener la clave privada y el certificado del almacén de claves
            pKey = (PrivateKey) ks.getKey(signer, p12pass.toCharArray());
            if (pKey == null) {
                System.err.println("La clave privada es nula.");
                return null;
            }

            pCertificate = (X509Certificate) ks.getCertificate(signer);
            if (pCertificate == null) {
                System.err.println("El certificado es nulo.");
                return null;
            }

            SignerDN = pCertificate.getSubjectDN().toString();

            // Crear una lista de certificados para incluir en el CMS final
            ArrayList<X509Certificate> certList = new ArrayList<X509Certificate>();
            certList.add(pCertificate);

            // Agregar el proveedor de seguridad Bouncy Castle si no está presente
            if (Security.getProvider("BC") == null) {
                Security.addProvider(new BouncyCastleProvider());
            }

            // Crear un almacén de certificados
            cstore = CertStore.getInstance("Collection", new CollectionCertStoreParameters(certList), "BC");
        } catch (Exception e) {
            // Manejo de excepciones
            System.err.println("Error al manejar claves y certificados: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        // Crear el mensaje XML
        LoginTicketRequest_xml = create_LoginTicketRequest(SignerDN, dstDN, service, TicketTime);

        // Crear el mensaje CMS
        try {
            CMSSignedDataGenerator gen = new CMSSignedDataGenerator();

            // Agregar un firmante al mensaje
            gen.addSigner(pKey, pCertificate, CMSSignedDataGenerator.DIGEST_SHA1);

            // Agregar el certificado al mensaje
            gen.addCertificatesAndCRLs(cstore);

            // Agregar los datos (XML) al mensaje
            CMSProcessable data = new CMSProcessableByteArray(LoginTicketRequest_xml.getBytes());

            // Agregar una firma a los datos del mensaje
            CMSSignedData signed = gen.generate(data, true, "BC");

            // Obtener la representación codificada del mensaje CMS
            asn1_cms = signed.getEncoded();
        } catch (Exception e) {
            // Manejo de excepciones
            System.err.println("Error al crear el mensaje CMS: " + e.getMessage());
            e.printStackTrace();
        }

        return asn1_cms;
    }

    // Método para crear el mensaje XML para el servicio web de AFIP
    public static String create_LoginTicketRequest(String SignerDN, String dstDN, String service, Long TicketTime) {
        String LoginTicketRequest_xml;

        try {
            // Obtener una instancia de DatatypeFactory para trabajar con fechas XML
            DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();

            // Obtener la fecha y hora actual
            Date genTime = new Date();
            GregorianCalendar genTimeCalendar = new GregorianCalendar();
            GregorianCalendar expTimeCalendar = new GregorianCalendar();
            String uniqueId = String.valueOf(genTime.getTime() / 1000);

            // Configurar la fecha de expiración del ticket
            expTimeCalendar.setTime(new Date(genTime.getTime() + TicketTime));

            // Crear objetos XMLGregorianCalendar para representar las fechas
            XMLGregorianCalendar xmlGenTime = datatypeFactory.newXMLGregorianCalendar(genTimeCalendar);
            XMLGregorianCalendar xmlExpTime = datatypeFactory.newXMLGregorianCalendar(expTimeCalendar);

            // Construir el mensaje XML para el servicio web de AFIP
            LoginTicketRequest_xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                    + "<loginTicketRequest version=\"1.0\">"
                    + "<header>"
                    + "<source>" + SignerDN + "</source>"
                    + "<destination>" + dstDN + "</destination>"
                    + "<uniqueId>" + uniqueId + "</uniqueId>"
                    + "<generationTime>" + xmlGenTime + "</generationTime>"
                    + "<expirationTime>" + xmlExpTime + "</expirationTime>"
                    + "</header>"
                    + "<service>" + service + "</service>"
                    + "</loginTicketRequest>";
            System.out.println("TRA: " + LoginTicketRequest_xml);
            return LoginTicketRequest_xml;
        } catch (Exception ex) {
            // Manejo de excepciones
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
        return null;
    }
}

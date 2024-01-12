package quantumscript.facturacionelectronicaafip;

import java.io.FileInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class wsaa_test_java {

    public static void main(String[] args) {
        String LoginTicketResponse = null;

        // Configuración del sistema para un entorno proxy y lectura de propiedades desde un archivo
        System.setProperty("http.proxyHost", "");
        System.setProperty("http.proxyPort", "80");
        Properties config = new Properties();

        try {
            config.load(new FileInputStream("./wsaa_client.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtener configuraciones desde el archivo de propiedades
        String endpoint = config.getProperty("endpoint", "http://wsaahomo.afip.gov.ar/ws/services/LoginCms");
        String service = config.getProperty("service", "test");
        String dstDN = config.getProperty("dstdn", "cn=wsaahomo,o=afip,c=ar,serialNumber=CUIT 33693450239");

        String p12file = config.getProperty("keystore", "Certificado.pfx");
        String signer = config.getProperty("keystore-signer", "nicolasroldan");
        String p12pass = config.getProperty("keystore-password", "123456");

        // Configuración del sistema para un entorno proxy
        System.setProperty("http.proxyHost", config.getProperty("http_proxy", ""));
        System.setProperty("http.proxyPort", config.getProperty("http_proxy_port", ""));
        System.setProperty("http.proxyUser", config.getProperty("http_proxy_user", ""));
        System.setProperty("http.proxyPassword", config.getProperty("http_proxy_password", ""));

        // Configuración del keystore utilizado por SSL
        System.setProperty("javax.net.ssl.trustStore", config.getProperty("trustStore", ""));
        System.setProperty("javax.net.ssl.trustStorePassword", config.getProperty("trustStore_password", ""));

        Long TicketTime = new Long(config.getProperty("TicketTime", "36000"));

        // Crear LoginTicketRequest_xml_cms
        byte[] LoginTicketRequest_xml_cms = afip_wsaa_client.create_cms(p12file, p12pass,
                signer, dstDN, service, TicketTime);

        // Invocar wsaa de AFIP y obtener LoginTicketResponse
        try {
            LoginTicketResponse = afip_wsaa_client.invoke_wsaa(LoginTicketRequest_xml_cms, endpoint);
        } catch (Exception e) {
            // Manejo de excepciones
            System.err.println("Error al invocar wsaa: " + e.getMessage());
            e.printStackTrace();
        }

        // Obtener token y firma desde LoginTicketResponse
        try {
            Reader tokenReader = new StringReader(LoginTicketResponse);
            Document tokenDoc = new SAXReader(false).read(tokenReader);

            String token = tokenDoc.valueOf("/loginTicketResponse/credentials/token");
            String sign = tokenDoc.valueOf("/loginTicketResponse/credentials/sign");

            System.out.println("TOKEN: " + token);
            System.out.println("SIGN: " + sign);
        } catch (Exception e) {
            // Manejo de excepciones
            System.out.println("Error al obtener token y firma: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

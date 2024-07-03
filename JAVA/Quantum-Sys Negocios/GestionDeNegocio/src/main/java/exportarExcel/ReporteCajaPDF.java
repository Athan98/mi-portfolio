package exportarExcel;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import frames.CerrarCaja;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ReporteCajaPDF {

    String fechaApertura;
    String fechaCierre;
    String caja;
    String usuario;
    String sucursal;
    String saldoApertura;
    String ingresos;
    String egresos;
    String ventas;
    String totalTeorico;
    String totalReal;
    String diferencia;

    String efectivo;
    String debito;
    String credito;
    String trans;
    String mp;
    String uala;
    String ctaCte;

    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;
    Paragraph subtitulo;

    private static String emailFrom = "quantumscript_negocios@outlook.com";
    private static String password = "ywddcqhawvvolqxr";
    private String subject;
    private String content;

    private Properties mProperties;
    private javax.mail.Session mSession;
    private MimeMessage mCorreo;

    private File mArchivoAdjunto;


    public ReporteCajaPDF(String fechaApertura, String fechaCierre, String caja, String usuario, String sucursal, String saldoApertura, String ingresos, String egresos, String ventas, String totalTeorico, String totalReal, String diferencia, String efectivo, String debito, String credito, String trans, String mp, String uala, String ctaCte) {
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.caja = caja;
        this.usuario = usuario;
        this.sucursal = sucursal;
        this.saldoApertura = saldoApertura;
        this.ingresos = ingresos;
        this.egresos = egresos;
        this.ventas = ventas;
        this.totalTeorico = totalTeorico;
        this.totalReal = totalReal;
        this.diferencia = diferencia;
        this.efectivo = efectivo;
        this.debito = debito;
        this.credito = credito;
        this.trans = trans;
        this.mp = mp;
        this.uala = uala;
        this.ctaCte = ctaCte;
        mProperties = new Properties();

        documento = new Document();
        titulo = new Paragraph("Reporte de caja", FontFactory.getFont(FontFactory.HELVETICA, 24));
        subtitulo = new Paragraph("Resumen formas de pago de las ventas diarias", FontFactory.getFont(FontFactory.HELVETICA, 18));
    }

    public void crearPlantilla() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setDialogTitle("Seleccionar carpeta de destino");

            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File carpetaDestino = chooser.getSelectedFile();

                String nombreArchivo = JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo", "Nombre del archivo", JOptionPane.PLAIN_MESSAGE);

                if (nombreArchivo != null && !nombreArchivo.isEmpty()) {
                    String rutaArchivoPDF = carpetaDestino.getAbsolutePath() + File.separator + nombreArchivo + ".pdf";

                    try (FileOutputStream archivo = new FileOutputStream(rutaArchivoPDF)) {
                        PdfWriter.getInstance(documento, archivo);
                        documento.open();

                        LineSeparator line = new LineSeparator();
                        titulo.setAlignment(Element.ALIGN_CENTER);
                        subtitulo.setAlignment(Element.ALIGN_CENTER);

                        documento.add(new Chunk(line));
                        documento.add(Chunk.NEWLINE);
                        documento.add(titulo);
                        documento.add(Chunk.NEWLINE);
                        documento.add(new Chunk(line));
                        documento.add(Chunk.NEWLINE);
                        documento.add(new Paragraph("Caja N°: " + caja));
                        documento.add(new Paragraph("Fecha y hora de apertura : " + fechaApertura));
                        documento.add(new Paragraph("Fecha y hora de cierre: " + fechaCierre));
                        documento.add(new Paragraph("Usuario: " + usuario));
                        documento.add(new Paragraph("Sucursal: " + sucursal));
                        documento.add(new Chunk(line));
                        documento.add(new Paragraph("Saldo apertura ($): " + saldoApertura));
                        documento.add(new Chunk(line));
                        documento.add(new Paragraph("Ingresos ($): " + ingresos));
                        documento.add(new Chunk(line));
                        documento.add(new Paragraph("Egresos ($): " + egresos));
                        documento.add(new Chunk(line));
                        documento.add(new Paragraph("Ventas ($): " + ventas));
                        documento.add(new Chunk(line));
                        documento.add(new Paragraph("Total teorico ($): " + totalTeorico));
                        documento.add(new Chunk(line));
                        documento.add(new Paragraph("Total real ($): " + totalReal));
                        documento.add(new Chunk(line));
                        documento.add(new Paragraph("Diferencia ($): " + diferencia));
                        documento.add(Chunk.NEWLINE);
                        documento.add(new Chunk(line));
                        documento.add(Chunk.NEWLINE);
                        documento.add(subtitulo);
                        documento.add(Chunk.NEWLINE);
                        documento.add(new Chunk(line));
                        documento.add(Chunk.NEWLINE);
                        documento.add(new Paragraph("Debito ($): " + debito));
                        documento.add(new Paragraph("Efectivo ($): " + efectivo));
                        documento.add(new Paragraph("Transferencia bancaria ($): " + trans));
                        documento.add(new Paragraph("Mercado pago ($): " + mp));
                        documento.add(new Paragraph("Ualá ($): " + uala));
                        documento.add(new Paragraph("Credito ($): " + credito));
                        documento.add(new Paragraph("Cuenta corriente ($): " + ctaCte));
                        documento.add(Chunk.NEWLINE);
                        documento.add(new Chunk(line));

                        documento.close();

                        mArchivoAdjunto = new File(rutaArchivoPDF);

                        JOptionPane.showMessageDialog(null, "Archivo PDF creado exitosamente en: " + rutaArchivoPDF);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de archivo válido.");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

    }

    public void crearEmail(String[] direccionesDestino) {
        try {
            Date fecha = new Date();

            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

            // Convertir la fecha a una cadena de texto
            String fechaFormateada = formato.format(fecha);

            subject = "Cierre de caja al " + fechaFormateada;
            content = "Se ha realizado el cierre de caja. Se adjunta PDF con un resumen. -QuantumSys: Negocios-";

            mProperties.put("mail.smtp.host", "smtp.office365.com");
            mProperties.put("mail.smtp.starttls.enable", "true");
            mProperties.put("mail.smtp.port", "587");

            // Configuración de las credenciales de Outlook
            mProperties.setProperty("mail.smtp.user", emailFrom);
            mProperties.setProperty("mail.smtp.password", password);
            mProperties.setProperty("mail.smtp.auth", "true");

            mSession = javax.mail.Session.getInstance(mProperties);

            MimeMultipart mElementoCorreo = new MimeMultipart();
            MimeBodyPart mContenido = new MimeBodyPart();
            mContenido.setContent(content, "text/html; charset=utf-8");
            mElementoCorreo.addBodyPart(mContenido);

            // Agregar archivos adjuntos
            MimeBodyPart mAdjunto = new MimeBodyPart();
            mAdjunto.setDataHandler(new DataHandler(new FileDataSource(mArchivoAdjunto.getAbsolutePath())));
            mAdjunto.setFileName(mArchivoAdjunto.getName());
            mElementoCorreo.addBodyPart(mAdjunto);

            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));

            // Agregar destinatarios
            InternetAddress[] recipientAddresses = new InternetAddress[direccionesDestino.length];
            for (int i = 0; i < direccionesDestino.length; i++) {
                recipientAddresses[i] = new InternetAddress(direccionesDestino[i]);
            }
            mCorreo.setRecipients(Message.RecipientType.TO, recipientAddresses);

            mCorreo.setSubject(subject);
            mCorreo.setContent(mElementoCorreo);

        } catch (AddressException ex) {
            Logger.getLogger(CerrarCaja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(CerrarCaja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void enviarEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, password);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(CerrarCaja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(CerrarCaja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

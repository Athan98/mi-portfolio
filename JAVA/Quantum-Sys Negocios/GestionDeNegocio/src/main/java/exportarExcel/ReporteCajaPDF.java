package exportarExcel;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.File;
import java.io.FileOutputStream;
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
}

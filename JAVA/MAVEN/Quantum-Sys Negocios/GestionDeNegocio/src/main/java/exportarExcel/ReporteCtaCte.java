package exportarExcel;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import entidades.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ReporteCtaCte {

    CuentaCorriente cc;
    List<DetallesCtaCte> detalles;
    Date fechaReporte = new Date();

    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;
    Paragraph subtitulo;

    public ReporteCtaCte(CuentaCorriente ctaCte, List<DetallesCtaCte> detalles) {
        this.cc = ctaCte;
        this.detalles = detalles;

        documento = new Document();
        titulo = new Paragraph("Reporte de Cuenta corriente", FontFactory.getFont(FontFactory.HELVETICA, 24));
        subtitulo = new Paragraph("-" + fechaReporte + "-", FontFactory.getFont(FontFactory.HELVETICA, 10));

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

                        documento.add(titulo);
                        documento.add(subtitulo);
                        documento.add(Chunk.NEWLINE);
                        documento.add(new Chunk(line));
                        documento.add(new Paragraph("Cliente : " + cc.getCliente().getNombre()));
                        documento.add(new Paragraph("C.U.I.T. / C.U.I.L. : " + cc.getCliente().getCuit_cuil()));
                        documento.add(new Paragraph("D.N.I. : " + cc.getCliente().getDni()));
                        documento.add(new Paragraph("Direccion: " + cc.getCliente().getDireccion()));
                        documento.add(new Paragraph("Cliente: " + cc.getCliente().getTelefono()));
                        documento.add(new Chunk(line));
                        documento.add(Chunk.NEWLINE);

                        PdfPTable tabla = new PdfPTable(3);
                        tabla.addCell("Fecha venta");
                        tabla.addCell("Monto venta ($)");
                        tabla.addCell("Vendedor");

                        for (int i = 0; i < detalles.size(); i++) {
                            tabla.addCell(detalles.get(i).getVenta().getFecha().toString());
                            tabla.addCell(detalles.get(i).getVenta().getPrecioTotalVenta() + "");
                            tabla.addCell(detalles.get(i).getVenta().getUsuario().getNombre());
                        }

                        documento.add(tabla);
                        documento.add(Chunk.NEWLINE);
                        documento.add(new Chunk(line));
                        documento.add(new Paragraph("ESTADO : " + cc.getEstado(), FontFactory.getFont(FontFactory.HELVETICA, 18)));
                        documento.add(new Paragraph("TOTAL ADEUDADO ($): " + cc.getMontoTotal(), FontFactory.getFont(FontFactory.HELVETICA, 18)));
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

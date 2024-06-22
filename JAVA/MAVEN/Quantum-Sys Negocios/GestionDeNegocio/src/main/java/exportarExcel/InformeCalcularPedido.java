package exportarExcel;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import entidades.DetalleCalculoPedido;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class InformeCalcularPedido {

    String usuario;
    String fecha;
    String nroInforme;
    String total;
    List<DetalleCalculoPedido> detalles;

    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;
    Paragraph subtitulo;

    public InformeCalcularPedido(String usuario, String fecha, String nroInforme, String total, List<DetalleCalculoPedido> detalles) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.nroInforme = nroInforme;
        this.total = total;
        this.detalles = detalles;

        documento = new Document();
        titulo = new Paragraph("INFORME", FontFactory.getFont(FontFactory.HELVETICA, 24));
        subtitulo = new Paragraph("Resumen de pedido calculado", FontFactory.getFont(FontFactory.HELVETICA, 10));
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
                        documento.add(new Paragraph("N° de informe: " + nroInforme));
                        documento.add(new Paragraph("Fecha y hora: " + fecha));
                        documento.add(new Paragraph("Usuario: " + usuario));

                        documento.add(new Chunk(line));
                        documento.add(Chunk.NEWLINE);

                        PdfPTable tabla = new PdfPTable(4);
                        tabla.addCell("Codigo");
                        tabla.addCell("Producto");
                        tabla.addCell("Cantidad");
                        tabla.addCell("Costo total ($)");

                        for (int i = 0; i < detalles.size(); i++) {
                            tabla.addCell(detalles.get(i).getProducto().getCodigo());
                            tabla.addCell(detalles.get(i).getProducto().getNombre());
                            tabla.addCell(detalles.get(i).getCantidad() + "");
                            tabla.addCell((detalles.get(i).getCostoDetalle()) + "");
                        }

                        documento.add(tabla);
                        documento.add(Chunk.NEWLINE);
                        documento.add(new Chunk(line));
                        documento.add(new Paragraph("COSTO TOTAL DEL PEDIDO ($): " + total, FontFactory.getFont(FontFactory.HELVETICA, 18)));
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

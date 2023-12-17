package frames;

import config.HibernateConfig;
import data.Proveedor_data;
import data.Venta_data;
import entidades.Proveedor;
import entidades.Venta;
import exportarExcel.Controlador;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.chart.axis.NumberAxis;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class VentasTotalesEstadisticas extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    JFreeChart grafico;

    public VentasTotalesEstadisticas() {
        initComponents();
        armarCabeceraTabla();
        borrarFilas();
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableVentas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbGraficar = new javax.swing.JButton();
        jbExportar = new javax.swing.JButton();

        setClosable(true);
        setTitle("ESTADISTICAS : \"VENTAS TOTALES\"");
        setPreferredSize(new java.awt.Dimension(630, 486));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtableVentas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbGraficar.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jbGraficar.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color2"));
        jbGraficar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficarx64.png"))); // NOI18N
        jbGraficar.setText("  GRAFICAR");
        jbGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGraficarActionPerformed(evt);
            }
        });

        jbExportar.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jbExportar.setForeground(new java.awt.Color(0, 153, 0));
        jbExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excelx64.png"))); // NOI18N
        jbExportar.setText("EXPORTAR");
        jbExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jbExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbExportar, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(jbGraficar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGraficarActionPerformed

        ArrayList<String> fechas = new ArrayList<>();

        XYSeries ventas = new XYSeries("Ventas");

        for (int i = 0; i < jtableVentas.getRowCount(); i++) {
            Date fecha = (Date) modelo.getValueAt(i, 1);
            Object monto = modelo.getValueAt(i, 2);

            // Asegurarse de que fecha y monto sean valores numéricos antes de agregarlos al gráfico
            if (fecha != null && monto instanceof Number) {
                long fechaLong = fecha.getTime(); // Obtén la representación en milisegundos de la fecha
                ventas.add(fechaLong, ((Number) monto).doubleValue());
            }
        }

        XYSeriesCollection dataset = new XYSeriesCollection(ventas);

        grafico = ChartFactory.createXYLineChart(
                "Ventas",
                "Fecha",
                "Monto",
                dataset,
                PlotOrientation.VERTICAL, true, true, true);

        XYPlot plot = grafico.getXYPlot();

// Configurar el eje X para mostrar las fechas por mes
        DateAxis xAxis = new DateAxis("Fecha");
        xAxis.setDateFormatOverride(new SimpleDateFormat("MM-yyyy")); // Ajusta el formato según tus necesidades
        plot.setDomainAxis(xAxis);

        XYItemLabelGenerator generator = new XYItemLabelGenerator() {
            @Override
            public String generateLabel(XYDataset dataset, int series, int item) {
                // Obtén el índice del array correspondiente al punto de datos actual
                if (item >= 0 && item < fechas.size()) {
                    return fechas.get(item); // Devuelve la fecha del array como etiqueta
                }
                return ""; // Devuelve una cadena vacía si el índice está fuera de rango
            }
        };

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setDefaultItemLabelGenerator(generator);
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelFont(new Font("Dialog", Font.PLAIN, 10)); // Ajusta el tamaño de la fuente si es necesario
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2));

        plot.setRenderer(renderer);

        // Crear panel y mostrar el gráfico
        ChartPanel panel = new ChartPanel(grafico);

        JFrame ventana = new JFrame("Gráfica");
        ventana.setVisible(true);
        ventana.setSize(1000, 700);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.add(panel);


    }//GEN-LAST:event_jbGraficarActionPerformed

    private void jbExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExportarActionPerformed
        Controlador obj;
        try {
            obj = new Controlador();
            obj.exportarExcel(jtableVentas);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error de archivo");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbExportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExportar;
    private javax.swing.JButton jbGraficar;
    private javax.swing.JTable jtableVentas;
    // End of variables declaration//GEN-END:variables

    public void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    public void armarCabeceraTabla() {
        modelo.setColumnCount(0);

        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Monto ($)");
        modelo.addColumn("Formas de pago");
        modelo.addColumn("Vendedor");

        jtableVentas.setModel(modelo);
    }

    public void actualizarTabla() {

        modelo.setRowCount(0);

        Session session = HibernateConfig.get().openSession();

        Venta_data provd = new Venta_data(session);

        List<Venta> ventas = provd.listarTodo();

        for (Venta v : ventas) {
            modelo.addRow(new Object[]{
                v.getIdVenta(),
                v.getFecha(),
                v.getPrecioTotalVenta(),
                v.getFormaDePago(),
                v.getUsuario()});
        }
        session.close();
    }

}

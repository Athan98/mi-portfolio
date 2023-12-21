package frames;

import config.HibernateConfig;
import data.DetallePedido_data;
import entidades.DetallePedido;
import exportarExcel.Controlador;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class CostosPorProveedorEstadisticas extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    public CostosPorProveedorEstadisticas() {
        initComponents();
        armarCabeceraTabla();
        borrarFilas();
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableVentas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbGraficar = new javax.swing.JButton();
        jbExportar = new javax.swing.JButton();

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGraficarActionPerformed

        int filas = modelo.getRowCount();

        Map<String, Double> montosPorProveedor = new HashMap<>();

        for (int i = 0; i <= filas-1; i++) {
            String nombreProveedor = (String) modelo.getValueAt(i, 0);
            double montoTotal = (double) modelo.getValueAt(i, 1);

            montosPorProveedor.put(nombreProveedor, montoTotal);
        }

        DefaultCategoryDataset datos = new DefaultCategoryDataset();

        // Agregar los valores del Map al dataset
        for (Map.Entry<String, Double> entry : montosPorProveedor.entrySet()) {
            datos.addValue(entry.getValue(), "Monto Total", entry.getKey());
        }

        JFreeChart graficoBarras = ChartFactory.createBarChart(
                "Costos por proveedor",
                "Proveedor",
                "Monto ($)",
                datos,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel panel = new ChartPanel(graficoBarras);

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

        modelo.addColumn("Proveedor");
        modelo.addColumn("Monto ($)");

        jtableVentas.setModel(modelo);
    }

    public void actualizarTabla() {
        modelo.setRowCount(0);

        Session session = HibernateConfig.get().openSession();

        DetallePedido_data dpd = new DetallePedido_data(session);

        List<DetallePedido> detalles = dpd.listarTodo();

        // Utilizar un mapa para mantener un registro de los montos asociados a cada proveedor
        Map<String, Double> montosPorProveedor = new HashMap<>();

        for (DetallePedido dp : detalles) {
            String nombreProveedor = dp.getProveedor().getNombre();
            double montoActual = dp.getPedido().getPrecioTotalCosto();

            // Verificar si el proveedor ya ha sido agregado al mapa
            if (montosPorProveedor.containsKey(nombreProveedor)) {
                // Sumar el monto actual al monto existente
                double montoExistente = montosPorProveedor.get(nombreProveedor);
                montosPorProveedor.put(nombreProveedor, montoExistente + montoActual);
            } else {
                // Agregar el proveedor al mapa con el monto actual
                montosPorProveedor.put(nombreProveedor, montoActual);
            }
        }

        // Iterar sobre el mapa y agregar las filas a la tabla
        for (Map.Entry<String, Double> entry : montosPorProveedor.entrySet()) {
            modelo.addRow(new Object[]{
                entry.getKey(), // Nombre del proveedor
                entry.getValue() // Monto total del proveedor
            });
        }

        session.close();
    }

}

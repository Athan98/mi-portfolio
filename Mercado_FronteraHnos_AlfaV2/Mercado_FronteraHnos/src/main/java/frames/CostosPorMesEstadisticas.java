package frames;

import config.HibernateConfig;
import data.FormasDePagoPedidos_data;
import data.Pedido_data;
import data.Venta_data;
import entidades.DetallePedido;
import entidades.Pedido;
import entidades.Venta;
import exportarExcel.Controlador;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

public class CostosPorMesEstadisticas extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    public CostosPorMesEstadisticas() {
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
        jLabel1 = new javax.swing.JLabel();
        jtAnio = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbGraficar = new javax.swing.JButton();
        jbExportar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(634, 540));

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

        jLabel1.setText("AÑO :");

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbGraficar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jbGraficar.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color2"));
        jbGraficar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficarx64.png"))); // NOI18N
        jbGraficar.setText("  GRAFICAR");
        jbGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGraficarActionPerformed(evt);
            }
        });

        jbExportar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
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

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        modelo.setRowCount(0);

        Session session = HibernateConfig.get().openSession();

        FormasDePagoPedidos_data dpd = new FormasDePagoPedidos_data(session);

        List<DetallePedido> detalles = dpd.listarTodo();

// Utilizar un conjunto para mantener un registro de los idPedido ya agregados
        Set<Integer> idPedidosAgregados = new HashSet<>();

        for (DetallePedido dp : detalles) {
            String yearString = jtAnio.getText();

            // Verifica si la cadena es un número entero válido
            // Convierte la cadena a un número entero
            int yearInTextField = Integer.parseInt(yearString);

            // Obtén la fecha del Date
            Date date = dp.getPedido().getFecha();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            // Obtén el año de la fecha
            int yearInDate = calendar.get(Calendar.YEAR);

            // Compara el año del Date con el año ingresado en el TextField
            if (yearInDate == yearInTextField) {
                int idPedido = dp.getPedido().getIdPedido();

                // Verificar si el idPedido ya ha sido agregado
                if (!idPedidosAgregados.contains(idPedido)) {
                    modelo.addRow(new Object[]{
                        idPedido,
                        dp.getPedido().getFecha(),
                        dp.getPedido().getPrecioTotalCosto(),
                        dp.getProveedor().getNombre(),
                        dp.getPedido().getUsuario().getNombre()});

                    // Agregar el idPedido al conjunto para evitar repeticiones
                    idPedidosAgregados.add(idPedido);
                }
            }
        }

        session.close();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGraficarActionPerformed

        double enero = 0;
        double feb = 0;
        double mar = 0;
        double abr = 0;
        double may = 0;
        double jun = 0;
        double jul = 0;
        double agost = 0;
        double sep = 0;
        double oct = 0;
        double nov = 0;
        double dic = 0;

        int fila = modelo.getRowCount();

        for (int i = 0; i < fila; i++) {
            double monto = (double) jtableVentas.getValueAt(i, 2);

            Date fecha = (Date) jtableVentas.getValueAt(i, 1);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);

            // Obtener el valor del mes (los meses en Java comienzan desde 0)
            int mes = calendar.get(Calendar.MONTH);

            if (mes == Calendar.JANUARY) {
                enero = enero + monto;
            } else if (mes == Calendar.FEBRUARY) {
                feb = feb + monto;
            } else if (mes == Calendar.MARCH) {
                mar = mar + monto;
            } else if (mes == Calendar.APRIL) {
                abr = abr + monto;
            } else if (mes == Calendar.MAY) {
                may = may + monto;
            } else if (mes == Calendar.JUNE) {
                jun = jun + monto;
            } else if (mes == Calendar.JULY) {
                jul = jul + monto;
            } else if (mes == Calendar.AUGUST) {
                agost = agost + monto;
            } else if (mes == Calendar.SEPTEMBER) {
                sep = sep + monto;
            } else if (mes == Calendar.OCTOBER) {
                oct = oct + monto;
            } else if (mes == Calendar.NOVEMBER) {
                nov = nov + monto;
            } else if (mes == Calendar.DECEMBER) {
                dic = dic + monto;
            }
        }

        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.setValue(enero, "Costos", "Enero");
        datos.setValue(feb, "Costos", "Febrero");
        datos.setValue(mar, "Costos", "Marzo");
        datos.setValue(abr, "Costos", "Abril");
        datos.setValue(may, "Costos", "Mayo");
        datos.setValue(jun, "Costos", "Junio");
        datos.setValue(jul, "Costos", "Julio");
        datos.setValue(agost, "Costos", "Agosto");
        datos.setValue(sep, "Costos", "Septiembre");
        datos.setValue(oct, "Costos", "Octubre");
        datos.setValue(nov, "Costos", "Noviembre");
        datos.setValue(dic, "Costos", "Diciembre");

        JFreeChart graficoBarras = ChartFactory.createBarChart(
                "Costos totales por mes",
                "Mes",
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbExportar;
    private javax.swing.JButton jbGraficar;
    private javax.swing.JTextField jtAnio;
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

        modelo.addColumn("ID Pedido");
        modelo.addColumn("Fecha");
        modelo.addColumn("Monto ($)");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Usuario");

        jtableVentas.setModel(modelo);
    }

    public void actualizarTabla() {
        modelo.setRowCount(0);

        Session session = HibernateConfig.get().openSession();

        FormasDePagoPedidos_data dpd = new FormasDePagoPedidos_data(session);

        List<DetallePedido> detalles = dpd.listarTodo();

        // Utilizar un conjunto para mantener un registro de los idPedido ya agregados
        Set<Integer> idPedidosAgregados = new HashSet<>();

        for (DetallePedido dp : detalles) {
            int idPedido = dp.getPedido().getIdPedido();

            // Verificar si el idPedido ya ha sido agregado
            if (!idPedidosAgregados.contains(idPedido)) {
                modelo.addRow(new Object[]{
                    idPedido,
                    dp.getPedido().getFecha(),
                    dp.getPedido().getPrecioTotalCosto(),
                    dp.getProveedor().getNombre(),
                    dp.getPedido().getUsuario().getNombre()});

                // Agregar el idPedido al conjunto para evitar repeticiones
                idPedidosAgregados.add(idPedido);
            }
        }

        session.close();
    }

}

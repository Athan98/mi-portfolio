package frames;

import config.HibernateConfig;
import data.*;
import entidades.*;
import exportarExcel.Controlador;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class VentasPorFormaDePagoEstadisticas extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    public VentasPorFormaDePagoEstadisticas() {
        initComponents();
        armarCabeceraTabla();
        borrarFilas();
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jbGraficar = new javax.swing.JButton();
        jbExportar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableVentas = new javax.swing.JTable();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(634, 540));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbGraficar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbGraficar.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color2"));
        jbGraficar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficar.png"))); // NOI18N
        jbGraficar.setText("  GRAFICAR");
        jbGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGraficarActionPerformed(evt);
            }
        });

        jbExportar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbExportar.setForeground(new java.awt.Color(0, 153, 0));
        jbExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excel.png"))); // NOI18N
        jbExportar.setText("EXPORTAR");
        jbExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExportarActionPerformed(evt);
            }
        });

        jbCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
        jbCancelar.setText("Cancelar Ctas Corrientes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExportar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jbGraficar)
                        .addComponent(jbExportar)))
                .addContainerGap())
        );

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
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

        double efectivo = 0;
        double debito = 0;
        double credito = 0;
        double mp = 0;
        double uala = 0;
        double trans = 0;
        double cta = 0;

        Date fechaActual = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        calendar.add(Calendar.YEAR, -1);
        Date fechaLimite = calendar.getTime();

        for (int i = 0; i < jtableVentas.getRowCount(); i++) {
            Date fechaVenta = (Date) modelo.getValueAt(i, 0);

            if (fechaVenta.after(fechaLimite) || fechaVenta.equals(fechaLimite)) {
                String fdp1 = (String) modelo.getValueAt(i, 1);
                String fdp2 = (String) modelo.getValueAt(i, 3);

                Object valorFDP1 = modelo.getValueAt(i, 2);
                Object valorFDP2 = modelo.getValueAt(i, 4);

                if (valorFDP1 instanceof Double) {

                    double montoFDP1 = (double) valorFDP1;

                    if (fdp1 != "-") {
                        if (fdp1.equals("Efectivo")) {
                            efectivo = efectivo + montoFDP1;
                        } else if (fdp1.equals("Debito")) {
                            debito = debito + montoFDP1;
                        } else if (fdp1.equals("Credito")) {
                            credito = credito + montoFDP1;
                        } else if (fdp1.equals("Mercado Pago")) {
                            mp = mp + montoFDP1;
                        } else if (fdp1.equals("Uala")) {
                            uala = uala + montoFDP1;
                        } else if (fdp1.equals("Transferencia")) {
                            trans = trans + montoFDP1;
                        } else if (fdp1.equals("Cuenta corriente")) {
                            cta = cta + montoFDP1;
                        }
                    }

                } else if (valorFDP1 instanceof String) {
                    System.out.println("Es un string");
                }

                if (valorFDP2 instanceof Double) {

                    double montoFDP2 = (double) valorFDP2;

                    if (fdp2 != "-") {
                        if (fdp2.equals("Efectivo")) {
                            efectivo = efectivo + montoFDP2;
                        } else if (fdp2.equals("Debito")) {
                            debito = debito + montoFDP2;
                        } else if (fdp2.equals("Credito")) {
                            credito = credito + montoFDP2;
                        } else if (fdp2.equals("Mercado Pago")) {
                            mp = mp + montoFDP2;
                        } else if (fdp2.equals("Uala")) {
                            uala = uala + montoFDP2;
                        } else if (fdp2.equals("Transferencia")) {
                            trans = trans + montoFDP2;
                        } else if (fdp2.equals("Cuenta corriente")) {
                            cta = cta + montoFDP2;
                        }
                    } else if (valorFDP2 instanceof String) {
                        System.out.println("Es un string");
                    }

                }

            }
        }

        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Efectivo", efectivo);
        datos.setValue("Mercado Pago", mp);
        datos.setValue("Credito", credito);
        datos.setValue("Debito", debito);
        datos.setValue("Uala", uala);
        datos.setValue("Transferencia bancaria", trans);
        datos.setValue("Cuenta corriente", cta);

        JFreeChart graficoCircular = ChartFactory.createPieChart(
                "Ventas por formas de pago del ultimo año",
                datos,
                true,
                true,
                false
        );

        // Crear panel y mostrar el gráfico
        ChartPanel panel = new ChartPanel(graficoCircular);

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
    private javax.swing.JButton jbCancelar;
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

        modelo.addColumn("Fecha");
        modelo.addColumn("Forma de pago 1");
        modelo.addColumn("Monto ($)");
        modelo.addColumn("Forma de pago 2");
        modelo.addColumn("Monto ($)");
        modelo.addColumn("Vendedor");

        jtableVentas.setModel(modelo);
    }

    public void actualizarTabla() {

        modelo.setRowCount(0);

        Session session = HibernateConfig.get().openSession();

        FormasDePagoVentas_data provd = new FormasDePagoVentas_data(session);

        List<FormasDePagoVentas> fdpvs = provd.listarTodo();

        for (FormasDePagoVentas fdpv : fdpvs) {
            modelo.addRow(new Object[]{
                fdpv.getVenta().getFecha(),
                fdpv.getFpd1().getNombreFormaDePago(),
                fdpv.getMontoFDP1(),
                (fdpv.getFpd2() != null) ? fdpv.getFpd2().getNombreFormaDePago() : "-",
                (fdpv.getMontoFDP2() != null) ? fdpv.getMontoFDP2() : "0.0",
                fdpv.getVenta().getUsuario().getNombre()
            });

        }

        session.close();
    }

}

package frames;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class Estadisticas extends javax.swing.JInternalFrame {

    public Estadisticas() {
        this.setBorder(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jbVentasTotales = new javax.swing.JButton();
        jbVentasPorFormasDePago = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jbProductosMasVendidos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jbCostosPorMes = new javax.swing.JButton();
        jbCostosPorDia = new javax.swing.JButton();
        jbCostosPorProveedor = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/estadisticas.png"));
        Image image = icon.getImage();
        estadisticasPane = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };

        setClosable(true);
        setTitle("ESTADISTICAS");

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setForeground(java.awt.Color.darkGray);

        jPanel2.setBackground(java.awt.Color.darkGray);
        jPanel2.setForeground(java.awt.Color.darkGray);

        jPanel3.setBackground(java.awt.Color.darkGray);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ventas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gill Sans MT Condensed", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(java.awt.Color.darkGray);

        jbVentasTotales.setBackground(new java.awt.Color(51, 51, 51));
        jbVentasTotales.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        jbVentasTotales.setForeground(new java.awt.Color(255, 255, 255));
        jbVentasTotales.setText("Ventas por mes");
        jbVentasTotales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasTotalesActionPerformed(evt);
            }
        });

        jbVentasPorFormasDePago.setBackground(new java.awt.Color(51, 51, 51));
        jbVentasPorFormasDePago.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        jbVentasPorFormasDePago.setForeground(new java.awt.Color(255, 255, 255));
        jbVentasPorFormasDePago.setText("Ventas por formas de pago");
        jbVentasPorFormasDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasPorFormasDePagoActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Ventas por dia");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbVentasTotales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVentasPorFormasDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbVentasTotales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbVentasPorFormasDePago)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(java.awt.Color.darkGray);
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gill Sans MT Condensed", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setForeground(java.awt.Color.darkGray);

        jbProductosMasVendidos.setBackground(new java.awt.Color(51, 51, 51));
        jbProductosMasVendidos.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        jbProductosMasVendidos.setForeground(new java.awt.Color(255, 255, 255));
        jbProductosMasVendidos.setText("Mas vendidos");
        jbProductosMasVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProductosMasVendidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbProductosMasVendidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbProductosMasVendidos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(java.awt.Color.darkGray);
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Costos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gill Sans MT Condensed", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(java.awt.Color.darkGray);

        jbCostosPorMes.setBackground(new java.awt.Color(51, 51, 51));
        jbCostosPorMes.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        jbCostosPorMes.setForeground(new java.awt.Color(255, 255, 255));
        jbCostosPorMes.setText("Costos por mes");
        jbCostosPorMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCostosPorMesActionPerformed(evt);
            }
        });

        jbCostosPorDia.setBackground(new java.awt.Color(51, 51, 51));
        jbCostosPorDia.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        jbCostosPorDia.setForeground(new java.awt.Color(255, 255, 255));
        jbCostosPorDia.setText("Costos por dia");
        jbCostosPorDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCostosPorDiaActionPerformed(evt);
            }
        });

        jbCostosPorProveedor.setBackground(new java.awt.Color(51, 51, 51));
        jbCostosPorProveedor.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        jbCostosPorProveedor.setForeground(new java.awt.Color(255, 255, 255));
        jbCostosPorProveedor.setText("Costos por proveedor");
        jbCostosPorProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCostosPorProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCostosPorMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCostosPorDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCostosPorProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCostosPorMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCostosPorDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCostosPorProveedor)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        estadisticasPane.setPreferredSize(new java.awt.Dimension(634, 550));

        javax.swing.GroupLayout estadisticasPaneLayout = new javax.swing.GroupLayout(estadisticasPane);
        estadisticasPane.setLayout(estadisticasPaneLayout);
        estadisticasPaneLayout.setHorizontalGroup(
            estadisticasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        estadisticasPaneLayout.setVerticalGroup(
            estadisticasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estadisticasPane, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estadisticasPane, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVentasTotalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVentasTotalesActionPerformed
        Thread cargaThread = new Thread(() -> {
            // Mostrar el frame de carga
            Loading loading = new Loading();
            loading.setVisible(true);

            try {
                estadisticasPane.removeAll();
                estadisticasPane.repaint();
                Thread.sleep(2000);
                VentasPorMesEstadisticas ve = new VentasPorMesEstadisticas();
                ve.setVisible(true);
                estadisticasPane.add(ve);

            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar el frame de carga
            loading.dispose();
        });

        // Iniciar el hilo
        cargaThread.start();
    }//GEN-LAST:event_jbVentasTotalesActionPerformed

    private void jbVentasPorFormasDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVentasPorFormasDePagoActionPerformed
        Thread cargaThread = new Thread(() -> {
            // Mostrar el frame de carga
            Loading loading = new Loading();
            loading.setVisible(true);

            try {
                estadisticasPane.removeAll();
                estadisticasPane.repaint();
                Thread.sleep(2000);
                VentasPorFormaDePagoEstadisticas vpfp = new VentasPorFormaDePagoEstadisticas();
                vpfp.setVisible(true);
                estadisticasPane.add(vpfp);

            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar el frame de carga
            loading.dispose();
        });

        // Iniciar el hilo
        cargaThread.start();
    }//GEN-LAST:event_jbVentasPorFormasDePagoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Thread cargaThread = new Thread(() -> {
            // Mostrar el frame de carga
            Loading loading = new Loading();
            loading.setVisible(true);

            try {
                estadisticasPane.removeAll();
                estadisticasPane.repaint();
                Thread.sleep(2000);
                VentasPorDiaEstadisticas vpd = new VentasPorDiaEstadisticas();
                vpd.setVisible(true);
                estadisticasPane.add(vpd);

            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar el frame de carga
            loading.dispose();
        });

        // Iniciar el hilo
        cargaThread.start();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jbCostosPorMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCostosPorMesActionPerformed
        Thread cargaThread = new Thread(() -> {
            // Mostrar el frame de carga
            Loading loading = new Loading();
            loading.setVisible(true);

            try {
                estadisticasPane.removeAll();
                estadisticasPane.repaint();
                Thread.sleep(2000);
                CostosPorMesEstadisticas cpm = new CostosPorMesEstadisticas();
                cpm.setVisible(true);
                estadisticasPane.add(cpm);

            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar el frame de carga
            loading.dispose();
        });

        // Iniciar el hilo
        cargaThread.start();
    }//GEN-LAST:event_jbCostosPorMesActionPerformed

    private void jbCostosPorDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCostosPorDiaActionPerformed
        Thread cargaThread = new Thread(() -> {
            // Mostrar el frame de carga
            Loading loading = new Loading();
            loading.setVisible(true);

            try {
                estadisticasPane.removeAll();
                estadisticasPane.repaint();
                Thread.sleep(2000);
                CostosPorDiaEstadisticas cpd = new CostosPorDiaEstadisticas();
                cpd.setVisible(true);
                estadisticasPane.add(cpd);

            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar el frame de carga
            loading.dispose();
        });

        // Iniciar el hilo
        cargaThread.start();
    }//GEN-LAST:event_jbCostosPorDiaActionPerformed

    private void jbCostosPorProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCostosPorProveedorActionPerformed
        Thread cargaThread = new Thread(() -> {
            // Mostrar el frame de carga
            Loading loading = new Loading();
            loading.setVisible(true);

            try {
                estadisticasPane.removeAll();
                estadisticasPane.repaint();
                Thread.sleep(2000);
                CostosPorProveedorEstadisticas cpp = new CostosPorProveedorEstadisticas();
                cpp.setVisible(true);
                estadisticasPane.add(cpp);

            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar el frame de carga
            loading.dispose();
        });

        // Iniciar el hilo
        cargaThread.start();
    }//GEN-LAST:event_jbCostosPorProveedorActionPerformed

    private void jbProductosMasVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProductosMasVendidosActionPerformed
        Thread cargaThread = new Thread(() -> {
            // Mostrar el frame de carga
            Loading loading = new Loading();
            loading.setVisible(true);

            try {
                estadisticasPane.removeAll();
                estadisticasPane.repaint();
                Thread.sleep(2000);
                ProductosMasVendidosEstadisticas pmv = new ProductosMasVendidosEstadisticas();
                pmv.setVisible(true);
                estadisticasPane.add(pmv);

            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar el frame de carga
            loading.dispose();
        });

        // Iniciar el hilo
        cargaThread.start();
    }//GEN-LAST:event_jbProductosMasVendidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane estadisticasPane;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbCostosPorDia;
    private javax.swing.JButton jbCostosPorMes;
    private javax.swing.JButton jbCostosPorProveedor;
    private javax.swing.JButton jbProductosMasVendidos;
    private javax.swing.JButton jbVentasPorFormasDePago;
    private javax.swing.JButton jbVentasTotales;
    // End of variables declaration//GEN-END:variables

}

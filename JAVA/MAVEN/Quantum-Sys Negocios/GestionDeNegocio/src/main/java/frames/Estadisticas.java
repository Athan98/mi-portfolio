package frames;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Estadisticas extends javax.swing.JInternalFrame {

    private SwingWorker<Void, Void> cargaWorker;

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
        jbVentasPorDia = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jbProductosMasVendidos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jbCostosPorMes = new javax.swing.JButton();
        jbCostosPorDia = new javax.swing.JButton();
        jbCostosPorProveedor = new javax.swing.JButton();
        jbCostosFDP = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/fondoOUSIA.jpeg"));
        Image image = icon.getImage();
        estadisticasPane = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };

        setClosable(true);
        setTitle("ESTADISTICAS");

        jPanel1.setBackground(new java.awt.Color(226, 230, 240));
        jPanel1.setForeground(new java.awt.Color(226, 230, 240));

        jPanel2.setBackground(new java.awt.Color(226, 230, 240));
        jPanel2.setForeground(new java.awt.Color(226, 230, 240));

        jPanel3.setBackground(new java.awt.Color(226, 230, 240));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ventas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 30), new java.awt.Color(97, 130, 189))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(226, 230, 240));

        jbVentasTotales.setBackground(new java.awt.Color(97, 130, 189));
        jbVentasTotales.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jbVentasTotales.setForeground(new java.awt.Color(255, 255, 255));
        jbVentasTotales.setText("Ventas por mes");
        jbVentasTotales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasTotalesActionPerformed(evt);
            }
        });

        jbVentasPorFormasDePago.setBackground(new java.awt.Color(97, 130, 189));
        jbVentasPorFormasDePago.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jbVentasPorFormasDePago.setForeground(new java.awt.Color(255, 255, 255));
        jbVentasPorFormasDePago.setText("Ventas por formas de pago");
        jbVentasPorFormasDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasPorFormasDePagoActionPerformed(evt);
            }
        });

        jbVentasPorDia.setBackground(new java.awt.Color(97, 130, 189));
        jbVentasPorDia.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jbVentasPorDia.setForeground(new java.awt.Color(255, 255, 255));
        jbVentasPorDia.setText("Ventas por dia");
        jbVentasPorDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasPorDiaActionPerformed(evt);
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
                    .addComponent(jbVentasPorDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVentasPorFormasDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbVentasTotales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbVentasPorDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbVentasPorFormasDePago)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(226, 230, 240));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 30), new java.awt.Color(97, 130, 189))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(226, 230, 240));

        jbProductosMasVendidos.setBackground(new java.awt.Color(97, 130, 189));
        jbProductosMasVendidos.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
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
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(226, 230, 240));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Costos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 30), new java.awt.Color(97, 130, 189))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(226, 230, 240));

        jbCostosPorMes.setBackground(new java.awt.Color(97, 130, 189));
        jbCostosPorMes.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jbCostosPorMes.setForeground(new java.awt.Color(255, 255, 255));
        jbCostosPorMes.setText("Costos por mes");
        jbCostosPorMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCostosPorMesActionPerformed(evt);
            }
        });

        jbCostosPorDia.setBackground(new java.awt.Color(97, 130, 189));
        jbCostosPorDia.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jbCostosPorDia.setForeground(new java.awt.Color(255, 255, 255));
        jbCostosPorDia.setText("Costos por dia");
        jbCostosPorDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCostosPorDiaActionPerformed(evt);
            }
        });

        jbCostosPorProveedor.setBackground(new java.awt.Color(97, 130, 189));
        jbCostosPorProveedor.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jbCostosPorProveedor.setForeground(new java.awt.Color(255, 255, 255));
        jbCostosPorProveedor.setText("Costos por proveedor");
        jbCostosPorProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCostosPorProveedorActionPerformed(evt);
            }
        });

        jbCostosFDP.setBackground(new java.awt.Color(97, 130, 189));
        jbCostosFDP.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jbCostosFDP.setForeground(new java.awt.Color(255, 255, 255));
        jbCostosFDP.setText("Costos por formas de pago");
        jbCostosFDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCostosFDPActionPerformed(evt);
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
                    .addComponent(jbCostosPorProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCostosFDP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCostosPorMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCostosPorDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCostosFDP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        estadisticasPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        estadisticasPane.setPreferredSize(new java.awt.Dimension(634, 550));

        javax.swing.GroupLayout estadisticasPaneLayout = new javax.swing.GroupLayout(estadisticasPane);
        estadisticasPane.setLayout(estadisticasPaneLayout);
        estadisticasPaneLayout.setHorizontalGroup(
            estadisticasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
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
                .addComponent(estadisticasPane, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estadisticasPane, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }

        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

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

                return null;
            }

            @Override
            protected void done() {
                // Cerrar el frame de carga después de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbVentasTotalesActionPerformed

    private void jbVentasPorFormasDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVentasPorFormasDePagoActionPerformed

        // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }

        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

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

                return null;
            }

            @Override
            protected void done() {
                // Cerrar el frame de carga después de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbVentasPorFormasDePagoActionPerformed

    private void jbVentasPorDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVentasPorDiaActionPerformed

        // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }

        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

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

                return null;
            }

            @Override
            protected void done() {
                // Cerrar el frame de carga después de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbVentasPorDiaActionPerformed

    private void jbCostosPorMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCostosPorMesActionPerformed

        // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }

        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

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

                return null;
            }

            @Override
            protected void done() {
                // Cerrar el frame de carga después de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbCostosPorMesActionPerformed

    private void jbCostosPorDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCostosPorDiaActionPerformed

        // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }

        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

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

                return null;
            }

            @Override
            protected void done() {
                // Cerrar el frame de carga después de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbCostosPorDiaActionPerformed

    private void jbCostosPorProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCostosPorProveedorActionPerformed

        // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }

        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

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

                return null;
            }

            @Override
            protected void done() {
                // Cerrar el frame de carga después de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbCostosPorProveedorActionPerformed

    private void jbProductosMasVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProductosMasVendidosActionPerformed

        // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }

        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

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

                return null;
            }

            @Override
            protected void done() {
                // Cerrar el frame de carga después de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbProductosMasVendidosActionPerformed

    private void jbCostosFDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCostosFDPActionPerformed

        // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }

        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

                loading.setVisible(true);

                try {
                    estadisticasPane.removeAll();
                    estadisticasPane.repaint();
                    Thread.sleep(2000);
                    CostosPorFormaDePagoEstadisticas cpfdp = new CostosPorFormaDePagoEstadisticas();
                    cpfdp.setVisible(true);
                    estadisticasPane.add(cpfdp);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                return null;
            }

            @Override
            protected void done() {
                // Cerrar el frame de carga después de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbCostosFDPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane estadisticasPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbCostosFDP;
    private javax.swing.JButton jbCostosPorDia;
    private javax.swing.JButton jbCostosPorMes;
    private javax.swing.JButton jbCostosPorProveedor;
    private javax.swing.JButton jbProductosMasVendidos;
    private javax.swing.JButton jbVentasPorDia;
    private javax.swing.JButton jbVentasPorFormasDePago;
    private javax.swing.JButton jbVentasTotales;
    // End of variables declaration//GEN-END:variables

}

package frames;

import config.HibernateConfig;
import config_tables.RenderCtaCte;
import data.CuentaCorriente_data;
import entidades.CuentaCorriente;
import exportarExcel.Controlador;
import static frames.Principal.escritorio;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Session;

public class GestionCtaCte extends javax.swing.JInternalFrame {

    private SwingWorker<Void, Void> cargaWorker;

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;  // Hacer la primera columna (checkbox) editable
        }

    };

    List<CuentaCorriente> ctaCteList = null;
    public static CuentaCorriente cc = null;
    JButton botonInfo = new JButton();
    public static int columna1;
    public static int fila1;

    public GestionCtaCte() {
        initComponents();
        botonInfo.setName("Info");
        setButton(botonInfo, "/iconos/info.png");
        armarCabeceraTabla();
        borrarFilas();
        listarCtaCte();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtBuscarNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCtaCte = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbHabilitar = new javax.swing.JButton();
        jbExportar = new javax.swing.JButton();

        setClosable(true);
        setTitle("GESTION DE CUENTAS CORRIENTES");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuentas corrientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setText("Buscar por nombre de cliente :");

        jtBuscarNombre.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jtBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBuscarNombreActionPerformed(evt);
            }
        });
        jtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarNombreKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jtBuscarNombre)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtCtaCte.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCtaCte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCtaCteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCtaCte);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbAgregar.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(0, 153, 0));
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        jbAgregar.setText("NUEVA CTA. CTE.");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbCancelar.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jbCancelar.setForeground(new java.awt.Color(153, 153, 0));
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calcular.png"))); // NOI18N
        jbCancelar.setText("CANCELAR CTA. CTE.");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(153, 0, 0));
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        jbEliminar.setText("DESHABILITAR CTA. CTE");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbHabilitar.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jbHabilitar.setForeground(new java.awt.Color(0, 153, 0));
        jbHabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ok.png"))); // NOI18N
        jbHabilitar.setText("HABILITAR CTA. CTE.");
        jbHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHabilitarActionPerformed(evt);
            }
        });

        jbExportar.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jbExportar.setForeground(new java.awt.Color(0, 153, 0));
        jbExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/excel.png"))); // NOI18N
        jbExportar.setText("EXPORTAR");
        jbExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbHabilitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAgregar)
                .addGap(18, 18, 18)
                .addComponent(jbCancelar)
                .addGap(18, 18, 18)
                .addComponent(jbEliminar)
                .addGap(18, 18, 18)
                .addComponent(jbHabilitar)
                .addGap(18, 18, 18)
                .addComponent(jbExportar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void setButton(JButton jButton, String ruta) {
        jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
    }

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operacion actual termine.");
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
                    escritorio.removeAll();
                    escritorio.repaint();
                    Thread.sleep(1000);
                    NuevaCtaCte ncc = new NuevaCtaCte();
                    ncc.setVisible(true);
                    escritorio.add(ncc);
                    escritorio.moveToFront(ncc);
                    ncc.setLocation((Principal.escritorio.getWidth() - ncc.getWidth()) / 2, (Principal.escritorio.getHeight() - ncc.getHeight()) / 2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                return null;
            }

            @Override
            protected void done() {
                // Cerrar el frame de carga despu�s de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jtBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBuscarNombreActionPerformed

    private void jtBuscarNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarNombreKeyReleased
        try {

            borrarFilas();

            for (CuentaCorriente cc : ctaCteList) {

                if (cc.getCliente().getNombre().toUpperCase().startsWith(jtBuscarNombre.getText().toUpperCase())) {

                    if (cc.getMontoTotal() > 0 && cc.getEstado().equals("VIGENTE")) {
                        modelo.addRow(new Object[]{
                            cc.getIdCtaCte(),
                            cc.getCliente().getNombre(),
                            cc.getCliente().getCuit_cuil(),
                            cc.getMontoTotal(),
                            "FALTA DE PAGO",
                            botonInfo});
                    } else if (cc.getMontoTotal() <= 0 && cc.getEstado().equals("VIGENTE")) {
                        modelo.addRow(new Object[]{
                            cc.getIdCtaCte(),
                            cc.getCliente().getNombre(),
                            cc.getCliente().getCuit_cuil(),
                            cc.getMontoTotal(),
                            "AL DIA",
                            botonInfo});
                    } else if (cc.getEstado().equals("NO VIGENTE")) {
                        modelo.addRow(new Object[]{
                            cc.getIdCtaCte(),
                            cc.getCliente().getNombre(),
                            cc.getCliente().getCuit_cuil(),
                            cc.getMontoTotal(),
                            "NO VIGENTE",
                            botonInfo});
                    }
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jtBuscarNombreKeyReleased

    private void jtCtaCteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCtaCteMouseClicked
        columna1 = jtCtaCte.getColumnModel().getColumnIndexAtX(evt.getX());
        fila1 = evt.getY() / jtCtaCte.getRowHeight();

        if (columna1 <= jtCtaCte.getColumnCount() && columna1 >= 0 && fila1 <= jtCtaCte.getRowCount() && fila1 >= 0) {
            Object o = jtCtaCte.getValueAt(fila1, columna1);
            if (o instanceof JButton) {
                JButton botones = (JButton) o;
                if (botones.getName().equals("Info")) {
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

                            int idCtaCte = (int) modelo.getValueAt(jtCtaCte.getSelectedRow(), 0);
                            Session session = HibernateConfig.get().openSession();
                            CuentaCorriente_data ccd = new CuentaCorriente_data(session);
                            cc = ccd.encontrarPorID(idCtaCte);
                            session.close();

                            // Mostrar InfoCtaCte solo cuando se presiona el botón "Info"
                            InfoCtaCte icc = new InfoCtaCte();
                            icc.setVisible(true);
                            escritorio.add(icc);
                            escritorio.moveToFront(icc);
                            icc.setLocation((Principal.escritorio.getWidth() - icc.getWidth()) / 2, (Principal.escritorio.getHeight() - icc.getHeight()) / 2);

                            return null;
                        }

                        @Override
                        protected void done() {
                            // Cerrar el frame de carga después de que la tarea haya terminado
                            loading.dispose();
                        }
                    };

                    cargaWorker.execute();
                }
            }
        }
    }//GEN-LAST:event_jtCtaCteMouseClicked

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        try {
            int filaSeleccionada = jtCtaCte.getSelectedRow();

            if (filaSeleccionada != -1) {

                String input = JOptionPane.showInputDialog(null, "Monto que el cliente entrega: ");

                if (input == null || input.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido");
                } else {
                    Double montoCancelar = Double.parseDouble(input);
                    int idCtaCte = (int) modelo.getValueAt(filaSeleccionada, 0);

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

                            Session session = HibernateConfig.get().openSession();
                            CuentaCorriente_data ccd = new CuentaCorriente_data(session);
                            CuentaCorriente cuentaCorriente = ccd.encontrarPorID(idCtaCte);
                            Double montoCuenta = cuentaCorriente.getMontoTotal();

                            cuentaCorriente.setMontoTotal(montoCuenta - montoCancelar);

                            ccd.actualizar(cuentaCorriente);

                            session.close();

                            borrarFilas();
                            listarCtaCte();

                            return null;
                        }

                        @Override
                        protected void done() {
                            // Cerrar el frame de carga después de que la tarea haya terminado
                            loading.dispose();
                        }
                    };

                    cargaWorker.execute();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            int filaSeleccionada = jtCtaCte.getSelectedRow();

            if (filaSeleccionada != -1) {
                // Solicitar confirmación al usuario antes de eliminar
                int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de deshabilitar la cuenta corriente seleccionada?", "Confirmar eliminación cuenta corriente", JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    // Si el usuario confirma la eliminación
                    int idCtaCte = (int) modelo.getValueAt(filaSeleccionada, 0);

                    Session session = HibernateConfig.get().openSession();
                    CuentaCorriente_data ccd = new CuentaCorriente_data(session);
                    CuentaCorriente cuentaCorriente = ccd.encontrarPorID(idCtaCte);

                    cuentaCorriente.setEstado("NO VIGENTE");

                    ccd.actualizar(cuentaCorriente);

                    session.close();

                    borrarFilas();
                    listarCtaCte();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHabilitarActionPerformed
        try {
            int filaSeleccionada = jtCtaCte.getSelectedRow();

            if (filaSeleccionada != -1) {
                // Solicitar confirmación al usuario antes de eliminar
                int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de habilitar la cuenta corriente seleccionada?", "Confirmar eliminación cuenta corriente", JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    // Si el usuario confirma la eliminación
                    int idCtaCte = (int) modelo.getValueAt(filaSeleccionada, 0);

                    Session session = HibernateConfig.get().openSession();
                    CuentaCorriente_data ccd = new CuentaCorriente_data(session);
                    CuentaCorriente cuentaCorriente = ccd.encontrarPorID(idCtaCte);

                    cuentaCorriente.setEstado("VIGENTE");

                    ccd.actualizar(cuentaCorriente);

                    session.close();

                    borrarFilas();
                    listarCtaCte();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbHabilitarActionPerformed

    private void jbExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExportarActionPerformed
        Controlador obj;
        try {
            obj = new Controlador();
            obj.exportarExcel(jtCtaCte);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error de archivo");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbExportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbExportar;
    private javax.swing.JButton jbHabilitar;
    private javax.swing.JTextField jtBuscarNombre;
    private javax.swing.JTable jtCtaCte;
    // End of variables declaration//GEN-END:variables

    public void listarCtaCte() {

        try {

            Session session = HibernateConfig.get().openSession();
            CuentaCorriente_data ccd = new CuentaCorriente_data(session);

            ctaCteList = ccd.listarTodo();

            for (CuentaCorriente cc : ctaCteList) {

                if (cc.getMontoTotal() > 0 && cc.getEstado().equals("VIGENTE")) {
                    modelo.addRow(new Object[]{
                        cc.getIdCtaCte(),
                        cc.getCliente().getNombre(),
                        cc.getCliente().getCuit_cuil(),
                        cc.getMontoTotal(),
                        "FALTA DE PAGO",
                        botonInfo});
                } else if (cc.getMontoTotal() <= 0 && cc.getEstado().equals("VIGENTE")) {
                    modelo.addRow(new Object[]{
                        cc.getIdCtaCte(),
                        cc.getCliente().getNombre(),
                        cc.getCliente().getCuit_cuil(),
                        cc.getMontoTotal(),
                        "AL DIA",
                        botonInfo});
                } else if (cc.getEstado().equals("NO VIGENTE")) {
                    modelo.addRow(new Object[]{
                        cc.getIdCtaCte(),
                        cc.getCliente().getNombre(),
                        cc.getCliente().getCuit_cuil(),
                        cc.getMontoTotal(),
                        "NO VIGENTE",
                        botonInfo});
                }
            }

            session.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

    }

    public void armarCabeceraTabla() {
        try {
            modelo.setColumnCount(0);

            jtCtaCte.setDefaultRenderer(Object.class, new RenderCtaCte());

            jtCtaCte.setRowHeight(25);

            modelo.addColumn("ID Cta. Cte.");
            modelo.addColumn("Cliente");
            modelo.addColumn("CUIT/CUIL Cliente");
            modelo.addColumn("Monto ($)");
            modelo.addColumn("Estado");
            modelo.addColumn(" ");

            jtCtaCte.setModel(modelo);

            TableColumn column0 = jtCtaCte.getColumnModel().getColumn(0);
            column0.setPreferredWidth(25);

            TableColumn column5 = jtCtaCte.getColumnModel().getColumn(5);
            column5.setPreferredWidth(25);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    public void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

}

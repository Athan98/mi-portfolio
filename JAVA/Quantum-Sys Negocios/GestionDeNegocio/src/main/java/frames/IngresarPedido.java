package frames;

import config.HibernateConfig;
import data.*;
import entidades.*;
import static frames.Principal.escritorio;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.hibernate.Session;

public class IngresarPedido extends javax.swing.JInternalFrame {

    Usuario user = Principal.user;
    public static Pedido ped;
    private SwingWorker<Void, Void> cargaWorker;

    public IngresarPedido() {
        initComponents();
        cargarFormasDePago();
        llenarComboUsers();
        llenarComboProveedores();
        jtFecha.setText(setFecha());
        setearUser(user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jcProveedores = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtCosto = new javax.swing.JTextField();
        jbAgregarProveedor = new javax.swing.JButton();
        jbActualizarProveedores = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbIngresarPedido = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jcFormaDePago = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcUsuarios = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtFecha = new javax.swing.JTextField();

        jCheckBox1.setText("jCheckBox1");

        setClosable(true);
        setTitle("INGRESAR NUEVOS PEDIDOS");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUEVAS ENTRADAS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 20))); // NOI18N

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Proveedor :");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Costo Total ($):");

        jtCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCosto.setText("0");
        jtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCostoKeyPressed(evt);
            }
        });

        jbAgregarProveedor.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jbAgregarProveedor.setText("NUEVO");
        jbAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarProveedorActionPerformed(evt);
            }
        });

        jbActualizarProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jbActualizarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarProveedoresActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbIngresarPedido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbIngresarPedido.setForeground(new java.awt.Color(0, 204, 0));
        jbIngresarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        jbIngresarPedido.setText("AGREGAR");
        jbIngresarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIngresarPedidoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 153, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/limpiar.png"))); // NOI18N
        jButton1.setText("LIMPIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbIngresarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbIngresarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Forma de pago :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(24, 24, 24)
                                        .addComponent(jcProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcFormaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbAgregarProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbActualizarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbActualizarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jcProveedores)
                        .addComponent(jbAgregarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jcFormaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel2.setText("Usuario:");

        jLabel4.setText("Fecha:");

        jtFecha.setEditable(false);
        jtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jcUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProveedorActionPerformed
        // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
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
                    Thread.sleep(2000);
                    Proveedores p = new Proveedores();
                    p.setVisible(true);
                    escritorio.add(p);
                    escritorio.moveToFront(p);
                    p.setLocation((escritorio.getWidth() - p.getWidth()) / 2, (escritorio.getHeight() - p.getHeight()) / 2);
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
    }//GEN-LAST:event_jbAgregarProveedorActionPerformed

    private void jbActualizarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarProveedoresActionPerformed
        llenarComboProveedores();
    }//GEN-LAST:event_jbActualizarProveedoresActionPerformed

    private void jbIngresarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIngresarPedidoActionPerformed

        Session session = HibernateConfig.get().openSession();

        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea confirmar la operacion ?", "Confirmacion de ingreso", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Operacion cancelada");
        } else {

            if (jcUsuarios.getSelectedIndex() == -1 || jcProveedores.getSelectedIndex() == -1 || jcFormaDePago.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            } else {

                try {
                    Pedido_data pedd = new Pedido_data(session);

                    //CREO EL PEDIDO
                    Date fechaDate = new Date();
                    Usuario user = (Usuario) jcUsuarios.getSelectedItem();
                    Double precioCostoTotal = Double.parseDouble(jtCosto.getText());
                    Proveedor prov = (Proveedor) jcProveedores.getSelectedItem();
                    FormaDePago fdp = (FormaDePago) jcFormaDePago.getSelectedItem();

                    ped = new Pedido(fechaDate, precioCostoTotal, user, prov, fdp, true);

                    pedd.agregar(ped);

                    PagoPedido pp = new PagoPedido();
                    pp.setVisible(true);

                    limpiarCampos();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
                }

            }

        }

        session.close();
    }//GEN-LAST:event_jbIngresarPedidoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCostoKeyPressed

        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                || (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) || (evt.getKeyChar() == '.')) {
            jtCosto.setEditable(true);
        } else {
            jtCosto.setEditable(false);
        }
    }//GEN-LAST:event_jtCostoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbActualizarProveedores;
    private javax.swing.JButton jbAgregarProveedor;
    private javax.swing.JButton jbIngresarPedido;
    private javax.swing.JComboBox<FormaDePago> jcFormaDePago;
    private javax.swing.JComboBox<Proveedor> jcProveedores;
    private javax.swing.JComboBox<Usuario> jcUsuarios;
    private javax.swing.JTextField jtCosto;
    private javax.swing.JTextField jtFecha;
    // End of variables declaration//GEN-END:variables

    private void llenarComboUsers() {

        try {
            jcUsuarios.removeAllItems();

            Session session = HibernateConfig.get().openSession();
            Usuario_data userd = new Usuario_data(session);
            List<Usuario> users = userd.listarTodo();

            Set<String> usersAgregados = new HashSet<>();

            for (Usuario u : users) {
                String nombreUser = u.getNombre();
                if (!usersAgregados.contains(nombreUser)) {
                    jcUsuarios.addItem(u);
                    usersAgregados.add(nombreUser);
                }
            }

            jcUsuarios.setSelectedIndex(-1);

            session.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    private void llenarComboProveedores() {

        try {
            jcProveedores.removeAllItems();

            Session session = HibernateConfig.get().openSession();
            Proveedor_data pd = new Proveedor_data(session);
            List<Proveedor> proveedores = pd.listarTodo();

            Set<String> proveedoresAgregados = new HashSet<>();

            for (Proveedor p : proveedores) {
                String nombreProveedores = p.getNombre();
                if (!proveedoresAgregados.contains(nombreProveedores)) {
                    jcProveedores.addItem(p);
                    proveedoresAgregados.add(nombreProveedores);
                }
            }

            jcProveedores.setSelectedIndex(-1);

            session.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    private void setearUser(Usuario usuarioBuscado) {
        try {
            for (int i = 0; i <= jcUsuarios.getItemCount(); i++) {
                Usuario usuario = (Usuario) jcUsuarios.getItemAt(i);

                if (usuario.getNombre().equals(usuarioBuscado.getNombre())) {

                    jcUsuarios.setSelectedItem(usuario);
                    break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        jcProveedores.setSelectedIndex(-1);
        jcFormaDePago.setSelectedIndex(-1);
        jtCosto.setText("0");
        jtCosto.setText("0");
    }

    public void cargarFormasDePago() {
        try {
            jcFormaDePago.removeAllItems();

            Session session = HibernateConfig.get().openSession();
            FormaDePago_data fdpd = new FormaDePago_data(session);
            List<FormaDePago> formasDePago = fdpd.listarTodo();

            Set<String> formasDePagoAgregadas = new HashSet<>();

            for (FormaDePago fp : formasDePago) {
                String formaDePago = fp.getNombreFormaDePago();
                if (!formasDePagoAgregadas.contains(formaDePago)) {
                    jcFormaDePago.addItem(fp);
                    formasDePagoAgregadas.add(formaDePago);
                }
            }

            jcFormaDePago.setSelectedIndex(-1);

            session.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    public String setFecha() {
        Date fechaYHoraActual = new Date();

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String fechaYHoraFormateada = formato.format(fechaYHoraActual);

        return fechaYHoraFormateada;
    }

}

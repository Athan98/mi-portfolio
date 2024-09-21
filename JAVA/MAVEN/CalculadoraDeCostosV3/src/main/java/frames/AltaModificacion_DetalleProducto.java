package frames;

import config.HibernateConfig;
import data.*;
import entidades.*;
import static frames.Principal.escritorio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class AltaModificacion_DetalleProducto extends javax.swing.JInternalFrame {

    private SwingWorker<Void, Void> cargaWorker;
    private float valorPaquete = 0;

    List<Proveedor> proveedores = new ArrayList<>();
    List<Producto> productos = new ArrayList<>();
    List<DetalleProducto> detalles = new ArrayList<>();

    public int idDetalleProducto;

    public AltaModificacion_DetalleProducto(int idDetalleProducto) {
        initComponents();
        proveedores = listarProveedores();
        detalles = listarDetallesProductos();
        productos = listarProductos();
        cargarProveedores();
        cargarProductos();
        this.idDetalleProducto = idDetalleProducto;
        setDetallesProducto();
        jbAgregar.setEnabled(false);
    }

    public AltaModificacion_DetalleProducto() {
        initComponents();
        proveedores = listarProveedores();
        detalles = listarDetallesProductos();
        productos = listarProductos();
        cargarProveedores();
        cargarProductos();
        jbGuardar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcProveedores = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtCostoUnitario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtCantidadPorPaquete = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtValorPaquete = new javax.swing.JTextField();
        jbNuevoProveedor = new javax.swing.JButton();
        jbActualizarListaProv = new javax.swing.JButton();
        jbCalcularPack = new javax.swing.JButton();
        jcProductos = new javax.swing.JComboBox<>();
        jbNuevoProducto = new javax.swing.JButton();
        jbActualizarListaProductos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbGuardar = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Alta y modificación de Detalles de Producto");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre del producto :");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Preventista :");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio por unidad :");

        jtCostoUnitario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCostoUnitario.setText("0");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cantidad por paquete :");

        jtCantidadPorPaquete.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCantidadPorPaquete.setText("0");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Valor del paquete :");

        jtValorPaquete.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtValorPaquete.setText("0");

        jbNuevoProveedor.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jbNuevoProveedor.setText("Modificar");
        jbNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoProveedorActionPerformed(evt);
            }
        });

        jbActualizarListaProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jbActualizarListaProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarListaProvActionPerformed(evt);
            }
        });

        jbCalcularPack.setFont(new java.awt.Font("Trebuchet MS", 2, 14)); // NOI18N
        jbCalcularPack.setForeground(new java.awt.Color(0, 204, 0));
        jbCalcularPack.setText("Calcular valor del paquete");
        jbCalcularPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularPackActionPerformed(evt);
            }
        });

        jbNuevoProducto.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jbNuevoProducto.setText("Modificar");
        jbNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoProductoActionPerformed(evt);
            }
        });

        jbActualizarListaProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jbActualizarListaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarListaProductosActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbGuardar.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(0, 0, 0));
        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/guardar.png"))); // NOI18N
        jbGuardar.setText(" GUARDAR");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbAgregar.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jbAgregar.setText(" NUEVO");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jbGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcProductos, 0, 263, Short.MAX_VALUE)
                                    .addComponent(jcProveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbNuevoProducto)
                                    .addComponent(jbNuevoProveedor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbActualizarListaProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbActualizarListaProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtValorPaquete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(jtCantidadPorPaquete, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtCostoUnitario, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(jbCalcularPack, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbActualizarListaProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizarListaProv, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtCantidadPorPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtValorPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCalcularPack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoProveedorActionPerformed
/// Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }

        this.dispose();

        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

                loading.setVisible(true);

                try {
                    int idProveedor = ((Proveedor) jcProveedores.getSelectedItem()).getIdProveedor();
                    Thread.sleep(2000);
                    AltaBajaModificacion_Proveedor abmp = new AltaBajaModificacion_Proveedor(idProveedor);
                    abmp.setVisible(true);
                    escritorio.add(abmp);
                    escritorio.moveToFront(abmp);
                    abmp.setLocation((escritorio.getWidth() - abmp.getWidth()) / 2, (escritorio.getHeight() - abmp.getHeight()) / 2);
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
    }//GEN-LAST:event_jbNuevoProveedorActionPerformed

    private void jbActualizarListaProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarListaProvActionPerformed
        cargarProveedores();
    }//GEN-LAST:event_jbActualizarListaProvActionPerformed

    private void jbCalcularPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularPackActionPerformed
        float precioUnitario = Float.parseFloat(jtCostoUnitario.getText());
        int cantidadUnidades = Integer.parseInt(jtCantidadPorPaquete.getText());
        valorPaquete = precioUnitario * cantidadUnidades;
        jtValorPaquete.setText(valorPaquete + "");
    }//GEN-LAST:event_jbCalcularPackActionPerformed

    private void jbNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoProductoActionPerformed
// Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }

        this.dispose();

        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

                loading.setVisible(true);

                try {
                    int idProducto = ((Producto) jcProductos.getSelectedItem()).getIdProducto();
                    Thread.sleep(2000);
                    AltaBajaModificacion_Producto abmp = new AltaBajaModificacion_Producto(idProducto);
                    abmp.setVisible(true);
                    escritorio.add(abmp);
                    escritorio.moveToFront(abmp);
                    abmp.setLocation((escritorio.getWidth() - abmp.getWidth()) / 2, (escritorio.getHeight() - abmp.getHeight()) / 2);
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
    }//GEN-LAST:event_jbNuevoProductoActionPerformed

    private void jbActualizarListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarListaProductosActionPerformed
        cargarProductos();
    }//GEN-LAST:event_jbActualizarListaProductosActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed

        Session session = null;

        DetalleProducto dp = new DetalleProducto(
                idDetalleProducto,
                (Producto) jcProductos.getSelectedItem(),
                (Proveedor) jcProveedores.getSelectedItem(),
                Float.parseFloat(jtCostoUnitario.getText()),
                Integer.parseInt(jtCantidadPorPaquete.getText()),
                Float.parseFloat(jtValorPaquete.getText())
        );

        try {
            session = HibernateConfig.get().openSession();
            DetalleProducto_data dpd = new DetalleProducto_data(session);
            dpd.actualizar(dp);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            this.dispose();
            Productos_Proveedores pp = new Productos_Proveedores();
            pp.setVisible(true);
            Principal.escritorio.add(pp);
            Principal.escritorio.moveToFront(pp);
            pp.setLocation((Principal.escritorio.getWidth() - pp.getWidth()) / 2, (Principal.escritorio.getHeight() - pp.getHeight()) / 2);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        Session session = null;

        DetalleProducto dp = new DetalleProducto(
                (Producto) jcProductos.getSelectedItem(),
                (Proveedor) jcProveedores.getSelectedItem(),
                Float.parseFloat(jtCostoUnitario.getText()),
                Integer.parseInt(jtCantidadPorPaquete.getText()),
                Float.parseFloat(jtValorPaquete.getText())
        );

        try {
            session = HibernateConfig.get().openSession();
            DetalleProducto_data dpd = new DetalleProducto_data(session);
            dpd.agregar(dp);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            this.dispose();
        }
    }//GEN-LAST:event_jbAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbActualizarListaProductos;
    private javax.swing.JButton jbActualizarListaProv;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbCalcularPack;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevoProducto;
    private javax.swing.JButton jbNuevoProveedor;
    private javax.swing.JComboBox<Producto> jcProductos;
    private javax.swing.JComboBox<Proveedor> jcProveedores;
    private javax.swing.JTextField jtCantidadPorPaquete;
    private javax.swing.JTextField jtCostoUnitario;
    private javax.swing.JTextField jtValorPaquete;
    // End of variables declaration//GEN-END:variables

    private void cargarProveedores() {
        jcProveedores.removeAllItems();
        Set<String> proveedoresAgregados = new HashSet<>();
        for (Proveedor p : proveedores) {
            String nombreProveedores = p.getNombre();
            if (!proveedoresAgregados.contains(nombreProveedores)) {
                jcProveedores.addItem(p);
                proveedoresAgregados.add(nombreProveedores);
            }
        }
        jcProveedores.setSelectedIndex(-1);
    }

    private void cargarProductos() {
        jcProductos.removeAllItems();
        Set<String> productosAgregados = new HashSet<>();
        for (Producto p : productos) {
            String nombreProducto = p.getNombre();
            if (!productosAgregados.contains(nombreProducto)) {
                jcProductos.addItem(p);
                productosAgregados.add(nombreProducto);
            }
        }
        jcProductos.setSelectedIndex(-1);
    }

    public List<Proveedor> listarProveedores() {
        Session session = null;
        try {
            session = HibernateConfig.get().openSession();
            Proveedor_data pd = new Proveedor_data(session);
            return pd.listarTodo();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return Collections.emptyList();
    }

    public List<DetalleProducto> listarDetallesProductos() {
        Session session = null;
        try {
            session = HibernateConfig.get().openSession();
            DetalleProducto_data dpd = new DetalleProducto_data(session);
            return dpd.listarTodo();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return Collections.emptyList();
    }

    public List<Producto> listarProductos() {
        Session session = null;
        try {
            session = HibernateConfig.get().openSession();
            Producto_data pd = new Producto_data(session);
            return pd.listarTodo();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return Collections.emptyList();
    }

    public void setDetallesProducto() {
        Proveedor prov;
        Producto prod;
        for (DetalleProducto dp : detalles) {
            if (dp.getIdDetalleProducto() == idDetalleProducto) {
                jcProductos.setSelectedItem(dp.getProducto().getNombre());
                prov = dp.getProveedor();
                prod = dp.getProducto();
                jtCostoUnitario.setText(dp.getPrecioCosto() + "");
                jtCantidadPorPaquete.setText(dp.getUnidadesPorPaquete() + "");
                jtValorPaquete.setText(dp.getPrecioPorPaquete() + "");

                for (int i = 0; i < jcProveedores.getItemCount(); i++) {
                    Proveedor item = (Proveedor) jcProveedores.getItemAt(i);
                    if (item.getIdProveedor() == prov.getIdProveedor()) {
                        jcProveedores.setSelectedItem(item);
                        break;
                    }
                }

                for (int i = 0; i < jcProductos.getItemCount(); i++) {
                    Producto item = (Producto) jcProductos.getItemAt(i);
                    if (item.getIdProducto() == prod.getIdProducto()) {
                        jcProductos.setSelectedItem(item);
                        break;
                    }
                }
            }
        }
    }
}

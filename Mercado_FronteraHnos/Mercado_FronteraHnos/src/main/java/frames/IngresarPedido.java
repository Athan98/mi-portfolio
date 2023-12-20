package frames;

import config.HibernateConfig;
import data.*;
import entidades.*;
import static frames.Principal.escritorio;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class IngresarPedido extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    Double costoTotal = 0.0;
    Pedido ped;

    public IngresarPedido() {
        initComponents();
        borrarColumnas();
        armarCabeceraTabla();
        llenarComboProductos();
        llenarComboUsers();
        llenarComboProveedores();
        jtFecha.setText(convertirFecha(LocalDate.now()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jcProveedores = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcProductos = new javax.swing.JComboBox<>();
        jbAgregarProducto = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jlCostoTotal = new javax.swing.JLabel();
        jbIngresarPedido = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jtCosto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtCantidad = new javax.swing.JTextField();
        jbAgregarProveedor = new javax.swing.JButton();
        jbActualizarProductos = new javax.swing.JButton();
        jbActualizarProveedores = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcUsuarios = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtFecha = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUEVAS ENTRADAS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 20))); // NOI18N

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Proveedor :");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Producto :");

        jcProductos.setMaximumRowCount(999999999);

        jbAgregarProducto.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jbAgregarProducto.setText("NUEVO");
        jbAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarProductoActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(0, 153, 0));
        jbAgregar.setText("AGREGAR");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(153, 0, 0));
        jbEliminar.setText("ELIMINAR");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEliminar))
                .addContainerGap())
        );

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableProductos);

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 0, 153));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Costo total ($) :");

        jlCostoTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlCostoTotal.setForeground(new java.awt.Color(153, 0, 153));
        jlCostoTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCostoTotal.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlCostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlCostoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jbIngresarPedido.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jbIngresarPedido.setText("INGRESAR PEDIDO");
        jbIngresarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIngresarPedidoActionPerformed(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Costo Unitario ($):");

        jtCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCosto.setText("0");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Cantidad :");

        jtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCantidad.setText("0");

        jbAgregarProveedor.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jbAgregarProveedor.setText("NUEVO");
        jbAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarProveedorActionPerformed(evt);
            }
        });

        jbActualizarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jbActualizarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarProductosActionPerformed(evt);
            }
        });

        jbActualizarProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jbActualizarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarProveedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jcProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAgregarProveedor))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAgregarProducto)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbActualizarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbActualizarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbIngresarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbActualizarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbAgregarProveedor)
                                .addComponent(jLabel14))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jcProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbAgregarProducto)
                        .addComponent(jLabel15))
                    .addComponent(jbActualizarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbIngresarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la venta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel2.setText("Usuario:");

        jLabel4.setText("Fecha:");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProductoActionPerformed
        AgregarProductoPedido app = new AgregarProductoPedido();
        app.setVisible(true);
        Principal.escritorio.add(app);
        Principal.escritorio.moveToFront(app);
        app.setLocation((Principal.escritorio.getWidth() - app.getWidth()) / 2, (Principal.escritorio.getHeight() - app.getHeight()) / 2);
    }//GEN-LAST:event_jbAgregarProductoActionPerformed

    private void jbAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProveedorActionPerformed
        // Crear e iniciar el hilo para ejecutar la carga en segundo plano
        Thread cargaThread = new Thread(() -> {
            // Mostrar el frame de carga
            Loading loading = new Loading();
            loading.setVisible(true);

            try {
                Thread.sleep(2000);
                Proveedores prov = new Proveedores();
                prov.setVisible(true);

                escritorio.add(prov);
                escritorio.moveToFront(prov);

            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar el frame de carga
            loading.dispose();
        });

        // Iniciar el hilo
        cargaThread.start();
    }//GEN-LAST:event_jbAgregarProveedorActionPerformed

    private void jbActualizarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarProductosActionPerformed
        llenarComboProductos();
    }//GEN-LAST:event_jbActualizarProductosActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed

        if (jcProveedores.getSelectedIndex() == -1 || jcProductos.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto y un proveedor");
        } else {
            Proveedor prov = (Proveedor) jcProveedores.getSelectedItem();
            Producto prod = (Producto) jcProductos.getSelectedItem();
            Double costo = Double.parseDouble(jtCosto.getText());
            int cantidad = Integer.parseInt(jtCantidad.getText());

            modelo.addRow(new Object[]{
                prod.getIdProducto(),
                prod.getCodigo(),
                prod.getNombre(),
                prov.getIdProveedor(),
                prov.getNombre(),
                costo,
                cantidad,});

            costoTotal = costoTotal + (costo * cantidad);
            jlCostoTotal.setText(Math.round(costoTotal * 100.0) / 100.0 + "");

            limpiarCampos();
        }

    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int filaSeleccionada = jTableProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            Double costo = (Double) modelo.getValueAt(filaSeleccionada, 5);
            int cantidad = (int) modelo.getValueAt(filaSeleccionada, 6);

            costoTotal = costoTotal - (costo * cantidad);

            jlCostoTotal.setText(Math.round(costoTotal * 100.0) / 100.0 + "");

            modelo.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbIngresarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIngresarPedidoActionPerformed
        Session session = HibernateConfig.get().openSession();

        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea confirmar la operacion ?", "Confirmación de ingreso", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Operacion cancelada");
        } else {

            if (jcUsuarios.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe especificar que usuario realiza el ingreso");
            } else {

                try {
                    Producto_data pd = new Producto_data(session);
                    Pedido_data pedd = new Pedido_data(session);
                    DetallePedido_data dpd = new DetallePedido_data(session);
                    Proveedor_data provd = new Proveedor_data(session);

                    //CREO EL PEDIDO
                    Date fechaDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
                    Usuario user = (Usuario) jcUsuarios.getSelectedItem();
                    Double precioCostoTotal = Double.parseDouble(jlCostoTotal.getText());
                    List<DetallePedido> detalles = new ArrayList<>();

                    ped = new Pedido(fechaDate, detalles, precioCostoTotal, user);

                    pedd.agregar(ped);

                    int filas = modelo.getRowCount();
                    int idProducto = 0;
                    int idProveedor = 0;
                    int cantidad = 0;
                    double precioCosto = 0.0;
                    double precioCostoPorProducto = 0.0;
                    Producto p = null;
                    DetallePedido dp = null;
                    Proveedor prov = null;

                    for (int i = 0; i <= filas - 1; i++) {
                        idProducto = (int) modelo.getValueAt(i, 0);
                        idProveedor = (int) modelo.getValueAt(i, 3);
                        cantidad = (int) modelo.getValueAt(i, 6);
                        precioCosto = (double) modelo.getValueAt(i, 5);

                        prov = provd.encontrarPorID(idProveedor);

                        p = pd.encontrarPorID(idProducto);
                        p.setPrecioCostoUnitario(precioCosto);
                        p.setStock(p.getStock() + cantidad);

                        precioCostoPorProducto = precioCosto * cantidad;

                        dp = new DetallePedido(ped, prov, p, cantidad, precioCostoPorProducto);

                        detalles.add(dp);

                        dpd.agregar(dp);
                    }

                    ped.setDetallesPedido(detalles);

                    pedd.actualizar(ped);

                    limpiarCampos();
                    borrarFilas();
                    costoTotal=0.0;
                    jlCostoTotal.setText("0");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
                }

            }

        }

        session.close();
    }//GEN-LAST:event_jbIngresarPedidoActionPerformed

    private void jbActualizarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarProveedoresActionPerformed
        llenarComboProveedores();
    }//GEN-LAST:event_jbActualizarProveedoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JButton jbActualizarProductos;
    private javax.swing.JButton jbActualizarProveedores;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbAgregarProducto;
    private javax.swing.JButton jbAgregarProveedor;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbIngresarPedido;
    public javax.swing.JComboBox<Producto> jcProductos;
    private javax.swing.JComboBox<Proveedor> jcProveedores;
    private javax.swing.JComboBox<Usuario> jcUsuarios;
    private javax.swing.JLabel jlCostoTotal;
    private javax.swing.JTextField jtCantidad;
    private javax.swing.JTextField jtCosto;
    private javax.swing.JTextField jtFecha;
    // End of variables declaration//GEN-END:variables

    public void armarCabeceraTabla() {
        modelo.setColumnCount(0);

        modelo.addColumn("ID Producto");
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Costo ($)");
        modelo.addColumn("Cantidad");

        jTableProductos.setModel(modelo);
    }

    public void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private void llenarComboUsers() {
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
    }

    public void llenarComboProductos() {
        jcProductos.removeAllItems();

        Session session = HibernateConfig.get().openSession();
        Producto_data pd = new Producto_data(session);
        List<Producto> productos = pd.listarTodo();
        System.out.println(productos);

        for (Producto p : productos) {
            jcProductos.addItem(p);
        }

        jcProductos.setSelectedIndex(-1);

        session.close();
    }

    private void llenarComboProveedores() {
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
    }

    public void borrarColumnas() {

        modelo.setColumnCount(0);

    }

    private void limpiarCampos() {
        jcProveedores.setSelectedIndex(-1);
        jcProductos.setSelectedIndex(-1);
        jtCantidad.setText("0");
        jtCosto.setText("0");
    }

    public String convertirFecha(LocalDate fechaActual) {
        // Crear un formateador para el formato dd-MM-yyyy
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Convertir LocalDate a String en el formato especificado
        String fechaFormateada = fechaActual.format(formateador);

        // Convertir LocalDate a Date
        Date fechaDate = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Configurar el texto del TextField
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechaDateFormateada = sdf.format(fechaDate);

        return fechaDateFormateada;
    }

}

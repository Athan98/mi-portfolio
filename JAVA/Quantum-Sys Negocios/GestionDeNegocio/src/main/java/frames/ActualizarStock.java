package frames;

import config.HibernateConfig;
import data.*;
import entidades.*;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class ActualizarStock extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    List<Producto> productosBuscados = null;

    public ActualizarStock() {
        initComponents();
        borrarColumnas();
        armarCabeceraTabla();
        actualizarListaProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jtBusquedaCodigo = new javax.swing.JTextField();
        jtBuscarPorNombre = new javax.swing.JTextField();
        jbEscanear = new javax.swing.JButton();
        jbLimpiarCodigo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtStock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jbActualizar = new javax.swing.JButton();

        setClosable(true);
        setTitle("ACTUALIZAR STOCKS");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACTUALIZAR STOCK", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 20))); // NOI18N

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
        jScrollPane2.setViewportView(jTableProductos);

        jtBusquedaCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtBusquedaCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaCodigoKeyReleased(evt);
            }
        });

        jtBuscarPorNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtBuscarPorNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarPorNombreKeyReleased(evt);
            }
        });

        jbEscanear.setText("Escanear");
        jbEscanear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEscanearActionPerformed(evt);
            }
        });

        jbLimpiarCodigo.setText("Limpiar");
        jbLimpiarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCodigoActionPerformed(evt);
            }
        });

        jLabel11.setText("Buscar por codigo:");

        jLabel10.setText("Buscar por nombre:");

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("unidades");

        jtStock.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtStock.setForeground(new java.awt.Color(153, 0, 153));
        jtStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtStock.setText("0");
        jtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtStockKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setText("Se agregan ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtStock)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jbActualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbActualizar.setForeground(new java.awt.Color(0, 153, 0));
        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actualizar.png"))); // NOI18N
        jbActualizar.setText("ACTUALIZAR");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jtBusquedaCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jbEscanear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbLimpiarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtBuscarPorNombre))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtBusquedaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEscanear)
                    .addComponent(jbLimpiarCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtBusquedaCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaCodigoKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtBusquedaCodigo.setEditable(true);
        } else {
            jtBusquedaCodigo.setEditable(false);
        }
    }//GEN-LAST:event_jtBusquedaCodigoKeyPressed

    private void jtBuscarPorNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarPorNombreKeyPressed
        char x = evt.getKeyChar();
        if (Character.isLetter(x) || Character.isISOControl(x) || (evt.getKeyChar() == ' ')) {
            jtBuscarPorNombre.setEditable(true);
        } else {
            jtBuscarPorNombre.setEditable(false);
        }
    }//GEN-LAST:event_jtBuscarPorNombreKeyPressed

    private void jtBuscarPorNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarPorNombreKeyReleased
        try {
            String campoBuscarNombre = jtBuscarPorNombre.getText().toUpperCase();

            borrarFilas();

            for (Producto p : productosBuscados) {
                if (p.getNombre().toUpperCase().startsWith(campoBuscarNombre)) {
                    modelo.addRow(new Object[]{
                        p.getIdProducto(),
                        p.getCodigo(),
                        p.getCategoria().getNombre(),
                        p.getNombre(),
                        p.getPrecioCostoUnitario(),
                        p.getPrecioVentaUnitario(),
                        p.getStock(),});
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

    }//GEN-LAST:event_jtBuscarPorNombreKeyReleased

    private void jbEscanearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEscanearActionPerformed
        jtBusquedaCodigo.setText("");
        JOptionPane.showMessageDialog(null, "Presione ACEPTAR y escanee el producto");
        jtBusquedaCodigo.requestFocus();
    }//GEN-LAST:event_jbEscanearActionPerformed

    private void jbLimpiarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCodigoActionPerformed
        jtBusquedaCodigo.setText("");
        actualizarListaProductos();
    }//GEN-LAST:event_jbLimpiarCodigoActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed

        try {
            int idProducto = (int) modelo.getValueAt(jTableProductos.getSelectedRow(), 0);
            int stock = Integer.parseInt(jtStock.getText());

            Session session = HibernateConfig.get().openSession();
            Producto_data pd = new Producto_data(session);

            Producto prod = pd.encontrarPorID(idProducto);

            prod.setStock(prod.getStock() + stock);

            pd.actualizar(prod);

            session.close();

            actualizarListaProductos();

            JOptionPane.showMessageDialog(null, "El stock ha sido actualizado");

            jtBuscarPorNombre.setText("");
            jtBusquedaCodigo.setText("");
            jtStock.setText("0");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jtBusquedaCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaCodigoKeyReleased
        try {
            String campoBuscarCodigo = jtBusquedaCodigo.getText();

            borrarFilas();

            for (Producto p : productosBuscados) {
                if (p.getCodigo().startsWith(campoBuscarCodigo) || p.getCodigo().equals(campoBuscarCodigo)) {
                    modelo.addRow(new Object[]{
                        p.getIdProducto(),
                        p.getCodigo(),
                        p.getCategoria().getNombre(),
                        p.getNombre(),
                        p.getPrecioCostoUnitario(),
                        p.getPrecioVentaUnitario(),
                        p.getStock(),});
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jtBusquedaCodigoKeyReleased

    private void jtStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtStockKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtStock.setEditable(true);
        } else {
            jtStock.setEditable(false);
        }
    }//GEN-LAST:event_jtStockKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbEscanear;
    private javax.swing.JButton jbLimpiarCodigo;
    private javax.swing.JTextField jtBuscarPorNombre;
    private javax.swing.JTextField jtBusquedaCodigo;
    private javax.swing.JTextField jtStock;
    // End of variables declaration//GEN-END:variables

    public void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    public void actualizarListaProductos() {

        try {

            modelo.setRowCount(0);

            Session session = HibernateConfig.get().openSession();

            Producto_data pd = new Producto_data(session);

            productosBuscados = pd.listarTodo();

            for (Producto p : productosBuscados) {
                modelo.addRow(new Object[]{
                    p.getIdProducto(),
                    p.getCodigo(),
                    p.getCategoria().getNombre(),
                    p.getNombre(),
                    p.getPrecioCostoUnitario(),
                    p.getPrecioVentaUnitario(),
                    p.getStock(),});

            }

            session.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    public void armarCabeceraTabla() {
        modelo.setColumnCount(0);

        modelo.addColumn("ID");
        modelo.addColumn("Codigo");
        modelo.addColumn("Categoria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Costo unitario");
        modelo.addColumn("Precio venta unitario");
        modelo.addColumn("Stock");

        jTableProductos.setModel(modelo);
    }

    public void borrarColumnas() {

        modelo.setColumnCount(0);

    }
}

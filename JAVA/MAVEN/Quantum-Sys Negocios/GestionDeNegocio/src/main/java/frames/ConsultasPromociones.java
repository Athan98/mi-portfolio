package frames;

import entidades.Producto;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultasPromociones extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };
    
    List<Producto>prod=Consultas.productos;

    public ConsultasPromociones() {
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

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jtBusquedaCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(jbEscanear)
                                .addGap(18, 18, 18)
                                .addComponent(jbLimpiarCodigo))
                            .addComponent(jtBuscarPorNombre))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiarCodigo)
                    .addComponent(jbEscanear)
                    .addComponent(jtBusquedaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

            for (Producto p : prod) {
                if ((p.getNombre().toUpperCase().startsWith(campoBuscarNombre)) && (p.getCategoria().getNombre().equals("PROMOCIONES")
                        || p.getCategoria().getNombre().equals("PROMO")
                        || p.getCategoria().getNombre().equals("PROMOCION"))) {
                    modelo.addRow(new Object[]{
                        p.getCodigo(),
                        p.getCategoria().getNombre(),
                        p.getNombre(),
                        p.getPrecioVentaUnitario()});
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
        try {
            jtBusquedaCodigo.setText("");
            borrarFilas();

            for (Producto p : prod) {
                if (p.getCategoria().getNombre().equals("PROMOCIONES") || p.getCategoria().getNombre().equals("PROMO")
                        || p.getCategoria().getNombre().equals("PROMOCION")) {
                    modelo.addRow(new Object[]{
                        p.getCodigo(),
                        p.getCategoria().getNombre(),
                        p.getNombre(),
                        p.getPrecioVentaUnitario()});
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbLimpiarCodigoActionPerformed

    private void jtBusquedaCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaCodigoKeyReleased
        try {
            String campoBuscarCodigo = jtBusquedaCodigo.getText();

            borrarFilas();

            for (Producto p : prod) {
                if ((p.getCodigo().startsWith(campoBuscarCodigo) || p.getCodigo().equals(campoBuscarCodigo)) && (p.getCategoria().getNombre().equals("PROMOCIONES")
                        || p.getCategoria().getNombre().equals("PROMO")
                        || p.getCategoria().getNombre().equals("PROMOCION"))) {
                    modelo.addRow(new Object[]{
                        p.getCodigo(),
                        p.getCategoria().getNombre(),
                        p.getNombre(),});
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

    }//GEN-LAST:event_jtBusquedaCodigoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JButton jbEscanear;
    private javax.swing.JButton jbLimpiarCodigo;
    private javax.swing.JTextField jtBuscarPorNombre;
    private javax.swing.JTextField jtBusquedaCodigo;
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

            for (Producto p : prod) {
                if (p.getCategoria().getNombre().equals("PROMOCIONES") || p.getCategoria().getNombre().equals("PROMO")
                        || p.getCategoria().getNombre().equals("PROMOCION")) {
                    modelo.addRow(new Object[]{
                        p.getCodigo(),
                        p.getCategoria().getNombre(),
                        p.getNombre(),
                        p.getPrecioVentaUnitario()});
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }

    }

    public void armarCabeceraTabla() {
        modelo.setColumnCount(0);

        modelo.addColumn("Codigo");
        modelo.addColumn("Categoria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio Venta");

        jTableProductos.setModel(modelo);
        jTableProductos.setRowHeight(25);

    }

    public void borrarColumnas() {

        modelo.setColumnCount(0);

    }

}

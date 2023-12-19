package frames;

import config.HibernateConfig;
import data.Categoria_data;
import data.Producto_data;
import entidades.Categoria;
import entidades.Producto;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class AgregarProductoPedido extends javax.swing.JInternalFrame {
    

    public AgregarProductoPedido() {
        initComponents();
        cargarComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtCodigo = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcCategorias = new javax.swing.JComboBox<>();
        jbAgregarCategoria = new javax.swing.JButton();
        jbEscanearNuevo = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jbLimpiar = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();

        setClosable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripciones del producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jtDescripcion.setColumns(20);
        jtDescripcion.setRows(5);
        jScrollPane1.setViewportView(jtDescripcion);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Descripcion:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre:");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Código:");

        jtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCodigoKeyPressed(evt);
            }
        });

        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNombreKeyPressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Categoria:");

        jbAgregarCategoria.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jbAgregarCategoria.setText("NUEVO");
        jbAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarCategoriaActionPerformed(evt);
            }
        });

        jbEscanearNuevo.setText("Escanear");
        jbEscanearNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEscanearNuevoActionPerformed(evt);
            }
        });

        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(172, 172, 172))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbEscanearNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jcCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jbAgregarCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCodigo)
                    .addComponent(jbEscanearNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbLimpiar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        jbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiar.png"))); // NOI18N
        jbLimpiar.setText("LIMPIAR CAMPOS");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar.png"))); // NOI18N
        jbAgregar.setText("AGREGAR PRODUCTO");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jbLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodigoKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtCodigo.setEditable(true);
        } else {
            jtCodigo.setEditable(false);
        }
    }//GEN-LAST:event_jtCodigoKeyPressed

    private void jtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyPressed
        char x = evt.getKeyChar();
        if (Character.isLetter(x) || Character.isISOControl(x) || (evt.getKeyChar() == ' ')) {
            jtNombre.setEditable(true);
        } else {
            jtNombre.setEditable(false);
        }
    }//GEN-LAST:event_jtNombreKeyPressed

    private void jbEscanearNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEscanearNuevoActionPerformed
        jtCodigo.setText("");
        JOptionPane.showMessageDialog(null, "Presione ACEPTAR y escanee el producto");
        jtCodigo.requestFocus();
    }//GEN-LAST:event_jbEscanearNuevoActionPerformed

    private void jbAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarCategoriaActionPerformed
        Categorias c = new Categorias();
        c.setVisible(true);
        Principal.escritorio.add(c);
        Principal.escritorio.moveToFront(c);
        c.setLocation((Principal.escritorio.getWidth() - c.getWidth()) / 2, (Principal.escritorio.getHeight() - c.getHeight()) / 2);
    }//GEN-LAST:event_jbAgregarCategoriaActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        cargarComboBox();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed

        Session session = HibernateConfig.get().openSession();
        Categoria cat = (Categoria) jcCategorias.getSelectedItem();
        String nombreProd = jtNombre.getText();
        String descripcion = jtDescripcion.getText();
        String codigo = jtCodigo.getText();
        Double precioVentaUnitario = 0.0;
        Double precioCostoUnitario = 0.0;
        int stock = 0;

        if (jtCodigo.getText().isEmpty() || jtNombre.getText().isEmpty()
                || jcCategorias.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos");
        } else {

            Producto prod = new Producto(cat, nombreProd, descripcion, codigo, precioVentaUnitario, precioCostoUnitario, stock);

            Producto_data pd = new Producto_data(session);

            pd.agregar(prod);
        }

        session.close();

        limpiarCampos();

    }//GEN-LAST:event_jbAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbAgregarCategoria;
    private javax.swing.JButton jbEscanearNuevo;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JComboBox<Categoria> jcCategorias;
    private javax.swing.JTextField jtCodigo;
    private javax.swing.JTextArea jtDescripcion;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables

    public void cargarComboBox() {
        jcCategorias.removeAllItems();

        Session session = HibernateConfig.get().openSession();
        Categoria_data cat_data = new Categoria_data(session);
        List<Categoria> categorias = cat_data.listarTodo();

        Set<String> categoriasAgregadas = new HashSet<>();

        for (Categoria cat : categorias) {
            String categoria = cat.getNombre();
            if (!categoriasAgregadas.contains(categoria)) {
                jcCategorias.addItem(cat);
                categoriasAgregadas.add(categoria);
            }
        }

        jcCategorias.setSelectedIndex(-1);

        session.close();
    }

    private void limpiarCampos() {
        jcCategorias.setSelectedIndex(-1);
        jtCodigo.setText("");
        jtNombre.setText("");
        jtDescripcion.setText("");
    }

}

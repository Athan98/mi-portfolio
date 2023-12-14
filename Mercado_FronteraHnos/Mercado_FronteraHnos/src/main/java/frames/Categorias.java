package frames;

import config.HibernateConfig;
import data.Categoria_data;
import entidades.Categoria;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class Categorias extends javax.swing.JInternalFrame {

    Productos frameProd;

    public Categorias(Productos prod) {
        initComponents();
        this.frameProd=prod;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtNuevaCategoria = new javax.swing.JTextField();
        jbVolver = new javax.swing.JButton();
        jbAgregarCategoria = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CATEGORIAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Ingrese el nombre de la categoria:");

        jbVolver.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jbVolver.setForeground(new java.awt.Color(0, 0, 0));
        jbVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/volver_1.png"))); // NOI18N
        jbVolver.setText("VOLVER");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jbAgregarCategoria.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jbAgregarCategoria.setForeground(new java.awt.Color(0, 0, 0));
        jbAgregarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar_1.png"))); // NOI18N
        jbAgregarCategoria.setText("AGREGAR CATEGORIA");
        jbAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jtNuevaCategoria))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jbVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jbAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(50, 50, 50)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jtNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbVolver)
                        .addComponent(jbAgregarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(46, 46, 46)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        this.setVisible(false);
        frameProd.cargarComboBox();
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarCategoriaActionPerformed

        if (jtNuevaCategoria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre de la categoría");
        } else if (verificarCategoria() == true) {
            JOptionPane.showMessageDialog(null, "La categoria ingresada ya existe");
            jtNuevaCategoria.setText("");
        } else {
            String nombreCategoria = jtNuevaCategoria.getText().toUpperCase();
            Categoria cat = new Categoria(nombreCategoria);
            Session session = HibernateConfig.get().openSession();
            Categoria_data cat_data = new Categoria_data(session);
            cat_data.agregar(cat);
            jtNuevaCategoria.setText("");
            session.close();
        }
    }//GEN-LAST:event_jbAgregarCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbAgregarCategoria;
    private javax.swing.JButton jbVolver;
    private javax.swing.JTextField jtNuevaCategoria;
    // End of variables declaration//GEN-END:variables

    private boolean verificarCategoria() {
        boolean verificacion = false;
        String nombreCategoria = jtNuevaCategoria.getText().toUpperCase();

        Session session = HibernateConfig.get().openSession();
        Categoria_data cat_data = new Categoria_data(session);
        List<Categoria> categorias = cat_data.listarTodo();

        for (Categoria cat : categorias) {
            if (nombreCategoria.equals(cat.getNombre())) {
                verificacion = true;
            }
        }
        session.close();
        return verificacion;
    }
}

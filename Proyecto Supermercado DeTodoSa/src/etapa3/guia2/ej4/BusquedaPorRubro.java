/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etapa3.guia2.ej4;

import javax.swing.table.DefaultTableModel;

public class BusquedaPorRubro extends javax.swing.JInternalFrame {

    DefaultTableModel modelo3 = new DefaultTableModel();

    public boolean isCellEditable3(int c, int f) {
        return false;
    }

    public BusquedaPorRubro() {
        initComponents();
        armarCabeceraTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtBusquedaPorRubro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos3 = new javax.swing.JTable();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Listado por \"Rubro\"");

        jLabel2.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel2.setText("Escriba los primeros caracteres");

        jtBusquedaPorRubro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaPorRubroKeyReleased(evt);
            }
        });

        jtProductos3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtProductos3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtBusquedaPorRubro)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtBusquedaPorRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtBusquedaPorRubroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaPorRubroKeyReleased
        borrarFilas();
        for (Producto producto : MenuPrincipal.listaProductos) {
            String categoria = producto.getRubros().toString();
            if (categoria.startsWith(jtBusquedaPorRubro.getText())) {
                modelo3.addRow(new Object[]{
                    producto.getCodigo(),
                    producto.getDescripción(),
                    producto.getPrecio(),
                    producto.getStock()
                });
            }
        }
    }//GEN-LAST:event_jtBusquedaPorRubroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtBusquedaPorRubro;
    private javax.swing.JTable jtProductos3;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceraTabla() {
        modelo3.addColumn("Codigo");
        modelo3.addColumn("Descripcion");
        modelo3.addColumn("Precio ($)");
        modelo3.addColumn("Stock");
        jtProductos3.setModel(modelo3);
    }

//IR BORRANDO FILAS QUE NO PERTENECEN A LA BUSQUEDA//
    private void borrarFilas() {
        int f = jtProductos3.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo3.removeRow(f);
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalFrames;

import Entidades.Cliente;
import etapa3.guia2.ejextra2.Directorio;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class BusquedaPorApellido extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    private int filaSeleccionada;

    /**
     * Creates new form BusquedaPorTelefono
     */
    public BusquedaPorApellido() {
        initComponents();
        armarCabecera();
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
        jtApellido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTelefonos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtEditorNombre = new javax.swing.JTextField();
        jtEditorApellido = new javax.swing.JTextField();
        jtEditorEmail = new javax.swing.JTextField();
        jbEditar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtCodigoAreaEditor = new javax.swing.JTextField();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(700, 600));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 255));
        jLabel1.setText("Busqueda por Apellido");

        jLabel2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel2.setText("Ingrese los primeros caracteres");

        jtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtApellidoKeyReleased(evt);
            }
        });

        jtTelefonos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtTelefonos);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Apellido:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("E-mail:");

        jbEditar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jbEditar.setText("EDITAR");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jbGuardar.setText("GUARDAR");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Codigo de área:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtApellido))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbGuardar)
                                    .addGap(51, 51, 51))
                                .addComponent(jtEditorNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                .addComponent(jtEditorEmail)
                                .addComponent(jtEditorApellido))
                            .addComponent(jtCodigoAreaEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtEditorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtEditorApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtEditorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtCodigoAreaEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidoKeyReleased
        borrarFilas();
        for (Map.Entry<Integer, Cliente> entry : Directorio.directorio.entrySet()) {
            if (entry.getValue().getApellido().startsWith(jtApellido.getText())) {
                modelo.addRow(new Object[]{
                    entry.getValue().getCodigoArea(),
                    entry.getKey(),
                    entry.getValue().getApellido(),
                    entry.getValue().getNombre(),
                    entry.getValue().getEmail()
                });
            }
        }
    }//GEN-LAST:event_jtApellidoKeyReleased

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        if (jtTelefonos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para editar");
        } else {

            filaSeleccionada = jtTelefonos.getSelectedRow();
            jtCodigoAreaEditor.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
            jtEditorApellido.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
            jtEditorNombre.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
            jtEditorEmail.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
        }
        Directorio.directorio.remove(filaSeleccionada);
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed

        try {
            if(jtEditorApellido.getText().isEmpty() || jtEditorEmail.getText().isEmpty() || jtEditorNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");
            }else{

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Realmente desea realizar los cambios?", "ALERTA!!!", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                modelo.setValueAt(jtCodigoAreaEditor.getText(), filaSeleccionada, 0);
                modelo.setValueAt(jtEditorApellido.getText(), filaSeleccionada, 2);
                modelo.setValueAt(jtEditorNombre.getText(), filaSeleccionada, 3);
                modelo.setValueAt(jtEditorEmail.getText(), filaSeleccionada, 4);
                Cliente cliente = new Cliente( Integer.parseInt(jtCodigoAreaEditor.getText()),jtEditorApellido.getText(), jtEditorNombre.getText(), jtEditorEmail.getText());
                Directorio.directorio.put((Integer) modelo.getValueAt(filaSeleccionada, 1), cliente);
                JOptionPane.showMessageDialog(this, "La modificacion resultó exitosa");
                jtCodigoAreaEditor.setText("");
                jtEditorApellido.setText("");
                jtEditorEmail.setText("");
                jtEditorNombre.setText("");
                

            } else {
                JOptionPane.showMessageDialog(this, "No se ha modificado el elemento");
            }}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error");
        }


    }//GEN-LAST:event_jbGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtCodigoAreaEditor;
    private javax.swing.JTextField jtEditorApellido;
    private javax.swing.JTextField jtEditorEmail;
    private javax.swing.JTextField jtEditorNombre;
    private javax.swing.JTable jtTelefonos;
    // End of variables declaration//GEN-END:variables

    private void borrarFilas() {
        int f = jtTelefonos.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }

    }

    private void armarCabecera() {
        
        modelo.addColumn("Codigo de área");
        modelo.addColumn("N° de Telefono");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("E-mail");
        jtTelefonos.setModel(modelo);

    }

}
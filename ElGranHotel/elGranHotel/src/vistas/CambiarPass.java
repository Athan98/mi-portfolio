package vistas;

import data.Conexion;
import data.User_data;
import entidades.User;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CambiarPass extends javax.swing.JInternalFrame {

    Conexion con = new Conexion("jdbc:mariadb://localhost:3306/elgranhotel", "root", "");
    User_data usd = new User_data(con);
    String stringUser = Login.user;
    User user = null;
    boolean validacionUser = false;

    public CambiarPass() {
        initComponents();
        jbEstablecerNuevaPass.setEnabled(false);
        jbVerificarRespuesta.setEnabled(false);
        jtNuevaContraseña.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtUsuarioBuscado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbVerificarUsuario = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtNuevaContraseña = new javax.swing.JTextField();
        jbEstablecerNuevaPass = new javax.swing.JButton();
        jlPreguntaBD = new javax.swing.JLabel();
        jbVerificarRespuesta = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setClosable(true);
        setForeground(new java.awt.Color(51, 51, 51));

        jtUsuarioBuscado.setBackground(new java.awt.Color(102, 102, 102));
        jtUsuarioBuscado.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jtUsuarioBuscado.setForeground(new java.awt.Color(0, 0, 0));
        jtUsuarioBuscado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingrese usuario:");

        jbVerificarUsuario.setBackground(new java.awt.Color(102, 102, 102));
        jbVerificarUsuario.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jbVerificarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jbVerificarUsuario.setText("Verificar Usuario");
        jbVerificarUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbVerificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerificarUsuarioActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nueva contraseña:");

        jtNuevaContraseña.setEditable(false);
        jtNuevaContraseña.setBackground(new java.awt.Color(102, 102, 102));
        jtNuevaContraseña.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtNuevaContraseña.setForeground(new java.awt.Color(0, 0, 0));
        jtNuevaContraseña.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbEstablecerNuevaPass.setBackground(new java.awt.Color(102, 102, 102));
        jbEstablecerNuevaPass.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jbEstablecerNuevaPass.setForeground(new java.awt.Color(0, 0, 0));
        jbEstablecerNuevaPass.setText("Guardar cambios");
        jbEstablecerNuevaPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbEstablecerNuevaPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEstablecerNuevaPassActionPerformed(evt);
            }
        });

        jlPreguntaBD.setBackground(new java.awt.Color(51, 51, 51));
        jlPreguntaBD.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jlPreguntaBD.setForeground(new java.awt.Color(255, 255, 255));
        jlPreguntaBD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jbVerificarRespuesta.setBackground(new java.awt.Color(102, 102, 102));
        jbVerificarRespuesta.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jbVerificarRespuesta.setForeground(new java.awt.Color(0, 0, 0));
        jbVerificarRespuesta.setText("Ingresar respuesta");
        jbVerificarRespuesta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbVerificarRespuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerificarRespuestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlPreguntaBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbVerificarRespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbEstablecerNuevaPass, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                .addComponent(jtNuevaContraseña)))
                        .addGap(0, 116, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlPreguntaBD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVerificarRespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtNuevaContraseña))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbEstablecerNuevaPass)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtUsuarioBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbVerificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtUsuarioBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVerificarUsuario))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVerificarRespuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerificarRespuestaActionPerformed

        boolean val = false;
        int intentos = 3;
        do {
            String entrada = JOptionPane.showInputDialog(this, "Ingrese la respuesta");
            if (entrada != user.getRespuesta() || entrada == null) {
                JOptionPane.showMessageDialog(null, "Respuesta incorrecta. Le quedan " + intentos + " intentos");
                intentos = intentos - 1;

            } else {
                val = true;
                JOptionPane.showMessageDialog(null, "¡Respuesta CORRECTA!");
                break;

            }
        } while (intentos >= 0);

        if (val == true) {
            jtNuevaContraseña.setEditable(true);
            jbEstablecerNuevaPass.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Se han terminado los intentos. El programa se cerrará");
            System.exit(0);
        }
    }//GEN-LAST:event_jbVerificarRespuestaActionPerformed

    private void jbEstablecerNuevaPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEstablecerNuevaPassActionPerformed
        usd.modificarPass(jtUsuarioBuscado.getText(), jtNuevaContraseña.getText());
        this.setVisible(false);

    }//GEN-LAST:event_jbEstablecerNuevaPassActionPerformed

    private void jbVerificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerificarUsuarioActionPerformed

        try {
            user = buscarUser(jtUsuarioBuscado.getText());

            if (user.getUser().equals(jtUsuarioBuscado.getText())) {
                jbVerificarRespuesta.setEnabled(true);
                jlPreguntaBD.setText(user.getPregunta());
                validacionUser = true;
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "El usuario ingresado no existe.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbVerificarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbEstablecerNuevaPass;
    private javax.swing.JButton jbVerificarRespuesta;
    private javax.swing.JButton jbVerificarUsuario;
    private javax.swing.JLabel jlPreguntaBD;
    private javax.swing.JTextField jtNuevaContraseña;
    private javax.swing.JTextField jtUsuarioBuscado;
    // End of variables declaration//GEN-END:variables

    public User buscarUser(String userIngresado) {

        List<User> userList = usd.listarUsers();

        User user = null;

        for (User u : userList) {
            if (u.getUser().equals(userIngresado)) {
                user = new User();
                user.setUser(u.getUser());
                user.setPass(u.getPass());
                user.setPregunta(u.getPregunta());
                user.setRespuesta(u.getRespuesta());
                break;
            }
        }

        return user;

    }
}

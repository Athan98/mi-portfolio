/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import data.Conexion;
import data.Huesped_data;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import entidades.*;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class GestionHuesped extends javax.swing.JInternalFrame {

    Conexion con = new Conexion("jdbc:mariadb://localhost:3306/elgranhotel", "root", "");
    Huesped_data hd = new Huesped_data(con);

    public GestionHuesped() {
        initComponents();
        paneFoto.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtDNI = new javax.swing.JTextField();
        jtAPELLIDO = new javax.swing.JTextField();
        jtNOMBRE = new javax.swing.JTextField();
        jtTELEFONO = new javax.swing.JTextField();
        jtDIRECCION = new javax.swing.JTextField();
        jtCORREO = new javax.swing.JTextField();
        jbCARGAR = new javax.swing.JButton();
        jbCARGARFOTO = new javax.swing.JButton();
        jtCARGARFOTO = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        paneFoto = new javax.swing.JPanel();
        jlFOTOCARGADA = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setPreferredSize(new java.awt.Dimension(800, 650));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("D.N.I. :");

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Apellido :");

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre :");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Telefono :");

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Correo :");

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Direccion :");

        jbCARGAR.setFont(new java.awt.Font("Bauhaus 93", 1, 18)); // NOI18N
        jbCARGAR.setForeground(new java.awt.Color(49, 147, 49));
        jbCARGAR.setText("CARGAR");
        jbCARGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCARGARActionPerformed(evt);
            }
        });

        jbCARGARFOTO.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jbCARGARFOTO.setText("Seleccionar archivo");
        jbCARGARFOTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCARGARFOTOActionPerformed(evt);
            }
        });

        jtCARGARFOTO.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Foto :");

        jlFOTOCARGADA.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jlFOTOCARGADA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFOTOCARGADA.setText("*Sin foto*");
        jlFOTOCARGADA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout paneFotoLayout = new javax.swing.GroupLayout(paneFoto);
        paneFoto.setLayout(paneFotoLayout);
        paneFotoLayout.setHorizontalGroup(
            paneFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneFotoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlFOTOCARGADA, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneFotoLayout.setVerticalGroup(
            paneFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneFotoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlFOTOCARGADA, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtTELEFONO, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtCARGARFOTO, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtCORREO, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbCARGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtDIRECCION, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbCARGARFOTO))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(paneFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtTELEFONO, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(paneFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDIRECCION, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCORREO, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCARGARFOTO, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCARGARFOTO, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jbCARGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCARGARFOTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCARGARFOTOActionPerformed

        JFileChooser archivo = new JFileChooser();
        int ventana = archivo.showOpenDialog(null);

        //CREAR FILTRO JP
        if (ventana == JFileChooser.APPROVE_OPTION) {
            //CARGAR FOTO DESDE ARCHIVO
            File file = archivo.getSelectedFile();
            jtCARGARFOTO.setText(String.valueOf(file));
            //CARGAR FOTO SELECCIONADA EN LABEL
            Image foto = getToolkit().getImage(jtCARGARFOTO.getText());
            foto = foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            jlFOTOCARGADA.setText("");
            jlFOTOCARGADA.setIcon(new ImageIcon(foto));

        }


    }//GEN-LAST:event_jbCARGARFOTOActionPerformed

    private void jbCARGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCARGARActionPerformed

        Huesped h = new Huesped();

        try {
            if (jtAPELLIDO.getText().isEmpty() || jtCORREO.getText().isEmpty() || jtDNI.getText().isEmpty() || jtNOMBRE.getText().isEmpty() || jtTELEFONO.getText().isEmpty() || jtDIRECCION.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete los campos necesarios");
                //Revisar String para que no contenga numeros
            } else if (revisarString(jtAPELLIDO.getText()) == false || revisarString(jtNOMBRE.getText()) == false) {
                JOptionPane.showMessageDialog(this, "Por favor, agruegue un nombre y apellido valido");

            } else if (jtCARGARFOTO.getText().isEmpty()) {

                h.setApellido(jtAPELLIDO.getText());
                h.setNombre(jtNOMBRE.getText());
                h.setCorreo(jtCORREO.getText());
                h.setDireccion(jtDIRECCION.getText());
                h.setDni(jtDNI.getText());
                h.setTelefono(jtTELEFONO.getText());
                h.setEstado(true);
                h.setFotoHuesped(null);
                h.setNombreFotoHuesped(null);

                hd.agregarHuesped(h);
            } else {

                h.setApellido(jtAPELLIDO.getText());
                h.setNombre(jtNOMBRE.getText());
                h.setCorreo(jtCORREO.getText());
                h.setDireccion(jtDIRECCION.getText());
                h.setDni(jtDNI.getText());
                h.setTelefono(jtTELEFONO.getText());
                h.setEstado(true);
                h.setFotoHuesped(new FileInputStream(jtCARGARFOTO.getText()));
                h.setNombreFotoHuesped(jtCARGARFOTO.getText());

                hd.agregarHuesped(h);

            }

            jtAPELLIDO.setText("");
            jtCARGARFOTO.setText("");
            jtCORREO.setText("");
            jtDIRECCION.setText("");
            jtDNI.setText("");
            jtNOMBRE.setText("");
            jtTELEFONO.setText("");
            jlFOTOCARGADA.setIcon(null);
            jlFOTOCARGADA.setText("*Sin foto*");
            

        } catch (NullPointerException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Complete correctamente los campos.");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbCARGARActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jbCARGAR;
    private javax.swing.JButton jbCARGARFOTO;
    private javax.swing.JLabel jlFOTOCARGADA;
    private javax.swing.JTextField jtAPELLIDO;
    private javax.swing.JTextField jtCARGARFOTO;
    private javax.swing.JTextField jtCORREO;
    private javax.swing.JTextField jtDIRECCION;
    private javax.swing.JTextField jtDNI;
    private javax.swing.JTextField jtNOMBRE;
    private javax.swing.JTextField jtTELEFONO;
    private javax.swing.JPanel paneFoto;
    // End of variables declaration//GEN-END:variables

    //Revisar String para que no contenga numeros
    public boolean revisarString(String nombre) {
        boolean num = true;
        String x = nombre.toUpperCase();

        for (int i = 0; i <= x.length() - 1; i++) {
            if (x.charAt(i) >= 48 && x.charAt(i) <= 57) {
                num = false;
            }
        }
        return num;
    }

}
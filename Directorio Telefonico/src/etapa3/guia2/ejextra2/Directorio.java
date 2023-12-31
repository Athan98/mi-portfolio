/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etapa3.guia2.ejextra2;

import Entidades.Cliente;
import InternalFrames.Administracion;
import InternalFrames.BusquedaPorApellido;
import java.util.TreeMap;

/**
 *
 * @author Usuario
 */
public class Directorio extends javax.swing.JFrame {

    public static TreeMap<Integer, Cliente> directorio = new TreeMap<>();

    /**
     * Creates new form Directorio
     */
    public Directorio() {
        initComponents();
        cargarClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jbAdministracion = new javax.swing.JButton();
        jbBuscador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 700));

        jbAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Contacts_31110.png"))); // NOI18N
        jbAdministracion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Contacts_31110.png"))); // NOI18N
        jbAdministracion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Contacts_31110.png"))); // NOI18N
        jbAdministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdministracionActionPerformed(evt);
            }
        });

        jbBuscador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/loupe_78956.png"))); // NOI18N
        jbBuscador.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/loupe_78956.png"))); // NOI18N
        jbBuscador.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/loupe_78956.png"))); // NOI18N
        jbBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscadorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMINISTRACION");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BUSCADOR");

        escritorio.setLayer(jbAdministracion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jbBuscador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jbAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jbBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(99, 99, 99)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(200, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscadorActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        BusquedaPorApellido bpa = new BusquedaPorApellido();
        bpa.setVisible(true);
        escritorio.add(bpa);
        escritorio.moveToFront(bpa);
        escritorio.add(jbAdministracion);
        escritorio.add(jbBuscador);
        escritorio.add(jLabel1);
        escritorio.add(jLabel2);
    }//GEN-LAST:event_jbBuscadorActionPerformed

    private void jbAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdministracionActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        Administracion a = new Administracion();
        a.setVisible(true);
        escritorio.add(a);
        escritorio.moveToFront(a);
        escritorio.add(jbAdministracion);
        escritorio.add(jbBuscador);
        escritorio.add(jLabel1);
        escritorio.add(jLabel2);
    }//GEN-LAST:event_jbAdministracionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Directorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Directorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Directorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Directorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Directorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbAdministracion;
    private javax.swing.JButton jbBuscador;
    // End of variables declaration//GEN-END:variables

    private void cargarClientes() {

        Cliente c1 = new Cliente(2657,"Nicolas", "Roldan", "nicoroldan15@outlook.com.ar");
        directorio.put(123456, c1);
        Cliente c2 = new Cliente(2625,"Franco", "Alvarez", "francogomez98@gmail.com");
        directorio.put(256397, c2);
        Cliente c3 = new Cliente(2657,"Ignacio", "Zarate", "zarateign76@hotmail.com");
        directorio.put(236589, c3);

    }

}

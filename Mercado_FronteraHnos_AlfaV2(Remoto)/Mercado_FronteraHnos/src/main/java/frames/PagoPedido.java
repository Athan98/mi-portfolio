package frames;

import config.HibernateConfig;
import data.*;
import entidades.*;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class PagoPedido extends javax.swing.JFrame {
    
    private Color transparent;
    private Color gris;
    private Color negro;
    Pedido ped=IngresarPedido.ped;
    
    public PagoPedido() {
        transparent = new Color(0, 0, 0, 0);
        gris = new Color(192, 192, 192, 128);
        negro = new Color(0, 0, 0, 128);
        setUndecorated(true);
        initComponents();
        setLabel(ped);
        setLocationRelativeTo(null);
        setBackground(transparent);
        cargarFormasDePago();
        
        if (!ped.getFdp().getNombreFormaDePago().equals("Otro")) {
            jtForma2.setEditable(false);
            setearFDP();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlFDP = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtForma1 = new javax.swing.JTextField();
        jtForma2 = new javax.swing.JTextField();
        jbAceptar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jcForma1 = new javax.swing.JComboBox<>();
        jcForma2 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jlTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlFDP.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlFDP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFDP.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFDP, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFDP, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtForma1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jtForma2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jbAceptar.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jbAceptar.setForeground(new java.awt.Color(0, 153, 0));
        jbAceptar.setText("ACEPTAR");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        jbCancelar.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jbCancelar.setForeground(new java.awt.Color(153, 0, 0));
        jbCancelar.setText("CANCELAR");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jcForma1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jcForma2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        jlTotal.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jlTotal.setForeground(new java.awt.Color(0, 204, 0));
        jlTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTotal.setText("-");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TOTAL ($) :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcForma1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcForma2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtForma1)
                            .addComponent(jtForma2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jbAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtForma1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcForma1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtForma2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcForma2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        
        Session session = HibernateConfig.get().openSession();
        FormasDePagoPedidos_data fdppd = new FormasDePagoPedidos_data(session);
        
        if (ped.getFdp().getNombreFormaDePago().equals("Otro")) {
            Double montoForma1 = Double.parseDouble(jtForma1.getText());
            Double montoForma2 = Double.parseDouble(jtForma2.getText());
            Double montoTotal = Double.parseDouble(jlTotal.getText());
            FormaDePago fdp1 = (FormaDePago) jcForma1.getSelectedItem();
            FormaDePago fdp2 = (FormaDePago) jcForma2.getSelectedItem();
            FormasDePagoPedidos fdpp = new FormasDePagoPedidos(fdp1, montoForma1, fdp2, montoForma2, ped);
            
            if ((montoForma1 + montoForma2) < montoTotal) {
                
                JOptionPane.showMessageDialog(null, "El dinero no es suficiente");
                
            } else {
                
                Double vuelto = (montoForma1 + montoForma2) - montoTotal;
                
                if (fdpp.getFpd1().getNombreFormaDePago().equals("Efectivo")) {
                    
                    fdpp.setMontoFDP1(montoForma1 - vuelto);
                    
                } else if (fdpp.getFpd2().getNombreFormaDePago().equals("Efectivo")) {
                    
                    fdpp.setMontoFDP2(montoForma2 - vuelto);
                }
                
                fdppd.agregar(fdpp);
                
                DecimalFormat formato = new DecimalFormat("#.##");
                
                mostrarVuelto("El vuelto es = $" + formato.format(vuelto));
                
                JOptionPane.showMessageDialog(null, "El pago del pedido ha sido agregado a la base de datos");
                
                this.setVisible(false);
            }
            
        } else {
            Double montoForma1 = Double.parseDouble(jtForma1.getText());
            FormaDePago fdp1 = (FormaDePago) jcForma1.getSelectedItem();
            Double montoTotal = Double.parseDouble(jlTotal.getText());
            FormasDePagoPedidos fdpp = new FormasDePagoPedidos(fdp1, montoForma1, ped);
            
            if (montoForma1 < montoTotal) {
                
                JOptionPane.showMessageDialog(null, "El dinero no es suficiente");
                
            } else {
                
                Double vuelto = montoForma1 - montoTotal;
                
                fdpp.setMontoFDP1(montoForma1 - vuelto);
                
                fdppd.agregar(fdpp);
                
                DecimalFormat formato = new DecimalFormat("#.##");
                
                mostrarVuelto("El vuelto es = $" + formato.format(vuelto));
                
                JOptionPane.showMessageDialog(null, "El pago del pedido ha sido agregado a la base de datos");
                
                this.setVisible(false);
            }
        }
        
        ped=null;
        
        session.close();
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        
        Session session = HibernateConfig.get().openSession();
        Pedido_data pd = new Pedido_data(session);
        pd.eliminarPorID(ped.getIdPedido());
        session.close();
        this.setVisible(false);

    }//GEN-LAST:event_jbCancelarActionPerformed
    
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
            java.util.logging.Logger.getLogger(PagoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagoPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JComboBox<FormaDePago> jcForma1;
    private javax.swing.JComboBox<FormaDePago> jcForma2;
    private javax.swing.JLabel jlFDP;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JTextField jtForma1;
    private javax.swing.JTextField jtForma2;
    // End of variables declaration//GEN-END:variables

    private void setLabel(Pedido ped) {
        jlFDP.setText(ped.getFdp().getNombreFormaDePago());
        jlTotal.setText(ped.getPrecioTotalCosto()+"");
    }
    
    public static void mostrarVuelto(String mensaje) {
        JLabel label = new JLabel(mensaje);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        JOptionPane.showMessageDialog(null, label);
    }
    
    public void cargarFormasDePago() {
        jcForma1.removeAllItems();
        jcForma2.removeAllItems();
        
        Session session = HibernateConfig.get().openSession();
        FormaDePago_data fdpd = new FormaDePago_data(session);
        List<FormaDePago> formasDePago = fdpd.listarTodo();
        
        Set<String> formasDePagoAgregadas = new HashSet<>();
        
        for (FormaDePago fp : formasDePago) {
            String formaDePago = fp.getNombreFormaDePago();
            if (!formasDePagoAgregadas.contains(formaDePago)) {
                jcForma1.addItem(fp);
                jcForma2.addItem(fp);
                formasDePagoAgregadas.add(formaDePago);
            }
        }
        
        jcForma1.setSelectedIndex(-1);
        jcForma2.setSelectedIndex(-1);
        
        session.close();
    }
    
    private void setearFDP() {
        
        String fdp = jlFDP.getText();
        
        for (int i = 0; i <= jcForma1.getItemCount(); i++) {
            if (jcForma1.getItemAt(i).getNombreFormaDePago().equals(fdp)) {
                jcForma1.setSelectedIndex(i);
                break;
            }
        }
        
    }
}

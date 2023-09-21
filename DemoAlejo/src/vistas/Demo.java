
package vistas;

import javax.swing.JInternalFrame;


public class Demo extends javax.swing.JFrame {

    Loading l = new Loading();

    public Demo() {
        initComponents();
        this.setLocationRelativeTo(this);
        escritorio.moveToFront(l);
        escritorio.add(l);
        l.setVisible(false);
        centrarLoading(l);

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jbConversor = new javax.swing.JButton();
        jbInflacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbConversor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1486564179-finance-saving_81499.png"))); // NOI18N
        jbConversor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1486564179-finance-saving_81499.png"))); // NOI18N
        jbConversor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1486564179-finance-saving_81499.png"))); // NOI18N
        jbConversor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConversorActionPerformed(evt);
            }
        });

        jbInflacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inflation_icon_155908.png"))); // NOI18N
        jbInflacion.setAlignmentY(0.0F);
        jbInflacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbInflacion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inflation_icon_155908.png"))); // NOI18N
        jbInflacion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inflation_icon_155908.png"))); // NOI18N
        jbInflacion.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inflation_icon_155908.png"))); // NOI18N
        jbInflacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInflacionActionPerformed(evt);
            }
        });

        escritorio.setLayer(jbConversor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jbInflacion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jbConversor, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addComponent(jbInflacion, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbInflacion)
                    .addComponent(jbConversor))
                .addContainerGap(302, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConversorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConversorActionPerformed

       CargaConversor hiloLoading=new CargaConversor();
       hiloLoading.start();

    }//GEN-LAST:event_jbConversorActionPerformed

    private void jbInflacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInflacionActionPerformed
        
        CargaInflacion hiloLoading=new CargaInflacion();
        hiloLoading.start();
    }//GEN-LAST:event_jbInflacionActionPerformed

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
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Demo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    public static javax.swing.JButton jbConversor;
    public static javax.swing.JButton jbInflacion;
    // End of variables declaration//GEN-END:variables

    public class CargaConversor extends Thread {
        @Override
        public void run() {
            l.setVisible(true);
            Conversor c = new Conversor();
            c.setVisible(true);
            escritorio.add(c);
            escritorio.moveToFront(c);
            l.setVisible(false);
        }
    }
    
    public class CargaInflacion extends Thread{
        @Override
        public void run(){
            l.setVisible(true);
            InflacionFrame i=new InflacionFrame();
            i.setVisible(true);
            escritorio.add(i);
            escritorio.moveToFront(i);
            l.setVisible(false);
        }
    }
    
    

    private void centrarLoading(JInternalFrame intFrame) {
        int x = (escritorio.getWidth() / 2) - (intFrame.getWidth() / 2);
        int y = (escritorio.getHeight() / 2) - (intFrame.getHeight() / 2);
        intFrame.setLocation(x, y);

    }
        
    
}



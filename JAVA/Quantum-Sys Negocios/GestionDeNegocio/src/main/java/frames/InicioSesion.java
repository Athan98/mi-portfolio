package frames;

import config.HibernateConfig;
import data.Licencia_data;
import data.Usuario_data;
import entidades.Licencia;
import entidades.Usuario;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class InicioSesion extends javax.swing.JFrame {

    public InicioSesion() {
        setUndecorated(true);
        initComponents();
        ejectuarXAMPP();
        crearBD();
        this.setLocationRelativeTo(null);
        jpIniciar.setOpaque(false);
        jpInicio.setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jSlider1 = new javax.swing.JSlider();
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/imagenes/inicio.png"));
        Image image2 = icon2.getImage();
        panelBack = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image2,0,0,getWidth(),getHeight(),this);
            }
        };
        jpIniciar = new javax.swing.JPanel();
        jbIniciar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jpInicio = new javax.swing.JPanel();
        jtUser = new javax.swing.JTextField();
        jtPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de sesion");

        panelBack.setBackground(java.awt.Color.lightGray);
        panelBack.setForeground(java.awt.Color.lightGray);

        jpIniciar.setBackground(java.awt.Color.lightGray);
        jpIniciar.setForeground(java.awt.Color.lightGray);

        jbIniciar.setBackground(new java.awt.Color(213, 20, 81));
        jbIniciar.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 20)); // NOI18N
        jbIniciar.setForeground(new java.awt.Color(255, 255, 255));
        jbIniciar.setText("Iniciar sesion");
        jbIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(213, 20, 81));
        jbSalir.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 20)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dosis Medium", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUANTUM-SYS");

        jpInicio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Negocios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Mistral", 1, 36), new java.awt.Color(213, 20, 81))); // NOI18N

        jtUser.setBackground(new java.awt.Color(213, 19, 80));
        jtUser.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        jtUser.setForeground(new java.awt.Color(255, 255, 255));
        jtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtUserKeyPressed(evt);
            }
        });

        jtPass.setBackground(new java.awt.Color(213, 19, 80));
        jtPass.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        jtPass.setForeground(new java.awt.Color(255, 255, 255));
        jtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPassKeyPressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userIcon.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/passIcon.png"))); // NOI18N

        javax.swing.GroupLayout jpInicioLayout = new javax.swing.GroupLayout(jpInicio);
        jpInicio.setLayout(jpInicioLayout);
        jpInicioLayout.setHorizontalGroup(
            jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtUser)
                    .addComponent(jtPass))
                .addContainerGap())
        );
        jpInicioLayout.setVerticalGroup(
            jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInicioLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jpIniciarLayout = new javax.swing.GroupLayout(jpIniciar);
        jpIniciar.setLayout(jpIniciarLayout);
        jpIniciarLayout.setHorizontalGroup(
            jpIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIniciarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpIniciarLayout.createSequentialGroup()
                        .addComponent(jbIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jpInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpIniciarLayout.setVerticalGroup(
            jpIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIniciarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbIniciar)
                    .addComponent(jbSalir))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarActionPerformed

        String user = jtUser.getText();
        String pass = jtPass.getText();

        Usuario usuario = returnUser(user, pass);

        if (puedeEjecutar() == true) {
            if (usuario != null) {
                Principal p = new Principal(usuario);
                p.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Su licencia ha expirado. Contacto: nicoroldan15@outlook.com.ar");
        }

    }//GEN-LAST:event_jbIniciarActionPerformed

    private void jtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbIniciarActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Enter"));
        }
    }//GEN-LAST:event_jtPassKeyPressed

    private void jtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbIniciarActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Enter"));
        }
    }//GEN-LAST:event_jtUserKeyPressed

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton jbIniciar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JPanel jpIniciar;
    private javax.swing.JPanel jpInicio;
    private javax.swing.JPasswordField jtPass;
    private javax.swing.JTextField jtUser;
    private javax.swing.JPanel panelBack;
    // End of variables declaration//GEN-END:variables

    private Usuario returnUser(String nombre, String pass) {

        Session session = HibernateConfig.get().openSession();
        Usuario_data ud = new Usuario_data(session);

        List<Usuario> usuarios = ud.listarTodo();

        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getContrasenia().equals(pass)) {
                return u;
            }
        }

        session.close();

        return null;
    }

    private void crearBD() {
        Session session = HibernateConfig.get().openSession();
        session.close();
    }

    private static boolean puedeEjecutar() {
        Session session = HibernateConfig.get().openSession();
        Licencia_data ld = new Licencia_data(session);
        List<Licencia> licencias = ld.listarTodo();

        LocalDate localDate = LocalDate.now();

        // Convertir LocalDate a Date
        Date fechaDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(fechaDate);
        boolean ver = false;

        for (Licencia lic : licencias) {
            if (lic.isEstado() == true) {
                if ((fechaDate.after(lic.getFechaAdq()) || fechaDate.equals(lic.getFechaAdq()))
                        && (fechaDate.before(lic.getFechaTermino()) || fechaDate.equals(lic.getFechaTermino()))) {
                    ver = true;
                }
            }
        }

        return ver;
    }

    private void ejectuarXAMPP() {
        Process proceso = null;
        try {
            System.out.println("Ejecutando XAMPP");
            String rutaXAMPP = "C:\\xampp\\xampp_start.exe";
            proceso = Runtime.getRuntime().exec(rutaXAMPP);
            System.out.println("XAMPP inicializado");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo ejecutar XAMPP");
        }
    }

}

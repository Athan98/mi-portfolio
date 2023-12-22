package frames;

import config.HibernateConfig;
import entidades.Usuario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.hibernate.Session;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Nicolas Roldan
 */
public class Principal extends javax.swing.JFrame {

    Loading l = new Loading();
    Usuario user;

    public Principal(Usuario user) {
        initComponents();
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
        this.user = user;
        jlUser.setText(user.getNombre());
        actualizarFechaHora();
//        ejectuarXAMPP();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbProductos = new javax.swing.JButton();
        jbVentas = new javax.swing.JButton();
        jbProveedores = new javax.swing.JButton();
        jbPedidos = new javax.swing.JButton();
        jbEstadisticas = new javax.swing.JButton();
        jbConsultas = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/fondoPane.png"));
        Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jlUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jbVolverAlInicio = new javax.swing.JButton();
        jlFechaHora = new javax.swing.JLabel();
        jlFH = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.lightGray);
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(java.awt.Color.lightGray);

        jbProductos.setBackground(java.awt.Color.darkGray);
        jbProductos.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 16)); // NOI18N
        jbProductos.setForeground(new java.awt.Color(255, 255, 255));
        jbProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productos_1.png"))); // NOI18N
        jbProductos.setText("Productos");
        jbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProductosActionPerformed(evt);
            }
        });

        jbVentas.setBackground(java.awt.Color.darkGray);
        jbVentas.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 16)); // NOI18N
        jbVentas.setForeground(new java.awt.Color(255, 255, 255));
        jbVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas.png"))); // NOI18N
        jbVentas.setText("Ventas");
        jbVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasActionPerformed(evt);
            }
        });

        jbProveedores.setBackground(java.awt.Color.darkGray);
        jbProveedores.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 16)); // NOI18N
        jbProveedores.setForeground(new java.awt.Color(255, 255, 255));
        jbProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor.png"))); // NOI18N
        jbProveedores.setText("Proveedores");
        jbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProveedoresActionPerformed(evt);
            }
        });

        jbPedidos.setBackground(java.awt.Color.darkGray);
        jbPedidos.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 16)); // NOI18N
        jbPedidos.setForeground(new java.awt.Color(255, 255, 255));
        jbPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pedido.png"))); // NOI18N
        jbPedidos.setText("Pedidos");
        jbPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPedidosActionPerformed(evt);
            }
        });

        jbEstadisticas.setBackground(java.awt.Color.darkGray);
        jbEstadisticas.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 16)); // NOI18N
        jbEstadisticas.setForeground(new java.awt.Color(255, 255, 255));
        jbEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/estadisticas.png"))); // NOI18N
        jbEstadisticas.setText("Estadisticas");
        jbEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEstadisticasActionPerformed(evt);
            }
        });

        jbConsultas.setBackground(java.awt.Color.darkGray);
        jbConsultas.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 16)); // NOI18N
        jbConsultas.setForeground(new java.awt.Color(255, 255, 255));
        jbConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultar.png"))); // NOI18N
        jbConsultas.setText("Consultas");
        jbConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbProductos)
                .addGap(18, 18, 18)
                .addComponent(jbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbProveedores)
                .addGap(18, 18, 18)
                .addComponent(jbPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbEstadisticas)
                .addGap(18, 18, 18)
                .addComponent(jbConsultas)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbProductos)
                        .addComponent(jbVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbPedidos)
                        .addComponent(jbEstadisticas)
                        .addComponent(jbConsultas))
                    .addComponent(jbProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        jPanel2.setBackground(java.awt.Color.lightGray);
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(java.awt.Color.lightGray);

        jlUser.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 20)); // NOI18N
        jlUser.setForeground(new java.awt.Color(0, 0, 0));
        jlUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlUser.setText("-");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¡BIENVENIDO!");

        jbSalir.setBackground(new java.awt.Color(153, 0, 0));
        jbSalir.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("SALIR");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbVolverAlInicio.setBackground(new java.awt.Color(153, 153, 0));
        jbVolverAlInicio.setFont(new java.awt.Font("Franklin Gothic Demi", 2, 14)); // NOI18N
        jbVolverAlInicio.setForeground(new java.awt.Color(0, 0, 0));
        jbVolverAlInicio.setText("Volver al inicio de sesion");
        jbVolverAlInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverAlInicioActionPerformed(evt);
            }
        });

        jlFechaHora.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 18)); // NOI18N
        jlFechaHora.setForeground(new java.awt.Color(0, 0, 0));
        jlFechaHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlFH.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 18)); // NOI18N
        jlFH.setForeground(new java.awt.Color(0, 0, 0));
        jlFH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFH.setText("Fecha y hora:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlFechaHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbVolverAlInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(jlFH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlFH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbVolverAlInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(escritorio))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProductosActionPerformed

        if (user.getAcceso() == 2) {

            // Crear e iniciar el hilo para ejecutar la carga en segundo plano
            Thread cargaThread = new Thread(() -> {
                // Mostrar el frame de carga
                Loading loading = new Loading();
                loading.setVisible(true);

                try {
                    escritorio.removeAll();
                    escritorio.repaint();
                    Thread.sleep(2000);
                    Productos productos = new Productos();
                    productos.setVisible(true);
                    escritorio.add(productos);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Cerrar el frame de carga
                loading.dispose();
            });

            // Iniciar el hilo
            cargaThread.start();
        } else {
            JOptionPane.showMessageDialog(null, "No posee los permisos suficientes");
        }
    }//GEN-LAST:event_jbProductosActionPerformed

    private void jbVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVentasActionPerformed
        // Crear e iniciar el hilo para ejecutar la carga en segundo plano
        Thread cargaThread = new Thread(() -> {
            // Mostrar el frame de carga
            Loading loading = new Loading();
            loading.setVisible(true);

            try {
                escritorio.removeAll();
                escritorio.repaint();
                Thread.sleep(2000);
                Ventas ventas = new Ventas();
                ventas.setVisible(true);
                escritorio.add(ventas);
                ventas.setLocation((Principal.escritorio.getWidth() - ventas.getWidth()) / 2, (Principal.escritorio.getHeight() - ventas.getHeight()) / 2);

            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar el frame de carga
            loading.dispose();
        });

        // Iniciar el hilo
        cargaThread.start();
    }//GEN-LAST:event_jbVentasActionPerformed

    private void jbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProveedoresActionPerformed

        if (user.getAcceso() == 2) {
            // Crear e iniciar el hilo para ejecutar la carga en segundo plano
            Thread cargaThread = new Thread(() -> {
                // Mostrar el frame de carga
                Loading loading = new Loading();
                loading.setVisible(true);

                try {
                    escritorio.removeAll();
                    escritorio.repaint();
                    Thread.sleep(2000);
                    Proveedores prov = new Proveedores();
                    prov.setVisible(true);
                    escritorio.add(prov);
                    prov.setLocation((Principal.escritorio.getWidth() - prov.getWidth()) / 2, (Principal.escritorio.getHeight() - prov.getHeight()) / 2);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Cerrar el frame de carga
                loading.dispose();
            });

            // Iniciar el hilo
            cargaThread.start();
        } else {
            JOptionPane.showMessageDialog(null, "No posee los permisos suficientes");
        }
    }//GEN-LAST:event_jbProveedoresActionPerformed

    private void jbPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPedidosActionPerformed

        if (user.getAcceso() == 2) {

            // Crear e iniciar el hilo para ejecutar la carga en segundo plano
            Thread cargaThread = new Thread(() -> {
                // Mostrar el frame de carga
                Loading loading = new Loading();
                loading.setVisible(true);

                try {
                    escritorio.removeAll();
                    escritorio.repaint();
                    Thread.sleep(2000);
                    Pedidos p = new Pedidos();
                    p.setVisible(true);
                    escritorio.add(p);
                    p.setLocation((Principal.escritorio.getWidth() - p.getWidth()) / 2, (Principal.escritorio.getHeight() - p.getHeight()) / 2);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Cerrar el frame de carga
                loading.dispose();
            });

            // Iniciar el hilo
            cargaThread.start();
        } else {
            JOptionPane.showMessageDialog(null, "No posee los permisos suficientes");
        }
    }//GEN-LAST:event_jbPedidosActionPerformed

    private void jbEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEstadisticasActionPerformed

        if (user.getAcceso() == 2) {

            // Crear e iniciar el hilo para ejecutar la carga en segundo plano
            Thread cargaThread = new Thread(() -> {
                // Mostrar el frame de carga
                Loading loading = new Loading();
                loading.setVisible(true);

                try {
                    escritorio.removeAll();
                    escritorio.repaint();
                    Thread.sleep(2000);
                    Estadisticas e = new Estadisticas();
                    e.setVisible(true);
                    escritorio.add(e);
                    e.setLocation((Principal.escritorio.getWidth() - e.getWidth()) / 2, (Principal.escritorio.getHeight() - e.getHeight()) / 2);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Cerrar el frame de carga
                loading.dispose();
            });

            // Iniciar el hilo
            cargaThread.start();
        } else {
            JOptionPane.showMessageDialog(null, "No posee los permisos suficientes");
        }
    }//GEN-LAST:event_jbEstadisticasActionPerformed

    private void jbConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultasActionPerformed
        // Crear e iniciar el hilo para ejecutar la carga en segundo plano
        Thread cargaThread = new Thread(() -> {
            // Mostrar el frame de carga
            Loading loading = new Loading();
            loading.setVisible(true);

            try {
                Thread.sleep(2000);
                Consultas c = new Consultas();
                c.setVisible(true);
                escritorio.add(c);
                escritorio.moveToFront(c);
                c.setLocation((Principal.escritorio.getWidth() - c.getWidth()) / 2, (Principal.escritorio.getHeight() - c.getHeight()) / 2);

            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar el frame de carga
            loading.dispose();
        });

        // Iniciar el hilo
        cargaThread.start();
    }//GEN-LAST:event_jbConsultasActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbVolverAlInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverAlInicioActionPerformed
        InicioSesion is = new InicioSesion();
        is.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbVolverAlInicioActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InicioSesion inicioSesion = new InicioSesion();
                inicioSesion.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbConsultas;
    private javax.swing.JButton jbEstadisticas;
    private javax.swing.JButton jbPedidos;
    private javax.swing.JButton jbProductos;
    private javax.swing.JButton jbProveedores;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbVentas;
    private javax.swing.JButton jbVolverAlInicio;
    private javax.swing.JLabel jlFH;
    private javax.swing.JLabel jlFechaHora;
    private javax.swing.JLabel jlUser;
    // End of variables declaration//GEN-END:variables

    private Runnable loading(int segundos) {
        Runnable run = () -> {
            Loading l = new Loading();
            l.setVisible(true);

            try {
                Thread.sleep(segundos);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            l.dispose();

            Productos prod = new Productos();
            prod.setVisible(true);
            escritorio.add(prod);

        };

        return run;
    }

    private void ejectuarXAMPP() {
        Process proceso = null;
        try {
            System.out.println("Ejecutando XAMPP");
            String rutaXAMPP = "E:\\XAMPP\\xampp_start.exe";
            proceso = Runtime.getRuntime().exec(rutaXAMPP);
            System.out.println("XAMPP inicializado");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo ejecutar XAMPP");
        }
    }

    private void detenerXAAMP() {
        Process proceso = null;
        try {
            System.out.println("Deteniendo XAAMP");
            String rutaXAMPP = "E:\\XAMPP\\xampp_stop.exe";
            proceso = Runtime.getRuntime().exec(rutaXAMPP);
            int exitCode = proceso.waitFor();
            System.out.println("XAMPP detenido con código de salida: " + exitCode);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo ejecutar XAMPP");
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (proceso != null) {
                proceso.destroy();
            }
        }
    }

    private void actualizarFechaHora() {
        Thread reloj = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            while (true) {
                String fechaHora = sdf.format(new Date());
                SwingUtilities.invokeLater(() -> jlFechaHora.setText(fechaHora));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        reloj.start();
    }

}

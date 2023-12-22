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
    public static Usuario user;

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

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jbVolverAlInicio = new javax.swing.JButton();
        jlFechaHora = new javax.swing.JLabel();
        jlFH = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbProductos = new javax.swing.JButton();
        jbVentas = new javax.swing.JButton();
        jbProveedores = new javax.swing.JButton();
        jbPedidos = new javax.swing.JButton();
        jbEstadisticas = new javax.swing.JButton();
        jbConsultas = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/fondoEscritorio.png"));
        Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(java.awt.Color.darkGray);
        jPanel3.setForeground(java.awt.Color.darkGray);

        jPanel2.setBackground(java.awt.Color.darkGray);
        jPanel2.setForeground(java.awt.Color.darkGray);

        jlUser.setBackground(new java.awt.Color(255, 255, 255));
        jlUser.setFont(new java.awt.Font("Gill Sans MT Condensed", 2, 30)); // NOI18N
        jlUser.setForeground(new java.awt.Color(255, 255, 255));
        jlUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlUser.setText("-");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¡BIENVENIDO!");

        jbSalir.setBackground(new java.awt.Color(153, 0, 0));
        jbSalir.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 30)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("SALIR");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbVolverAlInicio.setBackground(new java.awt.Color(153, 153, 0));
        jbVolverAlInicio.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbVolverAlInicio.setForeground(new java.awt.Color(0, 0, 0));
        jbVolverAlInicio.setText("Volver al inicio");
        jbVolverAlInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverAlInicioActionPerformed(evt);
            }
        });

        jlFechaHora.setBackground(new java.awt.Color(255, 255, 255));
        jlFechaHora.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 30)); // NOI18N
        jlFechaHora.setForeground(new java.awt.Color(255, 255, 255));
        jlFechaHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlFH.setBackground(new java.awt.Color(255, 255, 255));
        jlFH.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 30)); // NOI18N
        jlFH.setForeground(new java.awt.Color(255, 255, 255));
        jlFH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFH.setText("Fecha y hora:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlFechaHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jlUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVolverAlInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlUser)
                .addGap(18, 18, 18)
                .addComponent(jbVolverAlInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(jlFH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addContainerGap())
        );

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setForeground(java.awt.Color.darkGray);

        jbProductos.setBackground(new java.awt.Color(51, 51, 51));
        jbProductos.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbProductos.setForeground(new java.awt.Color(255, 255, 255));
        jbProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productos_1.png"))); // NOI18N
        jbProductos.setText("Productos");
        jbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProductosActionPerformed(evt);
            }
        });

        jbVentas.setBackground(new java.awt.Color(51, 51, 51));
        jbVentas.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbVentas.setForeground(new java.awt.Color(255, 255, 255));
        jbVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas.png"))); // NOI18N
        jbVentas.setText("Ventas");
        jbVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasActionPerformed(evt);
            }
        });

        jbProveedores.setBackground(new java.awt.Color(51, 51, 51));
        jbProveedores.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbProveedores.setForeground(new java.awt.Color(255, 255, 255));
        jbProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor.png"))); // NOI18N
        jbProveedores.setText("Proveedores");
        jbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProveedoresActionPerformed(evt);
            }
        });

        jbPedidos.setBackground(new java.awt.Color(51, 51, 51));
        jbPedidos.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbPedidos.setForeground(new java.awt.Color(255, 255, 255));
        jbPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pedido.png"))); // NOI18N
        jbPedidos.setText("Pedidos");
        jbPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPedidosActionPerformed(evt);
            }
        });

        jbEstadisticas.setBackground(new java.awt.Color(51, 51, 51));
        jbEstadisticas.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbEstadisticas.setForeground(new java.awt.Color(255, 255, 255));
        jbEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/estadisticas.png"))); // NOI18N
        jbEstadisticas.setText("Estadisticas");
        jbEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEstadisticasActionPerformed(evt);
            }
        });

        jbConsultas.setBackground(new java.awt.Color(51, 51, 51));
        jbConsultas.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
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
                .addComponent(jbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbEstadisticas)
                .addGap(18, 18, 18)
                .addComponent(jbConsultas)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbPedidos)
                        .addComponent(jbEstadisticas)
                        .addComponent(jbConsultas)
                        .addComponent(jbVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbProductos))
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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(escritorio))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(escritorio))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        user=null;
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbVolverAlInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverAlInicioActionPerformed
        InicioSesion is = new InicioSesion();
        is.setVisible(true);
        user=null;
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
    private javax.swing.JPanel jPanel3;
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

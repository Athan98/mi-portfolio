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
import javax.swing.SwingWorker;

/**
 *
 * @author Nicolas Roldan
 */
public class Principal extends javax.swing.JFrame {

    Loading l = new Loading();
    public static Usuario user;
    private SwingWorker<Void, Void> cargaWorker;

    public Principal(Usuario user) {
        initComponents();
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
        this.user = user;
        jlUser.setText(user.getNombre());
        actualizarFechaHora();
        jpBotonera.setOpaque(false);
        jpInicio.setOpaque(false);
        escritorio.setOpaque(false);
//        ejectuarXAMPP();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon2 = new ImageIcon(getClass().getResource("/imagenes/fondoPrincipal.png"));
        Image image2 = icon2.getImage();
        jPanel3 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image2,0,0,getWidth(),getHeight(),this);
            }
        };
        jpInicio = new javax.swing.JPanel();
        jlUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jbVolverAlInicio = new javax.swing.JButton();
        jlFechaHora = new javax.swing.JLabel();
        jlFH = new javax.swing.JLabel();
        jpBotonera = new javax.swing.JPanel();
        jbProductos = new javax.swing.JButton();
        jbVentas = new javax.swing.JButton();
        jbProveedores = new javax.swing.JButton();
        jbPedidos = new javax.swing.JButton();
        jbEstadisticas = new javax.swing.JButton();
        jbConsultas = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/fondoEscritorio1.png"));
        Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(java.awt.Color.lightGray);
        jPanel3.setForeground(java.awt.Color.lightGray);

        jpInicio.setBackground(java.awt.Color.lightGray);
        jpInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpInicio.setForeground(java.awt.Color.lightGray);

        jlUser.setBackground(new java.awt.Color(0, 0, 0));
        jlUser.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 30)); // NOI18N
        jlUser.setForeground(new java.awt.Color(0, 204, 51));
        jlUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlUser.setText("-");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
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

        jbVolverAlInicio.setBackground(new java.awt.Color(204, 204, 0));
        jbVolverAlInicio.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbVolverAlInicio.setForeground(new java.awt.Color(0, 0, 0));
        jbVolverAlInicio.setText("Volver al inicio");
        jbVolverAlInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverAlInicioActionPerformed(evt);
            }
        });

        jlFechaHora.setBackground(new java.awt.Color(0, 0, 0));
        jlFechaHora.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jlFechaHora.setForeground(new java.awt.Color(255, 255, 255));
        jlFechaHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlFH.setBackground(new java.awt.Color(0, 0, 0));
        jlFH.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jlFH.setForeground(new java.awt.Color(255, 255, 255));
        jlFH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFH.setText("Fecha y hora:");

        javax.swing.GroupLayout jpInicioLayout = new javax.swing.GroupLayout(jpInicio);
        jpInicio.setLayout(jpInicioLayout);
        jpInicioLayout.setHorizontalGroup(
            jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlFechaHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jlUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVolverAlInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpInicioLayout.setVerticalGroup(
            jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlUser)
                .addGap(18, 18, 18)
                .addComponent(jbVolverAlInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(jlFH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalir)
                .addContainerGap())
        );

        jpBotonera.setBackground(java.awt.Color.lightGray);
        jpBotonera.setForeground(java.awt.Color.lightGray);

        jbProductos.setBackground(new java.awt.Color(86, 117, 165));
        jbProductos.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbProductos.setForeground(new java.awt.Color(0, 0, 0));
        jbProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productos_1.png"))); // NOI18N
        jbProductos.setText("Productos");
        jbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProductosActionPerformed(evt);
            }
        });

        jbVentas.setBackground(new java.awt.Color(86, 117, 165));
        jbVentas.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbVentas.setForeground(new java.awt.Color(0, 0, 0));
        jbVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas.png"))); // NOI18N
        jbVentas.setText("Ventas");
        jbVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasActionPerformed(evt);
            }
        });

        jbProveedores.setBackground(new java.awt.Color(86, 117, 165));
        jbProveedores.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbProveedores.setForeground(new java.awt.Color(0, 0, 0));
        jbProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor.png"))); // NOI18N
        jbProveedores.setText("Proveedores");
        jbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProveedoresActionPerformed(evt);
            }
        });

        jbPedidos.setBackground(new java.awt.Color(86, 117, 165));
        jbPedidos.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbPedidos.setForeground(new java.awt.Color(0, 0, 0));
        jbPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pedido.png"))); // NOI18N
        jbPedidos.setText("Pedidos");
        jbPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPedidosActionPerformed(evt);
            }
        });

        jbEstadisticas.setBackground(new java.awt.Color(86, 117, 165));
        jbEstadisticas.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbEstadisticas.setForeground(new java.awt.Color(0, 0, 0));
        jbEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/estadisticas.png"))); // NOI18N
        jbEstadisticas.setText("Estadisticas");
        jbEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEstadisticasActionPerformed(evt);
            }
        });

        jbConsultas.setBackground(new java.awt.Color(86, 117, 165));
        jbConsultas.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        jbConsultas.setForeground(new java.awt.Color(0, 0, 0));
        jbConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultar.png"))); // NOI18N
        jbConsultas.setText("Consultas");
        jbConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotoneraLayout = new javax.swing.GroupLayout(jpBotonera);
        jpBotonera.setLayout(jpBotoneraLayout);
        jpBotoneraLayout.setHorizontalGroup(
            jpBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoneraLayout.createSequentialGroup()
                .addComponent(jbProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jpBotoneraLayout.setVerticalGroup(
            jpBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbPedidos)
                .addComponent(jbEstadisticas)
                .addComponent(jbConsultas)
                .addComponent(jbVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbProductos))
            .addComponent(jbProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        escritorio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        escritorio.setForeground(null);

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
                .addComponent(jpInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(escritorio))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpBotonera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
            if (cargaWorker != null && !cargaWorker.isDone()) {
                JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
                return;
            }

            // Crear e iniciar el hilo SwingWorker
            cargaWorker = new SwingWorker<Void, Void>() {
                Loading loading = new Loading();

                @Override
                protected Void doInBackground() throws Exception {
                    // Mostrar el frame de carga

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

                    return null;
                }

                @Override
                protected void done() {
                    // Cerrar el frame de carga después de que la tarea haya terminado
                    loading.dispose();
                }
            };

            cargaWorker.execute();
        } else {
            JOptionPane.showMessageDialog(null, "No posee los permisos suficientes");
        }
    }//GEN-LAST:event_jbProductosActionPerformed

    private void jbVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVentasActionPerformed

// Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }

        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

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

                return null;
            }

            @Override
            protected void done() {
                // Cerrar el frame de carga después de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbVentasActionPerformed

    private void jbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProveedoresActionPerformed

        if (user.getAcceso() == 2) {
            // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
            if (cargaWorker != null && !cargaWorker.isDone()) {
                JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
                return;
            }

            // Crear e iniciar el hilo SwingWorker
            cargaWorker = new SwingWorker<Void, Void>() {
                Loading loading = new Loading();

                @Override
                protected Void doInBackground() throws Exception {
                    // Mostrar el frame de carga

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

                    return null;
                }

                @Override
                protected void done() {
                    // Cerrar el frame de carga después de que la tarea haya terminado
                    loading.dispose();
                }
            };

            cargaWorker.execute();
        } else {
            JOptionPane.showMessageDialog(null, "No posee los permisos suficientes");
        }
    }//GEN-LAST:event_jbProveedoresActionPerformed

    private void jbPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPedidosActionPerformed

        if (user.getAcceso() == 2) {
            // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
            if (cargaWorker != null && !cargaWorker.isDone()) {
                JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
                return;
            }

            // Crear e iniciar el hilo SwingWorker
            cargaWorker = new SwingWorker<Void, Void>() {
                Loading loading = new Loading();

                @Override
                protected Void doInBackground() throws Exception {
                    // Mostrar el frame de carga

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

                    return null;
                }

                @Override
                protected void done() {
                    // Cerrar el frame de carga después de que la tarea haya terminado
                    loading.dispose();
                }
            };

            cargaWorker.execute();
        } else {
            JOptionPane.showMessageDialog(null, "No posee los permisos suficientes");
        }
    }//GEN-LAST:event_jbPedidosActionPerformed

    private void jbEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEstadisticasActionPerformed

        if (user.getAcceso() == 2) {
            // Verificar si hay un hilo SwingWorker en ejecución y esperar a que termine
            if (cargaWorker != null && !cargaWorker.isDone()) {
                JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
                return;
            }

            // Crear e iniciar el hilo SwingWorker
            cargaWorker = new SwingWorker<Void, Void>() {
                Loading loading = new Loading();

                @Override
                protected Void doInBackground() throws Exception {
                    // Mostrar el frame de carga

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

                    return null;
                }

                @Override
                protected void done() {
                    // Cerrar el frame de carga después de que la tarea haya terminado
                    loading.dispose();
                }
            };

            cargaWorker.execute();
        } else {
            JOptionPane.showMessageDialog(null, "No posee los permisos suficientes");
        }
    }//GEN-LAST:event_jbEstadisticasActionPerformed

    private void jbConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultasActionPerformed

        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operación actual termine.");
            return;
        }
        // Crear e iniciar el hilo SwingWorker
        cargaWorker = new SwingWorker<Void, Void>() {
            Loading loading = new Loading();

            @Override
            protected Void doInBackground() throws Exception {
                // Mostrar el frame de carga

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

                return null;
            }

            @Override
            protected void done() {
                // Cerrar el frame de carga después de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbConsultasActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        System.exit(0);
        user = null;
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbVolverAlInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverAlInicioActionPerformed
        InicioSesion is = new InicioSesion();
        is.setVisible(true);
        user = null;
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
    private javax.swing.JPanel jpBotonera;
    private javax.swing.JPanel jpInicio;
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

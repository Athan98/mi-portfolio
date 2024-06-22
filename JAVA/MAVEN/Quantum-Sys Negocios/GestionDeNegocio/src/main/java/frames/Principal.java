package frames;

import config.HibernateConfig;
import config.RespaldoBD;
import data.Caja_data;
import entidades.*;
import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static Caja caja = buscarCaja(1);

    public Principal(Usuario user) {
        initComponents();
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
        this.user = user;
        jlUser.setText(user.getNombre());
        actualizarFechaHora();
        jpBotonera.setOpaque(false);
        jpInicio.setOpaque(false);
        escritorio.setOpaque(false);
        setPaneCaja();
//        ejectuarXAMPP();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jpInicio = new javax.swing.JPanel();
        jlUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jbVolverAlInicio = new javax.swing.JButton();
        jlFechaHora = new javax.swing.JLabel();
        jlFH1 = new javax.swing.JLabel();
        jpCaja = new javax.swing.JPanel();
        jpCajaActivacion = new javax.swing.JPanel();
        jlCajaActivacion = new javax.swing.JLabel();
        jbActualizar = new javax.swing.JButton();
        jpBotonera = new javax.swing.JPanel();
        jbVentas = new javax.swing.JButton();
        jbProveedores = new javax.swing.JButton();
        jbPedidos = new javax.swing.JButton();
        jbEstadisticas = new javax.swing.JButton();
        jbConsultas = new javax.swing.JButton();
        jbCaja = new javax.swing.JButton();
        jbSistema = new javax.swing.JButton();
        jbClientes = new javax.swing.JButton();
        jbProductos = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/fondoOUSIA.jpeg"));
        Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quantum-Sys: Negocios");

        jPanel3.setBackground(new java.awt.Color(226, 230, 240));
        jPanel3.setForeground(new java.awt.Color(226, 230, 240));

        jpInicio.setBackground(new java.awt.Color(226, 230, 240));
        jpInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpInicio.setForeground(new java.awt.Color(226, 230, 240));

        jlUser.setBackground(new java.awt.Color(0, 0, 0));
        jlUser.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jlUser.setForeground(new java.awt.Color(97, 130, 189));
        jlUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlUser.setText("-");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(97, 130, 189));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BIENVENIDO");

        jbSalir.setBackground(new java.awt.Color(153, 0, 0));
        jbSalir.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("SALIR");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbVolverAlInicio.setBackground(new java.awt.Color(204, 204, 0));
        jbVolverAlInicio.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jbVolverAlInicio.setForeground(new java.awt.Color(0, 0, 0));
        jbVolverAlInicio.setText("Volver al inicio");
        jbVolverAlInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverAlInicioActionPerformed(evt);
            }
        });

        jlFechaHora.setBackground(new java.awt.Color(0, 0, 0));
        jlFechaHora.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jlFechaHora.setForeground(new java.awt.Color(97, 130, 189));
        jlFechaHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlFH1.setBackground(new java.awt.Color(0, 0, 0));
        jlFH1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jlFH1.setForeground(new java.awt.Color(97, 130, 189));
        jlFH1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFH1.setText("Fecha y hora:");

        jpCaja.setBackground(new java.awt.Color(226, 230, 240));
        jpCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "ESTADO CAJA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 24), new java.awt.Color(97, 130, 189))); // NOI18N
        jpCaja.setForeground(new java.awt.Color(0, 0, 0));

        jpCajaActivacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlCajaActivacion.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jlCajaActivacion.setForeground(new java.awt.Color(255, 255, 255));
        jlCajaActivacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCajaActivacion.setText("-");

        javax.swing.GroupLayout jpCajaActivacionLayout = new javax.swing.GroupLayout(jpCajaActivacion);
        jpCajaActivacion.setLayout(jpCajaActivacionLayout);
        jpCajaActivacionLayout.setHorizontalGroup(
            jpCajaActivacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlCajaActivacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpCajaActivacionLayout.setVerticalGroup(
            jpCajaActivacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlCajaActivacion, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jbActualizar.setBackground(new java.awt.Color(97, 130, 189));
        jbActualizar.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 16)); // NOI18N
        jbActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/refresh.png"))); // NOI18N
        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCajaLayout = new javax.swing.GroupLayout(jpCaja);
        jpCaja.setLayout(jpCajaLayout);
        jpCajaLayout.setHorizontalGroup(
            jpCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCajaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpCajaActivacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpCajaLayout.setVerticalGroup(
            jpCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCajaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpCajaActivacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jpInicioLayout = new javax.swing.GroupLayout(jpInicio);
        jpInicio.setLayout(jpInicioLayout);
        jpInicioLayout.setHorizontalGroup(
            jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jbVolverAlInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlFechaHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlFH1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpInicioLayout.setVerticalGroup(
            jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlUser)
                .addGap(24, 24, 24)
                .addComponent(jlFH1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jpCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbVolverAlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpBotonera.setBackground(java.awt.Color.lightGray);
        jpBotonera.setForeground(java.awt.Color.lightGray);

        jbVentas.setBackground(new java.awt.Color(97, 130, 189));
        jbVentas.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 16)); // NOI18N
        jbVentas.setForeground(new java.awt.Color(255, 255, 255));
        jbVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas.png"))); // NOI18N
        jbVentas.setText("Ventas");
        jbVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasActionPerformed(evt);
            }
        });

        jbProveedores.setBackground(new java.awt.Color(97, 130, 189));
        jbProveedores.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 16)); // NOI18N
        jbProveedores.setForeground(new java.awt.Color(255, 255, 255));
        jbProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor.png"))); // NOI18N
        jbProveedores.setText("Proveedores");
        jbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProveedoresActionPerformed(evt);
            }
        });

        jbPedidos.setBackground(new java.awt.Color(97, 130, 189));
        jbPedidos.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 16)); // NOI18N
        jbPedidos.setForeground(new java.awt.Color(255, 255, 255));
        jbPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pedido.png"))); // NOI18N
        jbPedidos.setText("Pedidos");
        jbPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPedidosActionPerformed(evt);
            }
        });

        jbEstadisticas.setBackground(new java.awt.Color(97, 130, 189));
        jbEstadisticas.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 16)); // NOI18N
        jbEstadisticas.setForeground(new java.awt.Color(255, 255, 255));
        jbEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/estadisticas.png"))); // NOI18N
        jbEstadisticas.setText("Estadisticas");
        jbEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEstadisticasActionPerformed(evt);
            }
        });

        jbConsultas.setBackground(new java.awt.Color(97, 130, 189));
        jbConsultas.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 16)); // NOI18N
        jbConsultas.setForeground(new java.awt.Color(255, 255, 255));
        jbConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultar.png"))); // NOI18N
        jbConsultas.setText("Consultas");
        jbConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultasActionPerformed(evt);
            }
        });

        jbCaja.setBackground(new java.awt.Color(97, 130, 189));
        jbCaja.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 16)); // NOI18N
        jbCaja.setForeground(new java.awt.Color(255, 255, 255));
        jbCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/caja.png"))); // NOI18N
        jbCaja.setText("Caja");
        jbCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCajaActionPerformed(evt);
            }
        });

        jbSistema.setBackground(new java.awt.Color(97, 130, 189));
        jbSistema.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 16)); // NOI18N
        jbSistema.setForeground(new java.awt.Color(255, 255, 255));
        jbSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/system_pc_679.png"))); // NOI18N
        jbSistema.setText("Sistema");
        jbSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSistemaActionPerformed(evt);
            }
        });

        jbClientes.setBackground(new java.awt.Color(97, 130, 189));
        jbClientes.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 16)); // NOI18N
        jbClientes.setForeground(new java.awt.Color(255, 255, 255));
        jbClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/userIcon.png"))); // NOI18N
        jbClientes.setText("Clientes");
        jbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClientesActionPerformed(evt);
            }
        });

        jbProductos.setBackground(new java.awt.Color(97, 130, 189));
        jbProductos.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 16)); // NOI18N
        jbProductos.setForeground(new java.awt.Color(255, 255, 255));
        jbProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productos_1.png"))); // NOI18N
        jbProductos.setText("Productos");
        jbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotoneraLayout = new javax.swing.GroupLayout(jpBotonera);
        jpBotonera.setLayout(jpBotoneraLayout);
        jpBotoneraLayout.setHorizontalGroup(
            jpBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoneraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbProveedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbEstadisticas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jbConsultas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSistema)
                .addGap(25, 25, 25))
        );
        jpBotoneraLayout.setVerticalGroup(
            jpBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbPedidos)
                .addComponent(jbEstadisticas)
                .addComponent(jbConsultas)
                .addComponent(jbCaja)
                .addComponent(jbClientes)
                .addComponent(jbSistema)
                .addComponent(jbVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbProductos))
            .addComponent(jbProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        escritorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jpInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(escritorio)))
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
            // Verificar si hay un hilo SwingWorker en ejecuci�n y esperar a que termine
            if (cargaWorker != null && !cargaWorker.isDone()) {
                JOptionPane.showMessageDialog(null, "Espere a que la operaci�n actual termine.");
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
                    // Cerrar el frame de carga despu�s de que la tarea haya terminado
                    loading.dispose();
                }
            };

            cargaWorker.execute();
        } else {
            JOptionPane.showMessageDialog(null, "No posee los permisos suficientes");
        }
    }//GEN-LAST:event_jbProductosActionPerformed

    private void jbVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVentasActionPerformed

// Verificar si hay un hilo SwingWorker en ejecuci�n y esperar a que termine
        if (cargaWorker != null && !cargaWorker.isDone()) {
            JOptionPane.showMessageDialog(null, "Espere a que la operaci�n actual termine.");
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
                // Cerrar el frame de carga despu�s de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbVentasActionPerformed

    private void jbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProveedoresActionPerformed

        if (user.getAcceso() == 2) {
            // Verificar si hay un hilo SwingWorker en ejecuci�n y esperar a que termine
            if (cargaWorker != null && !cargaWorker.isDone()) {
                JOptionPane.showMessageDialog(null, "Espere a que la operaci�n actual termine.");
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
                    // Cerrar el frame de carga despu�s de que la tarea haya terminado
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
            InicioPedidos p = new InicioPedidos();
            p.setVisible(true);
            escritorio.add(p);
            escritorio.moveToFront(p);
            p.setLocation((Principal.escritorio.getWidth() - p.getWidth()) / 2, (Principal.escritorio.getHeight() - p.getHeight()) / 2);
        } else {
            JOptionPane.showMessageDialog(null, "No posee los permisos suficientes");
        }
    }//GEN-LAST:event_jbPedidosActionPerformed

    private void jbEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEstadisticasActionPerformed

        if (user.getAcceso() == 2) {
            // Verificar si hay un hilo SwingWorker en ejecuci�n y esperar a que termine
            if (cargaWorker != null && !cargaWorker.isDone()) {
                JOptionPane.showMessageDialog(null, "Espere a que la operaci�n actual termine.");
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
                        ex.printStackTrace();
                    }

                    return null;
                }

                @Override
                protected void done() {
                    // Cerrar el frame de carga despu�s de que la tarea haya terminado
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
                // Cerrar el frame de carga despu�s de que la tarea haya terminado
                loading.dispose();
            }
        };

        cargaWorker.execute();
    }//GEN-LAST:event_jbConsultasActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        if (jlCajaActivacion.getText().equals("ABIERTA")) {
            JOptionPane.showMessageDialog(null, "La caja se encuentra abierta, debe cerrarla para salir del programa");
            return;
        } else {

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
                        detenerXAMPP();
                        user = null;
                        System.exit(0);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    return null;
                }

                @Override
                protected void done() {
                    // Cerrar el frame de carga despu�s de que la tarea haya terminado
                    loading.dispose();
                }
            };

            cargaWorker.execute();
        }
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbVolverAlInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverAlInicioActionPerformed

        if (caja.isEstado() == true) {
            JOptionPane.showMessageDialog(null, "La caja se encuentra abierta, debe cerrarla para salir del programa");
            return;
        } else {
            InicioSesion is = new InicioSesion();
            is.setVisible(true);
            user = null;
            this.dispose();
        }
    }//GEN-LAST:event_jbVolverAlInicioActionPerformed

    private void jbCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCajaActionPerformed
        Cajas c = new Cajas();
        c.setVisible(true);
        escritorio.add(c);
        escritorio.moveToFront(c);
        c.setLocation((Principal.escritorio.getWidth() - c.getWidth()) / 2, (Principal.escritorio.getHeight() - c.getHeight()) / 2);
    }//GEN-LAST:event_jbCajaActionPerformed

    private void jbSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSistemaActionPerformed
        Sistema c = new Sistema();
        c.setVisible(true);
        escritorio.add(c);
        escritorio.moveToFront(c);
        c.setLocation((Principal.escritorio.getWidth() - c.getWidth()) / 2, (Principal.escritorio.getHeight() - c.getHeight()) / 2);

    }//GEN-LAST:event_jbSistemaActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        try {
            caja = buscarCaja(1);
            setPaneCaja();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClientesActionPerformed
         if (user.getAcceso() == 2) {
            ClientesInicio ci = new ClientesInicio();
            ci.setVisible(true);
            escritorio.add(ci);
            escritorio.moveToFront(ci);
            ci.setLocation((Principal.escritorio.getWidth() - ci.getWidth()) / 2, (Principal.escritorio.getHeight() - ci.getHeight()) / 2);
        } else {
            JOptionPane.showMessageDialog(null, "No posee los permisos suficientes");
        }
    }//GEN-LAST:event_jbClientesActionPerformed

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
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbCaja;
    private javax.swing.JButton jbClientes;
    private javax.swing.JButton jbConsultas;
    private javax.swing.JButton jbEstadisticas;
    private javax.swing.JButton jbPedidos;
    private javax.swing.JButton jbProductos;
    private javax.swing.JButton jbProveedores;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbSistema;
    private javax.swing.JButton jbVentas;
    private javax.swing.JButton jbVolverAlInicio;
    public static javax.swing.JLabel jlCajaActivacion;
    private javax.swing.JLabel jlFH1;
    private javax.swing.JLabel jlFechaHora;
    private javax.swing.JLabel jlUser;
    private javax.swing.JPanel jpBotonera;
    private javax.swing.JPanel jpCaja;
    public static javax.swing.JPanel jpCajaActivacion;
    private javax.swing.JPanel jpInicio;
    // End of variables declaration//GEN-END:variables

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

    public static Caja buscarCaja(int id) {

        Caja caja = null;

        try {

            Session session = HibernateConfig.get().openSession();

            Caja_data cd = new Caja_data(session);

            caja = cd.encontrarPorID(id);

            session.close();
        } catch (NullPointerException nex) {
            JOptionPane.showMessageDialog(null, "No se encontro la caja en la base de datos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

        return caja;

    }

    public static void setPaneCaja() {

        if (caja.isEstado() == false) {
            jpCajaActivacion.setBackground(Color.RED);
            jlCajaActivacion.setText("CERRADA");
        } else {
            jpCajaActivacion.setBackground(Color.GREEN);
            jlCajaActivacion.setText("ABIERTA");
        }

    }

    private void detenerXAMPP() {
        Process proceso = null;
        try {
            System.out.println("Deteniendo XAAMP");
            String rutaXAMPP = "C:\\xampp\\xampp_stop.exe";
            proceso = Runtime.getRuntime().exec(rutaXAMPP);
            int exitCode = proceso.waitFor();
            System.out.println("XAMPP detenido con c�digo de salida: " + exitCode);
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

}

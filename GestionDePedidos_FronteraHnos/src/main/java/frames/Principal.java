package frames;

import config.HibernateConfig;
import config_tables.Render;
import data.*;
import entidades.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Session;

public class Principal extends javax.swing.JFrame {

    private SwingWorker<Void, Void> cargaWorker;
    private JButton boton = new JButton();
    private JButton botonEliminar = new JButton();
    public static int columna1;
    public static int fila1;
    public static int columna2;
    public static int fila2;
    public static int numeroPacks = 0;
    public static float tasa = 0;
    public static DetalleProducto dp = null;

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    private final DefaultTableModel modelo2 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    public Principal() {
        initComponents();
        jpBotonera.setOpaque(false);
        jpBusqueda.setOpaque(false);
        jpDesktop.setOpaque(false);
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
        setButton(boton, "/icons/oferta.png");
        setButton(botonEliminar, "/icons/borrarx18.png");
        boton.setName("Oferta");
        botonEliminar.setName("Borrar");
        armarTablaProductos();
        armarTablaOfertas();
        borrarFilas();
        actualizarListaProductos();
        borrarFilas2();
        actualizarListaOfertas();
        cargarProveedores();
    }

    private void setButton(JButton jbutton, String ruta) {
        jbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
        jbutton.setBackground(Color.GRAY);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/fondoPrincipal.png"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jpBotonera = new javax.swing.JPanel();
        jbProductos = new javax.swing.JButton();
        jbPreventistas = new javax.swing.JButton();
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/fondoEscritorio1.png"));
        Image image2 = icon2.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image2,0,0,getWidth(),getHeight(),this);
            }
        };
        jpDesktop = new javax.swing.JPanel();
        jpProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jpPromociones = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOfertas = new javax.swing.JTable();
        jpBusqueda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtBuscar = new javax.swing.JTextField();
        jcProveedores = new javax.swing.JComboBox<>();
        jbBuscar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbProductos.setBackground(new java.awt.Color(102, 102, 255));
        jbProductos.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 18)); // NOI18N
        jbProductos.setForeground(new java.awt.Color(255, 255, 255));
        jbProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productos.png"))); // NOI18N
        jbProductos.setText("Productos");
        jbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProductosActionPerformed(evt);
            }
        });

        jbPreventistas.setBackground(new java.awt.Color(102, 102, 255));
        jbPreventistas.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 18)); // NOI18N
        jbPreventistas.setForeground(new java.awt.Color(255, 255, 255));
        jbPreventistas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor.png"))); // NOI18N
        jbPreventistas.setText("Preventistas");
        jbPreventistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPreventistasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotoneraLayout = new javax.swing.GroupLayout(jpBotonera);
        jpBotonera.setLayout(jpBotoneraLayout);
        jpBotoneraLayout.setHorizontalGroup(
            jpBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoneraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbProductos)
                .addGap(18, 18, 18)
                .addComponent(jbPreventistas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBotoneraLayout.setVerticalGroup(
            jpBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoneraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbPreventistas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        escritorio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jpProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductos);

        javax.swing.GroupLayout jpProductosLayout = new javax.swing.GroupLayout(jpProductos);
        jpProductos.setLayout(jpProductosLayout);
        jpProductosLayout.setHorizontalGroup(
            jpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpProductosLayout.setVerticalGroup(
            jpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProductosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpPromociones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Promociones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jTableOfertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableOfertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOfertasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableOfertas);

        javax.swing.GroupLayout jpPromocionesLayout = new javax.swing.GroupLayout(jpPromociones);
        jpPromociones.setLayout(jpPromocionesLayout);
        jpPromocionesLayout.setHorizontalGroup(
            jpPromocionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPromocionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpPromocionesLayout.setVerticalGroup(
            jpPromocionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPromocionesLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Búsqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar por producto : ");

        jtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarKeyReleased(evt);
            }
        });

        jbBuscar.setBackground(new java.awt.Color(102, 102, 255));
        jbBuscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbBuscar.setText("Buscar");
        jbBuscar.setAutoscrolls(true);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbLimpiar.setBackground(new java.awt.Color(102, 102, 255));
        jbLimpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jbLimpiar.setText("Limpiar");
        jbLimpiar.setAutoscrolls(true);
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar por preventista :");

        jbActualizar.setBackground(new java.awt.Color(255, 255, 0));
        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refreshx48.png"))); // NOI18N
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBusquedaLayout = new javax.swing.GroupLayout(jpBusqueda);
        jpBusqueda.setLayout(jpBusquedaLayout);
        jpBusquedaLayout.setHorizontalGroup(
            jpBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpBusquedaLayout.createSequentialGroup()
                        .addComponent(jcProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpiar))
                    .addComponent(jtBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpBusquedaLayout.setVerticalGroup(
            jpBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBusquedaLayout.createSequentialGroup()
                .addGroup(jpBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBusquedaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtBuscar))
                        .addGap(12, 12, 12)
                        .addGroup(jpBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar)
                            .addComponent(jbLimpiar)))
                    .addComponent(jbActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpDesktopLayout = new javax.swing.GroupLayout(jpDesktop);
        jpDesktop.setLayout(jpDesktopLayout);
        jpDesktopLayout.setHorizontalGroup(
            jpDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDesktopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpDesktopLayout.createSequentialGroup()
                        .addComponent(jpProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpPromociones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpDesktopLayout.setVerticalGroup(
            jpDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDesktopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpPromociones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        escritorio.setLayer(jpDesktop, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(escritorio))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpBotonera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProductosActionPerformed
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
                    Thread.sleep(2000);
                    Productos ap = new Productos();
                    ap.setVisible(true);
                    escritorio.add(ap);
                    escritorio.moveToFront(ap);
                    ap.setLocation((escritorio.getWidth() - ap.getWidth()) / 2, (escritorio.getHeight() - ap.getHeight()) / 2);
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
    }//GEN-LAST:event_jbProductosActionPerformed

    private void jbPreventistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPreventistasActionPerformed
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
                    Thread.sleep(2000);
                    Proveedores p = new Proveedores();
                    p.setVisible(true);
                    escritorio.add(p);
                    escritorio.moveToFront(p);
                    p.setLocation((escritorio.getWidth() - p.getWidth()) / 2, (escritorio.getHeight() - p.getHeight()) / 2);
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
    }//GEN-LAST:event_jbPreventistasActionPerformed

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        try {
            columna1 = jTableProductos.getColumnModel().getColumnIndexAtX(evt.getX());
            fila1 = evt.getY() / jTableProductos.getRowHeight();

            if (columna1 <= jTableProductos.getColumnCount() && columna1 >= 0 && fila1 <= jTableProductos.getRowCount() && fila1 >= 0) {
                Object o = jTableProductos.getValueAt(fila1, columna1);
                if (o instanceof JButton) {

                    ((JButton) o).doClick();
                    JButton botones = (JButton) o;

                    if (botones.getName().equals("Oferta")) {
                        int idDP = (int) modelo.getValueAt(jTableProductos.getSelectedRow(), 0);
                        Session session = HibernateConfig.get().openSession();
                        DetalleProducto_data dpd = new DetalleProducto_data(session);
                        dp = dpd.encontrarPorID(idDP);
                        session.close();
                        Ofertas of = new Ofertas();
                        of.setVisible(true);
                        escritorio.add(of);
                        escritorio.moveToFront(of);
                        of.setLocation((escritorio.getWidth() - of.getWidth()) / 2, (escritorio.getHeight() - of.getHeight()) / 2);
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarKeyReleased
        try {
            Session session = HibernateConfig.get().openSession();

            DetalleProducto_data pd = new DetalleProducto_data(session);
            Oferta_data ofd = new Oferta_data(session);

            List<DetalleProducto> productos = pd.listarTodo();
            List<Oferta> ofertas = ofd.listarTodo();

            String campoBuscarNombre = jtBuscar.getText().toUpperCase();

            borrarFilas();

            Collections.sort(productos, Comparator.comparing(DetalleProducto::getPrecioPorPaquete));

            for (DetalleProducto p : productos) {
                if (p.getProducto().getNombre().toUpperCase().startsWith(campoBuscarNombre)) {
                    modelo.addRow(new Object[]{
                        p.getIdDetalleProducto(),
                        p.getProducto().getNombre(),
                        p.getProveedor().getNombre(),
                        p.getPrecioCosto(),
                        p.getUnidadesPorPaquete(),
                        p.getPrecioPorPaquete(),
                        boton,});
                }
            }

            borrarFilas2();

            Collections.sort(ofertas, Comparator.comparing(Oferta::getPrecioFinalTotal));

            for (Oferta o : ofertas) {
                if (o.getProducto().getNombre().toUpperCase().startsWith(campoBuscarNombre)) {
                    modelo2.addRow(new Object[]{
                        o.getIdOferta(),
                        o.getFecha(),
                        o.getProducto().getNombre(),
                        o.getProveedor().getNombre(),
                        o.getNumPaquetes(),
                        o.getTasaDesc(),
                        o.getPrecioFinalUnitario(),
                        o.getPrecioFinalPack(),
                        o.getPrecioFinalTotal(),
                        botonEliminar});
                }
            }

            session.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jtBuscarKeyReleased

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            Session session = HibernateConfig.get().openSession();

            DetalleProducto_data pd = new DetalleProducto_data(session);
            Oferta_data ofd = new Oferta_data(session);

            List<DetalleProducto> productos = pd.listarTodo();
            List<Oferta> ofertas = ofd.listarTodo();

            Proveedor prov = (Proveedor) jcProveedores.getSelectedItem();

            borrarFilas();

            Collections.sort(productos, Comparator.comparing(DetalleProducto::getPrecioPorPaquete));

            for (DetalleProducto p : productos) {
                if (p.getProveedor().getNombre().equals(prov.getNombre())) {
                    modelo.addRow(new Object[]{
                        p.getIdDetalleProducto(),
                        p.getProducto().getNombre(),
                        p.getProveedor().getNombre(),
                        p.getPrecioCosto(),
                        p.getUnidadesPorPaquete(),
                        p.getPrecioPorPaquete(),
                        boton,});
                }
            }

            borrarFilas2();
            Collections.sort(ofertas, Comparator.comparing(Oferta::getPrecioFinalTotal));
            for (Oferta o : ofertas) {
                if (o.getProveedor().getNombre().equals(prov.getNombre())) {
                    modelo2.addRow(new Object[]{
                        o.getIdOferta(),
                        o.getFecha(),
                        o.getProducto().getNombre(),
                        o.getProveedor().getNombre(),
                        o.getNumPaquetes(),
                        o.getTasaDesc(),
                        o.getPrecioFinalUnitario(),
                        o.getPrecioFinalPack(),
                        o.getPrecioFinalTotal(),
                        botonEliminar});
                }
            }

            session.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        jcProveedores.setSelectedIndex(-1);
        actualizarListaProductos();
        actualizarListaOfertas();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        borrarFilas();
        actualizarListaProductos();
        borrarFilas2();
        actualizarListaOfertas();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jTableOfertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOfertasMouseClicked
        try {
            columna2 = jTableOfertas.getColumnModel().getColumnIndexAtX(evt.getX());
            fila2 = evt.getY() / jTableOfertas.getRowHeight();

            if (columna2 <= jTableOfertas.getColumnCount() && columna2 >= 0 && fila2 <= jTableOfertas.getRowCount() && fila2 >= 0) {
                Object o = jTableOfertas.getValueAt(fila2, columna2);
                if (o instanceof JButton) {
                    ((JButton) o).doClick();
                    JButton botones = (JButton) o;

                    if (botones.getName().equals("Borrar")) {
                        // Preguntar al usuario si realmente desea borrar el registro
                        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este registro?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (confirmacion == JOptionPane.YES_OPTION) {
                            // Continuar con la eliminación
                            int idOF = (int) modelo2.getValueAt(jTableOfertas.getSelectedRow(), 0);
                            Session session = HibernateConfig.get().openSession();
                            Oferta_data ofd = new Oferta_data(session);
                            ofd.eliminarPorID(idOF);
                            borrarFilas2();
                            actualizarListaOfertas();
                            session.close();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jTableOfertasMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableOfertas;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbPreventistas;
    private javax.swing.JButton jbProductos;
    private javax.swing.JComboBox<Proveedor> jcProveedores;
    private javax.swing.JPanel jpBotonera;
    private javax.swing.JPanel jpBusqueda;
    private javax.swing.JPanel jpDesktop;
    private javax.swing.JPanel jpProductos;
    private javax.swing.JPanel jpPromociones;
    private javax.swing.JTextField jtBuscar;
    // End of variables declaration//GEN-END:variables

    public void armarTablaProductos() {

        modelo.setColumnCount(0);

        jTableProductos.setDefaultRenderer(Object.class, new Render());

        jTableProductos.setRowHeight(25);

        modelo.addColumn("ID");
        modelo.addColumn("Producto");
        modelo.addColumn("Proveedor");
        modelo.addColumn("$ unidad");
        modelo.addColumn("Unidades por pack");
        modelo.addColumn("$ pack");
        modelo.addColumn(" ");

        jTableProductos.setModel(modelo);

        TableColumn column6 = jTableProductos.getColumnModel().getColumn(6);
        TableColumn column0 = jTableProductos.getColumnModel().getColumn(0);

        column6.setPreferredWidth(25);
        column0.setPreferredWidth(25);
    }

    public void armarTablaOfertas() {

        modelo2.setColumnCount(0);

        jTableOfertas.setDefaultRenderer(Object.class, new Render());

        jTableOfertas.setRowHeight(25);

        modelo2.addColumn("ID");
        modelo2.addColumn("Fecha");
        modelo2.addColumn("Producto");
        modelo2.addColumn("Proveedor");
        modelo2.addColumn("Cantidad de packs");
        modelo2.addColumn("Tasa (%)");
        modelo2.addColumn("$ unidad");
        modelo2.addColumn("$ pack");
        modelo2.addColumn("$ total");
        modelo2.addColumn(" ");

        jTableOfertas.setModel(modelo2);

        TableColumn column9 = jTableOfertas.getColumnModel().getColumn(9);  // Por ejemplo, la segunda columna (índice 1)
        TableColumn column0 = jTableOfertas.getColumnModel().getColumn(0);

        // Establecer el ancho preferido de la columna
        column9.setPreferredWidth(25);
        column0.setPreferredWidth(25);
    }

    public void actualizarListaProductos() {
        modelo.setRowCount(0);

        Session session = HibernateConfig.get().openSession();

        DetalleProducto_data pd = new DetalleProducto_data(session);

        List<DetalleProducto> productos = pd.listarTodo();

        // Ordenar la lista de productos por precioCosto de menor a mayor
        Collections.sort(productos, Comparator.comparing(DetalleProducto::getPrecioPorPaquete));

        for (DetalleProducto p : productos) {
            modelo.addRow(new Object[]{
                p.getIdDetalleProducto(),
                p.getProducto().getNombre(),
                p.getProveedor().getNombre(),
                p.getPrecioCosto(),
                p.getUnidadesPorPaquete(),
                p.getPrecioPorPaquete(),
                boton});
        }

        session.close();
    }

    public void actualizarListaOfertas() {
        modelo2.setRowCount(0);

        Session session = HibernateConfig.get().openSession();

        Oferta_data od = new Oferta_data(session);

        List<Oferta> ofertas = od.listarTodo();

        Collections.sort(ofertas, Comparator.comparing(Oferta::getPrecioFinalTotal));
        for (Oferta o : ofertas) {
            modelo2.addRow(new Object[]{
                o.getIdOferta(),
                o.getFecha(),
                o.getProducto().getNombre(),
                o.getProveedor().getNombre(),
                o.getNumPaquetes(),
                o.getTasaDesc(),
                o.getPrecioFinalUnitario(),
                o.getPrecioFinalPack(),
                o.getPrecioFinalTotal(),
                botonEliminar});
        }

        session.close();

    }

    public void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    public void borrarFilas2() {
        int f = modelo2.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo2.removeRow(f);
        }
    }

    private void cargarProveedores() {
        jcProveedores.removeAllItems();

        Session session = HibernateConfig.get().openSession();
        Proveedor_data pd = new Proveedor_data(session);
        List<Proveedor> proveedores = pd.listarTodo();

        Set<String> proveedoresAgregados = new HashSet<>();

        for (Proveedor p : proveedores) {
            String nombreProveedores = p.getNombre();
            if (!proveedoresAgregados.contains(nombreProveedores)) {
                jcProveedores.addItem(p);
                proveedoresAgregados.add(nombreProveedores);
            }
        }

        jcProveedores.setSelectedIndex(-1);

        session.close();

    }
}

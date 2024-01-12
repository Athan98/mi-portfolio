package frames;

import config.HibernateConfig;
import config_tables.Render;
import data.*;
import entidades.*;
import exportarExcel.Controlador;
import static frames.Principal.escritorio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Session;

public class Productos extends javax.swing.JInternalFrame {

    private SwingWorker<Void, Void> cargaWorker;
    private float valorPaquete = 0;

    Class tipo[] = new Class[]{java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return col == 0;  // Hacer la primera columna (checkbox) editable
        }

        @Override
        public Class getColumnClass(int index) {
            return tipo[index];
        }
    };

    public Productos() {
        initComponents();
        cargarProveedores();
        cargarProductos();
        armarCabeceraTabla();
        actualizarListaProductos();
        jbGuardar.setEnabled(false);
        jbAgregar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcProveedores = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtPrecioUnitario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtCantidadPorPaquete = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtValorPaquete = new javax.swing.JTextField();
        jbNuevoProveedor = new javax.swing.JButton();
        jbActualizarListaProv = new javax.swing.JButton();
        jbCalcularPack = new javax.swing.JButton();
        jcProductos = new javax.swing.JComboBox<>();
        jbNuevoProducto = new javax.swing.JButton();
        jbActualizarListaProductos = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jlID = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtBuscarNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jbEliminar = new javax.swing.JButton();
        jbExportar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();

        setClosable(true);
        setTitle("PRODUCTOS");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre del producto :");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Preventista :");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio por unidad :");

        jtPrecioUnitario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtPrecioUnitario.setText("0");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cantidad por paquete :");

        jtCantidadPorPaquete.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCantidadPorPaquete.setText("0");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Valor del paquete :");

        jtValorPaquete.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtValorPaquete.setText("0");

        jbNuevoProveedor.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jbNuevoProveedor.setText("Nuevo");
        jbNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoProveedorActionPerformed(evt);
            }
        });

        jbActualizarListaProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jbActualizarListaProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarListaProvActionPerformed(evt);
            }
        });

        jbCalcularPack.setForeground(new java.awt.Color(0, 204, 0));
        jbCalcularPack.setText("Calcular valor del paquete");
        jbCalcularPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularPackActionPerformed(evt);
            }
        });

        jbNuevoProducto.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jbNuevoProducto.setText("Nuevo");
        jbNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoProductoActionPerformed(evt);
            }
        });

        jbActualizarListaProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jbActualizarListaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarListaProductosActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ID :");

        jlID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlID.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtCantidadPorPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcProveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jtValorPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbCalcularPack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jcProductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbNuevoProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbNuevoProveedor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbActualizarListaProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbActualizarListaProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addComponent(jlID, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNuevoProducto)
                    .addComponent(jbActualizarListaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNuevoProveedor)
                    .addComponent(jbActualizarListaProv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtCantidadPorPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtValorPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCalcularPack))
                .addGap(66, 66, 66))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(0, 204, 0));
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbLimpiar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        jbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/limpiar.png"))); // NOI18N
        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(0, 0, 0));
        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/guardar.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jbLimpiar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbLimpiar)
                    .addComponent(jbGuardar))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel6.setText("Buscar por nombre :");

        jtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarNombreKeyReleased(evt);
            }
        });

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
        jScrollPane1.setViewportView(jTableProductos);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(204, 0, 0));
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jbEliminar.setText("Eliminar seleccionados");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbExportar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbExportar.setForeground(new java.awt.Color(0, 204, 0));
        jbExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        jbExportar.setText("Exportar");
        jbExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExportarActionPerformed(evt);
            }
        });

        jbEditar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEditar.setForeground(new java.awt.Color(0, 0, 0));
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExportar)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtBuscarNombre))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoProveedorActionPerformed
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
    }//GEN-LAST:event_jbNuevoProveedorActionPerformed

    private void jbActualizarListaProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarListaProvActionPerformed
        cargarProveedores();
    }//GEN-LAST:event_jbActualizarListaProvActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        Session session = HibernateConfig.get().openSession();
        DetalleProducto_data dpd = new DetalleProducto_data(session);

        Producto prod = (Producto) jcProductos.getSelectedItem();
        Proveedor prov = (Proveedor) jcProveedores.getSelectedItem();
        float precioUnitario = Float.parseFloat(jtPrecioUnitario.getText());
        int cantidad = Integer.parseInt(jtCantidadPorPaquete.getText());
        float valorPaquete = Float.parseFloat(jtValorPaquete.getText());

        DetalleProducto dp = new DetalleProducto(prod, prov, precioUnitario, cantidad, valorPaquete);

        try {

            dpd.agregar(dp);
            limpiarCampos();
            actualizarListaProductos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

        session.close();


    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExportarActionPerformed
        Controlador obj;
        try {
            obj = new Controlador();
            obj.exportarExcel(jTableProductos);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error de archivo");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbExportarActionPerformed

    private void jbCalcularPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularPackActionPerformed
        float precioUnitario = Float.parseFloat(jtPrecioUnitario.getText());
        int cantidadUnidades = Integer.parseInt(jtCantidadPorPaquete.getText());

        valorPaquete = precioUnitario * cantidadUnidades;

        jtValorPaquete.setText(valorPaquete + "");
    }//GEN-LAST:event_jbCalcularPackActionPerformed

    private void jbNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoProductoActionPerformed
        AgregarProducto ap = new AgregarProducto();
        ap.setVisible(true);
        Principal.escritorio.add(ap);
        Principal.escritorio.moveToFront(ap);
        ap.setLocation((Principal.escritorio.getWidth() - ap.getWidth()) / 2, (Principal.escritorio.getHeight() - ap.getHeight()) / 2);
    }//GEN-LAST:event_jbNuevoProductoActionPerformed

    private void jbActualizarListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarListaProductosActionPerformed
        cargarProductos();
    }//GEN-LAST:event_jbActualizarListaProductosActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jtBuscarNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarNombreKeyReleased
        try {
            Session session = HibernateConfig.get().openSession();

            DetalleProducto_data pd = new DetalleProducto_data(session);

            List<DetalleProducto> productos = pd.listarTodo();
            String campoBuscarNombre = jtBuscarNombre.getText().toUpperCase();

            borrarFilas();

            for (DetalleProducto p : productos) {
                if (p.getProducto().getNombre().toUpperCase().startsWith(campoBuscarNombre)) {
                    modelo.addRow(new Object[]{
                        false,
                        p.getIdDetalleProducto(),
                        p.getProducto().getNombre(),
                        p.getProveedor().getNombre(),
                        p.getPrecioCosto(),
                        p.getUnidadesPorPaquete(),
                        p.getPrecioPorPaquete(),});
                }
            }

            session.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jtBuscarNombreKeyReleased

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        if (jcProductos.getSelectedIndex() == -1 || jcProveedores.getSelectedIndex() == -1
                || jtPrecioUnitario.getText().isEmpty() || jtCantidadPorPaquete.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Asegúrese de llenar los campos correctamente");
        } else {

            try {
                Session session = HibernateConfig.get().openSession();
                DetalleProducto_data dpd = new DetalleProducto_data(session);

                int idDP = Integer.parseInt(jlID.getText());
                Producto prod = (Producto) jcProductos.getSelectedItem();
                Proveedor prov = (Proveedor) jcProveedores.getSelectedItem();
                float precioUnitario = Float.parseFloat(jtPrecioUnitario.getText());
                int cantidad = Integer.parseInt(jtCantidadPorPaquete.getText());
                float precioPack = Float.parseFloat(jtValorPaquete.getText());

                DetalleProducto dp = new DetalleProducto(idDP, prod, prov, precioUnitario, cantidad, precioPack);
                dpd.actualizar(dp);

                JOptionPane.showMessageDialog(null, "El detalle ha sido actualizado");
                limpiarCampos();
                borrarFilas();
                actualizarListaProductos();
                jbAgregar.setEnabled(true);
                jbGuardar.setEnabled(false);

                session.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        jbGuardar.setEnabled(true);
        jbAgregar.setEnabled(false);

        try {
            int filaSeleccionada = jTableProductos.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
                return;
            }

            int idDP = (int) modelo.getValueAt(filaSeleccionada, 1);

            Session session = HibernateConfig.get().openSession();
            DetalleProducto_data dpd = new DetalleProducto_data(session);
            DetalleProducto dp = dpd.encontrarPorID(idDP);

            session.close();

            for (int i = 0; i < jcProductos.getItemCount(); i++) {
                Producto prod = jcProductos.getItemAt(i);
                if (prod.getNombre().toUpperCase().equals(dp.getProducto().getNombre().toUpperCase())) {
                    jcProductos.setSelectedIndex(i);
                    break;
                }
            }

            for (int i = 0; i < jcProveedores.getItemCount(); i++) {
                Proveedor prov = jcProveedores.getItemAt(i);
                if (prov.getNombre().toUpperCase().equals(dp.getProveedor().getNombre().toUpperCase())) {
                    jcProveedores.setSelectedIndex(i);
                    break;
                }
            }

            jtPrecioUnitario.setText(dp.getPrecioCosto() + "");
            jtCantidadPorPaquete.setText(dp.getUnidadesPorPaquete() + "");
            jtValorPaquete.setText(dp.getPrecioPorPaquete() + "");
            jlID.setText(dp.getIdDetalleProducto() + "");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            Session session = HibernateConfig.get().openSession();
            DetalleProducto_data dpd = new DetalleProducto_data(session);

            List<DetalleProducto> detalles = dpd.listarTodo();
            List<DetalleProducto> detallesAEliminar = new ArrayList<>(); // Inicializar la lista

            boolean ver;
            DetalleProducto dp;

            for (int i = 0; i < detalles.size(); i++) {
                ver = (boolean) modelo.getValueAt(i, 0);
                dp = dpd.encontrarPorID((int) modelo.getValueAt(i, 1));
                if (ver) {
                    detallesAEliminar.add(dp);
                }
            }

            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar las filas seleccionadas?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                for (DetalleProducto dps : detallesAEliminar) {
                    dpd.eliminar(dps);
                }
                JOptionPane.showMessageDialog(null, "Elementos eliminados exitosamente");
                borrarFilas();
                actualizarListaProductos();
            } else {
                JOptionPane.showMessageDialog(null, "Operacion cancelada");
            }

            session.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JButton jbActualizarListaProductos;
    private javax.swing.JButton jbActualizarListaProv;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbCalcularPack;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbExportar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbNuevoProducto;
    private javax.swing.JButton jbNuevoProveedor;
    private javax.swing.JComboBox<Producto> jcProductos;
    private javax.swing.JComboBox<Proveedor> jcProveedores;
    private javax.swing.JLabel jlID;
    private javax.swing.JTextField jtBuscarNombre;
    private javax.swing.JTextField jtCantidadPorPaquete;
    private javax.swing.JTextField jtPrecioUnitario;
    private javax.swing.JTextField jtValorPaquete;
    // End of variables declaration//GEN-END:variables

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

    private void cargarProductos() {
        jcProductos.removeAllItems();

        Session session = HibernateConfig.get().openSession();
        Producto_data pd = new Producto_data(session);
        List<Producto> productos = pd.listarTodo();

        Set<String> productosAgregados = new HashSet<>();

        for (Producto p : productos) {
            String nombreProducto = p.getNombre();
            if (!productosAgregados.contains(nombreProducto)) {
                jcProductos.addItem(p);
                productosAgregados.add(nombreProducto);
            }
        }

        jcProductos.setSelectedIndex(-1);

        session.close();

    }

    private void limpiarCampos() {
        jcProductos.setSelectedIndex(-1);
        jcProveedores.setSelectedIndex(-1);
        jtPrecioUnitario.setText("0");
        jtCantidadPorPaquete.setText("0");
        jtValorPaquete.setText("0");
        jlID.setText("-");
    }

    public void armarCabeceraTabla() {
        modelo.setColumnCount(0);

        jTableProductos.setDefaultRenderer(Object.class, new Render());

        jTableProductos.setRowHeight(25);

        modelo.addColumn(" ");
        modelo.addColumn("ID");
        modelo.addColumn("Producto");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Precio por unidad");
        modelo.addColumn("Unidades por pack");
        modelo.addColumn("Valor del pack");

        jTableProductos.setModel(modelo);

        TableColumn column1 = jTableProductos.getColumnModel().getColumn(1);
        TableColumn column0 = jTableProductos.getColumnModel().getColumn(0);

        column1.setPreferredWidth(25);
        column0.setPreferredWidth(20);
    }

    public void actualizarListaProductos() {

        modelo.setRowCount(0);

        Session session = HibernateConfig.get().openSession();

        DetalleProducto_data pd = new DetalleProducto_data(session);

        List<DetalleProducto> productos = pd.listarTodo();

        for (DetalleProducto p : productos) {
            modelo.addRow(new Object[]{
                false,
                p.getIdDetalleProducto(),
                p.getProducto().getNombre(),
                p.getProveedor().getNombre(),
                p.getPrecioCosto(),
                p.getUnidadesPorPaquete(),
                p.getPrecioPorPaquete(),});

        }

        session.close();
    }

    public void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

}

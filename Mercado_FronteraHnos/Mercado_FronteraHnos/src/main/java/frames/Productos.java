package frames;

import config.HibernateConfig;
import data.Categoria_data;
import data.Producto_data;
import entidades.Categoria;
import entidades.Producto;
import exportarExcel.Controlador;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class Productos extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    public Productos() {
        initComponents();
        jbGuardar.setEnabled(false);
        jbAgregar.setEnabled(true);
        cargarComboBox();
        armarCabeceraTabla();
        actualizarListaProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtCodigo = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcCategorias = new javax.swing.JComboBox<>();
        jbAgregarCategoria = new javax.swing.JButton();
        jlID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbEscanearNuevo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtCostoUnitario = new javax.swing.JTextField();
        jtPrecioVenta = new javax.swing.JTextField();
        jtStock = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtGanancia = new javax.swing.JTextField();
        jbCalcularPrecioVenta = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jtBuscarPorNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtBusquedaCodigo = new javax.swing.JTextField();
        jbEscanear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jbEditarProducto = new javax.swing.JButton();
        jbExportarExcel = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jtTasaActualizacion = new javax.swing.JTextField();
        jbActualizarMasiva = new javax.swing.JButton();
        jbLimpiarCodigo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();

        setClosable(true);
        setTitle("PRODUCTOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 20))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripciones del producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jtDescripcion.setColumns(20);
        jtDescripcion.setRows(5);
        jScrollPane1.setViewportView(jtDescripcion);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Descripcion:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre:");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Código:");

        jtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCodigoKeyPressed(evt);
            }
        });

        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNombreKeyPressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Categoria:");

        jbAgregarCategoria.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jbAgregarCategoria.setText("NUEVO");
        jbAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarCategoriaActionPerformed(evt);
            }
        });

        jlID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlID.setText("-");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ID:");

        jbEscanearNuevo.setText("Escanear");
        jbEscanearNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEscanearNuevoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(172, 172, 172))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbEscanearNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlID, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(260, 260, 260))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jcCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAgregarCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCodigo)
                    .addComponent(jbEscanearNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbAgregarCategoria)
                        .addComponent(jcCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precios y Stock", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Precio venta unitario ($) :");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Precio costo unitario ($) :");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Stock:");

        jtCostoUnitario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCostoUnitario.setText("0");
        jtCostoUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCostoUnitarioKeyPressed(evt);
            }
        });

        jtPrecioVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtPrecioVenta.setText("0");
        jtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPrecioVentaKeyPressed(evt);
            }
        });

        jtStock.setEditable(false);
        jtStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtStock.setText("0");
        jtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtStockKeyPressed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ganancia (%):");

        jtGanancia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtGanancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtGananciaKeyPressed(evt);
            }
        });

        jbCalcularPrecioVenta.setForeground(new java.awt.Color(0, 153, 0));
        jbCalcularPrecioVenta.setText("Calcular $");
        jbCalcularPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularPrecioVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jtCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCalcularPrecioVenta))
                    .addComponent(jtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCalcularPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar.png"))); // NOI18N
        jbAgregar.setText("AGREGAR");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(0, 0, 0));
        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar.png"))); // NOI18N
        jbGuardar.setText("GUARDAR");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbLimpiar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        jbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiar.png"))); // NOI18N
        jbLimpiar.setText("LIMPIAR");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jbGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jbLimpiar)
                    .addComponent(jbGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 20))); // NOI18N

        jLabel10.setText("Buscar por nombre:");

        jtBuscarPorNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtBuscarPorNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarPorNombreKeyReleased(evt);
            }
        });

        jLabel11.setText("Buscar por código:");

        jtBusquedaCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtBusquedaCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaCodigoKeyReleased(evt);
            }
        });

        jbEscanear.setText("Escanear");
        jbEscanear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEscanearActionPerformed(evt);
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
        jScrollPane2.setViewportView(jTableProductos);

        jbEditarProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEditarProducto.setForeground(new java.awt.Color(0, 0, 0));
        jbEditarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        jbEditarProducto.setText("EDITAR");
        jbEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarProductoActionPerformed(evt);
            }
        });

        jbExportarExcel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbExportarExcel.setForeground(new java.awt.Color(51, 153, 0));
        jbExportarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excel.png"))); // NOI18N
        jbExportarExcel.setText("EXPORTAR");
        jbExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExportarExcelActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actualizar precios masivamente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel12.setText("Multiplicar por (%) :");

        jtTasaActualizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtTasaActualizacionKeyPressed(evt);
            }
        });

        jbActualizarMasiva.setForeground(new java.awt.Color(0, 153, 0));
        jbActualizarMasiva.setText("Actualizar $");
        jbActualizarMasiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarMasivaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jtTasaActualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbActualizarMasiva)
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtTasaActualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizarMasiva))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbLimpiarCodigo.setText("Limpiar");
        jbLimpiarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCodigoActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(204, 0, 0));
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        jbEliminar.setText("ELIMINAR");
        jbEliminar.setToolTipText("");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtBuscarPorNombre))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jtBusquedaCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(jbEscanear)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpiarCodigo))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jbEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jbExportarExcel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtBusquedaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEscanear)
                    .addComponent(jbLimpiarCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbExportarExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbEditarProducto)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed

        Session session = HibernateConfig.get().openSession();
        Categoria cat = (Categoria) jcCategorias.getSelectedItem();
        String nombreProd = jtNombre.getText();
        String descripcion = jtDescripcion.getText();
        String codigo = jtCodigo.getText();
        Double precioVentaUnitario = Double.parseDouble(jtPrecioVenta.getText());
        Double precioCostoUnitario = Double.parseDouble(jtCostoUnitario.getText());
        int stock = Integer.parseInt(jtStock.getText());

        if (jtCodigo.getText().isEmpty() || jtNombre.getText().isEmpty()
                || jcCategorias.getSelectedIndex() == -1 || jtPrecioVenta.getText().isEmpty()
                || jtCostoUnitario.getText().isEmpty() || jtStock.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos");
        } else {

            Producto prod = new Producto(cat, nombreProd, descripcion, codigo, precioVentaUnitario, precioCostoUnitario, stock);

            Producto_data pd = new Producto_data(session);

            pd.agregar(prod);
        }

        session.close();

        limpiarCampos();
        borrarFilas();
        actualizarListaProductos();
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbEscanearNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEscanearNuevoActionPerformed
        jtCodigo.setText("");
        JOptionPane.showMessageDialog(null, "Presione ACEPTAR y escanee el producto");
        jtCodigo.requestFocus();
    }//GEN-LAST:event_jbEscanearNuevoActionPerformed

    private void jbAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarCategoriaActionPerformed
        Categorias c = new Categorias(this);
        c.setVisible(true);
        Principal.escritorio.add(c);
        Principal.escritorio.moveToFront(c);
        c.setLocation((Principal.escritorio.getWidth() - c.getWidth()) / 2, (Principal.escritorio.getHeight() - c.getHeight()) / 2);
    }//GEN-LAST:event_jbAgregarCategoriaActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed

        if (jtCodigo.getText().isEmpty() || jtNombre.getText().isEmpty()
                || jcCategorias.getSelectedIndex() == -1 || jtPrecioVenta.getText().isEmpty()
                || jtCostoUnitario.getText().isEmpty() || jtStock.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos");
        } else {
            Session session = HibernateConfig.get().openSession();
            Producto_data pd = new Producto_data(session);

            int idProducto = Integer.parseInt(jlID.getText());
            String codigo = jtCodigo.getText();
            String nombre = jtNombre.getText();
            String descripcion = jtDescripcion.getText();
            Categoria cat = (Categoria) jcCategorias.getSelectedItem();
            Double precioCosto = Double.parseDouble(jtCostoUnitario.getText());
            Double precioVenta = Double.parseDouble(jtPrecioVenta.getText());
            int stock = Integer.parseInt(jtStock.getText());

            Producto prod = new Producto(idProducto, cat, nombre, descripcion, codigo, precioVenta, precioCosto, stock);
            pd.actualizar(prod);

            borrarFilas();
            actualizarListaProductos();
            limpiarCampos();

            session.close();

        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbCalcularPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularPrecioVentaActionPerformed
        Double costoUnitario = Double.parseDouble(jtCostoUnitario.getText());
        Double porcentajeGanancia = Double.parseDouble(jtGanancia.getText()) / 100;
        Double resultado = costoUnitario + (costoUnitario * porcentajeGanancia);

        jtPrecioVenta.setText(resultado + "");
    }//GEN-LAST:event_jbCalcularPrecioVentaActionPerformed

    private void jbEscanearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEscanearActionPerformed
        jtBusquedaCodigo.setText("");
        JOptionPane.showMessageDialog(null, "Presione ACEPTAR y escanee el producto");
        jtBusquedaCodigo.requestFocus();
    }//GEN-LAST:event_jbEscanearActionPerformed

    private void jtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodigoKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtCodigo.setEditable(true);
        } else {
            jtCodigo.setEditable(false);
        }
    }//GEN-LAST:event_jtCodigoKeyPressed

    private void jtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyPressed
        char x = evt.getKeyChar();
        if (Character.isLetter(x) || Character.isISOControl(x) || (evt.getKeyChar() == ' ')) {
            jtNombre.setEditable(true);
        } else {
            jtNombre.setEditable(false);
        }
    }//GEN-LAST:event_jtNombreKeyPressed

    private void jtCostoUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCostoUnitarioKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtCostoUnitario.setEditable(true);
        } else {
            jtCostoUnitario.setEditable(false);
        }
    }//GEN-LAST:event_jtCostoUnitarioKeyPressed

    private void jtGananciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtGananciaKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtGanancia.setEditable(true);
        } else {
            jtGanancia.setEditable(false);
        }
    }//GEN-LAST:event_jtGananciaKeyPressed

    private void jtPrecioVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecioVentaKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtPrecioVenta.setEditable(true);
        } else {
            jtPrecioVenta.setEditable(false);
        }
    }//GEN-LAST:event_jtPrecioVentaKeyPressed

    private void jtStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtStockKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtStock.setEditable(true);
        } else {
            jtStock.setEditable(false);
        }
    }//GEN-LAST:event_jtStockKeyPressed

    private void jtBuscarPorNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarPorNombreKeyPressed
        char x = evt.getKeyChar();
        if (Character.isLetter(x) || Character.isISOControl(x) || (evt.getKeyChar() == ' ')) {
            jtBuscarPorNombre.setEditable(true);
        } else {
            jtBuscarPorNombre.setEditable(false);
        }
    }//GEN-LAST:event_jtBuscarPorNombreKeyPressed

    private void jtBusquedaCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaCodigoKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtBusquedaCodigo.setEditable(true);
        } else {
            jtBusquedaCodigo.setEditable(false);
        }
    }//GEN-LAST:event_jtBusquedaCodigoKeyPressed

    private void jtBuscarPorNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarPorNombreKeyReleased
        Session session = HibernateConfig.get().openSession();

        Producto_data pd = new Producto_data(session);

        List<Producto> productos = pd.listarTodo();
        String campoBuscarNombre = jtBuscarPorNombre.getText().toUpperCase();

        borrarFilas();

        for (Producto p : productos) {
            if (p.getNombre().toUpperCase().startsWith(campoBuscarNombre)) {
                modelo.addRow(new Object[]{
                    p.getIdProducto(),
                    p.getCodigo(),
                    p.getCategoria().getNombre(),
                    p.getNombre(),
                    p.getPrecioCostoUnitario(),
                    p.getPrecioVentaUnitario(),
                    p.getStock(),});
            }
        }

        session.close();
    }//GEN-LAST:event_jtBuscarPorNombreKeyReleased

    private void jbEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarProductoActionPerformed
        jbAgregar.setEnabled(false);
        jbGuardar.setEnabled(true);

        Producto prod = new Producto();

        int idProducto = (int) modelo.getValueAt(jTableProductos.getSelectedRow(), 0);

        Session session = HibernateConfig.get().openSession();

        Producto_data prod_data = new Producto_data(session);

        prod = prod_data.encontrarPorID(idProducto);

        jlID.setText(prod.getIdProducto() + "");
        jtCodigo.setText(prod.getCodigo());
        jtNombre.setText(prod.getNombre());
        jtDescripcion.setText(prod.getDescripcion());
        jtCostoUnitario.setText(prod.getPrecioCostoUnitario() + "");
        jtPrecioVenta.setText(prod.getPrecioVentaUnitario() + "");
        jtStock.setText(prod.getStock() + "");

        float ganancia = (float) ((((prod.getPrecioVentaUnitario() / prod.getPrecioCostoUnitario())) - 1) * 100);
        jtGanancia.setText(ganancia + "");

        Object categoriaSeleccionada = modelo.getValueAt(jTableProductos.getSelectedRow(), 2);

        for (int i = 0; i < jcCategorias.getItemCount(); i++) {
            Categoria categoria = jcCategorias.getItemAt(i);
            if (categoria.getNombre().equals(categoriaSeleccionada)) {
                jcCategorias.setSelectedIndex(i);
                break;
            }
        }
        session.close();
    }//GEN-LAST:event_jbEditarProductoActionPerformed

    private void jbLimpiarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCodigoActionPerformed
        jtBusquedaCodigo.setText("");
        actualizarListaProductos();
    }//GEN-LAST:event_jbLimpiarCodigoActionPerformed

    private void jbActualizarMasivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarMasivaActionPerformed
        Session session = HibernateConfig.get().openSession();
        Producto_data pd = new Producto_data(session);

        List<Producto> productos = pd.listarTodo();
        double coeficiente = ((Double.parseDouble(jtTasaActualizacion.getText())) + 100) / 100;
        double nuevoPrecio = 0;

        for (Producto p : productos) {
            nuevoPrecio = p.getPrecioVentaUnitario() * coeficiente;
            p.setPrecioVentaUnitario(nuevoPrecio);
            pd.actualizar(p);
        }
        borrarFilas();
        actualizarListaProductos();
        jtTasaActualizacion.setText("");
        session.close();
    }//GEN-LAST:event_jbActualizarMasivaActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed

        int idProducto = (int) modelo.getValueAt(jTableProductos.getSelectedRow(), 0);

        Session session = HibernateConfig.get().openSession();

        Producto_data prod_data = new Producto_data(session);

        int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres eliminarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == JOptionPane.YES_OPTION) {
            prod_data.eliminarPorID(idProducto);

            borrarFilas();
            actualizarListaProductos();
        }

        session.close();

    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExportarExcelActionPerformed
        Controlador obj;
        try {
            obj = new Controlador();
            obj.exportarExcel(jTableProductos);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error de archivo");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbExportarExcelActionPerformed

    private void jtTasaActualizacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTasaActualizacionKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtTasaActualizacion.setEditable(true);
        } else {
            jtTasaActualizacion.setEditable(false);
        }
    }//GEN-LAST:event_jtTasaActualizacionKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarComboBox();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtBusquedaCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaCodigoKeyReleased
        Session session = HibernateConfig.get().openSession();

        Producto_data pd = new Producto_data(session);

        List<Producto> productos = pd.listarTodo();
        String campoBuscarCodigo = jtBusquedaCodigo.getText();

        borrarFilas();

        for (Producto p : productos) {
            if (p.getCodigo().startsWith(campoBuscarCodigo) || p.getCodigo().equals(campoBuscarCodigo)) {
                modelo.addRow(new Object[]{
                    p.getIdProducto(),
                    p.getCodigo(),
                    p.getCategoria().getNombre(),
                    p.getNombre(),
                    p.getPrecioCostoUnitario(),
                    p.getPrecioVentaUnitario(),
                    p.getStock(),});
            }
        }

        session.close();
    }//GEN-LAST:event_jtBusquedaCodigoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JButton jbActualizarMasiva;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbAgregarCategoria;
    private javax.swing.JButton jbCalcularPrecioVenta;
    private javax.swing.JButton jbEditarProducto;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbEscanear;
    private javax.swing.JButton jbEscanearNuevo;
    private javax.swing.JButton jbExportarExcel;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbLimpiarCodigo;
    private javax.swing.JComboBox<Categoria> jcCategorias;
    private javax.swing.JLabel jlID;
    private javax.swing.JTextField jtBuscarPorNombre;
    private javax.swing.JTextField jtBusquedaCodigo;
    private javax.swing.JTextField jtCodigo;
    private javax.swing.JTextField jtCostoUnitario;
    private javax.swing.JTextArea jtDescripcion;
    private javax.swing.JTextField jtGanancia;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPrecioVenta;
    private javax.swing.JTextField jtStock;
    private javax.swing.JTextField jtTasaActualizacion;
    // End of variables declaration//GEN-END:variables

    public void cargarComboBox() {
        jcCategorias.removeAllItems();

        Session session = HibernateConfig.get().openSession();
        Categoria_data cat_data = new Categoria_data(session);
        List<Categoria> categorias = cat_data.listarTodo();

        Set<String> categoriasAgregadas = new HashSet<>();

        for (Categoria cat : categorias) {
            String categoria = cat.getNombre();
            if (!categoriasAgregadas.contains(categoria)) {
                jcCategorias.addItem(cat);
                categoriasAgregadas.add(categoria);
            }
        }

        jcCategorias.setSelectedIndex(-1);

        session.close();
    }

    private void limpiarCampos() {
        jcCategorias.setSelectedIndex(-1);
        jlID.setText("");
        jtCodigo.setText("");
        jtNombre.setText("");
        jtDescripcion.setText("");
        jtCostoUnitario.setText("0");
        jtPrecioVenta.setText("0");
        jtGanancia.setText("0");
        jtStock.setText("0");
        jtBuscarPorNombre.setText("");
        jtBusquedaCodigo.setText("");
        jbAgregar.setEnabled(true);
        jbGuardar.setEnabled(false);
    }

    public void armarCabeceraTabla() {
        modelo.setColumnCount(0);

        modelo.addColumn("ID");
        modelo.addColumn("Codigo");
        modelo.addColumn("Categoria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Costo unitario");
        modelo.addColumn("Precio venta unitario");
        modelo.addColumn("Stock");

        jTableProductos.setModel(modelo);
    }

    public void actualizarListaProductos() {

        modelo.setRowCount(0);

        Session session = HibernateConfig.get().openSession();

        Producto_data pd = new Producto_data(session);

        List<Producto> productos = pd.listarTodo();

        for (Producto p : productos) {
            modelo.addRow(new Object[]{
                p.getIdProducto(),
                p.getCodigo(),
                p.getCategoria().getNombre(),
                p.getNombre(),
                p.getPrecioCostoUnitario(),
                p.getPrecioVentaUnitario(),
                p.getStock(),});

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

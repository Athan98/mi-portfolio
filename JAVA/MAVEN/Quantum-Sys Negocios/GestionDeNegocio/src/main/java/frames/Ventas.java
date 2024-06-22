package frames;

import config.HibernateConfig;
import data.*;
import entidades.*;
import exportarExcel.BoletaPDF;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.hibernate.Session;

public class Ventas extends javax.swing.JInternalFrame {

    Double precioNeto = 0.0;
    Double montoIva = 0.0;
    Double montoTotal = 0.0;
    public static Venta venta;
    public static Cliente cliente;
    Usuario usuario = Principal.user;
    public static boolean enterPresionado = false;
    public static boolean enterPresionadoNombre = false;
    Caja caja = Principal.caja;
    public static List<Producto> productosBuscados = null;
    Double ivaGeneral = 0.27;
    Double ivaReducido1 = 0.21;
    Double ivaReducido2 = 0.105;
    Double ivaSuperreducido = 0.025;

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    public Ventas() {
        initComponents();
        llenarComboUsers();
        llenarComboClientes();
        setearUser(usuario);
        jtFecha.setText(setFecha());
        jlCaja.setText(caja.getNroCaja());
        listarProductos();
        armarCabeceraTabla();
        cargarFormasDePago();
        jlCargar.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcUsuarios = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtFecha = new javax.swing.JTextField();
        jcClientes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jlCaja = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtNOMBRESUELTOS = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtMONTOSUELTOS = new javax.swing.JTextField();
        jtCodigoSUELTOS = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jbLimpiarCampos2 = new javax.swing.JButton();
        jbBuscarProdSueltos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jbAgregarProducto = new javax.swing.JButton();
        jbEliminarProducto = new javax.swing.JButton();
        jbCancelarCarro = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePedido = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jcFormasDePago = new javax.swing.JComboBox<>();
        jbPagar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jlTotalPagar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlPrecioNeto = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jcIVA = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jlMontoIVA = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtDescuento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jlCargar = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jtCodigo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtCantidad = new javax.swing.JTextField();
        jbLimpiarCampos = new javax.swing.JButton();
        jbBuscarProd = new javax.swing.JButton();

        setClosable(true);
        setTitle("VENTAS");

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(51, 153, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("$ VENTAS $");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la venta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel2.setText("Vendedor:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Fecha:");

        jtFecha.setEditable(false);
        jtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Caja:");

        jlCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCaja.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jlCaja))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar productos SUELTOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel6.setText("Nombre:");

        jtNOMBRESUELTOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNOMBRESUELTOSKeyPressed(evt);
            }
        });

        jLabel16.setText("Monto ($) :");

        jtMONTOSUELTOS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtMONTOSUELTOS.setText("0");
        jtMONTOSUELTOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtMONTOSUELTOSKeyPressed(evt);
            }
        });

        jtCodigoSUELTOS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCodigoSUELTOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCodigoSUELTOSKeyPressed(evt);
            }
        });

        jLabel17.setText("Codigo:");

        jbLimpiarCampos2.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jbLimpiarCampos2.setForeground(new java.awt.Color(0, 0, 0));
        jbLimpiarCampos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/limpiarx18.png"))); // NOI18N
        jbLimpiarCampos2.setText(" Limpiar campos");
        jbLimpiarCampos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCampos2ActionPerformed(evt);
            }
        });

        jbBuscarProdSueltos.setForeground(new java.awt.Color(0, 0, 0));
        jbBuscarProdSueltos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscarx18.png"))); // NOI18N
        jbBuscarProdSueltos.setText(" Buscar producto");
        jbBuscarProdSueltos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarProdSueltosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbBuscarProdSueltos, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpiarCampos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jtCodigoSUELTOS, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 170, Short.MAX_VALUE))
                            .addComponent(jtNOMBRESUELTOS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtMONTOSUELTOS))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel16))
                    .addComponent(jLabel17)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtCodigoSUELTOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNOMBRESUELTOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtMONTOSUELTOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbLimpiarCampos2)
                    .addComponent(jbBuscarProdSueltos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbAgregarProducto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jbAgregarProducto.setForeground(new java.awt.Color(51, 153, 0));
        jbAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carro.png"))); // NOI18N
        jbAgregarProducto.setText("Agregar al pedido");
        jbAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarProductoActionPerformed(evt);
            }
        });

        jbEliminarProducto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jbEliminarProducto.setForeground(new java.awt.Color(204, 0, 0));
        jbEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        jbEliminarProducto.setText("Eliminar del pedido");
        jbEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarProductoActionPerformed(evt);
            }
        });

        jbCancelarCarro.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jbCancelarCarro.setForeground(new java.awt.Color(0, 0, 0));
        jbCancelarCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelarCarro.png"))); // NOI18N
        jbCancelarCarro.setText("Cancelar carro");
        jbCancelarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarCarroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCancelarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
                        .addComponent(jbEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jbCancelarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTablePedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablePedido);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Forma de pago :");

        jcFormasDePago.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jcFormasDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcFormasDePagoActionPerformed(evt);
            }
        });

        jbPagar.setBackground(new java.awt.Color(0, 153, 0));
        jbPagar.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jbPagar.setForeground(new java.awt.Color(0, 0, 0));
        jbPagar.setText("$$$$$$$ PAGAR $$$$$$$");
        jbPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagarActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setForeground(new java.awt.Color(0, 0, 0));

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TOTAL ($) :");

        jlTotalPagar.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jlTotalPagar.setForeground(new java.awt.Color(0, 255, 0));
        jlTotalPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTotalPagar.setText("-");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Precio Neto ($):");

        jlPrecioNeto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlPrecioNeto.setForeground(new java.awt.Color(255, 255, 255));
        jlPrecioNeto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecioNeto.setText("-");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("I.V.A (%) :");

        jcIVA.setBackground(new java.awt.Color(153, 153, 153));
        jcIVA.setForeground(new java.awt.Color(0, 0, 0));
        jcIVA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin I.V.A. (0%)", "I.V.A. general (27%)", "I.V.A. reducido I (21%)", "I.V.A. reducido II (10,5%)", "I.V.A. superreducido (2,5%)" }));
        jcIVA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcIVAItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Monto I.V.A. ($) :");

        jlMontoIVA.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlMontoIVA.setForeground(new java.awt.Color(255, 255, 255));
        jlMontoIVA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMontoIVA.setText("-");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Descuento (%) :");

        jtDescuento.setBackground(new java.awt.Color(153, 153, 153));
        jtDescuento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtDescuento.setForeground(new java.awt.Color(0, 0, 0));
        jtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtDescuento.setText("0");

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Aplicar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlPrecioNeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcIVA, javax.swing.GroupLayout.Alignment.TRAILING, 0, 193, Short.MAX_VALUE)
                    .addComponent(jlMontoIVA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jtDescuento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jlTotalPagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jlPrecioNeto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jlMontoIVA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jlTotalPagar))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jlCargar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cargar.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jbPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcFormasDePago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jcFormasDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbPagar)
                    .addComponent(jlCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar productos por CODIGO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel13.setText("Codigo:");

        jtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCodigoKeyPressed(evt);
            }
        });

        jLabel14.setText("Nombre:");

        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNombreKeyPressed(evt);
            }
        });

        jLabel15.setText("Cantidad:");

        jtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCantidad.setText("1");
        jtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCantidadActionPerformed(evt);
            }
        });
        jtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCantidadKeyPressed(evt);
            }
        });

        jbLimpiarCampos.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jbLimpiarCampos.setForeground(new java.awt.Color(0, 0, 0));
        jbLimpiarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/limpiarx18.png"))); // NOI18N
        jbLimpiarCampos.setText(" Limpiar campos");
        jbLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCamposActionPerformed(evt);
            }
        });

        jbBuscarProd.setForeground(new java.awt.Color(0, 0, 0));
        jbBuscarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscarx18.png"))); // NOI18N
        jbBuscarProd.setText(" Buscar producto");
        jbBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jbBuscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbLimpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiarCampos)
                    .addComponent(jbBuscarProd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagarActionPerformed

        if (caja.isEstado() == false) {
            JOptionPane.showMessageDialog(null, "Antes de confirmar una venta debe realizar la apertura de caja");
        } else {

            if (jcUsuarios.getSelectedIndex() == -1 || jcFormasDePago.getSelectedIndex() == -1) {

                JOptionPane.showMessageDialog(null, "Asegurese de llenar todos los campos correctamente");

            } else {

                Thread importThread = new Thread(() -> {
                    try {
                        SwingUtilities.invokeLater(() -> jlCargar.setVisible(true));

                        Session session = HibernateConfig.get().openSession();

                        Venta_data vd = new Venta_data(session);
                        Producto_data pd = new Producto_data(session);
                        DetalleVenta_data dvd = new DetalleVenta_data(session);

                        //CREO LA VENTA
                        Usuario user = (Usuario) jcUsuarios.getSelectedItem();
                        Date fecha = new Date();
                        Double precioTotal = Double.parseDouble(jlTotalPagar.getText());
                        FormaDePago fdp = (FormaDePago) jcFormasDePago.getSelectedItem();
                        List<DetalleVenta> detallesVenta = new ArrayList<>();
                        cliente = (Cliente) jcClientes.getSelectedItem();

                        venta = new Venta(user, fecha, precioTotal, cliente, detallesVenta, fdp, caja);

                        //AGREGO VENTA A LA BD
                        vd.agregar(venta);

                        int filas = modelo.getRowCount();
                        int idProducto = 0;
                        int cantidad = 0;
                        double precioUnitario = 0.0;
                        double precio = 0.0;
                        Producto p = null;
                        DetalleVenta dv = null;

                        for (int i = 0; i <= filas - 1; i++) {
                            idProducto = (int) modelo.getValueAt(i, 0);
                            cantidad = (int) modelo.getValueAt(i, 5);
                            precioUnitario = (Double) modelo.getValueAt(i, 4);
                            precio = precioUnitario * cantidad;

                            //ENCONTRAR PRODUCTO EN BD
                            p = pd.encontrarPorID(idProducto);

                            //CREAR UN DETALLE DE VENTA
                            dv = new DetalleVenta(p, cantidad, venta, precio);

                            //AGREGAR A LA LISTA DE DETALLES DE VENTA PARA AGREGAR A LA VENTA
                            detallesVenta.add(dv);
                            dvd.agregar(dv);

                            //ACTUALIZAR STOCK
                            p.setStock(p.getStock() - cantidad);

                        }

                        venta.setDetallesVenta(detallesVenta);

                        vd.actualizar(venta);

                        cliente = (Cliente) jcClientes.getSelectedItem();

                        SwingUtilities.invokeLater(() -> jlCargar.setVisible(false));

                        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea generar el ticket?", "Generar ticket", JOptionPane.YES_NO_OPTION);

                        if (respuesta == JOptionPane.YES_OPTION) {
                            BoletaPDF obj;
                            try {
                                obj = new BoletaPDF(jcUsuarios.getSelectedItem().toString(), jcClientes.getSelectedItem().toString(), jtFecha.getText(), jlCaja.getText(), detallesVenta, jlPrecioNeto.getText(), jcIVA.getSelectedItem().toString(), jlTotalPagar.getText(), jtDescuento.getText(), jcFormasDePago.getSelectedItem().toString());
                                obj.crearPlantilla();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
                            }

                        }

                        Pago pago = new Pago();
                        pago.setVisible(true);
                        limpiarCamposNumericosYTabla();
                        session.close();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
                    }
                });

                importThread.start();
            }

        }

    }//GEN-LAST:event_jbPagarActionPerformed

    private void jbAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProductoActionPerformed

        try {

            int cant = Integer.parseInt(jtCantidad.getText());
            Double montoSUELTOS = Double.parseDouble(jtMONTOSUELTOS.getText());
            Double iva = 0.0;

            if (jcIVA.getSelectedItem().equals("Sin I.V.A. (0%)")) {
                iva = 0.0;
            } else if (jcIVA.getSelectedItem().equals("I.V.A. general (27%)")) {
                iva = ivaGeneral;
            } else if (jcIVA.getSelectedItem().equals("I.V.A. reducido I (21%)")) {
                iva = ivaReducido1;
            } else if (jcIVA.getSelectedItem().equals("I.V.A. reducido II (10,5%)")) {
                iva = ivaReducido2;
            } else if (jcIVA.getSelectedItem().equals("I.V.A. superreducido (2,5%)")) {
                iva = ivaSuperreducido;
            }

            if (verificarProducto() == null) {
                JOptionPane.showMessageDialog(null, "No se encontro el producto en la base de datos");
            } else {
                // AGREGAR PRODUCTO A LA LISTA
                Producto p = verificarProducto();

                if (p.getDisponibilidad().equals("NO DISPONIBLE")) {

                    JOptionPane.showMessageDialog(null, "El producto no se encuentra disponible");

                } else if (p.getDisponibilidad().equals("SIN STOCK")) {

                    JOptionPane.showMessageDialog(null, "¡ATENCION! Verificar stock del producto");

                    // Decidir si agregar montoSUELTOS o la cantidad
                    Double montoOPrecio;
                    if (!jtCodigoSUELTOS.getText().isEmpty() && !jtNOMBRESUELTOS.getText().isEmpty() && montoSUELTOS > 0) {
                        montoOPrecio = montoSUELTOS;
                    } else {
                        montoOPrecio = p.getPrecioVentaUnitario();
                    }

                    modelo.addRow(new Object[]{
                        p.getIdProducto(),
                        p.getCodigo(),
                        p.getCategoria().getNombre(),
                        p.getNombre(),
                        montoOPrecio,
                        cant,});

                    precioNeto = precioNeto + (montoOPrecio * cant);
                    montoIva = montoIva + ((iva * montoOPrecio) * cant);
                    montoTotal = (precioNeto + montoIva);

                    DecimalFormat formato = new DecimalFormat("#.##");

                    jlMontoIVA.setText(formato.format(montoIva));
                    jlPrecioNeto.setText(formato.format(precioNeto));
                    jlTotalPagar.setText(Math.round(montoTotal * 100.0) / 100.0 + "");

                    limpiarCampos();
                } else if (p.getDisponibilidad().equals("DISPONIBLE")) {

                    Double montoOPrecio;
                    if (!jtCodigoSUELTOS.getText().isEmpty() && !jtNOMBRESUELTOS.getText().isEmpty() && montoSUELTOS > 0) {
                        montoOPrecio = montoSUELTOS;
                    } else {
                        montoOPrecio = p.getPrecioVentaUnitario();
                    }

                    modelo.addRow(new Object[]{
                        p.getIdProducto(),
                        p.getCodigo(),
                        p.getCategoria().getNombre(),
                        p.getNombre(),
                        montoOPrecio,
                        cant,});

                    precioNeto = precioNeto + (montoOPrecio * cant);
                    montoIva = montoIva + ((iva * montoOPrecio) * cant);
                    montoTotal = (precioNeto + montoIva);

                    DecimalFormat formato = new DecimalFormat("#.##");

                    jlMontoIVA.setText(formato.format(montoIva));
                    System.out.println("IVA " + montoIva);
                    jlPrecioNeto.setText(formato.format(precioNeto));
                    System.out.println("NETO " + precioNeto);
                    jlTotalPagar.setText(Math.round(montoTotal * 100.0) / 100.0 + "");
                    System.out.println("TOTAL " + montoTotal);

                    limpiarCampos();
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbAgregarProductoActionPerformed

    private void jbEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarProductoActionPerformed

        try {
            int filaSeleccionada = jTablePedido.getSelectedRow();
            Double iva = 0.0;

            if (jcIVA.getSelectedItem().equals("Sin I.V.A. (0%)")) {
                iva = 0.0;
            } else if (jcIVA.getSelectedItem().equals("I.V.A. general (27%)")) {
                iva = ivaGeneral;
            } else if (jcIVA.getSelectedItem().equals("I.V.A. reducido I (21%)")) {
                iva = ivaReducido1;
            } else if (jcIVA.getSelectedItem().equals("I.V.A. reducido II (10,5%)")) {
                iva = ivaReducido2;
            } else if (jcIVA.getSelectedItem().equals("I.V.A. superreducido (2,5%)")) {
                iva = ivaSuperreducido;
            }

            if (filaSeleccionada != -1) {
                Double precioVenta = (Double) modelo.getValueAt(filaSeleccionada, 4);
                int cantidad = (int) modelo.getValueAt(filaSeleccionada, 5);

                precioNeto = precioNeto - (precioVenta * cantidad);
                montoIva = montoIva - ((iva * precioVenta) * cantidad);
                montoTotal = (precioNeto + montoIva);

                // Actualizar las etiquetas
                DecimalFormat formato = new DecimalFormat("#.##");
                jlMontoIVA.setText(formato.format(montoIva));
                jlPrecioNeto.setText(formato.format(precioNeto));
                jlTotalPagar.setText(Math.round(montoTotal * 100.0) / 100.0 + "");

                // Eliminar la fila del modelo
                modelo.removeRow(filaSeleccionada);

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbEliminarProductoActionPerformed

    private void jbCancelarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarCarroActionPerformed
        limpiarCamposNumericosYTabla();
    }//GEN-LAST:event_jbCancelarCarroActionPerformed

    private void jtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodigoKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtCodigo.setEditable(true);
        } else {
            jtCodigo.setEditable(false);
        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (enterPresionado == true) {
                jbAgregarProductoActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Enter"));
                enterPresionado = false;  // Restablecer el estado después de ejecutar la acción
                jtCodigo.requestFocus();
            } else {
                procesarCodigo();
                enterPresionado = true;
            }
        }
    }//GEN-LAST:event_jtCodigoKeyPressed

    private void jtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCantidadKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtCantidad.setEditable(true);
        } else {
            jtCantidad.setEditable(false);
        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbAgregarProductoActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Enter"));
            enterPresionado = false;
            enterPresionadoNombre = false;
            jtCodigo.requestFocus();
        }
    }//GEN-LAST:event_jtCantidadKeyPressed

    private void jtCodigoSUELTOSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodigoSUELTOSKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtCodigoSUELTOS.setEditable(true);
        } else {
            jtCodigoSUELTOS.setEditable(false);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            procesarCodigo();
        }
    }//GEN-LAST:event_jtCodigoSUELTOSKeyPressed

    private void jcFormasDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcFormasDePagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcFormasDePagoActionPerformed

    private void jtMONTOSUELTOSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMONTOSUELTOSKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtMONTOSUELTOS.setEditable(true);
        } else {
            jtMONTOSUELTOS.setEditable(false);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbAgregarProductoActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Enter"));
            jtCodigoSUELTOS.requestFocus();
        }
    }//GEN-LAST:event_jtMONTOSUELTOSKeyPressed

    private void jtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (enterPresionadoNombre) {
                jbAgregarProductoActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Enter"));
                enterPresionadoNombre = false; // Reinicia la bandera
                jtCodigo.requestFocus();
            } else {
                jtNombre.requestFocus();
                procesarCodigoNombre1();
                enterPresionadoNombre = true; // Establece la bandera para la prÃ³xima vez
            }
        }
    }//GEN-LAST:event_jtNombreKeyPressed

    private void jtNOMBRESUELTOSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNOMBRESUELTOSKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtNOMBRESUELTOS.requestFocus();
            procesarCodigoNombre2();
        }
    }//GEN-LAST:event_jtNOMBRESUELTOSKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double desc = (Double.parseDouble(jtDescuento.getText())) / 100;
        montoTotal = montoTotal * (1 - desc);
        jlTotalPagar.setText(Math.round(montoTotal * 100.0) / 100.0 + "");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCamposActionPerformed
        jtCodigo.setText("");
        jtNombre.setText("");
        jtCantidad.setText("1");
        jtCodigo.requestFocus();
        enterPresionado = false;
        enterPresionadoNombre = false;
    }//GEN-LAST:event_jbLimpiarCamposActionPerformed

    private void jbLimpiarCampos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCampos2ActionPerformed
        jtCodigoSUELTOS.setText("");
        jtNOMBRESUELTOS.setText("");
        jtMONTOSUELTOS.setText("0");
        jtCodigoSUELTOS.requestFocus();
        enterPresionado = false;
        enterPresionadoNombre = false;
    }//GEN-LAST:event_jbLimpiarCampos2ActionPerformed

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCantidadActionPerformed

    private void jcIVAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcIVAItemStateChanged

        Double iva = 0.0;
        montoIva = 0.0;

        if (jcIVA.getSelectedItem().equals("Sin I.V.A. (0%)")) {
            iva = 0.0;
            montoIva = montoIva + (iva * precioNeto);
            montoTotal = (precioNeto + montoIva);

            DecimalFormat formato = new DecimalFormat("#.##");

            jlMontoIVA.setText(formato.format(montoIva));
            jlPrecioNeto.setText(formato.format(precioNeto));
            jlTotalPagar.setText(Math.round(montoTotal * 100.0) / 100.0 + "");

        } else if (jcIVA.getSelectedItem().equals("I.V.A. general (27%)")) {

            iva = ivaGeneral;

            montoIva = montoIva + (iva * precioNeto);
            montoTotal = (precioNeto + montoIva);
            montoTotal = (precioNeto + montoIva);

            DecimalFormat formato = new DecimalFormat("#.##");

            jlMontoIVA.setText(formato.format(montoIva));
            jlPrecioNeto.setText(formato.format(precioNeto));
            jlTotalPagar.setText(Math.round(montoTotal * 100.0) / 100.0 + "");
        } else if (jcIVA.getSelectedItem().equals("I.V.A. reducido I (21%)")) {

            iva = ivaReducido1;

            montoIva = montoIva + (iva * precioNeto);
            montoTotal = (precioNeto + montoIva);
            montoTotal = (precioNeto + montoIva);

            DecimalFormat formato = new DecimalFormat("#.##");

            jlMontoIVA.setText(formato.format(montoIva));
            jlPrecioNeto.setText(formato.format(precioNeto));
            jlTotalPagar.setText(Math.round(montoTotal * 100.0) / 100.0 + "");

        } else if (jcIVA.getSelectedItem().equals("I.V.A. reducido II (10,5%)")) {

            iva = ivaReducido2;

            montoIva = montoIva + (iva * precioNeto);
            montoTotal = (precioNeto + montoIva);
            montoTotal = (precioNeto + montoIva);

            DecimalFormat formato = new DecimalFormat("#.##");

            jlMontoIVA.setText(formato.format(montoIva));
            jlPrecioNeto.setText(formato.format(precioNeto));
            jlTotalPagar.setText(Math.round(montoTotal * 100.0) / 100.0 + "");

        } else if (jcIVA.getSelectedItem().equals("I.V.A. superreducido (2,5%)")) {

            iva = ivaSuperreducido;

            montoIva = montoIva + (iva * precioNeto);
            montoTotal = (precioNeto + montoIva);
            montoTotal = (precioNeto + montoIva);

            DecimalFormat formato = new DecimalFormat("#.##");

            jlMontoIVA.setText(formato.format(montoIva));
            jlPrecioNeto.setText(formato.format(precioNeto));
            jlTotalPagar.setText(Math.round(montoTotal * 100.0) / 100.0 + "");
        }

    }//GEN-LAST:event_jcIVAItemStateChanged

    private void jbBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarProdActionPerformed

        BusquedaProdVentas b = new BusquedaProdVentas();
        b.setVisible(true);
        Principal.escritorio.add(b);
        Principal.escritorio.moveToFront(b);
        b.setLocation((Principal.escritorio.getWidth() - b.getWidth()) / 2, (Principal.escritorio.getHeight() - b.getHeight()) / 2);

    }//GEN-LAST:event_jbBuscarProdActionPerformed

    private void jbBuscarProdSueltosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarProdSueltosActionPerformed
        BusquedaProdSueltosVentas bs = new BusquedaProdSueltosVentas();
        bs.setVisible(true);
        Principal.escritorio.add(bs);
        Principal.escritorio.moveToFront(bs);
        bs.setLocation((Principal.escritorio.getWidth() - bs.getWidth()) / 2, (Principal.escritorio.getHeight() - bs.getHeight()) / 2);

    }//GEN-LAST:event_jbBuscarProdSueltosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePedido;
    private javax.swing.JButton jbAgregarProducto;
    private javax.swing.JButton jbBuscarProd;
    private javax.swing.JButton jbBuscarProdSueltos;
    private javax.swing.JButton jbCancelarCarro;
    private javax.swing.JButton jbEliminarProducto;
    private javax.swing.JButton jbLimpiarCampos;
    private javax.swing.JButton jbLimpiarCampos2;
    private javax.swing.JButton jbPagar;
    private javax.swing.JComboBox<Cliente> jcClientes;
    private javax.swing.JComboBox<FormaDePago> jcFormasDePago;
    private javax.swing.JComboBox<String> jcIVA;
    private javax.swing.JComboBox<Usuario> jcUsuarios;
    private javax.swing.JLabel jlCaja;
    private javax.swing.JLabel jlCargar;
    private javax.swing.JLabel jlMontoIVA;
    private javax.swing.JLabel jlPrecioNeto;
    private javax.swing.JLabel jlTotalPagar;
    public static javax.swing.JTextField jtCantidad;
    public static javax.swing.JTextField jtCodigo;
    public static javax.swing.JTextField jtCodigoSUELTOS;
    private javax.swing.JTextField jtDescuento;
    private javax.swing.JTextField jtFecha;
    public static javax.swing.JTextField jtMONTOSUELTOS;
    public static javax.swing.JTextField jtNOMBRESUELTOS;
    public static javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables

    private void limpiarCamposNumericosYTabla() {
        borrarFilas();
        montoTotal = 0.0;
        precioNeto = 0.0;
        montoIva = 0.0;
        jcFormasDePago.setSelectedIndex(-1);
        jlPrecioNeto.setText("-");
        jlMontoIVA.setText("-");
        jlTotalPagar.setText("-");
        jtDescuento.setText("0");
        jcClientes.setSelectedIndex(0);
    }

    public void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    public static void mostrarVuelto(String mensaje) {
        JLabel label = new JLabel(mensaje);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        JOptionPane.showMessageDialog(null, label);
    }

    private void llenarComboUsers() {

        try {
            jcUsuarios.removeAllItems();

            Session session = HibernateConfig.get().openSession();
            Usuario_data userd = new Usuario_data(session);
            List<Usuario> users = userd.listarTodo();

            Set<String> usersAgregados = new HashSet<>();

            for (Usuario u : users) {
                String nombreUser = u.getNombre();
                if (!usersAgregados.contains(nombreUser)) {
                    jcUsuarios.addItem(u);
                    usersAgregados.add(nombreUser);
                }
            }

            session.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    private void llenarComboClientes() {

        try {
            jcClientes.removeAllItems();

            Session session = HibernateConfig.get().openSession();
            Cliente_data cd = new Cliente_data(session);
            List<Cliente> clientes = cd.listarTodo();

            for (Cliente c : clientes) {

                jcClientes.addItem(c);

            }

            session.close();

            jcClientes.setSelectedIndex(0);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    private void setearUser(Usuario usuarioBuscado) {
        try {
            for (int i = 0; i <= jcUsuarios.getItemCount(); i++) {
                Usuario usuario = (Usuario) jcUsuarios.getItemAt(i);

                if (usuario.getNombre().equals(usuarioBuscado.getNombre())) {

                    jcUsuarios.setSelectedItem(usuario);
                    break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    private Producto verificarProducto() {
        try {

            for (Producto p : productosBuscados) {
                if ((jtCodigo.getText().equals(p.getCodigo()) && jtNombre.getText().equals(p.getNombre())
                        || (jtNOMBRESUELTOS.getText().equals(p.getNombre()) && jtCodigoSUELTOS.getText().equals(p.getCodigo())))) {
                    return p;
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
        return null;

    }

    private void procesarCodigo() {
        try {

            for (Producto p : productosBuscados) {
                if (jtCodigo.getText().equals(p.getCodigo())) {
                    jtCodigo.setText(p.getCodigo());
                    jtNombre.setText(p.getNombre());
                    break;
                } else if (jtCodigoSUELTOS.getText().equals(p.getCodigo())) {
                    jtNOMBRESUELTOS.setText(p.getNombre());
                    break;
                }

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    private void procesarCodigoNombre1() {
        try {
            String nombreIngresado1 = jtNombre.getText().toUpperCase();

            for (Producto p : productosBuscados) {
                String nombreProducto = p.getNombre().toUpperCase();

                if (nombreProducto.startsWith(nombreIngresado1)) {
                    jtNombre.setText(p.getNombre());
                    jtCodigo.setText(p.getCodigo());
                    break;
                }

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    private void procesarCodigoNombre2() {
        try {
            String nombreIngresado1 = jtNOMBRESUELTOS.getText().toUpperCase();

            for (Producto p : productosBuscados) {
                String nombreProducto = p.getNombre().toUpperCase();

                if (nombreProducto.startsWith(nombreIngresado1)) {
                    jtNOMBRESUELTOS.setText(p.getNombre());
                    jtCodigoSUELTOS.setText(p.getCodigo());
                    break;
                }

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        jtCodigo.setText("");
        jtNOMBRESUELTOS.setText("");
        jtCantidad.setText("1");
        jtMONTOSUELTOS.setText("0");
        jtCodigoSUELTOS.setText("");
        jtNombre.setText("");
    }

    public void armarCabeceraTabla() {
        modelo.setColumnCount(0);

        modelo.addColumn("ID");
        modelo.addColumn("Codigo");
        modelo.addColumn("Categoria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio ($)");
        modelo.addColumn("Cantidad");

        jTablePedido.setModel(modelo);

        TableColumn column0 = jTablePedido.getColumnModel().getColumn(0);

        column0.setPreferredWidth(20);

        TableColumn column5 = jTablePedido.getColumnModel().getColumn(5);

        column5.setPreferredWidth(20);
    }

    private void listarProductos() {
        try {
            Session session = HibernateConfig.get().openSession();

            Producto_data pd = new Producto_data(session);

            productosBuscados = pd.listarTodo();

            session.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

    }

    public void cargarFormasDePago() {
        try {
            jcFormasDePago.removeAllItems();

            Session session = HibernateConfig.get().openSession();
            FormaDePago_data fdpd = new FormaDePago_data(session);
            List<FormaDePago> formasDePago = fdpd.listarTodo();

            Set<String> formasDePagoAgregadas = new HashSet<>();

            for (FormaDePago fp : formasDePago) {
                String formaDePago = fp.getNombreFormaDePago();
                if (!formasDePagoAgregadas.contains(formaDePago)) {
                    jcFormasDePago.addItem(fp);
                    formasDePagoAgregadas.add(formaDePago);
                }
            }

            jcFormasDePago.setSelectedIndex(-1);

            session.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    public String setFecha() {

        Date fechaYHoraActual = new Date();

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String fechaYHoraFormateada = formato.format(fechaYHoraActual);

        return fechaYHoraFormateada;
    }

}

package frames;

import config.HibernateConfig;
import data.*;
import entidades.*;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class Ventas extends javax.swing.JInternalFrame {

    Double precioNeto = 0.0;
    Double montoIva = 0.0;
    Double montoTotal = 0.0;
    public static Venta venta;

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    public Ventas() {
        initComponents();
        llenarComboUsers();
        jtFecha.setText(convertirFecha(LocalDate.now()));
        armarCabeceraTabla();
        cargarFormasDePago();
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
        jPanel3 = new javax.swing.JPanel();
        jbEscanear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtCantidad = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jbAgregarProducto = new javax.swing.JButton();
        jbEliminarProducto = new javax.swing.JButton();
        jbCancelarCarro = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePedido = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jlPrecioNeto = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtIVA = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jcFormasDePago = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jlTotalPagar = new javax.swing.JLabel();
        jlMontoIVA = new javax.swing.JLabel();
        jbPagar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

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

        jcClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONSUMIDOR FINAL" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jcUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
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
                    .addComponent(jcClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jbEscanear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scanner.png"))); // NOI18N
        jbEscanear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEscanearActionPerformed(evt);
            }
        });

        jLabel5.setText("Codigo:");

        jtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCodigoKeyPressed(evt);
            }
        });

        jLabel6.setText("Nombre:");

        jLabel7.setText("Cantidad:");

        jtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCantidad.setText("1");
        jtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCantidadKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbEscanear, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(164, 164, 164)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtNombre)
                        .addGap(18, 18, 18)
                        .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbEscanear, javax.swing.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addGap(81, 81, 81)
                .addComponent(jbAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbEliminarProducto)
                .addGap(18, 18, 18)
                .addComponent(jbCancelarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelarCarro)
                    .addComponent(jbAgregarProducto)
                    .addComponent(jbEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

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
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pago", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Precio Neto :");

        jlPrecioNeto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecioNeto.setText("-");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("I.V.A (%) :");

        jtIVA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtIVA.setText("0");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Forma de pago :");

        jcFormasDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcFormasDePagoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total a pagar :");

        jlTotalPagar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlTotalPagar.setForeground(new java.awt.Color(153, 0, 153));
        jlTotalPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTotalPagar.setText("-");

        jlMontoIVA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMontoIVA.setText("-");

        jbPagar.setBackground(new java.awt.Color(0, 153, 0));
        jbPagar.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jbPagar.setForeground(new java.awt.Color(0, 0, 0));
        jbPagar.setText("$$$$$$$ PAGAR $$$$$$$");
        jbPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagarActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Monto I.V.A. ($) :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtIVA, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlMontoIVA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlTotalPagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcFormasDePago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlPrecioNeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jlPrecioNeto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlMontoIVA)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jlTotalPagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jcFormasDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPagar)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcFormasDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcFormasDePagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcFormasDePagoActionPerformed

    private void jbPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagarActionPerformed
        Session session = HibernateConfig.get().openSession();

        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea confirmar la operacion ?", "Confirmación de venta", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Operacion cancelada");
        } else {

            if (jcUsuarios.getSelectedItem() == null || jcFormasDePago.getSelectedItem() == null) {

                JOptionPane.showMessageDialog(null, "Asegurese de llenar todos los campos correctamente");

            } else {

                try {

                    Venta_data vd = new Venta_data(session);
                    Producto_data pd = new Producto_data(session);
                    DetalleVenta_data dvd = new DetalleVenta_data(session);

                    //CREO LA VENTA
                    String cliente = (String) jcClientes.getSelectedItem();
                    Usuario user = (Usuario) jcUsuarios.getSelectedItem();
                    SimpleDateFormat formatoFechaEntrada = new SimpleDateFormat("dd-MM-yyyy");
                    Date fecha = formatoFechaEntrada.parse(jtFecha.getText());
                    Double precioTotal = Double.parseDouble(jlTotalPagar.getText());
                    FormaDePago fdp = (FormaDePago) jcFormasDePago.getSelectedItem();
                    List<DetalleVenta> detallesVenta = new ArrayList<>();

                    venta = new Venta(user, fecha, precioTotal, cliente, detallesVenta, fdp);

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

                    Pago pago = new Pago();
                    pago.setVisible(true);
//                    

//                    //SETEAR CAMPOS DE PAGO Y VUELTO
//                    Double pagaCon = Double.parseDouble(jtPagaCon.getText());
//
//                    Double vuelto = pagaCon - montoTotal;
//
//                    DecimalFormat formato = new DecimalFormat("#.##");
//
//                    mostrarVuelto("El vuelto es = $" + formato.format(vuelto));
                    limpiarCamposNumericosYTabla();

                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Error al castear clases");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());

                }
            }
        }

        session.close();

    }//GEN-LAST:event_jbPagarActionPerformed

    private void jbEscanearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEscanearActionPerformed
        jtCodigo.setText("");
        JOptionPane.showMessageDialog(null, "Presione ACEPTAR y escanee el producto");
        jtCodigo.requestFocus();
        limpiarCampos();
    }//GEN-LAST:event_jbEscanearActionPerformed

    private void jtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodigoKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtCodigo.setEditable(true);
        } else {
            jtCodigo.setEditable(false);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            procesarCodigo();
        }
    }//GEN-LAST:event_jtCodigoKeyPressed

    private void jbAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProductoActionPerformed

        Double IVA = (Double.parseDouble(jtIVA.getText())) / 100;
        int cant = Integer.parseInt(jtCantidad.getText());

        if (jtCodigo.getText().isEmpty() || jtNombre.getText().isEmpty() || (cant <= 0)) {
            JOptionPane.showMessageDialog(null, "Llene los campos correctamente");
        } else {
            if (verificarProducto() == null) {
                JOptionPane.showMessageDialog(null, "No se encontro el producto en la base de datos");
            } else {
                //AGREGAR PRODUCTO A LA LISTA
                Producto p = verificarProducto();

                modelo.addRow(new Object[]{
                    p.getIdProducto(),
                    p.getCodigo(),
                    p.getCategoria().getNombre(),
                    p.getNombre(),
                    p.getPrecioVentaUnitario(),
                    cant,});

                precioNeto = precioNeto + (p.getPrecioVentaUnitario() * cant);
                montoIva = montoIva + ((IVA * p.getPrecioVentaUnitario()) * cant);
                montoTotal = (precioNeto + montoIva);

                DecimalFormat formato = new DecimalFormat("#.##");

                jlMontoIVA.setText(formato.format(montoIva));
                jlPrecioNeto.setText(formato.format(precioNeto));
                jlTotalPagar.setText(Math.round(montoTotal * 100.0) / 100.0 + "");

                limpiarCampos();

            }
        }
    }//GEN-LAST:event_jbAgregarProductoActionPerformed

    private void jbEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarProductoActionPerformed
        int filaSeleccionada = jTablePedido.getSelectedRow();
        Double IVA = (Double.parseDouble(jtIVA.getText())) / 100;

        if (filaSeleccionada != -1) {
            Object idProducto = modelo.getValueAt(filaSeleccionada, 0);
            Object cantidad = modelo.getValueAt(filaSeleccionada, 5);

            Session session = HibernateConfig.get().openSession();
            Producto_data pd = new Producto_data(session);

            Producto p = pd.encontrarPorID((int) idProducto);

            // Calcular los montos a restar
            Double montoRestarNeto = p.getPrecioVentaUnitario() * (int) cantidad;
            Double montoRestarIva = (IVA * p.getPrecioVentaUnitario()) * (int) cantidad;
            Double montoRestarTotal = montoRestarNeto + montoRestarIva;

            // Actualizar los montos
            precioNeto -= montoRestarNeto;
            montoIva -= montoRestarIva;
            montoTotal -= montoRestarTotal;

            // Actualizar las etiquetas
            DecimalFormat formato = new DecimalFormat("#.##");
            jlMontoIVA.setText(formato.format(montoIva));
            jlPrecioNeto.setText(formato.format(precioNeto));
            jlTotalPagar.setText(Math.round(montoTotal * 100.0) / 100.0 + "");

            // Eliminar la fila del modelo
            modelo.removeRow(filaSeleccionada);

            session.close();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_jbEliminarProductoActionPerformed

    private void jbCancelarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarCarroActionPerformed
        limpiarCamposNumericosYTabla();
    }//GEN-LAST:event_jbCancelarCarroActionPerformed

    private void jtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCantidadKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtCantidad.setEditable(true);
        } else {
            jtCantidad.setEditable(false);
        }
    }//GEN-LAST:event_jtCantidadKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePedido;
    private javax.swing.JButton jbAgregarProducto;
    private javax.swing.JButton jbCancelarCarro;
    private javax.swing.JButton jbEliminarProducto;
    private javax.swing.JButton jbEscanear;
    private javax.swing.JButton jbPagar;
    private javax.swing.JComboBox<String> jcClientes;
    private javax.swing.JComboBox<FormaDePago> jcFormasDePago;
    private javax.swing.JComboBox<Usuario> jcUsuarios;
    private javax.swing.JLabel jlMontoIVA;
    private javax.swing.JLabel jlPrecioNeto;
    private javax.swing.JLabel jlTotalPagar;
    private javax.swing.JTextField jtCantidad;
    private javax.swing.JTextField jtCodigo;
    private javax.swing.JTextField jtFecha;
    private javax.swing.JTextField jtIVA;
    private javax.swing.JTextField jtNombre;
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

        jcUsuarios.setSelectedIndex(-1);

        session.close();
    }

    public String convertirFecha(LocalDate fechaActual) {
        // Crear un formateador para el formato dd-MM-yyyy
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Convertir LocalDate a String en el formato especificado
        String fechaFormateada = fechaActual.format(formateador);

        // Convertir LocalDate a Date
        Date fechaDate = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Configurar el texto del TextField
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechaDateFormateada = sdf.format(fechaDate);

        return fechaDateFormateada;
    }

    private void procesarCodigo() {
        if (jtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El codigo no existe");

        } else {

            Session session = HibernateConfig.get().openSession();
            Producto_data pd = new Producto_data(session);
            List<Producto> productos = pd.listarTodo();

            for (Producto p : productos) {
                if (jtCodigo.getText().equals(p.getCodigo())) {
                    jtNombre.setText(p.getNombre());
                    break;
                }
            }

            session.close();
        }
    }

    private void limpiarCampos() {
        jtCodigo.setText("");
        jtNombre.setText("");
        jtCantidad.setText("1");
    }

    public void armarCabeceraTabla() {
        modelo.setColumnCount(0);

        modelo.addColumn("ID");
        modelo.addColumn("Codigo");
        modelo.addColumn("Categoria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio venta unitario");
        modelo.addColumn("Cantidad");

        jTablePedido.setModel(modelo);
    }

    private List<Producto> listarProductos() {
        Session session = HibernateConfig.get().openSession();

        Producto_data pd = new Producto_data(session);

        List<Producto> productos = pd.listarTodo();

        session.close();

        return productos;
    }

    private Producto verificarProducto() {
        List<Producto> productos = listarProductos();

        for (Producto p : productos) {

            if (jtCodigo.getText().equals(p.getCodigo()) && jtNombre.getText().equals(p.getNombre())) {
                return p;

            }
        }

        return null;
    }

    public void cargarFormasDePago() {
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
    }

}

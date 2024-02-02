package frames;

import config.HibernateConfig;
import data.*;
import entidades.*;
import exportarExcel.ReporteCajaPDF;
import java.awt.Color;
import java.awt.event.KeyEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class CerrarCaja extends javax.swing.JInternalFrame {

    Caja caja = Principal.caja;
    Usuario usuario = Principal.user;
    Double montoTotalTeorico = 0.0;
    Cajas cajas;

    public CerrarCaja() {
        initComponents();
        if (caja.isEstado() == false) {
            limpiar();
        } else {
            setDatos();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlFechaApertura = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jlCaja = new javax.swing.JLabel();
        jlSucursal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlApertura = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jlIngresos = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jlEgresos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlVentas = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jlTotalTeorico = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jtTotalReal = new javax.swing.JTextField();
        jbCalcularDif = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jlDiferencia = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jbGuardar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jlFechaCierre = new javax.swing.JLabel();
        jbImprimir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jlDebito = new javax.swing.JLabel();
        jlCredito = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jlUala = new javax.swing.JLabel();
        jlMP = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jlEfectivo = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jlTrans = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jlCtaCte = new javax.swing.JLabel();

        setClosable(true);
        setTitle("CIERRE DE CAJA");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cierre diario de caja", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Apertura :");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Caja :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Usuario :");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sucursal :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Saldo apertura ($) :");

        jlFechaApertura.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlFechaApertura.setForeground(new java.awt.Color(0, 0, 0));
        jlFechaApertura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFechaApertura.setText("-");

        jlUsuario.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jlUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlUsuario.setText("-");

        jlCaja.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlCaja.setForeground(new java.awt.Color(0, 0, 0));
        jlCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCaja.setText("-");

        jlSucursal.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlSucursal.setForeground(new java.awt.Color(0, 0, 0));
        jlSucursal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSucursal.setText("-");

        jlApertura.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlApertura.setForeground(new java.awt.Color(0, 0, 0));
        jlApertura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlApertura.setText("0");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ingresos ($) :");

        jlIngresos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlIngresos.setForeground(new java.awt.Color(0, 204, 0));
        jlIngresos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIngresos.setText("0");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Egresos ($) :");

        jlEgresos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlEgresos.setForeground(new java.awt.Color(204, 0, 0));
        jlEgresos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEgresos.setText("0");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ventas ($) :");

        jlVentas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlVentas.setForeground(new java.awt.Color(0, 0, 0));
        jlVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlVentas.setText("0");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Total teorico ($) :");

        jlTotalTeorico.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlTotalTeorico.setForeground(new java.awt.Color(0, 0, 0));
        jlTotalTeorico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTotalTeorico.setText("0");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Total real ($) :");

        jtTotalReal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtTotalReal.setText("0");
        jtTotalReal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtTotalRealKeyPressed(evt);
            }
        });

        jbCalcularDif.setText("Calcular");
        jbCalcularDif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularDifActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Diferencia ($) :");

        jlDiferencia.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlDiferencia.setForeground(new java.awt.Color(0, 0, 0));
        jlDiferencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDiferencia.setText("0");

        jbGuardar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(0, 0, 0));
        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/savex25.png"))); // NOI18N
        jbGuardar.setText("Guardar y cerrar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Cierre :");

        jlFechaCierre.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlFechaCierre.setForeground(new java.awt.Color(0, 0, 0));
        jlFechaCierre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFechaCierre.setText("-");

        jbImprimir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jbImprimir.setForeground(new java.awt.Color(0, 0, 0));
        jbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimirx25.png"))); // NOI18N
        jbImprimir.setText("Imprimir reporte");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addComponent(jSeparator6)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jbImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlFechaApertura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlCaja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlSucursal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlApertura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlEgresos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlVentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlTotalTeorico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtTotalReal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbCalcularDif)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jlDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlFechaCierre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlFechaApertura))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jlFechaCierre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlCaja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlSucursal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jlApertura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jlIngresos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jlEgresos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jlVentas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlTotalTeorico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtTotalReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCalcularDif))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jlDiferencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbImprimir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumen diario formas de pago de las ventas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tarjetas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Debito :");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Credito :");

        jlDebito.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlDebito.setForeground(new java.awt.Color(0, 0, 0));
        jlDebito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDebito.setText("0");

        jlCredito.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlCredito.setForeground(new java.awt.Color(0, 0, 0));
        jlCredito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCredito.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jlDebito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(13, 13, 13)
                        .addComponent(jlCredito, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jlDebito))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jlCredito))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Medios electrónicos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Ualá :");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Mercado pago");

        jlUala.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlUala.setForeground(new java.awt.Color(0, 0, 0));
        jlUala.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlUala.setText("0");

        jlMP.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlMP.setForeground(new java.awt.Color(0, 0, 0));
        jlMP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMP.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlUala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlMP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jlUala))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jlMP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Efectivo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Efectivo :");

        jlEfectivo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlEfectivo.setForeground(new java.awt.Color(0, 0, 0));
        jlEfectivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEfectivo.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jlEfectivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bancos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Transferencia :");

        jlTrans.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlTrans.setForeground(new java.awt.Color(0, 0, 0));
        jlTrans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTrans.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jlTrans))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuenta corriente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Cta. Cte. :");

        jlCtaCte.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlCtaCte.setForeground(new java.awt.Color(0, 0, 0));
        jlCtaCte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCtaCte.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jlCtaCte, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jlCtaCte))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCalcularDifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularDifActionPerformed

        try {

            Double montoTotalReal = Double.parseDouble(jtTotalReal.getText());
            Double diferencia = montoTotalTeorico - montoTotalReal;

            if (diferencia <= 0) {
                jlDiferencia.setForeground(Color.GREEN);
                jlDiferencia.setText(((-1) * diferencia) + "");
            } else {
                jlDiferencia.setForeground(Color.RED);
                jlDiferencia.setText("-" + diferencia);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

    }//GEN-LAST:event_jbCalcularDifActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            if (jtTotalReal.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Asegurese de ingresar el total real y calcula la diferencia");
            } else {
                if (caja.isEstado() == true) {
                    Date fechaActual = new Date();
                    Double diferencia = Double.parseDouble(jlDiferencia.getText());
                    Double montoTotalReal = Double.parseDouble(jtTotalReal.getText());
                    String sucursal = jlSucursal.getText();

                    Session session = HibernateConfig.get().openSession();
                    MovimientosCaja_data mcd = new MovimientosCaja_data(session);
                    Caja_data cd = new Caja_data(session);

                    MovimientosCaja mc = new MovimientosCaja(fechaActual, montoTotalTeorico, montoTotalReal, diferencia, "CIERRE", caja, sucursal, usuario);
                    caja.setEstado(false);

                    mcd.agregar(mc);
                    cd.actualizar(caja);

                    montoTotalTeorico = 0.0;
                    Principal.setPaneCaja();
                    limpiar();
                    session.close();
                    JOptionPane.showMessageDialog(null, "La caja ha sido cerrada exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "La caja ya esta cerrada. Intente realizar la apertura");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        ReporteCajaPDF obj;
        try {
            obj = new ReporteCajaPDF(jlFechaApertura.getText(), jlFechaCierre.getText(), jlCaja.getText(),
                    jlUsuario.getText(), jlSucursal.getText(), jlApertura.getText(), jlIngresos.getText(),
                    jlEgresos.getText(), jlVentas.getText(), jlTotalTeorico.getText(), jtTotalReal.getText(),
                    jlDiferencia.getText(), jlEfectivo.getText(), jlDebito.getText(), jlCredito.getText(),
                    jlTrans.getText(), jlMP.getText(), jlUala.getText(), jlCtaCte.getText());
            obj.crearPlantilla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jtTotalRealKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTotalRealKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                || (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) || (evt.getKeyChar() == '.')) {
            jtTotalReal.setEditable(true);
        } else {
            jtTotalReal.setEditable(false);
        }
    }//GEN-LAST:event_jtTotalRealKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JButton jbCalcularDif;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JLabel jlApertura;
    private javax.swing.JLabel jlCaja;
    private javax.swing.JLabel jlCredito;
    private javax.swing.JLabel jlCtaCte;
    private javax.swing.JLabel jlDebito;
    private javax.swing.JLabel jlDiferencia;
    private javax.swing.JLabel jlEfectivo;
    private javax.swing.JLabel jlEgresos;
    private javax.swing.JLabel jlFechaApertura;
    private javax.swing.JLabel jlFechaCierre;
    private javax.swing.JLabel jlIngresos;
    private javax.swing.JLabel jlMP;
    private javax.swing.JLabel jlSucursal;
    private javax.swing.JLabel jlTotalTeorico;
    private javax.swing.JLabel jlTrans;
    private javax.swing.JLabel jlUala;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JLabel jlVentas;
    private javax.swing.JTextField jtTotalReal;
    // End of variables declaration//GEN-END:variables

    public void setDatos() {
        try {
            MovimientosCaja movCajaApert = obtenerUltimaApertura();
            Date fechaApertura = movCajaApert.getFecha();
            Date fechaActual = new Date();

            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            String fechaYHoraFormateada = formato.format(fechaApertura);

            jlFechaApertura.setText(fechaYHoraFormateada);
            jlFechaCierre.setText(setFecha());

            jlCaja.setText(caja.getNroCaja());
            jlUsuario.setText(usuario.getNombre());
            jlSucursal.setText("PRINCIPAL");
            Double montoApertura = 0.0;
            Double ingresos = 0.0;
            Double egresos = 0.0;
            Double montoVentas = 0.0;

            Session session = HibernateConfig.get().openSession();
            MovimientosCaja_data mcd = new MovimientosCaja_data(session);
            Venta_data vd = new Venta_data(session);
            FormasDePagoVentas_data fdpvd = new FormasDePagoVentas_data(session);

            List<MovimientosCaja> movimientos = mcd.listarTodo();
            List<Venta> ventas = vd.listarTodo();
            List<FormasDePagoVentas> fdpvs = fdpvd.listarTodo();
////////////////////////////////////////////////////////////////////////////////////////////////////////////
            for (MovimientosCaja mc : movimientos) {

                if ((mc.getFecha().equals(fechaApertura)
                        || mc.getFecha().after(fechaApertura))
                        && (mc.getFecha().equals(fechaActual)
                        || mc.getFecha().before(fechaActual))) {

                    if (mc.getOperacion().equals("APERTURA")) {
                        montoApertura += mc.getMonto();
                    } else if (mc.getOperacion().equals("INGRESO")) {
                        ingresos += mc.getMonto();
                    } else if (mc.getOperacion().equals("EGRESO")) {
                        egresos += mc.getMonto();
                    }

                }
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
            for (Venta v : ventas) {

                if ((v.getFecha().equals(fechaApertura)
                        || v.getFecha().after(fechaApertura))
                        && (v.getFecha().equals(fechaActual)
                        || v.getFecha().before(fechaActual))) {

                    montoVentas += v.getPrecioTotalVenta();

                }
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
            double efectivo = 0;
            double debito = 0;
            double credito = 0;
            double mp = 0;
            double uala = 0;
            double trans = 0;
            double cta = 0;

            for (FormasDePagoVentas f : fdpvs) {

                if ((f.getVenta().getFecha().equals(fechaApertura)
                        || f.getVenta().getFecha().after(fechaApertura))
                        && (f.getVenta().getFecha().equals(fechaActual)
                        || f.getVenta().getFecha().before(fechaActual))) {

                    if (f.getMontoFDP1() != null) {
                        if (f.getFpd1().getNombreFormaDePago().equals("Efectivo")) {
                            efectivo = efectivo + f.getMontoFDP1();
                        } else if (f.getFpd1().getNombreFormaDePago().equals("Debito")) {
                            debito = debito + f.getMontoFDP1();;
                        } else if (f.getFpd1().getNombreFormaDePago().equals("Credito")) {
                            credito = credito + f.getMontoFDP1();;
                        } else if (f.getFpd1().getNombreFormaDePago().equals("Mercado Pago")) {
                            mp = mp + f.getMontoFDP1();;
                        } else if (f.getFpd1().getNombreFormaDePago().equals("Uala")) {
                            uala = uala + f.getMontoFDP1();;
                        } else if (f.getFpd1().getNombreFormaDePago().equals("Transferencia")) {
                            trans = trans + f.getMontoFDP1();;
                        } else if (f.getFpd1().getNombreFormaDePago().equals("Cuenta corriente")) {
                            cta = cta + f.getMontoFDP1();;
                        }
                    }

                    if (f.getMontoFDP2() != null) {
                        if (f.getFpd2().getNombreFormaDePago().equals("Efectivo")) {
                            efectivo = efectivo + f.getMontoFDP2();
                        } else if (f.getFpd2().getNombreFormaDePago().equals("Debito")) {
                            debito = debito + f.getMontoFDP2();
                        } else if (f.getFpd2().getNombreFormaDePago().equals("Credito")) {
                            credito = credito + f.getMontoFDP2();
                        } else if (f.getFpd2().getNombreFormaDePago().equals("Mercado Pago")) {
                            mp = mp + f.getMontoFDP2();
                        } else if (f.getFpd2().getNombreFormaDePago().equals("Uala")) {
                            uala = uala + f.getMontoFDP2();
                        } else if (f.getFpd2().getNombreFormaDePago().equals("Transferencia")) {
                            trans = trans + f.getMontoFDP2();
                        } else if (f.getFpd2().getNombreFormaDePago().equals("Cuenta corriente")) {
                            cta = cta + f.getMontoFDP2();
                        }
                    }

                }

            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
            jlApertura.setText(Math.round(montoApertura * 100.0) / 100.0 + "");
            jlIngresos.setText(Math.round(ingresos * 100.0) / 100.0 + "");
            jlEgresos.setText(Math.round(egresos * 100.0) / 100.0 + "");
            jlVentas.setText(Math.round(montoVentas * 100.0) / 100.0 + "");
            jlDebito.setText(Math.round(debito * 100.0) / 100.0 + "");
            jlEfectivo.setText(Math.round(efectivo * 100.0) / 100.0 + "");
            jlTrans.setText(Math.round(trans * 100.0) / 100.0 + "");
            jlCtaCte.setText(Math.round(cta * 100.0) / 100.0 + "");
            jlCredito.setText(Math.round(credito * 100.0) / 100.0 + "");
            jlMP.setText(Math.round(mp * 100.0) / 100.0 + "");
            jlUala.setText(Math.round(uala * 100.0) / 100.0 + "");

            montoTotalTeorico = montoApertura + ingresos - egresos + montoVentas;
            jlTotalTeorico.setText(Math.round(montoTotalTeorico * 100.0) / 100.0 + "");

            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private MovimientosCaja obtenerUltimaApertura() {
        try {
            Session session = HibernateConfig.get().openSession();
            MovimientosCaja_data mcd = new MovimientosCaja_data(session);

            List<MovimientosCaja> movimientos = mcd.listarTodo();

            MovimientosCaja ultimaApertura = null;

            for (MovimientosCaja mc : movimientos) {

                if ("APERTURA".equals(mc.getOperacion())) {
                    if (ultimaApertura == null || mc.getFecha().after(ultimaApertura.getFecha())) {
                        ultimaApertura = mc;
                    }
                }
            }

            session.close();
            return ultimaApertura;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

        return null;
    }

    public void limpiar() {
        jlDebito.setText("0");
        jlTrans.setText("0");
        jlCtaCte.setText("0");
        jlEfectivo.setText("0");
        jlUala.setText("0");
        jlMP.setText("0");
        jlCredito.setText("0");
        jlFechaApertura.setText("-");
        jlFechaCierre.setText("-");
        jlUsuario.setText("-");
        jlCaja.setText("-");
        jlSucursal.setText("-");
        jlApertura.setText("0");
        jlIngresos.setText("0");
        jlEgresos.setText("0");
        jlTotalTeorico.setText("0");
        jtTotalReal.setText("0");
        jlDiferencia.setText("0");
    }

    public String setFecha() {
        Date fechaYHoraActual = new Date();

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String fechaYHoraFormateada = formato.format(fechaYHoraActual);

        return fechaYHoraFormateada;
    }

}

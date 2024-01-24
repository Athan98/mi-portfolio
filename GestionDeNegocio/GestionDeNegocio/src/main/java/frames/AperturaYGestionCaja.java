package frames;

import config.HibernateConfig;
import data.*;
import entidades.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class AperturaYGestionCaja extends javax.swing.JInternalFrame {

    Caja caja = Principal.caja;
    Usuario usuario = Principal.user;

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    public AperturaYGestionCaja() {
        initComponents();
        jlFecha.setText(setFecha());
        jlUsuario.setText(usuario.getNombre());
        jcSucursal.setSelectedIndex(-1);
        jcCaja.setSelectedIndex(-1);
        jcOperacion.setSelectedIndex(-1);
        armarTabla();
        actualizarTabla();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        jcCaja = new javax.swing.JComboBox<>();
        jlUsuario = new javax.swing.JLabel();
        jcSucursal = new javax.swing.JComboBox<>();
        jcOperacion = new javax.swing.JComboBox<>();
        jtMonto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtComentario = new javax.swing.JTextArea();
        jbAceptar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMov = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Caja", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Apertura :");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Caja :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Usuario :");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sucursal :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Operacion :");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Monto ($) :");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Comentario :");

        jlFecha.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFecha.setText("-");

        jcCaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0001" }));

        jlUsuario.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jlUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlUsuario.setText("-");

        jcSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRINCIPAL" }));

        jcOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "APERTURA", "INGRESO", "EGRESO" }));

        jtMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtMonto.setText("0");

        jtComentario.setColumns(20);
        jtComentario.setRows(5);
        jScrollPane1.setViewportView(jtComentario);

        jbAceptar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jbAceptar.setForeground(new java.awt.Color(0, 204, 0));
        jbAceptar.setText("ACEPTAR");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcOperacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtMonto)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addComponent(jcCaja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlFecha))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcCaja)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlUsuario))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Movimientos del dia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24), new java.awt.Color(0, 0, 0))); // NOI18N

        jTableMov.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableMov);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        try {
            if (jcCaja.getSelectedIndex() == -1 || jcSucursal.getSelectedIndex() == -1 || jcOperacion.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Asegurese de llenar los campos correctamente");
            } else {
                Session session = HibernateConfig.get().openSession();
                Caja_data cd = new Caja_data(session);
                MovimientosCaja_data mcd = new MovimientosCaja_data(session);
                if (caja.isEstado() == false && !jcOperacion.getSelectedItem().equals("APERTURA")) {
                    JOptionPane.showMessageDialog(null, "Primero debe realizar la apertura de caja");
                    return;
                }

                if (caja.isEstado() == false && jcOperacion.getSelectedItem().equals("APERTURA")) {
                    Date fecha = new Date();
                    Double monto = Double.parseDouble(jtMonto.getText());
                    String operacion = (String) jcOperacion.getSelectedItem();
                    String comentario = jtComentario.getText();
                    String sucursal = (String) jcSucursal.getSelectedItem();
                    caja.setEstado(true);

                    MovimientosCaja mc = new MovimientosCaja(fecha, monto, operacion, comentario, caja, sucursal, usuario);

                    mcd.agregar(mc);
                    cd.actualizar(caja);
                    JOptionPane.showMessageDialog(null, "La apertura de caja se realizo correctamente");
                    Principal.setPaneCaja();
                    actualizarTabla();
                    limpiarCampos();

                } else if (caja.isEstado() == true && jcOperacion.getSelectedItem().equals("INGRESO")) {

                    Date fecha = new Date();
                    Double monto = Double.parseDouble(jtMonto.getText());
                    String operacion = (String) jcOperacion.getSelectedItem();
                    String comentario = jtComentario.getText();
                    String sucursal = (String) jcSucursal.getSelectedItem();

                    MovimientosCaja mc = new MovimientosCaja(fecha, monto, operacion, comentario, caja, sucursal, usuario);

                    mcd.agregar(mc);
                    actualizarTabla();
                    Principal.setPaneCaja();
                    limpiarCampos();

                } else if (caja.isEstado() == true && jcOperacion.getSelectedItem().equals("EGRESO")) {

                    Date fecha = new Date();
                    Double monto = Double.parseDouble(jtMonto.getText());
                    String operacion = (String) jcOperacion.getSelectedItem();
                    String comentario = jtComentario.getText();
                    String sucursal = (String) jcSucursal.getSelectedItem();

                    MovimientosCaja mc = new MovimientosCaja(fecha, monto, operacion, comentario, caja, sucursal, usuario);

                    mcd.agregar(mc);
                    actualizarTabla();
                    Principal.setPaneCaja();
                    limpiarCampos();

                } else if (caja.isEstado() == true && jcOperacion.getSelectedItem().equals("APERTURA")) {

                    JOptionPane.showMessageDialog(null, "La caja ya esta abierta");

                }
                session.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbAceptarActionPerformed


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMov;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JComboBox<String> jcCaja;
    private javax.swing.JComboBox<String> jcOperacion;
    private javax.swing.JComboBox<String> jcSucursal;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTextArea jtComentario;
    private javax.swing.JTextField jtMonto;
    // End of variables declaration//GEN-END:variables

    private void armarTabla() {
        modelo.setColumnCount(0);

        modelo.addColumn("Fecha");
        modelo.addColumn("Caja");
        modelo.addColumn("Usuario");
        modelo.addColumn("Operacion");
        modelo.addColumn("Monto");
        modelo.addColumn("Comentario");

        jTableMov.setModel(modelo);
        jTableMov.setRowHeight(35);

    }

    private void actualizarTabla() {

        MovimientosCaja movcaja = obtenerUltimaApertura();

        modelo.setRowCount(0);

        Session session = HibernateConfig.get().openSession();
        MovimientosCaja_data mcd = new MovimientosCaja_data(session);

        List<MovimientosCaja> movimientos = mcd.listarTodo();

        for (MovimientosCaja mc : movimientos) {
            if ((mc.getFecha().equals(movcaja.getFecha()) || mc.getFecha().after(movcaja.getFecha()))) {
                modelo.addRow(new Object[]{
                    mc.getFecha(),
                    mc.getCaja().getNroCaja(),
                    mc.getUsuario().getNombre(),
                    mc.getOperacion(),
                    mc.getMonto(),
                    mc.getComentario()});
            }

        }

        session.close();
    }

    private void limpiarCampos() {
        jtMonto.setText("0");
        jcOperacion.setSelectedIndex(-1);
        jcCaja.setSelectedIndex(-1);
        jcSucursal.setSelectedIndex(-1);
        jtComentario.setText("");
    }

    private MovimientosCaja obtenerUltimaApertura() {
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
    }

    public String setFecha() {
        Date fechaYHoraActual = new Date();

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String fechaYHoraFormateada = formato.format(fechaYHoraActual);

        return fechaYHoraFormateada;
    }

}

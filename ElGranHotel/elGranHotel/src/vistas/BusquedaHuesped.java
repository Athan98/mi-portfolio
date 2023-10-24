/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladorExportar.Controlador;
import data.Conexion;
import data.Huesped_data;
import entidades.Huesped;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BusquedaHuesped extends javax.swing.JInternalFrame {

    public static DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    Conexion con = new Conexion("jdbc:mariadb://localhost:3306/elgranhotel", "root", "");
    Huesped_data hd = new Huesped_data(con);

    public BusquedaHuesped() {
        initComponents();
        borrarColumnas();
        armarCabeceraTabla();
        actualizarLista();
        jbGUARDAR.setEnabled(false);
        jbCambiarFoto.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jtBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableHuespedes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtDni = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtTelefono = new javax.swing.JTextField();
        jtDireccion = new javax.swing.JTextField();
        jtCorreo = new javax.swing.JTextField();
        paneFoto = new javax.swing.JPanel();
        jlFoto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jrEstado = new javax.swing.JRadioButton();
        jbGUARDAR = new javax.swing.JButton();
        jtDireccionFoto = new javax.swing.JTextField();
        jbCambiarFoto = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jbLlenarCampos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jScrollPane2.setViewportView(jTree1);

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingrese el dato:");

        jtableHuespedes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtableHuespedes);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("D.N.I.:");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apellido:");

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Telefono:");

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Direccion:");

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Correo:");

        jtDni.setEditable(false);
        jtDni.setColumns(20);

        jtApellido.setColumns(20);
        jtApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtApellidoMouseClicked(evt);
            }
        });
        jtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtApellidoKeyPressed(evt);
            }
        });

        jtNombre.setColumns(20);
        jtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtNombreMouseClicked(evt);
            }
        });
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNombreKeyPressed(evt);
            }
        });

        jtTelefono.setColumns(20);
        jtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTelefonoMouseClicked(evt);
            }
        });
        jtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtTelefonoKeyPressed(evt);
            }
        });

        jtDireccion.setColumns(20);

        jtCorreo.setColumns(20);

        paneFoto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlFoto.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jlFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFoto.setText("*Sin foto*");

        javax.swing.GroupLayout paneFotoLayout = new javax.swing.GroupLayout(paneFoto);
        paneFoto.setLayout(paneFotoLayout);
        paneFotoLayout.setHorizontalGroup(
            paneFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneFotoLayout.setVerticalGroup(
            paneFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Foto:");

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Estado:");

        jbGUARDAR.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jbGUARDAR.setText("GUARDAR");
        jbGUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGUARDARActionPerformed(evt);
            }
        });

        jtDireccionFoto.setEditable(false);
        jtDireccionFoto.setColumns(20);

        jbCambiarFoto.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jbCambiarFoto.setText("Cambiar");
        jbCambiarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCambiarFotoActionPerformed(evt);
            }
        });

        jbLimpiar.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jbLimpiar.setText("Limpiar campos");
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrEstado)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtNombre)
                                    .addComponent(jtApellido)
                                    .addComponent(jtDni)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtDireccion))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtCorreo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(paneFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtDireccionFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbCambiarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtDireccionFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCambiarFoto))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiar)
                    .addComponent(jbGUARDAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(88, 88, 88))
        );

        jbLlenarCampos.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jbLlenarCampos.setText("EDITAR");
        jbLlenarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLlenarCamposActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jButton1.setText("EXPORTAR A EXCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jbLlenarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbLlenarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaKeyReleased

        borrarFilas();

        List<Huesped> huespedList = new ArrayList<>();

        huespedList = hd.listarHuespedes();

        for (Huesped huesped : huespedList) {
            if (huesped.getApellido().startsWith(jtBusqueda.getText()) || huesped.getNombre().startsWith(jtBusqueda.getText()) || huesped.getDni().startsWith(jtBusqueda.getText())) {

                modelo.addRow(new Object[]{
                    huesped.getIdHuesped(),
                    huesped.getDni(),
                    huesped.getApellido(),
                    huesped.getNombre(),
                    huesped.getTelefono()

                });
            }
        }

    }//GEN-LAST:event_jtBusquedaKeyReleased

    private void jbLlenarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLlenarCamposActionPerformed

        Huesped h = new Huesped();
        try {
            String dni = modelo.getValueAt(jtableHuespedes.getSelectedRow(), 1) + "";

            h = hd.buscarHuespedPorDni(dni);

            jtDni.setText(h.getDni());
            jtApellido.setText(h.getApellido());
            jtNombre.setText(h.getNombre());
            jtTelefono.setText(h.getTelefono());
            jtCorreo.setText(h.getCorreo());
            jtDireccion.setText(h.getDireccion());
            jrEstado.setSelected(h.isEstado());
            jtDireccionFoto.setText(h.getNombreFotoHuesped());

            //Convertir FileInputStream(Bytes) a imagen//
            // 1- Armar arreglo del tamaño del InputStream
            if (h.getFotoHuesped() != null) {
                byte[] imageBytes = new byte[h.getFotoHuesped().available()];

                // 2- Leer arreglo de Bytes
                h.getFotoHuesped().read(imageBytes);

                // 3- Convierte los bytes en una imagen
                Image imagen = Toolkit.getDefaultToolkit().createImage(imageBytes);
                imagen = imagen.getScaledInstance(110, 110, Image.SCALE_DEFAULT);

                // 4- Establecer imagen a JLabel
                jlFoto.setText("");
                jlFoto.setIcon(new ImageIcon(imagen));

            } else {
                jlFoto.setIcon(null);
                jlFoto.setText("*Sin foto*");

            }

            jbGUARDAR.setEnabled(true);
            jbCambiarFoto.setEnabled(true);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }


    }//GEN-LAST:event_jbLlenarCamposActionPerformed

    private void jbGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGUARDARActionPerformed

        try {

            FileInputStream fotoHuesped;
            String direccionFoto;
            String dni = jtDni.getText();
            String apellido = jtApellido.getText();
            String nombre = jtNombre.getText();
            String telefono = jtTelefono.getText();
            String correo = jtCorreo.getText();
            String direccion = jtDireccion.getText();
            boolean estado = jrEstado.isSelected();

            if (jtDireccionFoto.getText().isEmpty()) {
                fotoHuesped = null;
                direccionFoto = null;
            } else {
                fotoHuesped = new FileInputStream(jtDireccionFoto.getText());
                direccionFoto = jtDireccionFoto.getText();
            }

            if (jtApellido.getText().isEmpty() || jtNombre.getText().isEmpty() || jtTelefono.getText().isEmpty() || jtCorreo.getText().isEmpty() || jtDireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos necesarios");
            } else {
                hd.modificarHuesped(dni, apellido, nombre, telefono, correo, direccion, estado, fotoHuesped, direccionFoto);

                jlFoto.setIcon(null);
                jlFoto.setText("*Sin foto*");
                jtDireccionFoto.setText("");
                jtApellido.setText("");
                jtNombre.setText("");
                jtDni.setText("");
                jtTelefono.setText("");
                jtDireccion.setText("");
                jrEstado.setSelected(false);
                jtCorreo.setText("");
                jbGUARDAR.setEnabled(false);
                jbCambiarFoto.setEnabled(false);
                jtBusqueda.setText("");

                borrarFilas();
                actualizarLista();
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error, intente nuevamente");
        }


    }//GEN-LAST:event_jbGUARDARActionPerformed

    private void jbCambiarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCambiarFotoActionPerformed

        JFileChooser archivo = new JFileChooser();
        int ventana = archivo.showOpenDialog(null);

        //CREAR FILTRO JP
        if (ventana == JFileChooser.APPROVE_OPTION) {
            //CARGAR FOTO DESDE ARCHIVO
            File file = archivo.getSelectedFile();
            jtDireccionFoto.setText(String.valueOf(file));
            //CARGAR FOTO SELECCIONADA EN LABEL
            Image foto = getToolkit().getImage(jtDireccionFoto.getText());
            foto = foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            jlFoto.setText("");
            jlFoto.setIcon(new ImageIcon(foto));

        }

    }//GEN-LAST:event_jbCambiarFotoActionPerformed

    private void jtApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidoKeyPressed
        char x = evt.getKeyChar();
        if (Character.isLetter(x) || Character.isISOControl(x) || (evt.getKeyChar() == ' ')) {
            jtApellido.setEditable(true);
        } else {
            jtApellido.setEditable(false);
        }

    }//GEN-LAST:event_jtApellidoKeyPressed

    private void jtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyPressed
        char x = evt.getKeyChar();
        if (Character.isLetter(x) || Character.isISOControl(x) || (evt.getKeyChar() == ' ')) {
            jtNombre.setEditable(true);
        } else {
            jtNombre.setEditable(false);
        }

    }//GEN-LAST:event_jtNombreKeyPressed

    private void jtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTelefonoKeyPressed

        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {

            jtTelefono.setEditable(true);

        } else {

            jtTelefono.setEditable(false);
        }
    }//GEN-LAST:event_jtTelefonoKeyPressed

    private void jtApellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtApellidoMouseClicked
        jtApellido.setEditable(true);
    }//GEN-LAST:event_jtApellidoMouseClicked

    private void jtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtNombreMouseClicked
        jtNombre.setEditable(true);
    }//GEN-LAST:event_jtNombreMouseClicked

    private void jtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTelefonoMouseClicked
        jtTelefono.setEditable(true);
    }//GEN-LAST:event_jtTelefonoMouseClicked

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        jlFoto.setIcon(null);
        jlFoto.setText("*Sin foto*");
        jtDireccionFoto.setText("");
        jtApellido.setText("");
        jtNombre.setText("");
        jtDni.setText("");
        jtTelefono.setText("");
        jtDireccion.setText("");
        jrEstado.setSelected(false);
        jtCorreo.setText("");
        jbGUARDAR.setEnabled(false);
        jbCambiarFoto.setEnabled(false);
        jtBusqueda.setText("");
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Controlador obj;
        try {
            obj = new Controlador();
            obj.exportarExcel(jtableHuespedes);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error de archivo");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton jbCambiarFoto;
    private javax.swing.JButton jbGUARDAR;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbLlenarCampos;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JRadioButton jrEstado;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtBusqueda;
    private javax.swing.JTextField jtCorreo;
    private javax.swing.JTextField jtDireccion;
    private javax.swing.JTextField jtDireccionFoto;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtTelefono;
    public static javax.swing.JTable jtableHuespedes;
    private javax.swing.JPanel paneFoto;
    // End of variables declaration//GEN-END:variables

    public void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }

    }

    public void borrarColumnas() {

        modelo.setColumnCount(0);

    }

    private void armarCabeceraTabla() {

        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");

        jtableHuespedes.setModel(modelo);

    }

    public void actualizarLista() {

        List<Huesped> huespedList = new ArrayList<>();

        huespedList = hd.listarHuespedes();

        for (Huesped huesped : huespedList) {

            modelo.addRow(new Object[]{
                huesped.getIdHuesped(),
                huesped.getDni(),
                huesped.getApellido(),
                huesped.getNombre(),
                huesped.getTelefono()

            });

        }

    }
}

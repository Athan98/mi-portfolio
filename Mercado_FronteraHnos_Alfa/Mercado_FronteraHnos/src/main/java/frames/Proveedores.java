package frames;

import config.HibernateConfig;
import data.*;
import entidades.*;
import exportarExcel.Controlador;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class Proveedores extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };

    public Proveedores() {
        initComponents();
        jbGuardar.setEnabled(false);
        armarCabeceraTabla();
        actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtCUIT = new javax.swing.JTextField();
        jtDireccion = new javax.swing.JTextField();
        jtTelefono = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtBusquedaNombre = new javax.swing.JTextField();
        jtBusquedaCUIT = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProv = new javax.swing.JTable();
        jbEditar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbExportar = new javax.swing.JButton();

        setClosable(true);
        setTitle("PROVEEDORES");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Gestión", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID :");

        jlID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlID.setText("-");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre o Razon social :");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("C.U.I.T. :");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Direccion :");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Telefono:");

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar.png"))); // NOI18N
        jbAgregar.setText("AGREGAR");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbLimpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        jbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiar.png"))); // NOI18N
        jbLimpiar.setText("LIMPIAR");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(0, 0, 0));
        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar.png"))); // NOI18N
        jbGuardar.setText("GUARDAR");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtTelefono)
                            .addComponent(jtDireccion)
                            .addComponent(jtCUIT)
                            .addComponent(jlID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlID))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Búsqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Buscar por nombre :");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Buscar por C.U.I.T. :");

        jtBusquedaNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaNombreKeyReleased(evt);
            }
        });

        jtBusquedaCUIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaCUITKeyReleased(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableProv.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableProv);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbEditar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbEditar.setForeground(new java.awt.Color(0, 0, 0));
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        jbEditar.setText("EDITAR");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(204, 0, 0));
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        jbEliminar.setText("ELIMINAR");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbExportar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbExportar.setForeground(new java.awt.Color(0, 153, 0));
        jbExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excel.png"))); // NOI18N
        jbExportar.setText("EXPORTAR");
        jbExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtBusquedaCUIT)
                            .addComponent(jtBusquedaNombre))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtBusquedaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtBusquedaCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditar)
                    .addComponent(jbEliminar)
                    .addComponent(jbExportar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        String nombre = jtNombre.getText();
        String telefono = jtTelefono.getText();
        String direccion = jtDireccion.getText();
        String cuit = jtCUIT.getText();

        if (jtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Al menos debe ingresar un nombre");
        } else {

            Proveedor prov = new Proveedor(nombre, telefono, direccion, cuit);

            Session session = HibernateConfig.get().openSession();

            Proveedor_data provd = new Proveedor_data(session);

            provd.agregar(prov);

            session.close();

            limpiarCampos();
            borrarFilas();
            actualizarTabla();
        }


    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        jbAgregar.setEnabled(false);
        jbGuardar.setEnabled(true);

        Proveedor prov = new Proveedor();

        int idProv = (int) modelo.getValueAt(jTableProv.getSelectedRow(), 0);

        Session session = HibernateConfig.get().openSession();
        Proveedor_data provd = new Proveedor_data(session);
        prov = provd.encontrarPorID(idProv);

        jlID.setText(prov.getIdProveedor() + "");
        jtNombre.setText(prov.getNombre());
        jtCUIT.setText(prov.getCuit());
        jtDireccion.setText(prov.getDireccion());
        jtTelefono.setText(prov.getTelefono());

        session.close();
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jtBusquedaNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaNombreKeyReleased
        Session session = HibernateConfig.get().openSession();
        Proveedor_data provd = new Proveedor_data(session);
        List<Proveedor> proveedores = provd.listarTodo();

        String busquedaNombre = jtBusquedaNombre.getText().toUpperCase();

        borrarFilas();

        for (Proveedor p : proveedores) {
            if (p.getNombre().toUpperCase().startsWith(busquedaNombre)) {
                modelo.addRow(new Object[]{
                    p.getIdProveedor(),
                    p.getCuit(),
                    p.getNombre(),
                    p.getTelefono(),
                    p.getDireccion()});
            }
        }
        session.close();
    }//GEN-LAST:event_jtBusquedaNombreKeyReleased

    private void jtBusquedaCUITKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaCUITKeyReleased
        Session session = HibernateConfig.get().openSession();
        Proveedor_data provd = new Proveedor_data(session);
        List<Proveedor> proveedores = provd.listarTodo();

        String busquedaCUIT = jtBusquedaCUIT.getText().toUpperCase();

        borrarFilas();

        for (Proveedor p : proveedores) {
            if (p.getCuit().toUpperCase().startsWith(busquedaCUIT)) {
                modelo.addRow(new Object[]{
                    p.getIdProveedor(),
                    p.getCuit(),
                    p.getNombre(),
                    p.getTelefono(),
                    p.getDireccion()});
            }
        }
        session.close();
    }//GEN-LAST:event_jtBusquedaCUITKeyReleased

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        if (jtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Al menos debe ingresar un nombre");
        } else {
            Session session = HibernateConfig.get().openSession();

            Proveedor_data provd = new Proveedor_data(session);

            int idProv = Integer.parseInt(jlID.getText());
            String CUIT = jtCUIT.getText();
            String nombre = jtNombre.getText();
            String telefono = jtTelefono.getText();
            String direccion = jtDireccion.getText();

            Proveedor prov = new Proveedor(idProv, nombre, telefono, direccion, CUIT);

            provd.actualizar(prov);

            borrarFilas();
            actualizarTabla();
            limpiarCampos();
            jbAgregar.setEnabled(true);
            jbGuardar.setEnabled(false);

            session.close();
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiarCampos();
        actualizarTabla();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int idProv = (int) modelo.getValueAt(jTableProv.getSelectedRow(), 0);

        Session session = HibernateConfig.get().openSession();
        Proveedor_data provd = new Proveedor_data(session);

        int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres eliminarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == JOptionPane.YES_OPTION) {
            provd.eliminarPorID(idProv);

            borrarFilas();
            actualizarTabla();
        }

        session.close();
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExportarActionPerformed
        Controlador obj;
        try {
            obj = new Controlador();
            obj.exportarExcel(jTableProv);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error de archivo");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbExportarActionPerformed


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
    private javax.swing.JTable jTableProv;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbExportar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JLabel jlID;
    private javax.swing.JTextField jtBusquedaCUIT;
    private javax.swing.JTextField jtBusquedaNombre;
    private javax.swing.JTextField jtCUIT;
    private javax.swing.JTextField jtDireccion;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtTelefono;
    // End of variables declaration//GEN-END:variables

    public void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    public void armarCabeceraTabla() {
        modelo.setColumnCount(0);

        modelo.addColumn("ID");
        modelo.addColumn("CUIT");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");

        jTableProv.setModel(modelo);
    }

    public void actualizarTabla() {

        modelo.setRowCount(0);

        Session session = HibernateConfig.get().openSession();

        Proveedor_data provd = new Proveedor_data(session);

        List<Proveedor> proveedores = provd.listarTodo();

        for (Proveedor p : proveedores) {
            modelo.addRow(new Object[]{
                p.getIdProveedor(),
                p.getCuit(),
                p.getNombre(),
                p.getTelefono(),
                p.getDireccion()});
        }
        session.close();
    }

    private void limpiarCampos() {

        jlID.setText("-");
        jtCUIT.setText("");
        jtNombre.setText("");
        jtDireccion.setText("");
        jtTelefono.setText("");

    }

}

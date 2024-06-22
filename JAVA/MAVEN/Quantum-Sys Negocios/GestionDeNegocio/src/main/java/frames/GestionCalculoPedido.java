package frames;

import config.HibernateConfig;
import config_tables.Render;
import config_tables.RenderProductos;
import data.*;
import entidades.*;
import exportarExcel.InformeCalcularPedido;
import static frames.Principal.escritorio;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Session;

public class GestionCalculoPedido extends javax.swing.JInternalFrame {

    private final DefaultTableModel modeloInforme = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return col == 0;  // Hacer la primera columna (checkbox) editable
        }
    };
    private final DefaultTableModel modeloProducto = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return col == 0;  // Hacer la primera columna (checkbox) editable
        }

    };

    List<Producto> productos = null;
    List<DetalleCalculoPedido> detalles = new ArrayList<>();
    CalculoPedido cp = new CalculoPedido();
    Double total = 0.0;
    Usuario user = Principal.user;
    private SwingWorker<Void, Void> cargaWorker;

    public GestionCalculoPedido() {
        initComponents();
        borrarFilasProd();
        borrarFilasProd();
        armarCabeceraTablaProductos();
        actualizarListaProductos();
        armarCabeceraTablaDetalles();

        jlTotal.setText(total + "");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListaProductos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbLimpiarCampos = new javax.swing.JButton();
        jbEscanear = new javax.swing.JButton();
        jtCodigo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jlTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDetalles = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jbEliminarProd = new javax.swing.JButton();

        setClosable(true);
        setTitle("NUEVO CALCULO DE PEDIDO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jtListaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtListaProductos);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Buscar por nombre:");

        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtNombreKeyReleased(evt);
            }
        });

        jLabel2.setText("Buscar por codigo:");

        jbLimpiarCampos.setText("Limpiar");
        jbLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCamposActionPerformed(evt);
            }
        });

        jbEscanear.setText("Escanear");
        jbEscanear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEscanearActionPerformed(evt);
            }
        });

        jtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtCodigoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jtCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEscanear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpiarCampos))
                    .addComponent(jtNombre))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jbLimpiarCampos)
                    .addComponent(jbEscanear)
                    .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informe", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jlTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlTotal.setForeground(new java.awt.Color(0, 204, 0));
        jlTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTotal.setText("-");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TOTAL ($) :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jbGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(0, 0, 153));
        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/save.png"))); // NOI18N
        jbGuardar.setText("GUARDAR");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbGuardar)
                .addContainerGap())
        );

        jtDetalles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtDetalles);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/flechaDerecha.png"))); // NOI18N
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbEliminarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/flechaIzquierda.png"))); // NOI18N
        jbEliminarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbEliminarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jbAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbEliminarProd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        try {
            Producto p = verificarProducto();
            if (p == null) {
                JOptionPane.showMessageDialog(null, "Hubo un problema al recuperar el producto");
            } else {

                String input = JOptionPane.showInputDialog("Ingrese la cantidad:");

                if (input != null && !input.isEmpty()) {
                    try {
                        // Convertir la entrada a un número (en este caso, un entero)
                        int cantidad = Integer.parseInt(input);

                        DetalleCalculoPedido dcp = new DetalleCalculoPedido();
                        dcp.setCantidad(cantidad);
                        dcp.setProducto(p);
                        dcp.setCostoDetalle(p.getPrecioCostoUnitario() * cantidad);
                        dcp.setCp(cp);
                        detalles.add(dcp);

                        modeloInforme.addRow(new Object[]{
                            dcp.getCp().getIdCP(),
                            dcp.getProducto().getNombre(),
                            dcp.getProducto().getCodigo(),
                            dcp.getCantidad(),
                            dcp.getCostoDetalle()});

                        total = total + dcp.getCostoDetalle();
                        jlTotal.setText(Math.round(total * 100.0) / 100.0 + "");
                        limpiarCamposProd();
                        borrarFilasProd();

                        for (Producto prod : productos) {
                            modeloProducto.addRow(new Object[]{
                                prod.getIdProducto(),
                                prod.getCodigo(),
                                prod.getCategoria().getNombre(),
                                prod.getNombre(),
                                prod.getPrecioCostoUnitario(),
                                prod.getPrecioVentaUnitario(),
                                prod.getStock(),
                                prod.getDisponibilidad()});

                        }

                    } catch (NumberFormatException e) {
                        // Manejar el caso en el que la entrada no sea un número válido
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // El usuario hizo clic en Cancelar o cerró el cuadro de diálogo
                    JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            Session session = HibernateConfig.get().openSession();

            //CALCULO PEDIDO
            Date fecha = new Date();
            CalculoPedido_data cpd = new CalculoPedido_data(session);
            cp.setTotal(Double.parseDouble(jlTotal.getText()));
            cp.setFecha(fecha);
            cp.setDetalles(detalles);
            cp.setEstado(true);
            cp.setUsuario(user);
            cpd.agregar(cp);
            //

            //DETALLE CALCULO PEDIDO
            DetalleCalculoPedido_data dcpd = new DetalleCalculoPedido_data(session);
            for (DetalleCalculoPedido d : detalles) {
                if (detalles != null) {
                    dcpd.agregar(d);
                }
            }

            session.close();

            InformeCalcularPedido obj;

            try {

                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                String fechaStr = formato.format(fecha);
                obj = new InformeCalcularPedido(user.getNombre(), fechaStr, String.valueOf(cp.getIdCP()),
                        String.valueOf(cp.getTotal()), detalles);
                obj.crearPlantilla();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
            }

            total = 0.0;

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
                        escritorio.removeAll();
                        escritorio.repaint();
                        Thread.sleep(2000);
                        CalculoPedidoInicio cp = new CalculoPedidoInicio();
                        cp.setVisible(true);
                        escritorio.add(cp);
                        escritorio.moveToFront(cp);
                        cp.setLocation((Principal.escritorio.getWidth() - cp.getWidth()) / 2, (Principal.escritorio.getHeight() - cp.getHeight()) / 2);
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

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarProdActionPerformed

        int filaSeleccionada = jtDetalles.getSelectedRow();

        if (filaSeleccionada != -1) {
            Double costo = (Double) modeloInforme.getValueAt(filaSeleccionada, 4);
            total = total - costo;
            jlTotal.setText(Math.round(total * 100.0) / 100.0 + "");
            modeloInforme.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }


    }//GEN-LAST:event_jbEliminarProdActionPerformed

    private void jtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyReleased
        try {
            String campoBuscarNombre = jtNombre.getText().toUpperCase();

            borrarFilasProd();

            for (Producto p : productos) {
                if (p.getNombre().toUpperCase().startsWith(campoBuscarNombre)) {
                    modeloProducto.addRow(new Object[]{
                        p.getIdProducto(),
                        p.getCodigo(),
                        p.getCategoria().getNombre(),
                        p.getNombre(),
                        p.getPrecioCostoUnitario(),
                        p.getPrecioVentaUnitario(),
                        p.getStock(),
                        p.getDisponibilidad()});
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jtNombreKeyReleased

    private void jtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodigoKeyPressed
        if (Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            jtCodigo.setEditable(true);
        } else {
            jtCodigo.setEditable(false);
        }
    }//GEN-LAST:event_jtCodigoKeyPressed

    private void jtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodigoKeyReleased
        try {
            String campoBuscarCodigo = jtCodigo.getText();

            borrarFilasProd();

            for (Producto p : productos) {
                if (p.getCodigo().startsWith(campoBuscarCodigo) || p.getCodigo().equals(campoBuscarCodigo)) {
                    modeloProducto.addRow(new Object[]{
                        p.getIdProducto(),
                        p.getCodigo(),
                        p.getCategoria().getNombre(),
                        p.getNombre(),
                        p.getPrecioCostoUnitario(),
                        p.getPrecioVentaUnitario(),
                        p.getStock(),
                        p.getDisponibilidad()});
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jtCodigoKeyReleased

    private void jbEscanearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEscanearActionPerformed
        jtCodigo.setText("");
        JOptionPane.showMessageDialog(null, "Presione ACEPTAR y escanee el producto");
        jtCodigo.requestFocus();
    }//GEN-LAST:event_jbEscanearActionPerformed

    private void jbLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCamposActionPerformed
        jtCodigo.setText("");
        jtNombre.setText("");
        borrarFilasProd();
        for (Producto p : productos) {
            modeloProducto.addRow(new Object[]{
                p.getIdProducto(),
                p.getCodigo(),
                p.getCategoria().getNombre(),
                p.getNombre(),
                p.getPrecioCostoUnitario(),
                p.getPrecioVentaUnitario(),
                p.getStock(),
                p.getDisponibilidad()});

        }

    }//GEN-LAST:event_jbLimpiarCamposActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEliminarProd;
    private javax.swing.JButton jbEscanear;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiarCampos;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JTextField jtCodigo;
    private javax.swing.JTable jtDetalles;
    private javax.swing.JTable jtListaProductos;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables

    public void borrarFilasProd() {
        int f = modeloProducto.getRowCount() - 1;
        for (; f >= 0; f--) {
            modeloProducto.removeRow(f);
        }
    }

    public void borrarFilasInf() {
        int f = modeloInforme.getRowCount() - 1;
        for (; f >= 0; f--) {
            modeloInforme.removeRow(f);
        }
    }

    private void limpiarCamposProd() {
        jtNombre.setText("");
        jtCodigo.setText("");
    }

    public void actualizarListaProductos() {

        try {

            modeloProducto.setRowCount(0);

            Session session = HibernateConfig.get().openSession();

            Producto_data pd = new Producto_data(session);

            productos = pd.listarTodo();

            for (Producto p : productos) {
                modeloProducto.addRow(new Object[]{
                    p.getIdProducto(),
                    p.getCodigo(),
                    p.getCategoria().getNombre(),
                    p.getNombre(),
                    p.getPrecioCostoUnitario(),
                    p.getPrecioVentaUnitario(),
                    p.getStock(),
                    p.getDisponibilidad()});

            }

            session.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    public void armarCabeceraTablaProductos() {
        modeloProducto.setColumnCount(0);

        jtListaProductos.setRowHeight(25);

        modeloProducto.addColumn("ID");
        modeloProducto.addColumn("Codigo");
        modeloProducto.addColumn("Categoria");
        modeloProducto.addColumn("Nombre");
        modeloProducto.addColumn("Costo unitario");
        modeloProducto.addColumn("Precio venta unitario");
        modeloProducto.addColumn("Stock");
        modeloProducto.addColumn("Disponibilidad");

        jtListaProductos.setModel(modeloProducto);

        TableColumn column0 = jtListaProductos.getColumnModel().getColumn(0);

        column0.setPreferredWidth(20);
    }

    public void armarCabeceraTablaDetalles() {
        modeloInforme.setColumnCount(0);

        jtDetalles.setRowHeight(25);

        modeloInforme.addColumn("ID Informe");
        modeloInforme.addColumn("Producto");
        modeloInforme.addColumn("Codigo");
        modeloInforme.addColumn("Cantidad");
        modeloInforme.addColumn("Costo ($)");

        jtDetalles.setModel(modeloInforme);

        TableColumn column0 = jtDetalles.getColumnModel().getColumn(0);

        column0.setPreferredWidth(20);
    }

    private Producto verificarProducto() {
        try {

            int idProd = (int) modeloProducto.getValueAt(jtListaProductos.getSelectedRow(), 0);

            if (idProd == 0) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            } else {

                for (Producto p : productos) {
                    if (p.getIdProducto() == idProd) {
                        return p;
                    }
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
        return null;

    }

}

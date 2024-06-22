package frames;

import config.*;
import config_tables.RenderCalculoPedidos;
import config_tables.RenderProveedores;
import data.*;
import entidades.*;
import exportarExcel.InformeCalcularPedido;
import static frames.Principal.escritorio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Session;

public class CalculoPedidoInicio extends javax.swing.JInternalFrame {

    Class tipo[] = new Class[]{java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
        java.lang.Object.class, java.lang.Object.class};

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

    List<CalculoPedido> informes = null;
    private SwingWorker<Void, Void> cargaWorker;

    public CalculoPedidoInicio() {
        initComponents();
        armarCabeceraTabla();
        borrarFilas();
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaInformes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtDia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtAnio = new javax.swing.JTextField();
        jcMeses = new javax.swing.JComboBox<>();
        jbBuscar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbNuevoCalculo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbPDF = new javax.swing.JButton();

        setClosable(true);
        setTitle("CALCULADOR DE PEDIDOS: INICIO");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informes existentes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N

        jtListaInformes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtListaInformes);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Busqueda por FECHA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel3.setText("Dia :");

        jLabel4.setText("Mes :");

        jtDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDiaActionPerformed(evt);
            }
        });

        jLabel5.setText("Año :");

        jtAnio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jcMeses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        jcMeses.setSelectedIndex(-1);

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarPequenio.png"))); // NOI18N
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbLimpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jcMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbNuevoCalculo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbNuevoCalculo.setForeground(new java.awt.Color(0, 153, 0));
        jbNuevoCalculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        jbNuevoCalculo.setText("NUEVO CALCULO");
        jbNuevoCalculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoCalculoActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(153, 0, 0));
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        jbEliminar.setText("ELIMINAR");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbPDF.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbPDF.setForeground(new java.awt.Color(0, 0, 0));
        jbPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pdf.png"))); // NOI18N
        jbPDF.setText("GENERAR PDF");
        jbPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbNuevoCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbNuevoCalculo)
                            .addComponent(jbEliminar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jtDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDiaActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            List<CalculoPedido> informesXFecha = new ArrayList<>(); // Inicializa la lista

            String diaTexto = jtDia.getText();
            String mesTexto = (String) jcMeses.getSelectedItem();
            int numeroMes = obtenerNumeroMes(mesTexto);
            String anioTexto = jtAnio.getText();

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(diaTexto));
            calendar.set(Calendar.MONTH, numeroMes - 1); // Resta 1 porque los meses en Calendar van de 0 a 11
            calendar.set(Calendar.YEAR, Integer.parseInt(anioTexto));

            // Establece la hora a medianoche (00:00:00) para ignorar las horas
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            // Obtiene el objeto Date a partir del Calendar
            Date fechaIngresada = calendar.getTime();

            for (CalculoPedido cp : informes) {
                // Crea un nuevo objeto Calendar para la fecha del Pedido
                Calendar calendarPedido = Calendar.getInstance();
                calendarPedido.setTime(cp.getFecha());

                // Establece la hora a medianoche para ignorar las horas
                calendarPedido.set(Calendar.HOUR_OF_DAY, 0);
                calendarPedido.set(Calendar.MINUTE, 0);
                calendarPedido.set(Calendar.SECOND, 0);
                calendarPedido.set(Calendar.MILLISECOND, 0);

                // Compara las fechas sin tener en cuenta las horas
                if (calendarPedido.getTime().equals(fechaIngresada)) {
                    informesXFecha.add(cp);
                }
            }

            borrarFilas();

            for (CalculoPedido cp : informesXFecha) {
                if (cp.isEstado() == true) {
                    modelo.addRow(new Object[]{
                        false,
                        cp.getIdCP(),
                        cp.getFecha(),
                        cp.getTotal(),
                        cp.getUsuario().getNombre(),
                        "DISPONIBLE"});
                } else {
                    modelo.addRow(new Object[]{
                        false,
                        cp.getIdCP(),
                        cp.getFecha(),
                        cp.getTotal(),
                        cp.getUsuario().getNombre(),
                        "NO DISPONIBLE"});
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        jcMeses.setSelectedIndex(-1);
        jtDia.setText("");
        jtAnio.setText("");
        borrarFilas();
        for (CalculoPedido cp : informes) {
            if (cp.isEstado() == true) {
                modelo.addRow(new Object[]{
                    false,
                    cp.getIdCP(),
                    cp.getFecha(),
                    cp.getTotal(),
                    cp.getUsuario().getNombre(),
                    "DISPONIBLE"});
            } else {
                modelo.addRow(new Object[]{
                    false,
                    cp.getIdCP(),
                    cp.getFecha(),
                    cp.getTotal(),
                    cp.getUsuario().getNombre(),
                    "NO DISPONIBLE"});
            }
        }
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            Session session = HibernateConfig.get().openSession();
            CalculoPedido_data pd = new CalculoPedido_data(session);

            List<CalculoPedido> informesAEliminar = new ArrayList<>(); // Inicializar la lista

            boolean ver;
            CalculoPedido cp;

            for (int i = 0; i < informes.size(); i++) {
                ver = (boolean) modelo.getValueAt(i, 0);
                cp = pd.encontrarPorID((int) modelo.getValueAt(i, 1));
                if (ver) {
                    informesAEliminar.add(cp);
                }
            }

            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar las filas seleccionadas?", "Confirmaci�n", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                for (CalculoPedido c : informesAEliminar) {
                    c.setEstado(false);
                    pd.actualizar(c);
                }

                borrarFilas();
                actualizarTabla();
                JOptionPane.showMessageDialog(null, "Elementos eliminados exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Operacion cancelada");
            }

            session.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbNuevoCalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoCalculoActionPerformed
        try {

            if (cargaWorker != null && !cargaWorker.isDone()) {
                JOptionPane.showMessageDialog(null, "Espere a que la operacion actual termine.");
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
                        GestionCalculoPedido gcp = new GestionCalculoPedido();
                        gcp.setVisible(true);
                        escritorio.add(gcp);
                        gcp.setLocation((Principal.escritorio.getWidth() - gcp.getWidth()) / 2, (Principal.escritorio.getHeight() - gcp.getHeight()) / 2);
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
    }//GEN-LAST:event_jbNuevoCalculoActionPerformed

    private void jbPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPDFActionPerformed
        try {
            Session session = HibernateConfig.get().openSession();
            CalculoPedido_data cpd = new CalculoPedido_data(session);

            int filaSeleccionada = (int) modelo.getValueAt(jtListaInformes.getSelectedRow(), 1);

            CalculoPedido cp = cpd.encontrarPorID(filaSeleccionada);

            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea generar el PDF?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {

                InformeCalcularPedido obj;

                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                String fechaStr = formato.format(cp.getFecha());

                obj = new InformeCalcularPedido(cp.getUsuario().getNombre(), fechaStr,
                        String.valueOf(cp.getIdCP()), String.valueOf(cp.getTotal()), cp.getDetalles());

                obj.crearPlantilla();

            } else {
                JOptionPane.showMessageDialog(null, "Operacion cancelada");
            }

            session.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbNuevoCalculo;
    private javax.swing.JButton jbPDF;
    private javax.swing.JComboBox<String> jcMeses;
    private javax.swing.JTextField jtAnio;
    private javax.swing.JTextField jtDia;
    private javax.swing.JTable jtListaInformes;
    // End of variables declaration//GEN-END:variables

    public void armarCabeceraTabla() {
        modelo.setColumnCount(0);

        jtListaInformes.setDefaultRenderer(Object.class, new RenderCalculoPedidos());

        jtListaInformes.setRowHeight(25);

        modelo.addColumn(" ");
        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total ($)");
        modelo.addColumn("Usuario");
        modelo.addColumn("Estado");

        jtListaInformes.setModel(modelo);

        TableColumn column1 = jtListaInformes.getColumnModel().getColumn(1);
        TableColumn column0 = jtListaInformes.getColumnModel().getColumn(0);

        column1.setPreferredWidth(25);
        column0.setPreferredWidth(20);
    }

    public void actualizarTabla() {
        try {
            modelo.setRowCount(0);

            Session session = HibernateConfig.get().openSession();

            CalculoPedido_data cpd = new CalculoPedido_data(session);

            informes = cpd.listarTodo();

            for (CalculoPedido cp : informes) {
                if (cp.isEstado() == true) {
                    modelo.addRow(new Object[]{
                        false,
                        cp.getIdCP(),
                        cp.getFecha(),
                        cp.getTotal(),
                        cp.getUsuario().getNombre(),
                        "DISPONIBLE"});
                } else {
                    modelo.addRow(new Object[]{
                        false,
                        cp.getIdCP(),
                        cp.getFecha(),
                        cp.getTotal(),
                        cp.getUsuario().getNombre(),
                        "NO DISPONIBLE"});
                }
            }
            session.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    public void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private static int obtenerNumeroMes(String mesTexto) {
        switch (mesTexto.toLowerCase()) {
            case "enero":
                return 1;
            case "febrero":
                return 2;
            case "marzo":
                return 3;
            case "abril":
                return 4;
            case "mayo":
                return 5;
            case "junio":
                return 6;
            case "julio":
                return 7;
            case "agosto":
                return 8;
            case "septiembre":
                return 9;
            case "octubre":
                return 10;
            case "noviembre":
                return 11;
            case "diciembre":
                return 12;
            default:
                return 0;
        }

    }

}

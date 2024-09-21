package frames;

import config.HibernateConfig;
import config_tables.Render;
import data.DetalleProducto_data;
import data.Proveedor_data;
import entidades.DetalleProducto;
import entidades.Proveedor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class Productos_Proveedores extends javax.swing.JInternalFrame {

    public List<Proveedor> proveedores = new ArrayList<>();
    public List<DetalleProducto> detallesProducto = new ArrayList<>();
    public JButton btnEditar = new JButton("Editar");
    public JButton btnEliminar = new JButton("Eliminar");
    public static int columna, row;

    public Productos_Proveedores() {
        initComponents();
        proveedores = listarProveedores();
        detallesProducto = listarDetallesProductos();
        btnEditar.setName("btnEditar");
        btnEliminar.setName("btnEliminar");
        crearPestañasProveedores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();

        setClosable(true);
        setTitle("Productos por Proveedor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables

// Método para agrupar productos por proveedor
    public Map<Integer, List<DetalleProducto>> agruparProductosPorProveedor() {
        Map<Integer, List<DetalleProducto>> mapProductosPorProveedor = new HashMap<>();

        for (DetalleProducto dp : detallesProducto) {
            int idProveedor = dp.getProveedor().getIdProveedor();
            mapProductosPorProveedor.computeIfAbsent(idProveedor, k -> new ArrayList<>()).add(dp);
        }

        return mapProductosPorProveedor;
    }

    // Método para crear pestañas de proveedores
    public void crearPestañasProveedores() {
        for (Proveedor p : proveedores) {
            JPanel panel = new JPanel(new BorderLayout());
            JTable tablaProductos = crearTablaProductos();

            tablaProductos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int columna = tablaProductos.getColumnModel().getColumnIndexAtX(e.getX());
                    int row = e.getY() / tablaProductos.getRowHeight();
                    int idDetalle = (int) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0);

                    if (columna >= 0 && columna < tablaProductos.getColumnCount()
                            && row >= 0 && row < tablaProductos.getRowCount()) {
                        Object objeto = tablaProductos.getValueAt(row, columna);
                        if (objeto instanceof JButton) {
                            ((JButton) objeto).doClick();
                            JButton boton = (JButton) objeto;
                            if (boton.getName().equals("btnEditar")) {
                                AltaModificacion_DetalleProducto amdp = new AltaModificacion_DetalleProducto(idDetalle);
                                amdp.setVisible(true);
                                Principal.escritorio.add(amdp);
                                Principal.escritorio.moveToFront(amdp);
                                amdp.setLocation((Principal.escritorio.getWidth() - amdp.getWidth()) / 2, (Principal.escritorio.getHeight() - amdp.getHeight()) / 2);
                                // Obtener el JInternalFrame padre y cerrarlo
                                JInternalFrame parentFrame = (JInternalFrame) SwingUtilities.getAncestorOfClass(JInternalFrame.class, tablaProductos);
                                if (parentFrame != null) {
                                    parentFrame.dispose();
                                }
                            } else if (boton.getName().equals("btnEliminar")) {
                                int response = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este registro?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                if (response == JOptionPane.YES_OPTION) {
                                    eliminarDetalleProducto(idDetalle);
                                    borrarFilas((DefaultTableModel) tablaProductos.getModel());
                                    actualizarTabla((DefaultTableModel) tablaProductos.getModel(), p);
                                }
                            }
                        }
                    }
                }
            });

            actualizarTabla((DefaultTableModel) tablaProductos.getModel(), p);

            JScrollPane scrollPane = new JScrollPane(tablaProductos);
            panel.add(scrollPane, BorderLayout.CENTER);
            jTabbedPane.addTab(p.getNombre(), panel);
        }
    }

    // Método para crear la tabla de productos
    private JTable crearTablaProductos() {
        DefaultTableModel modeloTabla = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID Detalle", "Producto", "Costo unitario", "Unidades x paquete", "Costo x paquete", "", ""}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Deshabilitar la edición de todas las celdas
            }
        };

        JTable tablaProductos = new JTable(modeloTabla);
        tablaProductos.setDefaultRenderer(Object.class, new Render());
        tablaProductos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaProductos.setRowHeight(25); // Aquí se establece la altura deseada para las filas

        return tablaProductos;
    }

    // Método para actualizar la tabla de productos
    public void actualizarTabla(DefaultTableModel modeloTabla, Proveedor p) {
        List<DetalleProducto> productos = agruparProductosPorProveedor().getOrDefault(p.getIdProveedor(), new ArrayList<>());

        for (DetalleProducto dp : productos) {
            modeloTabla.addRow(new Object[]{
                dp.getIdDetalleProducto(),
                dp.getProducto().getNombre(),
                dp.getPrecioCosto(),
                dp.getUnidadesPorPaquete(),
                dp.getPrecioPorPaquete(),
                btnEditar,
                btnEliminar
            });
        }
    }

    // Método para listar proveedores
    public List<Proveedor> listarProveedores() {
        Session session = null;
        try {
            session = HibernateConfig.get().openSession();
            Proveedor_data pd = new Proveedor_data(session);
            return pd.listarTodo();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return Collections.emptyList();
    }

    // Método para listar detalles de productos
    public List<DetalleProducto> listarDetallesProductos() {
        Session session = null;
        try {
            session = HibernateConfig.get().openSession();
            DetalleProducto_data dpd = new DetalleProducto_data(session);
            return dpd.listarTodo();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return Collections.emptyList();
    }

    // Método para obtener productos por proveedor
    public List<DetalleProducto> obtenerProductosPorProveedor(int idProveedor) {
        return agruparProductosPorProveedor().getOrDefault(idProveedor, new ArrayList<>());
    }

    // Método para borrar filas de una tabla
    public void borrarFilas(DefaultTableModel modelo) {
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    // Método para eliminar un detalle de producto por ID
    private void eliminarDetalleProducto(int idDetalle) {
        Session session = null;
        try {
            session = HibernateConfig.get().openSession();
            DetalleProducto_data dpd = new DetalleProducto_data(session);
            dpd.eliminarPorID(idDetalle);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            detallesProducto = listarDetallesProductos();
        }
    }
}

package frames;

import config.HibernateConfig;
import data.Producto_data;
import entidades.Producto;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class Consultas extends javax.swing.JInternalFrame {

    ConsultasStock cs = new ConsultasStock();
    ConsultasPromociones cp = new ConsultasPromociones();
    ConsultaCodigos cc = new ConsultaCodigos();
    public static List<Producto> productos = null;

    public Consultas() {
        initComponents();
        productos = listaProductos();
        ConsultasPane.addTab("Consulta de codigo", cc);
        ConsultasPane.addTab("Consulta de stock", cs);
        ConsultasPane.addTab("Consulta de promos", cp);
        ConsultasPane.setSelectedComponent(cc);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConsultasPane = new javax.swing.JTabbedPane();

        setClosable(true);
        setTitle("CONSULTAS");

        ConsultasPane.setPreferredSize(new java.awt.Dimension(602, 582));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConsultasPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConsultasPane, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public List<Producto> listaProductos() {
        try {

            Session session = HibernateConfig.get().openSession();

            Producto_data pd = new Producto_data(session);

            productos = pd.listarTodo();

            Collections.sort(productos, Comparator.comparing(Producto::getCodigo));

            session.close();

            return productos;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }

        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane ConsultasPane;
    // End of variables declaration//GEN-END:variables
}

package repositories;

import entidades.ProductoVendedor;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductoVendedorData implements Repository<ProductoVendedor> {

    private final Session session;

    public ProductoVendedorData(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(ProductoVendedor t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "El producto del vendedor ha sido agregado a la base de datos con el ID: " + t.getIdProductosVendedor());
        trans.commit();
    }

    @Override
    public List<ProductoVendedor> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<ProductoVendedor> productos = session.createQuery("FROM productovendedor", ProductoVendedor.class).getResultList();
        trans.commit();
        return productos;
    }

    @Override
    public ProductoVendedor encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        ProductoVendedor producto = session.createQuery("FROM productovendedor WHERE idProductosVendedor=:id", ProductoVendedor.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return producto;
    }

    @Override
    public void actualizar(ProductoVendedor t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "El producto de vendedor con ID: " + t.getIdProductosVendedor() + " ha sido actualizado");
        trans.commit();
    }

    @Override
    public void eliminar(ProductoVendedor t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "El producto de vendedor con ID: " + t.getIdProductosVendedor() + " ha sido eliminado");
        trans.commit();
    }

}

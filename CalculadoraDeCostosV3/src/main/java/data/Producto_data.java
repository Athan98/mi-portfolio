package data;

import entidades.Producto;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Producto_data implements Repository<Producto> {

    private final Session session;

    public Producto_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Producto t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<Producto> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Producto> productos = session.createQuery("FROM Producto", Producto.class).getResultList();
        trans.commit();
        return productos;
    }

    @Override
    public Producto encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Producto producto = session.createQuery("FROM Producto WHERE idProducto=:id", Producto.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return producto;
    }

    @Override
    public void actualizar(Producto t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(Producto t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        Transaction trans = session.beginTransaction();

        Producto productoAEliminar = session.get(Producto.class, id);

        if (productoAEliminar != null) {
            session.delete(productoAEliminar);
            JOptionPane.showMessageDialog(null, "El producto con ID: " + id + " ha sido eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el producto con ID: " + id);
        }

        trans.commit();
    }

}

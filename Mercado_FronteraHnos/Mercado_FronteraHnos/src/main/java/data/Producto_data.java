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
        JOptionPane.showMessageDialog(null, "El producto ha sido agregado a la base de datos con el ID: " + t.getIdProducto());
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
        JOptionPane.showMessageDialog(null, "El producto con ID: " + t.getIdProducto() + " ha sido actualizado");
        trans.commit();
    }

    @Override
    public void eliminar(Producto t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "El producto con ID: " + t.getIdProducto() + " ha sido eliminado");
        trans.commit();
    }

}

package data;

import entidades.DetalleProducto;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetalleProducto_data implements Repository<DetalleProducto> {

    private final Session session;

    public DetalleProducto_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(DetalleProducto t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<DetalleProducto> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<DetalleProducto> productos = session.createQuery("FROM DetalleProducto", DetalleProducto.class).getResultList();
        trans.commit();
        return productos;
    }

    @Override
    public DetalleProducto encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        DetalleProducto producto = session.createQuery("FROM DetalleProducto WHERE idDetalleProducto=:id", DetalleProducto.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return producto;
    }

    @Override
    public void actualizar(DetalleProducto t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(DetalleProducto t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        Transaction trans = session.beginTransaction();

        DetalleProducto productoAEliminar = session.get(DetalleProducto.class, id);

        if (productoAEliminar != null) {
            session.delete(productoAEliminar);
            JOptionPane.showMessageDialog(null, "El detalle de producto con ID: " + id + " ha sido eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el detalle de producto con ID: " + id);
        }

        trans.commit();
    }

}

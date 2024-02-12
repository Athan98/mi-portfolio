package data;

import entidades.DetalleCalculoPedido;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetalleCalculoPedido_data implements Repository<DetalleCalculoPedido> {

    private final Session session;

    public DetalleCalculoPedido_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(DetalleCalculoPedido t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<DetalleCalculoPedido> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<DetalleCalculoPedido> detalles = session.createQuery("FROM DetalleCalculoPedido", DetalleCalculoPedido.class).getResultList();
        trans.commit();
        return detalles;
    }

    @Override
    public DetalleCalculoPedido encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        DetalleCalculoPedido detalle = session.createQuery("FROM DetalleCalculoPedido WHERE idDetalleCalculoPedido=:id", DetalleCalculoPedido.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return detalle;
    }

    @Override
    public void actualizar(DetalleCalculoPedido t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(DetalleCalculoPedido t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
    }

}

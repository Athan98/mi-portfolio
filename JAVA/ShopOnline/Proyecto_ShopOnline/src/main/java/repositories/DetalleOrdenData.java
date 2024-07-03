
package repositories;

import entidades.DetalleOrden;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DetalleOrdenData implements Repository<DetalleOrden> {
    
    private final Session session;

    public DetalleOrdenData(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(DetalleOrden t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "El detalle de orden ha sido agregada a la base de datos con el ID: " + t.getIdDetalleOrden());
        trans.commit();
    }

    @Override
    public List<DetalleOrden> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<DetalleOrden> detalles = session.createQuery("FROM detalleorden", DetalleOrden.class).getResultList();
        trans.commit();
        return detalles;
    }

    @Override
    public DetalleOrden encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        DetalleOrden detalle = session.createQuery("FROM detalleorden WHERE idDetalleOrden=:id", DetalleOrden.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return detalle;
    }

    @Override
    public void actualizar(DetalleOrden t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "El detalle de orden con ID: " + t.getIdDetalleOrden() + " ha sido actualizada");
        trans.commit();
    }

    @Override
    public void eliminar(DetalleOrden t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "El detalle de orden con ID: " + t.getIdDetalleOrden() + " ha sido eliminada");
        trans.commit();
    }
    
}

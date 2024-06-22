package data;

import entidades.DetallesCtaCte;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetallesCtaCte_data implements Repository<DetallesCtaCte> {

    private final Session session;

    public DetallesCtaCte_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(DetallesCtaCte t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<DetallesCtaCte> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<DetallesCtaCte> detalles = session.createQuery("FROM DetallesCtaCte", DetallesCtaCte.class).getResultList();
        trans.commit();
        return detalles;
    }

    @Override
    public DetallesCtaCte encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        DetallesCtaCte detalle = session.createQuery("FROM DetallesCtaCte WHERE idDetallesCtaCte=:id", DetallesCtaCte.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return detalle;
    }

    @Override
    public void actualizar(DetallesCtaCte t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(DetallesCtaCte t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        Transaction trans = session.beginTransaction();

        DetallesCtaCte detalleAEliminar = session.get(DetallesCtaCte.class, id);

        if (detalleAEliminar != null) {
            session.delete(detalleAEliminar);
            JOptionPane.showMessageDialog(null, "El detalle con ID: " + id + " ha sido eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el detalle con ID: " + id);
        }

        trans.commit();
    }

}

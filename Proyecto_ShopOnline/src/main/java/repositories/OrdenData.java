package repositories;

import entidades.Orden;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrdenData implements Repository<Orden> {

    private final Session session;

    public OrdenData(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Orden t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "La orden ha sido agregada a la base de datos con el ID: " + t.getIdOrden());
        trans.commit();
    }

    @Override
    public List<Orden> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Orden> ordenes = session.createQuery("FROM orden", Orden.class).getResultList();
        trans.commit();
        return ordenes;
    }

    @Override
    public Orden encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Orden orden = session.createQuery("FROM orden WHERE idOrden=:id", Orden.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return orden;
    }

    @Override
    public void actualizar(Orden t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "La orden con ID: " + t.getIdOrden() + " ha sido actualizada");
        trans.commit();
    }

    @Override
    public void eliminar(Orden t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "La orden con ID: " + t.getIdOrden() + " ha sido eliminada");
        trans.commit();
    }

}

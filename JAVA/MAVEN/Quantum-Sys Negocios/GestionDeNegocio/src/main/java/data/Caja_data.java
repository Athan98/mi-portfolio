package data;

import entidades.Caja;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Caja_data implements Repository<Caja> {

    private final Session session;

    public Caja_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Caja t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<Caja> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Caja> cajas = session.createQuery("FROM Caja", Caja.class).getResultList();
        trans.commit();
        return cajas;
    }

    @Override
    public Caja encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Caja caja = session.createQuery("FROM Caja WHERE idCaja=:id", Caja.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return caja;
    }

    @Override
    public void actualizar(Caja t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(Caja t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        Transaction trans = session.beginTransaction();

        Caja cajaAEliminar = session.get(Caja.class, id);

        if (cajaAEliminar != null) {
            session.delete(cajaAEliminar);
            JOptionPane.showMessageDialog(null, "La caja con ID: " + id + " ha sido eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la caja con ID: " + id);
        }

        trans.commit();
    }

}

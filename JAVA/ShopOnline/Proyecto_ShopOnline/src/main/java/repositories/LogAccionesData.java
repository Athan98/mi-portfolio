package repositories;

import entidades.LogAcciones;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LogAccionesData implements Repository<LogAcciones> {

    private final Session session;

    public LogAccionesData(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(LogAcciones t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "La accion ha sido agregada a la base de datos con el ID: " + t.getIdAccion());
        trans.commit();
    }

    @Override
    public List<LogAcciones> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<LogAcciones> acciones = session.createQuery("FROM logacciones", LogAcciones.class).getResultList();
        trans.commit();
        return acciones;
    }

    @Override
    public LogAcciones encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        LogAcciones accion = session.createQuery("FROM logacciones WHERE idAccion=:id", LogAcciones.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return accion;
    }

    @Override
    public void actualizar(LogAcciones t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "La accion con ID: " + t.getIdAccion() + " ha sido actualizada");
        trans.commit();
    }

    @Override
    public void eliminar(LogAcciones t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "La accion con ID: " + t.getIdAccion() + " ha sido eliminada");
        trans.commit();
    }

}

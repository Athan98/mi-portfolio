package data;

import entidades.FormaDePago;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormaDePago_data implements Repository<FormaDePago> {

    private final Session session;

    public FormaDePago_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(FormaDePago t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<FormaDePago> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<FormaDePago> formasDePago = session.createQuery("FROM FormaDePago", FormaDePago.class).getResultList();
        trans.commit();
        return formasDePago;
    }

    @Override
    public FormaDePago encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        FormaDePago formaDePago = session.createQuery("FROM FormaDePago WHERE idFormaDePago=:id", FormaDePago.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return formaDePago;
    }

    @Override
    public void actualizar(FormaDePago t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(FormaDePago t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
    }

}

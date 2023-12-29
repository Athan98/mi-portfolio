package data;

import entidades.*;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormasDePagoPedidos_data implements Repository<FormasDePagoPedidos> {

    private final Session session;

    public FormasDePagoPedidos_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(FormasDePagoPedidos t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<FormasDePagoPedidos> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<FormasDePagoPedidos> fdpp = session.createQuery("FROM FormasDePagoPedidos", FormasDePagoPedidos.class).getResultList();
        trans.commit();
        return fdpp;
    }

    @Override
    public FormasDePagoPedidos encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        FormasDePagoPedidos fdpp = session.createQuery("FROM FormasDePagoPedidos WHERE idFormaDePagoPedido=:id", FormasDePagoPedidos.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return fdpp;
    }

    @Override
    public void actualizar(FormasDePagoPedidos t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(FormasDePagoPedidos t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
    }

   
}

package data;

import entidades.CalculoPedido;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CalculoPedido_data implements Repository<CalculoPedido> {

    private final Session session;

    public CalculoPedido_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(CalculoPedido t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<CalculoPedido> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<CalculoPedido> calculos = session.createQuery("FROM CalculoPedido", CalculoPedido.class).getResultList();
        trans.commit();
        return calculos;
    }

    @Override
    public CalculoPedido encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        CalculoPedido calculo = session.createQuery("FROM CalculoPedido WHERE idCalculoPedido=:id", CalculoPedido.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return calculo;
    }

    @Override
    public void actualizar(CalculoPedido t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(CalculoPedido t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
    }

}

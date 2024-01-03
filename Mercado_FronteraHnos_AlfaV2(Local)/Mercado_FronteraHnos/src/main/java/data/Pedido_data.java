package data;

import entidades.Pedido;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Pedido_data implements Repository<Pedido> {

    private final Session session;

    public Pedido_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Pedido t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<Pedido> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Pedido> pedidos = session.createQuery("FROM Pedido", Pedido.class).getResultList();
        trans.commit();
        return pedidos;
    }

    @Override
    public Pedido encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Pedido pedido = session.createQuery("FROM Pedido WHERE idPedido=:id", Pedido.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return pedido;
    }

    @Override
    public void actualizar(Pedido t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(Pedido t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        Transaction trans = session.beginTransaction();

        Pedido pedidoAEliminar = session.get(Pedido.class, id);

        if (pedidoAEliminar != null) {
            session.delete(pedidoAEliminar);
            JOptionPane.showMessageDialog(null, "El pedido con ID: " + id + " ha sido eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el pedido con ID: " + id);
        }

        trans.commit();
    }

}

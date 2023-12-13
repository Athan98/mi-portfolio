package data;

import entidades.DetallePedido;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetallePedido_data implements Repository<DetallePedido> {

    private final Session session;

    public DetallePedido_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(DetallePedido t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "El detalle de pedido ha sido agregado a la base de datos");
        trans.commit();
    }

    @Override
    public List<DetallePedido> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<DetallePedido> detallePedidos = session.createQuery("FROM DetallePedido", DetallePedido.class).getResultList();
        trans.commit();
        return detallePedidos;
    }

    @Override
    public DetallePedido encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        DetallePedido detallePedido = session.createQuery("FROM DetallePedido WHERE idPedido=:id", DetallePedido.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return detallePedido;
    }

    @Override
    public void actualizar(DetallePedido t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "El detalle de pedido ha sido actualizado");
        trans.commit();
    }

    @Override
    public void eliminar(DetallePedido t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "El detalle de pedido ha sido eliminado");
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

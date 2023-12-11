package data;

import entidades.DetalleVenta;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetalleVenta_data implements Repository<DetalleVenta> {

    private final Session session;

    public DetalleVenta_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(DetalleVenta t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "El detalle de venta ha sido agregado a la base de datos");
        trans.commit();
    }

    @Override
    public List<DetalleVenta> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<DetalleVenta> detallesVentas = session.createQuery("FROM DetalleVenta", DetalleVenta.class).getResultList();
        trans.commit();
        return detallesVentas;
    }

    @Override
    public DetalleVenta encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        DetalleVenta detalleVenta = session.createQuery("FROM DetalleVenta WHERE idVenta=:id", DetalleVenta.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return detalleVenta;
    }

    @Override
    public void actualizar(DetalleVenta t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "El detalle de venta ha sido actualizado");
        trans.commit();
    }

    @Override
    public void eliminar(DetalleVenta t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "El detalle de venta ha sido eliminado");
        trans.commit();
    }

}

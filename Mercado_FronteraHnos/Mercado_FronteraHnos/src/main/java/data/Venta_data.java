package data;

import entidades.Venta;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Venta_data implements Repository<Venta> {

    private final Session session;

    public Venta_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Venta t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "La venta ha sido agregada a la base de datos con el ID: " + t.getIdVenta());
        trans.commit();
    }

    @Override
    public List<Venta> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Venta> ventas = session.createQuery("FROM Venta", Venta.class).getResultList();
        trans.commit();
        return ventas;
    }

    @Override
    public Venta encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Venta venta = session.createQuery("FROM Venta WHERE idVenta=:id", Venta.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return venta;
    }

    @Override
    public void actualizar(Venta t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "La venta con ID: " + t.getIdVenta() + " ha sido actualizada");
        trans.commit();
    }

    @Override
    public void eliminar(Venta t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "La venta con ID: " + t.getIdVenta() + " ha sido eliminada");
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

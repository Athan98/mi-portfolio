package data;

import entidades.Proveedor;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Proveedor_data implements Repository<Proveedor> {

    private final Session session;

    public Proveedor_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Proveedor t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "El proveedor ha sido agregado a la base de datos con el ID: " + t.getIdProveedor());
        trans.commit();
    }

    @Override
    public List<Proveedor> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Proveedor> proveedores = session.createQuery("FROM Proveedor", Proveedor.class).getResultList();
        trans.commit();
        return proveedores;
    }

    @Override
    public Proveedor encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Proveedor proveedor = session.createQuery("FROM Proveedor WHERE idProveedor=:id", Proveedor.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return proveedor;
    }

    @Override
    public void actualizar(Proveedor t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "El proveedor con ID: " + t.getIdProveedor() + " ha sido actualizado");
        trans.commit();
    }

    @Override
    public void eliminar(Proveedor t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "El proveedor con ID: " + t.getIdProveedor() + " ha sido eliminado");
        trans.commit();
    }

}

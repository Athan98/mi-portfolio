package repositories;

import entidades.Vendedor;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VendedorData implements Repository<Vendedor> {

    private final Session session;

    public VendedorData(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Vendedor t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "El vendedor ha sigo agregado a la base de datos con el ID: " + t.getIdVendedor());
        trans.commit();

    }

    @Override
    public List<Vendedor> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Vendedor> vendedores = session.createQuery("FROM vendedor", Vendedor.class).getResultList();
        trans.commit();
        return vendedores;
    }

    @Override
    public Vendedor encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Vendedor vendedor = session.createQuery("FROM vendedor WHERE idVendedor=:id", Vendedor.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return vendedor;
    }

    @Override
    public void actualizar(Vendedor t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "El vendedor con ID: " + t.getIdVendedor() + " ha sido actualizado");
        trans.commit();
    }

    @Override
    public void eliminar(Vendedor t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "El vendedor con ID: " + t.getIdVendedor() + " ha sido eliminado");
        trans.commit();
    }

}

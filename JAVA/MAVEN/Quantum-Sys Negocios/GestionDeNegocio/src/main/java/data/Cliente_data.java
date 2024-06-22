package data;

import entidades.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Cliente_data implements Repository<Cliente> {

    private final Session session;

    public Cliente_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Cliente t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<Cliente> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Cliente> clientes = session.createQuery("FROM Cliente", Cliente.class).getResultList();
        trans.commit();
        return clientes;
    }

    @Override
    public Cliente encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Cliente cliente = session.createQuery("FROM Cliente WHERE idCliente=:id", Cliente.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return cliente;
    }

    @Override
    public void actualizar(Cliente t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(Cliente t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        Transaction trans = session.beginTransaction();

        Cliente clienteAEliminar = session.get(Cliente.class, id);

        if (clienteAEliminar != null) {
            session.delete(clienteAEliminar);
            JOptionPane.showMessageDialog(null, "El cliente con ID: " + id + " ha sido eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el cliente con ID: " + id);
        }

        trans.commit();
    }

}

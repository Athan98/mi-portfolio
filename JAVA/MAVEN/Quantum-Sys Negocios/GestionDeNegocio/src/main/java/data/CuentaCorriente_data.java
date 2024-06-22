package data;

import entidades.CuentaCorriente;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CuentaCorriente_data implements Repository<CuentaCorriente> {

    private final Session session;

    public CuentaCorriente_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(CuentaCorriente t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<CuentaCorriente> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<CuentaCorriente> cuentasCorrientes = session.createQuery("FROM CuentaCorriente", CuentaCorriente.class).getResultList();
        trans.commit();
        return cuentasCorrientes;
    }

    @Override
    public CuentaCorriente encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        CuentaCorriente ctaCte = session.createQuery("FROM CuentaCorriente WHERE idCtaCte=:id", CuentaCorriente.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return ctaCte;
    }

    @Override
    public void actualizar(CuentaCorriente t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(CuentaCorriente t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        Transaction trans = session.beginTransaction();

        CuentaCorriente ctaCteAEliminar = session.get(CuentaCorriente.class, id);

        if (ctaCteAEliminar != null) {
            session.delete(ctaCteAEliminar);
            JOptionPane.showMessageDialog(null, "La cuenta corriente con ID: " + id + " ha sido eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la cuenta corriente con ID: " + id);
        }

        trans.commit();
    }

}

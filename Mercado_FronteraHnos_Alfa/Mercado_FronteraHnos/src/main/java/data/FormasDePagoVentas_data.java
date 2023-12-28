package data;

import entidades.FormasDePagoVentas;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormasDePagoVentas_data implements Repository<FormasDePagoVentas> {

    private final Session session;

    public FormasDePagoVentas_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(FormasDePagoVentas t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "La FDPV ha sido agregada a la base de datos con el ID: " + t.getIdFormaDePagoVenta());
        trans.commit();
    }

    @Override
    public List<FormasDePagoVentas> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<FormasDePagoVentas> FDPventas = session.createQuery("FROM FormasDePagoVentas", FormasDePagoVentas.class).getResultList();
        trans.commit();
        return FDPventas;
    }

    @Override
    public FormasDePagoVentas encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        FormasDePagoVentas FDPventas = session.createQuery("FROM FormasDePagoVentas WHERE idFormaDePagoVenta=:id", FormasDePagoVentas.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return FDPventas;
    }

    @Override
    public void actualizar(FormasDePagoVentas t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "La FDPV con ID: " + t.getIdFormaDePagoVenta() + " ha sido actualizada");
        trans.commit();
    }

    @Override
    public void eliminar(FormasDePagoVentas t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "La FDPV con ID: " + t.getIdFormaDePagoVenta() + " ha sido eliminada");
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        Transaction trans = session.beginTransaction();

        FormasDePagoVentas FDPventaAEliminar = session.get(FormasDePagoVentas.class, id);

        if (FDPventaAEliminar != null) {
            session.delete(FDPventaAEliminar);
            JOptionPane.showMessageDialog(null, "La FDPV con ID: " + id + " ha sido eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la FDPV con ID: " + id);
        }

        trans.commit();
    }

}

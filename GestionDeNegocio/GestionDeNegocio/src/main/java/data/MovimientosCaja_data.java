package data;

import entidades.MovimientosCaja;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class MovimientosCaja_data implements Repository<MovimientosCaja> {

    private final Session session;

    public MovimientosCaja_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(MovimientosCaja t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<MovimientosCaja> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<MovimientosCaja> movimientos = session.createQuery("FROM MovimientosCaja", MovimientosCaja.class).getResultList();
        trans.commit();
        return movimientos;
    }

    @Override
    public MovimientosCaja encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        MovimientosCaja movimiento = session.createQuery("FROM MovimientosCaja WHERE idMovimientoCaja=:id", MovimientosCaja.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return movimiento;
    }

    @Override
    public void actualizar(MovimientosCaja t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(MovimientosCaja t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        Transaction trans = session.beginTransaction();

        MovimientosCaja movAEliminar = session.get(MovimientosCaja.class, id);

        if (movAEliminar != null) {
            session.delete(movAEliminar);
            JOptionPane.showMessageDialog(null, "El movimiento con ID: " + id + " ha sido eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el movimiento con ID: " + id);
        }

        trans.commit();
    }

    public MovimientosCaja obtenerUltimoMovimientoApertura() {
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<MovimientosCaja> criteriaQuery = builder.createQuery(MovimientosCaja.class);
            Root<MovimientosCaja> root = criteriaQuery.from(MovimientosCaja.class);

            // Agrega las restricciones para obtener el último movimiento de apertura
            criteriaQuery.select(root).where(builder.equal(root.get("operacion"), "APERTURA"))
                    .orderBy(builder.desc(root.get("fechaApertura")));

            Query<MovimientosCaja> query = session.createQuery(criteriaQuery);
            query.setMaxResults(1);

            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
            return null;
        }
    }

}

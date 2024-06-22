package data;

import entidades.Oferta;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Oferta_data implements Repository<Oferta> {

    private final Session session;

    public Oferta_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Oferta t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<Oferta> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Oferta> ofertas = session.createQuery("FROM Oferta", Oferta.class).getResultList();
        trans.commit();
        return ofertas;
    }

    @Override
    public Oferta encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Oferta oferta = session.createQuery("FROM Oferta WHERE idOferta=:id", Oferta.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return oferta;
    }

    @Override
    public void actualizar(Oferta t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(Oferta t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        Transaction trans = session.beginTransaction();

        Oferta ofertaAEliminar = session.get(Oferta.class, id);

        if (ofertaAEliminar != null) {
            session.delete(ofertaAEliminar);
            JOptionPane.showMessageDialog(null, "La oferta con ID: " + id + " ha sido eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la oferta con ID: " + id);
        }

        trans.commit();
    }

}

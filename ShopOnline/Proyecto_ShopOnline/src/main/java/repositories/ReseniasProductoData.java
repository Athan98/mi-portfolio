package repositories;

import entidades.ReseniasProducto;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReseniasProductoData implements Repository<ReseniasProducto> {

    private final Session session;

    public ReseniasProductoData(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(ReseniasProducto t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "La reseña ha sido agregada a la base de datos con el ID: " + t.getIdResenias());
        trans.commit();
    }

    @Override
    public List<ReseniasProducto> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<ReseniasProducto> resenias = session.createQuery("FROM reseniasproducto", ReseniasProducto.class).getResultList();
        trans.commit();
        return resenias;
    }

    @Override
    public ReseniasProducto encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        ReseniasProducto resenia = session.createQuery("FROM reseniasproducto WHERE idResenias=:id", ReseniasProducto.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return resenia;
    }

    @Override
    public void actualizar(ReseniasProducto t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "La reseña con ID: " + t.getIdResenias() + " ha sido actualizada");
        trans.commit();
    }

    @Override
    public void eliminar(ReseniasProducto t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "La reseña con ID: " + t.getIdResenias() + " ha sido eliminada");
        trans.commit();
    }

}

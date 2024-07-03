package repositories;

import entidades.*;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoriaData implements Repository<Categoria> {

    private final Session session;

    public CategoriaData(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Categoria t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "La categoria ha sido agregada a la base de datos con el ID: " + t.getIdCategoria());
        trans.commit();
    }

    @Override
    public List<Categoria> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Categoria> categorias = session.createQuery("FROM categoria", Categoria.class).getResultList();
        trans.commit();
        return categorias;
    }

    @Override
    public Categoria encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Categoria categoria = session.createQuery("FROM categoria WHERE idCategoria=:id", Categoria.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return categoria;
    }

    @Override
    public void actualizar(Categoria t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "La categoria con ID: " + t.getIdCategoria() + " ha sido actualizada");
        trans.commit();
    }

    @Override
    public void eliminar(Categoria t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "La categoria con ID: " + t.getIdCategoria() + " ha sido eliminada");
        trans.commit();
    }

}

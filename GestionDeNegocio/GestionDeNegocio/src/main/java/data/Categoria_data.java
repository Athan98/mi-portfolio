package data;

import entidades.Categoria;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Categoria_data implements Repository<Categoria> {

    private final Session session;

    public Categoria_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Categoria t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<Categoria> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Categoria> categorias = session.createQuery("FROM Categoria", Categoria.class).getResultList();
        trans.commit();
        return categorias;
    }

    @Override
    public Categoria encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Categoria categoria = session.createQuery("FROM Categoria WHERE idCategoria=:id", Categoria.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return categoria;
    }

    @Override
    public void actualizar(Categoria t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(Categoria t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

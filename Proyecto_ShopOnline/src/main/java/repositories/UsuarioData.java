package repositories;

import entidades.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioData implements Repository<Usuario> {

    private final Session session;

    public UsuarioData(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Usuario t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "El usuario ha sido agregado a la base de datos con el ID: " + t.getIdUsuario());
        trans.commit();
    }

    @Override
    public List<Usuario> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Usuario> usuarios = session.createQuery("FROM usuario", Usuario.class).getResultList();
        trans.commit();
        return usuarios;
    }

    @Override
    public Usuario encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Usuario user = session.createQuery("FROM usuario WHERE idUsuario=:id", Usuario.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return user;
    }

    @Override
    public void actualizar(Usuario t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "El usuario con ID: " + t.getIdUsuario() + " ha sido actualizado");
        trans.commit();
    }

    @Override
    public void eliminar(Usuario t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "El usuario con ID: " + t.getIdUsuario() + " ha sido eliminado");
        trans.commit();
    }

}

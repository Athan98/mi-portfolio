package data;

import entidades.Licencia;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Licencia_data implements Repository<Licencia> {

    private final Session session;

    public Licencia_data(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(Licencia t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        trans.commit();
    }

    @Override
    public List<Licencia> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<Licencia> licencias = session.createQuery("FROM Licencia", Licencia.class).getResultList();
        trans.commit();
        return licencias;
    }

    @Override
    public Licencia encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        Licencia lic = session.createQuery("FROM Licencia WHERE idLicencia=:id", Licencia.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return lic;
    }

    @Override
    public void actualizar(Licencia t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        trans.commit();
    }

    @Override
    public void eliminar(Licencia t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        trans.commit();
    }

    @Override
    public void eliminarPorID(int id) {

    }

}

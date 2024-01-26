package repositories;

import entidades.CarritoCompras;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarritoComprasData implements Repository<CarritoCompras> {

    private final Session session;

    public CarritoComprasData(Session session) {
        this.session = session;
    }

    @Override
    public void agregar(CarritoCompras t) {
        Transaction trans = session.beginTransaction();
        session.save(t);
        JOptionPane.showMessageDialog(null, "El carrito de compras ha sido agregado a la base de datos con el ID: " + t.getIdCarro());
        trans.commit();
    }

    @Override
    public List<CarritoCompras> listarTodo() {
        Transaction trans = session.beginTransaction();
        List<CarritoCompras> carritos = session.createQuery("FROM carritocompras", CarritoCompras.class).getResultList();
        trans.commit();
        return carritos;
    }

    @Override
    public CarritoCompras encontrarPorID(int id) {
        Transaction trans = session.beginTransaction();
        CarritoCompras carrito = session.createQuery("FROM carritocompras WHERE idCarro=:id", CarritoCompras.class).setParameter("id", id).getSingleResult();
        trans.commit();
        return carrito;
    }

    @Override
    public void actualizar(CarritoCompras t) {
        Transaction trans = session.beginTransaction();
        session.update(t);
        JOptionPane.showMessageDialog(null, "El carrito con ID: " + t.getIdCarro() + " ha sido actualizado");
        trans.commit();
    }

    @Override
    public void eliminar(CarritoCompras t) {
        Transaction trans = session.beginTransaction();
        session.delete(t);
        JOptionPane.showMessageDialog(null, "El carrito con ID: " + t.getIdCarro() + " ha sido eliminado");
        trans.commit();
    }

}

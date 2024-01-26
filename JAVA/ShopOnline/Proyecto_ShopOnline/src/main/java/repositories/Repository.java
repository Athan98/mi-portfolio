
package repositories;

import java.util.List;


public interface Repository<T> {
    void agregar(T t);
    List<T> listarTodo();
    T encontrarPorID(int id);
    void actualizar(T t);
    void eliminar(T t);
}

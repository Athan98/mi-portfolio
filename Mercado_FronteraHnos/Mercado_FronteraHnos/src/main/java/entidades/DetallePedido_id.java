
package entidades;

import javax.persistence.*;


@Embeddable

public class DetallePedido_id {
    
    @Column(name = "idPedido")
    private int idPedido;

    @Column(name = "idProducto")
    private int idProducto;

    public DetallePedido_id() {
    }

    public DetallePedido_id(int idPedido, int idProducto) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "DetallePedido_id{" + "idPedido=" + idPedido + ", idProducto=" + idProducto + '}';
    }
 
}

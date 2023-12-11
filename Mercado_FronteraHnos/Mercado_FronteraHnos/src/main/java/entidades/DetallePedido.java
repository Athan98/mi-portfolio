package entidades;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name = "detallepedido")
public class DetallePedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetallePedido")
    private int idDetallePedido;

    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precioCosto", nullable = false)
    private Double precioCosto;

    public DetallePedido(Pedido pedido, Producto producto, int cantidad, Double precioCosto) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
    }

    public DetallePedido() {
    }

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "idDetallePedido=" + idDetallePedido + ", pedido=" + pedido + ", producto=" + producto + ", cantidad=" + cantidad + ", precioCosto=" + precioCosto + '}';
    }

}

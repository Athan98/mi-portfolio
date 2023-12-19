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
    @JoinColumn(name = "idProveedor", nullable = false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio", nullable = false)
    private Double precio;

    public DetallePedido(int idDetallePedido, Pedido pedido, Proveedor proveedor, Producto producto, int cantidad, Double precio) {
        this.idDetallePedido = idDetallePedido;
        this.pedido = pedido;
        this.proveedor = proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public DetallePedido(Pedido pedido, Proveedor proveedor, Producto producto, int cantidad, Double precio) {
        this.pedido = pedido;
        this.proveedor = proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "idDetallePedido=" + idDetallePedido + ", pedido=" + pedido + ", proveedor=" + proveedor + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

}

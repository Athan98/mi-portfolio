
package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class DetalleOrden implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleOrden;
    
    @ManyToOne(cascade = CascadeType.ALL) // Manejo de cascada en la relación con Orden
    @JoinColumn(name = "idOrden", nullable = false)
    private Orden orden;
    
    @ManyToOne(cascade = CascadeType.ALL) // Manejo de cascada en la relación con Producto
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;
    
    @Column(nullable = false)
    private int cantidad;
    
    @Column(nullable = false)
    private double precioUnitario;

    public DetalleOrden(Orden orden, Producto producto, int cantidad, double precioUnitario) {
        this.orden = orden;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public DetalleOrden() {
    }

    public int getIdDetalleOrden() {
        return idDetalleOrden;
    }

    public void setIdDetalleOrden(int idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "DetalleOrden{" + "idDetalleOrden=" + idDetalleOrden + ", orden=" + orden + ", producto=" + producto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }
 
}

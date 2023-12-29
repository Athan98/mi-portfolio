package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "detalleventa")
public class DetalleVenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleVenta")
    private int idDetalleVenta;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "idVenta", nullable = true)
    private Venta venta;
    
    @Column(name = "precio", nullable = false)
    private Double precio;

    public DetalleVenta(int idDetalleVenta, Producto producto, int cantidad, Venta venta, Double precio) {
        this.idDetalleVenta = idDetalleVenta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.venta = venta;
        this.precio = precio;
    }

    public DetalleVenta(Producto producto, int cantidad, Venta venta, Double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.venta = venta;
        this.precio = precio;
    }

    public DetalleVenta() {
    }


    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", producto=" + producto + ", cantidad=" + cantidad + ", venta=" + venta + ", precio=" + precio + '}';
    }

    
    
}

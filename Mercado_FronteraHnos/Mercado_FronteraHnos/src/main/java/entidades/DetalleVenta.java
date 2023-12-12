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
    @JoinColumn(name = "idVenta", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "idFormaDePago", nullable = false)
    private FormaDePago formaDePago;

    public DetalleVenta(Venta venta, Producto producto, int cantidad, FormaDePago formaDePago) {
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.formaDePago = formaDePago;
    }

    public DetalleVenta() {
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", venta=" + venta + ", producto=" + producto + ", cantidad=" + cantidad + ", formaDePago=" + formaDePago + '}';
    }

}

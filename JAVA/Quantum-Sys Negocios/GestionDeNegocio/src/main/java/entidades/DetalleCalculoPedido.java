package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "detalleCalculoPedido")
public class DetalleCalculoPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleCalculoPedido")
    private int idDCP;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "idCalculoPedido", nullable = true)
    private CalculoPedido cp;

    @Column(name = "costoDetalle", nullable = false)
    private Double costoDetalle;

    public DetalleCalculoPedido(int idDCP, Producto producto, int cantidad, CalculoPedido cp, Double costoDetalle) {
        this.idDCP = idDCP;
        this.producto = producto;
        this.cantidad = cantidad;
        this.cp = cp;
        this.costoDetalle = costoDetalle;
    }

    public DetalleCalculoPedido(Producto producto, int cantidad, CalculoPedido cp, Double costoDetalle) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.cp = cp;
        this.costoDetalle = costoDetalle;
    }

    public DetalleCalculoPedido() {
    }

    public int getIdDCP() {
        return idDCP;
    }

    public void setIdDCP(int idDCP) {
        this.idDCP = idDCP;
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

    public CalculoPedido getCp() {
        return cp;
    }

    public void setCp(CalculoPedido cp) {
        this.cp = cp;
    }

    public Double getCostoDetalle() {
        return costoDetalle;
    }

    public void setCostoDetalle(Double costoDetalle) {
        this.costoDetalle = costoDetalle;
    }

    @Override
    public String toString() {
        return "DetalleCalculoPedido{" + "idDCP=" + idDCP + ", producto=" + producto + ", cantidad=" + cantidad + ", cp=" + cp + ", costoDetalle=" + costoDetalle + '}';
    }

}

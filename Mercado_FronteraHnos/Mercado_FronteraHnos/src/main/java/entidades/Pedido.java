package entidades;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private int idPedido;

    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false)
    private Proveedor proveedor;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "precioTotalCosto", nullable = false)
    private Double precioTotalCosto;

    public Pedido(Proveedor proveedor, Date fecha, Double precioTotalCosto) {
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.precioTotalCosto = precioTotalCosto;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioTotalCosto() {
        return precioTotalCosto;
    }

    public void setPrecioTotalCosto(Double precioTotalCosto) {
        this.precioTotalCosto = precioTotalCosto;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", proveedor=" + proveedor + ", fecha=" + fecha + ", precioTotalCosto=" + precioTotalCosto + '}';
    }

}

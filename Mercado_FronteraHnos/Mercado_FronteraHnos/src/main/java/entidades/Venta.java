package entidades;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private int idVenta;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "precioTotalVenta", nullable = false)
    private Double precioTotalVenta;

    public Venta(Usuario usuario, Date fecha, Double precioTotalVenta) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.precioTotalVenta = precioTotalVenta;
    }

    public Venta() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioTotalVenta() {
        return precioTotalVenta;
    }

    public void setPrecioTotalVenta(Double precioTotalVenta) {
        this.precioTotalVenta = precioTotalVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", usuario=" + usuario + ", fecha=" + fecha + ", precioTotalVenta=" + precioTotalVenta + '}';
    }

}

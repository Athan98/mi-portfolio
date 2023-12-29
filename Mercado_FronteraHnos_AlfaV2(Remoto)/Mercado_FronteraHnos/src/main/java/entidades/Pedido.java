package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private int idPedido;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "precioTotalCosto", nullable = false)
    private Double precioTotalCosto;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false)
    private Proveedor prov;
    
    @ManyToOne
    @JoinColumn(name = "idFormaDePago", nullable = false)
    private FormaDePago fdp;

    public Pedido(int idPedido, Date fecha, Double precioTotalCosto, Usuario usuario, Proveedor prov, FormaDePago fdp) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.precioTotalCosto = precioTotalCosto;
        this.usuario = usuario;
        this.prov = prov;
        this.fdp = fdp;
    }

    public Pedido(Date fecha, Double precioTotalCosto, Usuario usuario, Proveedor prov, FormaDePago fdp) {
        this.fecha = fecha;
        this.precioTotalCosto = precioTotalCosto;
        this.usuario = usuario;
        this.prov = prov;
        this.fdp = fdp;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Proveedor getProv() {
        return prov;
    }

    public void setProv(Proveedor prov) {
        this.prov = prov;
    }

    public FormaDePago getFdp() {
        return fdp;
    }

    public void setFdp(FormaDePago fdp) {
        this.fdp = fdp;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", fecha=" + fecha + ", precioTotalCosto=" + precioTotalCosto + ", usuario=" + usuario + ", prov=" + prov + ", fdp=" + fdp + '}';
    }

}

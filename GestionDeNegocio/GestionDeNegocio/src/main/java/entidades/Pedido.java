package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "estado")
    private boolean estado;

    public Pedido(int idPedido, Date fecha, Double precioTotalCosto, Usuario usuario, Proveedor prov, FormaDePago fdp, boolean estado) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.precioTotalCosto = precioTotalCosto;
        this.usuario = usuario;
        this.prov = prov;
        this.fdp = fdp;
        this.estado = estado;
    }

    public Pedido(Date fecha, Double precioTotalCosto, Usuario usuario, Proveedor prov, FormaDePago fdp, boolean estado) {
        this.fecha = fecha;
        this.precioTotalCosto = precioTotalCosto;
        this.usuario = usuario;
        this.prov = prov;
        this.fdp = fdp;
        this.estado = estado;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}

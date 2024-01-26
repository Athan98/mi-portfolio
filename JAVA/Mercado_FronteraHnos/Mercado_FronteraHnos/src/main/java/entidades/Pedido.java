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

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detallesPedido = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public Pedido(int idPedido, Date fecha, List<DetallePedido> detallesPedido, Double precioTotalCosto, Usuario usuario) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.detallesPedido = detallesPedido;
        this.precioTotalCosto = precioTotalCosto;
        this.usuario = usuario;
    }

    public Pedido(Date fecha, List<DetallePedido> detallesPedido, Double precioTotalCosto, Usuario usuario) {
        this.fecha = fecha;
        this.detallesPedido = detallesPedido;
        this.precioTotalCosto = precioTotalCosto;
        this.usuario = usuario;
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

    public List<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", fecha=" + fecha + ", precioTotalCosto=" + precioTotalCosto + ", detallesPedido=" + detallesPedido + ", usuario=" + usuario + '}';
    }

}

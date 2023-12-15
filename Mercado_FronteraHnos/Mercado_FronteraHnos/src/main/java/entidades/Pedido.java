package entidades;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "idFormaDePago", nullable = false)
    private FormaDePago formaDePago;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detallesPedido = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public Pedido(int idPedido, Proveedor proveedor, Date fecha, Double precioTotalCosto, FormaDePago formaDePago, Usuario usuario) {
        this.idPedido = idPedido;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.precioTotalCosto = precioTotalCosto;
        this.formaDePago = formaDePago;
        this.usuario = usuario;
    }

    public Pedido(Proveedor proveedor, Date fecha, Double precioTotalCosto, FormaDePago formaDePago, Usuario usuario) {
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.precioTotalCosto = precioTotalCosto;
        this.formaDePago = formaDePago;
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

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
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
        return "Pedido{" + "idPedido=" + idPedido + ", proveedor=" + proveedor + ", fecha=" + fecha + ", precioTotalCosto=" + precioTotalCosto + ", formaDePago=" + formaDePago + ", detallesPedido=" + detallesPedido + ", usuario=" + usuario + '}';
    }

}

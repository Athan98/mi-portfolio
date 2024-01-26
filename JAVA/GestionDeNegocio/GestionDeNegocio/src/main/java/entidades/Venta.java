package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "venta")
public class Venta implements Serializable {

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

    @Column(name = "cliente", nullable = false)
    private String cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detallesVenta = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idFormaDePago", nullable = false)
    private FormaDePago formaDePago;

    @ManyToOne
    @JoinColumn(name = "idCaja")
    private Caja caja;

    public Venta(int idVenta, Usuario usuario, Date fecha, Double precioTotalVenta, String cliente, List<DetalleVenta> dv, FormaDePago formaDePago, Caja caja) {
        this.idVenta = idVenta;
        this.usuario = usuario;
        this.fecha = fecha;
        this.precioTotalVenta = precioTotalVenta;
        this.cliente = cliente;
        this.detallesVenta = dv;
        this.formaDePago = formaDePago;
        this.caja = caja;
    }

    public Venta(Usuario usuario, Date fecha, Double precioTotalVenta, String cliente, List<DetalleVenta> dv, FormaDePago formaDePago, Caja caja) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.precioTotalVenta = precioTotalVenta;
        this.cliente = cliente;
        this.detallesVenta = dv;
        this.formaDePago = formaDePago;
        this.caja = caja;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

}

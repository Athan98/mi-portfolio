package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "calculopedido")
public class CalculoPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCalculoPedido")
    private int idCP;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "cp", cascade = CascadeType.ALL)
    private List<DetalleCalculoPedido> detalles = new ArrayList<>();

    public CalculoPedido(int idCP, Date fecha, Double total, boolean estado, Usuario usuario) {
        this.idCP = idCP;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.usuario = usuario;
    }

    public CalculoPedido(Date fecha, Double total, boolean estado, Usuario usuario) {
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.usuario = usuario;
    }

    public CalculoPedido() {
    }

    public int getIdCP() {
        return idCP;
    }

    public void setIdCP(int idCP) {
        this.idCP = idCP;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetalleCalculoPedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCalculoPedido> detalles) {
        this.detalles = detalles;
    }

}

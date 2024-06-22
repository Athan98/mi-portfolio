package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "cuentaCorriente")
public class CuentaCorriente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCtaCte")
    private int idCtaCte;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @Column(name = "montoTotal", nullable = false)
    private Double montoTotal;

    @OneToMany(mappedBy = "ctaCte", cascade = CascadeType.ALL)
    private List<DetallesCtaCte> detalles = new ArrayList<>();

    @Column(name = "estado", nullable = false)
    private String estado;

    public CuentaCorriente(int idCtaCte, Cliente cliente, Double montoTotal, String estado) {
        this.idCtaCte = idCtaCte;
        this.cliente = cliente;
        this.montoTotal = montoTotal;
        this.estado = estado;
    }

    public CuentaCorriente(Cliente cliente, Double montoTotal, String estado) {
        this.cliente = cliente;
        this.montoTotal = montoTotal;
        this.estado = estado;
    }

    public CuentaCorriente() {
    }

    public int getIdCtaCte() {
        return idCtaCte;
    }

    public void setIdCtaCte(int idCtaCte) {
        this.idCtaCte = idCtaCte;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<DetallesCtaCte> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallesCtaCte> detalles) {
        this.detalles = detalles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" + "cliente=" + cliente + ", montoTotal=" + montoTotal + '}';
    }

}

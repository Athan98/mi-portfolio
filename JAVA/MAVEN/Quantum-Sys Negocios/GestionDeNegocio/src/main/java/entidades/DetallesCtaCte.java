package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "detallesCtaCte")
public class DetallesCtaCte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetallesCtaCte")
    private int idDetallesCtaCte;

    @ManyToOne
    @JoinColumn(name = "idVenta", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idCtaCte", nullable = false)
    private CuentaCorriente ctaCte;

    public DetallesCtaCte(int idDetallesCtaCte, Venta venta, CuentaCorriente ctaCte) {
        this.idDetallesCtaCte = idDetallesCtaCte;
        this.venta = venta;
        this.ctaCte = ctaCte;
    }

    public DetallesCtaCte(Venta venta, CuentaCorriente ctaCte) {
        this.venta = venta;
        this.ctaCte = ctaCte;
    }

    public DetallesCtaCte() {
    }

    public int getIdDetallesCtaCte() {
        return idDetallesCtaCte;
    }

    public void setIdDetallesCtaCte(int idDetallesCtaCte) {
        this.idDetallesCtaCte = idDetallesCtaCte;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public CuentaCorriente getCtaCte() {
        return ctaCte;
    }

    public void setCtaCte(CuentaCorriente ctaCte) {
        this.ctaCte = ctaCte;
    }

}

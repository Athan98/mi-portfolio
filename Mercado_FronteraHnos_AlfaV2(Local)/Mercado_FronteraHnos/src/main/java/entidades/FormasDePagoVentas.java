package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "formasDePagoVentas")
public class FormasDePagoVentas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFormaDePagoVenta")
    private int idFormaDePagoVenta;

    @OneToOne
    @JoinColumn(name = "forma1", nullable = false)
    private FormaDePago fpd1;

    @Column(name = "montoFDP1", nullable = false)
    private Double montoFDP1;

    @OneToOne
    @JoinColumn(name = "forma2")
    private FormaDePago fpd2;

    @Column(name = "montoFDP2")
    private Double montoFDP2;

    @OneToOne
    @JoinColumn(name = "idVenta")
    private Venta venta;

    public FormasDePagoVentas(int idFormaDePagoVenta, FormaDePago fpd1, Double montoFDP1, FormaDePago fpd2, Double montoFDP2, Venta venta) {
        this.idFormaDePagoVenta = idFormaDePagoVenta;
        this.fpd1 = fpd1;
        this.montoFDP1 = montoFDP1;
        this.fpd2 = fpd2;
        this.montoFDP2 = montoFDP2;
        this.venta = venta;
    }

    public FormasDePagoVentas(int idFormaDePagoVenta, FormaDePago fpd1, Double montoFDP1, Venta venta) {
        this.idFormaDePagoVenta = idFormaDePagoVenta;
        this.fpd1 = fpd1;
        this.montoFDP1 = montoFDP1;
        this.venta = venta;
    }

    public FormasDePagoVentas(FormaDePago fpd1, Double montoFDP1, Venta venta) {
        this.fpd1 = fpd1;
        this.montoFDP1 = montoFDP1;
        this.venta = venta;
    }

    public FormasDePagoVentas() {
    }

    public FormasDePagoVentas(FormaDePago fpd1, Double montoFDP1, FormaDePago fpd2, Double montoFDP2, Venta venta) {
        this.fpd1 = fpd1;
        this.montoFDP1 = montoFDP1;
        this.fpd2 = fpd2;
        this.montoFDP2 = montoFDP2;
        this.venta = venta;
    }

    public int getIdFormaDePagoVenta() {
        return idFormaDePagoVenta;
    }

    public void setIdFormaDePagoVenta(int idFormaDePagoVenta) {
        this.idFormaDePagoVenta = idFormaDePagoVenta;
    }

    public FormaDePago getFpd1() {
        return fpd1;
    }

    public void setFpd1(FormaDePago fpd1) {
        this.fpd1 = fpd1;
    }

    public Double getMontoFDP1() {
        return montoFDP1;
    }

    public void setMontoFDP1(Double montoFDP1) {
        this.montoFDP1 = montoFDP1;
    }

    public FormaDePago getFpd2() {
        return fpd2;
    }

    public void setFpd2(FormaDePago fpd2) {
        this.fpd2 = fpd2;
    }

    public Double getMontoFDP2() {
        return montoFDP2;
    }

    public void setMontoFDP2(Double montoFDP2) {
        this.montoFDP2 = montoFDP2;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "FormasDePagoVentas{" + "idFormaDePagoVenta=" + idFormaDePagoVenta + ", fpd1=" + fpd1 + ", montoFDP1=" + montoFDP1 + ", fpd2=" + fpd2 + ", montoFDP2=" + montoFDP2 + ", venta=" + venta + '}';
    }

}

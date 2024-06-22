
package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "formasDePagoPedidos")
public class FormasDePagoPedidos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFormaDePagoPedido")
    private int idFormaDePagoPedido;

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
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    public FormasDePagoPedidos(int idFormaDePagoPedido, FormaDePago fpd1, Double montoFDP1, FormaDePago fpd2, Double montoFDP2, Pedido pedido) {
        this.idFormaDePagoPedido = idFormaDePagoPedido;
        this.fpd1 = fpd1;
        this.montoFDP1 = montoFDP1;
        this.fpd2 = fpd2;
        this.montoFDP2 = montoFDP2;
        this.pedido = pedido;
    }

    public FormasDePagoPedidos(FormaDePago fpd1, Double montoFDP1, FormaDePago fpd2, Double montoFDP2, Pedido pedido) {
        this.fpd1 = fpd1;
        this.montoFDP1 = montoFDP1;
        this.fpd2 = fpd2;
        this.montoFDP2 = montoFDP2;
        this.pedido = pedido;
    }

    public FormasDePagoPedidos(FormaDePago fpd1, Double montoFDP1, Pedido pedido) {
        this.fpd1 = fpd1;
        this.montoFDP1 = montoFDP1;
        this.pedido = pedido;
    }

    public FormasDePagoPedidos() {
    }

    public int getIdFormaDePagoPedido() {
        return idFormaDePagoPedido;
    }

    public void setIdFormaDePagoPedido(int idFormaDePagoPedido) {
        this.idFormaDePagoPedido = idFormaDePagoPedido;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "FormasDePagoPedidos{" + "idFormaDePagoPedido=" + idFormaDePagoPedido + ", fpd1=" + fpd1 + ", montoFDP1=" + montoFDP1 + ", fpd2=" + fpd2 + ", montoFDP2=" + montoFDP2 + ", pedido=" + pedido + '}';
    }
 
}

package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "oferta")
public class Oferta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOferta")
    private int idOferta;

    @Column(name = "numeroPaquetes", nullable = false)
    private int numPaquetes;

    @Column(name = "tasaDescuento", nullable = false)
    private float tasaDesc;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "precioFinalUnitario", nullable = false)
    private float precioFinalUnitario;

    @Column(name = "precioFinalPack", nullable = false)
    private float precioFinalPack;

    @Column(name = "precioFinalTotal", nullable = false)
    private float precioFinalTotal;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    public Oferta(int idOferta, int numPaquetes, float tasaDesc, Date fecha, float precioFinalUnitario, float precioFinalPack, float precioFinalTotal, Producto producto, Proveedor proveedor) {
        this.idOferta = idOferta;
        this.numPaquetes = numPaquetes;
        this.tasaDesc = tasaDesc;
        this.fecha = fecha;
        this.precioFinalUnitario = precioFinalUnitario;
        this.precioFinalPack = precioFinalPack;
        this.precioFinalTotal = precioFinalTotal;
        this.producto = producto;
        this.proveedor = proveedor;
    }

    public Oferta(int numPaquetes, float tasaDesc, Date fecha, float precioFinalUnitario, float precioFinalPack, float precioFinalTotal, Producto producto, Proveedor proveedor) {
        this.numPaquetes = numPaquetes;
        this.tasaDesc = tasaDesc;
        this.fecha = fecha;
        this.precioFinalUnitario = precioFinalUnitario;
        this.precioFinalPack = precioFinalPack;
        this.precioFinalTotal = precioFinalTotal;
        this.producto = producto;
        this.proveedor = proveedor;
    }

    public Oferta() {
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public int getNumPaquetes() {
        return numPaquetes;
    }

    public void setNumPaquetes(int numPaquetes) {
        this.numPaquetes = numPaquetes;
    }

    public float getTasaDesc() {
        return tasaDesc;
    }

    public void setTasaDesc(float tasaDesc) {
        this.tasaDesc = tasaDesc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecioFinalUnitario() {
        return precioFinalUnitario;
    }

    public void setPrecioFinalUnitario(float precioFinalUnitario) {
        this.precioFinalUnitario = precioFinalUnitario;
    }

    public float getPrecioFinalPack() {
        return precioFinalPack;
    }

    public void setPrecioFinalPack(float precioFinalPack) {
        this.precioFinalPack = precioFinalPack;
    }

    public float getPrecioFinalTotal() {
        return precioFinalTotal;
    }

    public void setPrecioFinalTotal(float precioFinalTotal) {
        this.precioFinalTotal = precioFinalTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Oferta{" + "idOferta=" + idOferta + ", numPaquetes=" + numPaquetes + ", tasaDesc=" + tasaDesc + ", fecha=" + fecha + ", precioFinalUnitario=" + precioFinalUnitario + ", precioFinalPack=" + precioFinalPack + ", precioFinalTotal=" + precioFinalTotal + ", producto=" + producto + ", proveedor=" + proveedor + '}';
    }

}

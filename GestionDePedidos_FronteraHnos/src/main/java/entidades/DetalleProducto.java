package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "detalleproducto")
public class DetalleProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleProducto")
    private int idDetalleProducto;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    @Column(name = "precioCosto")
    private float precioCosto;

    @Column(name = "unidadesPorPaquete")
    private int unidadesPorPaquete;

    @Column(name = "precioPorPaquete")
    private float precioPorPaquete;

    @ManyToOne
    @JoinColumn(name = "idOferta")
    private Oferta oferta;

    public DetalleProducto(int idDetalleProducto, Producto producto, Proveedor proveedor, float precioCosto, int unidadesPorPaquete, float precioPorPaquete, Oferta oferta) {
        this.idDetalleProducto = idDetalleProducto;
        this.producto = producto;
        this.proveedor = proveedor;
        this.precioCosto = precioCosto;
        this.unidadesPorPaquete = unidadesPorPaquete;
        this.precioPorPaquete = precioPorPaquete;
        this.oferta = oferta;
    }

    public DetalleProducto(Producto producto, Proveedor proveedor, float precioCosto, int unidadesPorPaquete, float precioPorPaquete, Oferta oferta) {
        this.producto = producto;
        this.proveedor = proveedor;
        this.precioCosto = precioCosto;
        this.unidadesPorPaquete = unidadesPorPaquete;
        this.precioPorPaquete = precioPorPaquete;
        this.oferta = oferta;
    }

    public DetalleProducto(Producto producto, Proveedor proveedor, float precioCosto, int unidadesPorPaquete, float precioPorPaquete) {
        this.producto = producto;
        this.proveedor = proveedor;
        this.precioCosto = precioCosto;
        this.unidadesPorPaquete = unidadesPorPaquete;
        this.precioPorPaquete = precioPorPaquete;
    }

    public DetalleProducto(int idDetalleProducto, Producto producto, Proveedor proveedor, float precioCosto, int unidadesPorPaquete, float precioPorPaquete) {
        this.idDetalleProducto = idDetalleProducto;
        this.producto = producto;
        this.proveedor = proveedor;
        this.precioCosto = precioCosto;
        this.unidadesPorPaquete = unidadesPorPaquete;
        this.precioPorPaquete = precioPorPaquete;
    }
    

    public DetalleProducto() {
    }

    public int getIdDetalleProducto() {
        return idDetalleProducto;
    }

    public void setIdDetalleProducto(int idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
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

    public float getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getUnidadesPorPaquete() {
        return unidadesPorPaquete;
    }

    public void setUnidadesPorPaquete(int unidadesPorPaquete) {
        this.unidadesPorPaquete = unidadesPorPaquete;
    }

    public float getPrecioPorPaquete() {
        return precioPorPaquete;
    }

    public void setPrecioPorPaquete(float precioPorPaquete) {
        this.precioPorPaquete = precioPorPaquete;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    @Override
    public String toString() {
        return "DetalleProducto{" + "idDetalleProducto=" + idDetalleProducto + ", producto=" + producto + ", proveedor=" + proveedor + ", precioCosto=" + precioCosto + ", unidadesPorPaquete=" + unidadesPorPaquete + ", precioPorPaquete=" + precioPorPaquete + ", oferta=" + oferta + '}';
    }

}

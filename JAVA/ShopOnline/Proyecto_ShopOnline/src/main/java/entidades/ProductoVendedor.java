package entidades;

import javax.persistence.*;

@Entity
@Table
public class ProductoVendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idProductosVendedor;

    @ManyToOne(cascade = CascadeType.ALL) // Puedes ajustar el tipo de cascada según tus necesidades
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVendedor", nullable = false)
    private Vendedor vendedor;

    @Column(nullable = false)
    private int cantidadDisponible;

    @Column
    private String informacionEnvio;

    public ProductoVendedor(Producto producto, Vendedor vendedor, int cantidadDisponible, String informacionEnvio) {
        this.producto = producto;
        this.vendedor = vendedor;
        this.cantidadDisponible = cantidadDisponible;
        this.informacionEnvio = informacionEnvio;
    }

    public ProductoVendedor() {
    }

    public int getIdProductosVendedor() {
        return idProductosVendedor;
    }

    public void setIdProductosVendedor(int idProductosVendedor) {
        this.idProductosVendedor = idProductosVendedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getInformacionEnvio() {
        return informacionEnvio;
    }

    public void setInformacionEnvio(String informacionEnvio) {
        this.informacionEnvio = informacionEnvio;
    }

    @Override
    public String toString() {
        return "ProductoVendedor{" + "idProductosVendedor=" + idProductosVendedor + ", producto=" + producto + ", vendedor=" + vendedor + ", cantidadDisponible=" + cantidadDisponible + ", informacionEnvio=" + informacionEnvio + '}';
    }

}

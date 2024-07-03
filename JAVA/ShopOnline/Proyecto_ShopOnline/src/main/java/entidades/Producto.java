package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    @Column(nullable = false)
    private String nombreProducto;
    @Column
    private String descripcionProducto;
    @Column(nullable = false)
    private double precio;
    @Column(nullable = false)
    private int stock;

    @ManyToOne(cascade = CascadeType.ALL) // Puedes ajustar el tipo de cascada según tus necesidades (ALL, PERSIST, MERGE, etc.)
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVendedor", nullable = false)
    private Vendedor vendedor;

    @Lob
    @Column
    private byte[] imagenProducto;

    @Column
    private String direccionImagen;

    public Producto(String nombreProducto, String descripcionProducto, double precio, int stock, Categoria categoria, Vendedor vendedor, byte[] imagenProducto, String direccionImagen) {
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.vendedor = vendedor;
        this.imagenProducto = imagenProducto;
        this.direccionImagen = direccionImagen;
    }

    public Producto(String nombreProducto, String descripcionProducto, double precio, int stock, Categoria categoria, Vendedor vendedor) {
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.vendedor = vendedor;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public byte[] getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(byte[] imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcionProducto=" + descripcionProducto + ", precio=" + precio + ", stock=" + stock + ", categoria=" + categoria + ", vendedor=" + vendedor + ", direccionImagen=" + direccionImagen + '}';
    }

}

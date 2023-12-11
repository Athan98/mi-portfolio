
package entidades;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private int idProducto;

    @ManyToOne
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "codigo", unique = true)
    private String codigo;

    @Column(name = "precioVenta")
    private Double precioVenta;

    @Column(name = "stock")
    private int stock;

    public Producto(Categoria categoria, String nombre, String descripcion, String codigo, Double precioVenta, int stock) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public Producto(Categoria categoria, String nombre, String codigo, int stock) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.codigo = codigo;
        this.stock = stock;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", categoria=" + categoria + ", nombre=" + nombre + ", descripcion=" + descripcion + ", codigo=" + codigo + ", precioVenta=" + precioVenta + ", stock=" + stock + '}';
    }

}

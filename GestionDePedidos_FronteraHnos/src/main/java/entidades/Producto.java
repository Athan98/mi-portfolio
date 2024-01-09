package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private int idProducto;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetalleProducto> detallesProducto = new ArrayList<>();

    public Producto(int idProducto, String nombre, List<DetalleProducto> dp) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.detallesProducto = dp;
    }

    public Producto(int idProducto, String nombre) {
        this.idProducto = idProducto;
        this.nombre = nombre;
    }

    public Producto(String nombre, List<DetalleProducto> dp) {
        this.nombre = nombre;
        this.detallesProducto = dp;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DetalleProducto> getDetallesProducto() {
        return detallesProducto;
    }

    public void setDetallesProducto(List<DetalleProducto> detallesProducto) {
        this.detallesProducto = detallesProducto;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

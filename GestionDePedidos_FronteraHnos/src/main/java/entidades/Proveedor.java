package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "proveedor")

public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProveedor")
    private int idProveedor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cuit")
    private String cuit;

    public Proveedor(int idProveedor, String nombre, String cuit) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.cuit = cuit;
    }

    public Proveedor(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }

    public Proveedor() {
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Override
    public String toString() {
        return nombre;
    }

}

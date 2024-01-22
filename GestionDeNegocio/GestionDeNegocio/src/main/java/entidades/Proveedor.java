package entidades;

import javax.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProveedor")
    private int idProveedor;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "telefono", length = 60)
    private String telefono;

    @Column(name = "direccion", length = 120)
    private String direccion;

    @Column(name = "cuit", length = 60)
    private String cuit;

    @Column(name = "estado")
    private boolean estado;

    public Proveedor(int idProveedor, String nombre, String telefono, String direccion, String cuit, boolean estado) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuit = cuit;
        this.estado = estado;
    }

    public Proveedor(String nombre, String telefono, String direccion, String cuit, boolean estado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuit = cuit;
        this.estado = estado;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre;
    }

}


package entidades;

import java.io.FileInputStream;


public class Huesped {
    
    private int idHuesped=-1;
    private String dni;
    private String apellido;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private boolean estado;
    private FileInputStream fotoHuesped;
    private String nombreFotoHuesped;

    public Huesped(int idHuesped, String dni, String apellido, String nombre, String telefono, String correo, String direccion, boolean estado, FileInputStream fotoHuesped, String nombreFotoHuesped) {
        this.idHuesped = idHuesped;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
        this.fotoHuesped = fotoHuesped;
        this.nombreFotoHuesped = nombreFotoHuesped;
    }

    public Huesped(String dni, String apellido, String nombre, String telefono, String correo, String direccion, boolean estado, FileInputStream fotoHuesped, String nombreFotoHuesped) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
        this.fotoHuesped = fotoHuesped;
        this.nombreFotoHuesped = nombreFotoHuesped;
    }

    public Huesped(String dni, String apellido, String nombre, String telefono, String correo, String direccion, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Huesped() {
        this.idHuesped=-1;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public FileInputStream getFotoHuesped() {
        return fotoHuesped;
    }

    public void setFotoHuesped(FileInputStream fotoHuesped) {
        this.fotoHuesped = fotoHuesped;
    }

    public String getNombreFotoHuesped() {
        return nombreFotoHuesped;
    }

    public void setNombreFotoHuesped(String nombreFotoHuesped) {
        this.nombreFotoHuesped = nombreFotoHuesped;
    }

    @Override
    public String toString() {
        return "Huesped{" + "idHuesped=" + idHuesped + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", estado=" + estado + '}';
    }
    
    

   
    
}

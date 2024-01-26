
package Entidades;


public class Cliente {
    private Integer codigoArea;
    private String nombre;
    private String apellido;
    private String email;

    public Cliente(Integer codigoArea, String nombre, String apellido, String email) {
        this.codigoArea = codigoArea;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public Integer getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(Integer codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}

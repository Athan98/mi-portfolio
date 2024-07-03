package Entidades;

public class Tareas {

    private String nombre;
    private boolean estado;

    public Tareas(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public Tareas() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return estado + "";
    }

}

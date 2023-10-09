
package entidades;


public class Habitacion {
    
    private int idHabitacion = -1;
    private TipoHabitacion idTipoHabitacion;
    private int nroHabitacion;
    private int piso;
    private boolean ocupada;

    public Habitacion(int idHabitacion, TipoHabitacion idTipoHabitacion, int nroHabitacion, int piso, boolean ocupada) {
        this.idHabitacion = idHabitacion;
        this.idTipoHabitacion = idTipoHabitacion;
        this.nroHabitacion = nroHabitacion;
        this.piso = piso;
        this.ocupada = ocupada;
    }

    public Habitacion(TipoHabitacion idTipoHabitacion, int nroHabitacion, int piso, boolean ocupada) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.nroHabitacion = nroHabitacion;
        this.piso = piso;
        this.ocupada = ocupada;
    }    

    public Habitacion() {
        this.idHabitacion=-1;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public TipoHabitacion getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(TipoHabitacion idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    
    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "Habitacion{ id:" + idHabitacion + ", nro:" + nroHabitacion + ", piso:" + piso + ", TipoHabitacion:" + idTipoHabitacion.getTipo() + ", ocupada=" + ocupada + '}';
    }
    
    
}

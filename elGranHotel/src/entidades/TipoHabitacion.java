
package entidades;


public class TipoHabitacion {
    
    private int idTipoHabitacion = -1;
    private String tipo;
    private int cantidadCamas;
    private int cantidadPersonas;
    private String tipoCamas;
    private double precioPorNoche;

    public TipoHabitacion(String tipo, int cantidadPersonas, int cantidadCamas, String tipoCamas, double precioPorNoche) {
        this.tipo = tipo;
        this.cantidadCamas = cantidadCamas;
        this.cantidadPersonas = cantidadPersonas;
        this.tipoCamas = tipoCamas;
        this.precioPorNoche = precioPorNoche;
    }

    public TipoHabitacion(int idTipoHabitacion, String tipo, int cantidadPersonas, int cantidadCamas, String tipoCamas, double precioPorNoche) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.tipo = tipo;
        this.cantidadCamas = cantidadCamas;
        this.cantidadPersonas = cantidadPersonas;
        this.tipoCamas = tipoCamas;
        this.precioPorNoche = precioPorNoche;
    }

    public TipoHabitacion() {
        this.idTipoHabitacion = -1;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getTipoCamas() {
        return tipoCamas;
    }

    public void setTipoCamas(String tipoCamas) {
        this.tipoCamas = tipoCamas;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        return tipo + ": "+ tipoCamas;
    }

    
    
        
    
    
}

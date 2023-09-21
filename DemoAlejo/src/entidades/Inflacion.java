
package entidades;

import java.time.LocalDate;


public class Inflacion {
    
    private LocalDate fecha;
    private double tasa;

    public Inflacion() {
    }

    public Inflacion(LocalDate fecha) {
        this.fecha = fecha;
    }

    
    public Inflacion(LocalDate fecha, double tasa) {
        this.fecha = fecha;
        this.tasa = tasa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    @Override
    public String toString() {
        return "Fecha=" + fecha + ", Tasa=" + tasa;
    }
    
    
}

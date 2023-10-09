
package entidades;

import java.time.LocalDate;


public class ReservaHuesped {
    
    private int idReserva=-1;
    private Huesped idHuesped;
    private Habitacion idHabitacion;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private double monto;
    private boolean estado;

    public ReservaHuesped(int idReserva, Huesped idHuesped, Habitacion idHabitacion, LocalDate fechaIngreso, LocalDate fechaSalida, double monto, boolean estado) {
        this.idReserva = idReserva;
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.monto = monto;
        this.estado = estado;
    }

    public ReservaHuesped(Huesped idHuesped, Habitacion idHabitacion, LocalDate fechaIngreso, LocalDate fechaSalida, double monto, boolean estado) {
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.monto = monto;
        this.estado = estado;
    }

    public ReservaHuesped() {
        this.idReserva=-1;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Huesped getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(Huesped idHuesped) {
        this.idHuesped = idHuesped;
    }

    public Habitacion getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Habitacion idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ReservaHuesped{" + "idReserva=" + idReserva + ", idHuesped=" + idHuesped + ", idHabitacion=" + idHabitacion + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", monto=" + monto + ", estado=" + estado + '}';
    }
    
    
    
            
}

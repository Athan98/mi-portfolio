/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.security.Timestamp;
import javax.persistence.*;

@Entity
@Table
public class LogAcciones implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAccion")
    private int idAccion;

    @Column(nullable = false)
    private String accion;

    @Column(name = "FechaHora", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Timestamp fechaHora;

    public LogAcciones(String accion, Timestamp fechaHora) {
        this.accion = accion;
        this.fechaHora = fechaHora;
    }

    public LogAcciones() {
    }

    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "LogAcciones{" + "idAccion=" + idAccion + ", accion=" + accion + ", fechaHora=" + fechaHora + '}';
    }

}

package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "movimientosCaja")

public class MovimientosCaja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovimientoCaja")
    private int idMovCaja;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "saldoTeoricoCierre")
    private Double montoTeoricoCierre;

    @Column(name = "saldoRealCierre")
    private Double montoRealCierre;

    @Column(name = "diferencia")
    private Double diferencia;

    @Column(name = "operacion")
    private String operacion;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "idCaja")
    private Caja caja;

    @Column(name = "sucursal")
    private String sucursal;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public MovimientosCaja(int idMovCaja, Date fecha, Double monto, Double montoTeoricoCierre, Double montoRealCierre, Double diferencia, String operacion, String comentario, Caja caja, String sucursal, Usuario usuario) {
        this.idMovCaja = idMovCaja;
        this.fecha = fecha;
        this.monto = monto;
        this.montoTeoricoCierre = montoTeoricoCierre;
        this.montoRealCierre = montoRealCierre;
        this.diferencia = diferencia;
        this.operacion = operacion;
        this.comentario = comentario;
        this.caja = caja;
        this.sucursal = sucursal;
        this.usuario = usuario;
    }

    public MovimientosCaja(Date fecha, Double monto, Double montoTeoricoCierre, Double montoRealCierre, Double diferencia, String operacion, String comentario, Caja caja, String sucursal, Usuario usuario) {
        this.fecha = fecha;
        this.monto = monto;
        this.montoTeoricoCierre = montoTeoricoCierre;
        this.montoRealCierre = montoRealCierre;
        this.diferencia = diferencia;
        this.operacion = operacion;
        this.comentario = comentario;
        this.caja = caja;
        this.sucursal = sucursal;
        this.usuario = usuario;
    }

    public MovimientosCaja(Date fecha, Double montoTeoricoCierre, Double montoRealCierre, Double diferencia, String operacion, Caja caja, String sucursal, Usuario usuario) {
        this.fecha = fecha;
        this.montoTeoricoCierre = montoTeoricoCierre;
        this.montoRealCierre = montoRealCierre;
        this.diferencia = diferencia;
        this.operacion = operacion;
        this.caja = caja;
        this.sucursal = sucursal;
        this.usuario = usuario;
    }

    public MovimientosCaja() {
    }

    public MovimientosCaja(Date fecha, Double monto, String operacion, String comentario, Caja caja, String sucursal, Usuario usuario) {
        this.fecha = fecha;
        this.monto = monto;
        this.operacion = operacion;
        this.comentario = comentario;
        this.caja = caja;
        this.sucursal = sucursal;
        this.usuario = usuario;
    }

    public int getIdMovCaja() {
        return idMovCaja;
    }

    public void setIdMovCaja(int idMovCaja) {
        this.idMovCaja = idMovCaja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getMontoTeoricoCierre() {
        return montoTeoricoCierre;
    }

    public void setMontoTeoricoCierre(Double montoTeoricoCierre) {
        this.montoTeoricoCierre = montoTeoricoCierre;
    }

    public Double getMontoRealCierre() {
        return montoRealCierre;
    }

    public void setMontoRealCierre(Double montoRealCierre) {
        this.montoRealCierre = montoRealCierre;
    }

    public Double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(Double diferencia) {
        this.diferencia = diferencia;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "MovimientosCaja{" + "fechaApertura=" + fecha + ", operacion=" + operacion + '}';
    }

}

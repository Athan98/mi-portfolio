package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "licencia")
public class Licencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLicencia")
    private int idLicencia;

    @Column(name = "fechaAdquisicion")
    private Date fechaAdq;

    @Column(name = "fechaTermino")
    private Date fechaTermino;

    @Column(name = "meses")
    private int meses;

    @Column(name = "estado")
    private boolean estado;

    public Licencia(int idLicencia, Date fechaAdq, Date fechaTermino, int meses, boolean estado) {
        this.idLicencia = idLicencia;
        this.fechaAdq = fechaAdq;
        this.fechaTermino = fechaTermino;
        this.meses = meses;
        this.estado = estado;
    }

    public Licencia(Date fechaAdq, Date fechaTermino, int meses, boolean estado) {
        this.fechaAdq = fechaAdq;
        this.fechaTermino = fechaTermino;
        this.meses = meses;
        this.estado = estado;
    }

    public Licencia() {
    }

    public int getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(int idLicencia) {
        this.idLicencia = idLicencia;
    }

    public Date getFechaAdq() {
        return fechaAdq;
    }

    public void setFechaAdq(Date fechaAdq) {
        this.fechaAdq = fechaAdq;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    

}

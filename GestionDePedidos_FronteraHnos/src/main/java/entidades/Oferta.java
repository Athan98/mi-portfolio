package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "oferta")
public class Oferta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOferta")
    private int idOferta;

    @Column(name = "numeroPaquetes", nullable = false)
    private int numPaquetes;

    @Column(name = "tasaDescuento", nullable = false)
    private float tasaDesc;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "precioFinal", nullable = false)
    private float precioFinal;

    public Oferta(int idOferta, int numPaquetes, float tasaDesc, Date fecha, float precioFinal) {
        this.idOferta = idOferta;
        this.numPaquetes = numPaquetes;
        this.tasaDesc = tasaDesc;
        this.fecha = fecha;
        this.precioFinal = precioFinal;
    }

    public Oferta(int numPaquetes, float tasaDesc, Date fecha, float precioFinal) {
        this.numPaquetes = numPaquetes;
        this.tasaDesc = tasaDesc;
        this.fecha = fecha;
        this.precioFinal = precioFinal;
    }

    public Oferta() {
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public int getNumPaquetes() {
        return numPaquetes;
    }

    public void setNumPaquetes(int numPaquetes) {
        this.numPaquetes = numPaquetes;
    }

    public float getTasaDesc() {
        return tasaDesc;
    }

    public void setTasaDesc(float tasaDesc) {
        this.tasaDesc = tasaDesc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }

    @Override
    public String toString() {
        return "Oferta{" + "idOferta=" + idOferta + ", numPaquetes=" + numPaquetes + ", tasaDesc=" + tasaDesc + ", fecha=" + fecha + ", precioFinal=" + precioFinal + '}';
    }

}

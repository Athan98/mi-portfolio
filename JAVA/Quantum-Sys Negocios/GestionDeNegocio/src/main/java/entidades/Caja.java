package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "caja")
public class Caja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCaja")
    private int idCaja;

    @Column(name = "nroCaja", unique = true)
    private String nroCaja;

    @Column(name = "estado")
    private boolean estado;

    @OneToMany(mappedBy = "caja", cascade = CascadeType.ALL)
    private List<FormasDePagoVentas> cajaFDPVS = new ArrayList<>();

    @OneToMany(mappedBy = "caja", cascade = CascadeType.ALL)
    private List<Venta> ventas = new ArrayList<>();

    public Caja(int idCaja, String nroCaja, boolean estado, Usuario usuario) {
        this.idCaja = idCaja;
        this.nroCaja = nroCaja;
        this.estado = estado;
    }

    public Caja(String nroCaja, boolean estado, Usuario usuario) {
        this.nroCaja = nroCaja;
        this.estado = estado;
    }

    public Caja() {
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public String getNroCaja() {
        return nroCaja;
    }

    public void setNroCaja(String nroCaja) {
        this.nroCaja = nroCaja;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<FormasDePagoVentas> getCajaFDPVS() {
        return cajaFDPVS;
    }

    public void setCajaFDPVS(List<FormasDePagoVentas> cajaFDPVS) {
        this.cajaFDPVS = cajaFDPVS;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "N° Caja: " + nroCaja;
    }

}

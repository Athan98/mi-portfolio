
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table
public class Orden implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrden;
    @Column
    private Date fechaOrden;
    
    @ManyToOne(cascade = CascadeType.ALL) // Manejo de cascada en la relación con Usuario
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;
    
    @Column(name = "TipoOrden", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoOrden tipoOrden;

    public Orden(Date fechaOrden, Usuario usuario, TipoOrden tipoOrden) {
        this.fechaOrden = fechaOrden;
        this.usuario = usuario;
        this.tipoOrden = tipoOrden;
    }

    public Orden() {
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoOrden getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(TipoOrden tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    @Override
    public String toString() {
        return "Orden{" + "idOrden=" + idOrden + ", fechaOrden=" + fechaOrden + ", usuario=" + usuario + ", tipoOrden=" + tipoOrden + '}';
    }
 
}

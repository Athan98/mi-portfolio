
package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class Vendedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVendedor;
    @Column
    private String nombreTienda;
    @Column(nullable = false)
    private String nombreVendedor;
    @Column(nullable = false)
    private String correoElectronicoVendedor;
    @Column(nullable = false)
    private String direccionVendedor;

    public Vendedor(String nombreTienda, String nombreVendedor, String correoElectronicoVendedor, String direccionVendedor) {
        this.nombreTienda = nombreTienda;
        this.nombreVendedor = nombreVendedor;
        this.correoElectronicoVendedor = correoElectronicoVendedor;
        this.direccionVendedor = direccionVendedor;
    }

    public Vendedor() {
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getCorreoElectronicoVendedor() {
        return correoElectronicoVendedor;
    }

    public void setCorreoElectronicoVendedor(String correoElectronicoVendedor) {
        this.correoElectronicoVendedor = correoElectronicoVendedor;
    }

    public String getDireccionVendedor() {
        return direccionVendedor;
    }

    public void setDireccionVendedor(String direccionVendedor) {
        this.direccionVendedor = direccionVendedor;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "idVendedor=" + idVendedor + ", nombreTienda=" + nombreTienda + ", nombreVendedor=" + nombreVendedor + ", correoElectronicoVendedor=" + correoElectronicoVendedor + ", direccionVendedor=" + direccionVendedor + '}';
    }

}

package entidades;

import javax.persistence.*;

@Entity
@Table(name = "formadepago")
public class FormaDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFormaDePago")
    private int idFormaDePago;

    @Column(name = "formaDePago", unique = true, nullable = false)
    private String nombreFormaDePago;

    public FormaDePago(String nombreFormaDePago) {
        this.nombreFormaDePago = nombreFormaDePago;
    }

    public FormaDePago() {
    }

    public int getIdFormaDePago() {
        return idFormaDePago;
    }

    public void setIdFormaDePago(int idFormaDePago) {
        this.idFormaDePago = idFormaDePago;
    }

    public String getNombreFormaDePago() {
        return nombreFormaDePago;
    }

    public void setNombreFormaDePago(String nombreFormaDePago) {
        this.nombreFormaDePago = nombreFormaDePago;
    }

    @Override
    public String toString() {
        return "FormaDePago{" + "idFormaDePago=" + idFormaDePago + ", nombreFormaDePago=" + nombreFormaDePago + '}';
    }

}

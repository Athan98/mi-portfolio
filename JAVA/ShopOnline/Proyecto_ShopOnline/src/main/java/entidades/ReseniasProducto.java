/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table
public class ReseniasProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idResenias;

    @ManyToOne(cascade = CascadeType.ALL) // Puedes ajustar el tipo de cascada según tus necesidades
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private int calificacion;

    @Column(name = "Comentario", length = 255)
    private String comentario;

    @Column
    private Date fechaResenia;

    public ReseniasProducto(Producto producto, Usuario usuario, int calificacion, String comentario, Date fechaResenia) {
        this.producto = producto;
        this.usuario = usuario;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaResenia = fechaResenia;
    }

    public ReseniasProducto() {
    }

    public int getIdResenias() {
        return idResenias;
    }

    public void setIdResenias(int idResenias) {
        this.idResenias = idResenias;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaResenia() {
        return fechaResenia;
    }

    public void setFechaResenia(Date fechaResenia) {
        this.fechaResenia = fechaResenia;
    }

    @Override
    public String toString() {
        return "ReseniasProducto{" + "idResenias=" + idResenias + ", producto=" + producto + ", usuario=" + usuario + ", calificacion=" + calificacion + ", comentario=" + comentario + ", fechaResenia=" + fechaResenia + '}';
    }

}

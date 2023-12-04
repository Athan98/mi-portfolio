/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "CarritoCompras")
public class CarritoCompras implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idCarro;

    @ManyToOne(cascade = CascadeType.ALL) // Manejo de cascada en la relación con Usuario
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL) // Manejo de cascada en la relación con Producto
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private int cantidadProductos;

    @Column(nullable = false)
    private double precioTotal;

    public CarritoCompras(Usuario usuario, Producto producto, int cantidadProductos, double precioTotal) {
        this.usuario = usuario;
        this.producto = producto;
        this.cantidadProductos = cantidadProductos;
        this.precioTotal = precioTotal;
    }

    public CarritoCompras() {
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "CarritoCompras{" + "idCarro=" + idCarro + ", usuario=" + usuario + ", producto=" + producto + ", cantidadProductos=" + cantidadProductos + ", precioTotal=" + precioTotal + '}';
    }
    
    
}

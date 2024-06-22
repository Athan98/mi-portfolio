package entidades;

public class Producto {

    private int idProducto=-1;
    private TipoProducto idTipoProducto;
    private String codigo;
    private String nombre;
    private double precio;
    private boolean estado;

    public Producto() {
        this.idProducto=-1;
    }

    public Producto(int idProducto, TipoProducto idTipoProducto, String codigo, String nombre, double precio, boolean estado) {
        this.idProducto = idProducto;
        this.idTipoProducto = idTipoProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
    }

    public Producto(TipoProducto idTipoProducto, String codigo, String nombre, double precio, boolean estado) {
        this.idTipoProducto = idTipoProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public TipoProducto getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(TipoProducto idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", idTipoProducto=" + idTipoProducto + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", estado=" + estado + '}';
    } 
}

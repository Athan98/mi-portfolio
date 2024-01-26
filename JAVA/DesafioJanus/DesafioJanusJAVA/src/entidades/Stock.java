
package entidades;


public class Stock {
    
    private int idStock=-1;
    private Producto idProducto;
    private int cantidad;

    public Stock() {
        this.idStock=-1;
    }

    public Stock(Producto idProducto, int cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public Stock(int idStock, Producto idProducto, int cantidad) {
        this.idStock = idStock;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Stock{" + "idStock=" + idStock + ", idProducto=" + idProducto + ", cantidad=" + cantidad + '}';
    }
    
}

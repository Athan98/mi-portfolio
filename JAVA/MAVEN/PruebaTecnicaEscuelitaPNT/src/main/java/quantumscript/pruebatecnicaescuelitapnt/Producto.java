
package quantumscript.pruebatecnicaescuelitapnt;


public class Producto implements Comparable<Producto> {
    
    private String nombre;
    private Double cantidad;
    private String unidadDeMedida;
    private Double precio;

    public Producto(String nombre, Double cantidad, String unidadDeMedida, Double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadDeMedida = unidadDeMedida;
        this.precio = precio;
    }

    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "/// Cantidad: " + cantidad + "/// Unidad de medida: " + unidadDeMedida + "/// Precio: $" + precio;
    }
    
    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }
    
}

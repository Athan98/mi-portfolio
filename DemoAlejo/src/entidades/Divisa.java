
package entidades;


public class Divisa {
    private String nombreDivisa;
    private float precioCompra;
    private float precioVenta;
    private float variacion;

    public String getNombreDivisa() {
        return nombreDivisa;
    }

    public void setNombreDivisa(String nombreDivisa) {
        this.nombreDivisa = nombreDivisa;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getVariacion() {
        return variacion;
    }

    public void setVariacion(float variacion) {
        this.variacion = variacion;
    }

    public Divisa(String nombreDivisa, float precioCompra, float precioVenta, float variacion) {
        this.nombreDivisa = nombreDivisa;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.variacion = variacion;
    }

    public Divisa(String nombreDivisa, float precioCompra, float precioVenta) {
        this.nombreDivisa = nombreDivisa;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return nombreDivisa  ;
    }

    

    public Divisa() {
    }
    
    
}

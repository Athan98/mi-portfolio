package entidades;

public class Divisa {

    private String nombreDivisa;
    private float precioCompra;
    private float precioVenta;
    private String variacion;
    private String banco;

    public Divisa(String banco) {
        this.banco = banco;
    }

    public Divisa() {
    }

    public Divisa(String nombreDivisa, float precioCompra, float precioVenta, String variacion, String banco) {
        this.nombreDivisa = nombreDivisa;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.variacion = variacion;
        this.banco = banco;
    }

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

    public String getVariacion() {
        return variacion;
    }

    public void setVariacion(String variacion) {
        this.variacion = variacion;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

   

}

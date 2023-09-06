package entidades;

public class Divisa {

    private String nombreDivisa;
    private float precioCompra;
    private float precioVenta;
    private float variacion;
    private String banco;

    public Divisa(String banco) {
        this.banco = banco;
    }

    public Divisa(String nombreDivisa, float precioCompra, float precioVenta, float variacion, String banco) {
        this.nombreDivisa = nombreDivisa;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.variacion = variacion;
        this.banco = banco;
    }

    public Divisa(String nombreDivisa, float precioCompra, float precioVenta, String banco) {
        this.nombreDivisa = nombreDivisa;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.banco = banco;
    }

    public Divisa() {
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

    public float getVariacion() {
        return variacion;
    }

    public void setVariacion(float variacion) {
        this.variacion = variacion;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

}

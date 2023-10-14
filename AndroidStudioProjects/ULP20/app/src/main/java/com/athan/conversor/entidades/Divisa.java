package com.athan.conversor.entidades;

public class Divisa {

    private String nombreDivisa;
    private float precioCompra;
    private float precioVenta;
    private String variacion;
    private String banco;
    private String tipoDolar;

    public Divisa() {
    }

    public Divisa(String nombreDivisa, float precioCompra, float precioVenta, String variacion, String banco) {
        this.nombreDivisa = nombreDivisa;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.variacion = variacion;
        this.banco = banco;
    }

    public Divisa(float precioCompra, float precioVenta, String variacion, String tipoDolar) {
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.variacion = variacion;
        this.tipoDolar = tipoDolar;
    }

    public Divisa(String nombreDivisa, float precioCompra, float precioVenta, String variacion, String banco, String tipoDolar) {
        this.nombreDivisa = nombreDivisa;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.variacion = variacion;
        this.banco = banco;
        this.tipoDolar = tipoDolar;
    }

    public Divisa(float precioVenta, String tipoDolar) {
        this.precioVenta = precioVenta;
        this.tipoDolar = tipoDolar;
    }

    public Divisa(String nombreDivisa, float precioCompra, float precioVenta, String banco) {
        this.nombreDivisa = nombreDivisa;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.banco = banco;
    }

    public Divisa(String tipoDolar) {
        this.tipoDolar = tipoDolar;
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

    public String getTipoDolar() {
        return tipoDolar;
    }

    public void setTipoDolar(String tipoDolar) {
        this.tipoDolar = tipoDolar;
    }
}

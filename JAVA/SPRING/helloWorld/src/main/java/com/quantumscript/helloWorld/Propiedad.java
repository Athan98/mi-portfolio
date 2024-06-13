package com.quantumscript.helloWorld;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Propiedad {

    private Long idPropiedad;
    private String tipoPropiedad;
    private String direccion;
    private Double metrosCuadrados;
    private Double valorAlquiler;

    public Propiedad(Long idPropiedad, String tipoPropiedad, String direccion, Double metrosCuadrados, Double valorAlquiler) {
        this.idPropiedad = idPropiedad;
        this.tipoPropiedad = tipoPropiedad;
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.valorAlquiler = valorAlquiler;
    }

    public Propiedad(String tipoPropiedad, String direccion, Double metrosCuadrados, Double valorAlquiler) {
        this.tipoPropiedad = tipoPropiedad;
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.valorAlquiler = valorAlquiler;
    }

    public Propiedad() {
    }

}

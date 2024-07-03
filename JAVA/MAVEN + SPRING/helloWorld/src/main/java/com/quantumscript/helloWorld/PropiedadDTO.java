package com.quantumscript.helloWorld;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropiedadDTO {

    private Long idPropiedad;
    private String tipoPropiedad;
    private String direccion;
    private Double valorAlquiler;
    private String nombre;
    private String apellido;

    public PropiedadDTO(Long idPropiedad, String tipoPropiedad, String direccion, Double valorAlquiler, String nombre, String apellido) {
        this.idPropiedad = idPropiedad;
        this.tipoPropiedad = tipoPropiedad;
        this.direccion = direccion;
        this.valorAlquiler = valorAlquiler;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public PropiedadDTO(String tipoPropiedad, String direccion, Double valorAlquiler, String nombre, String apellido) {
        this.tipoPropiedad = tipoPropiedad;
        this.direccion = direccion;
        this.valorAlquiler = valorAlquiler;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public PropiedadDTO() {
    }

}

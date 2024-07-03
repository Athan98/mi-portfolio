package com.quantumscript.ArqMultiCapas.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {

    private Long idPersona;
    private String nombre;
    private String apellido;

    public Persona(Long idPersona, String nombre, String apellido) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona() {
    }

}

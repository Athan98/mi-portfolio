package com.quantumscript.helloWorld;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inquilino {

    private Long idInquilino;
    private String dni;
    private String nombre;
    private String apellido;
    private String profesion;

    public Inquilino(Long idInquilino, String dni, String nombre, String apellido, String profesion) {
        this.idInquilino = idInquilino;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
    }

    public Inquilino(String dni, String nombre, String apellido, String profesion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
    }

    public Inquilino() {
    }

}

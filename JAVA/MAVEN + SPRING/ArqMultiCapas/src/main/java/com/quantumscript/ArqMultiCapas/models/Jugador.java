package com.quantumscript.ArqMultiCapas.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jugador {

    private Long idJugador;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Double peso;
    private Double estatura;

    public Jugador(Long idJugador, String dni, String nombre, String apellido, Integer edad, Double peso, Double estatura) {
        this.idJugador = idJugador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
    }

    public Jugador() {
    }

}

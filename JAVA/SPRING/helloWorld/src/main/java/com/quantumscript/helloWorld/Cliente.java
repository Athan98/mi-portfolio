package com.quantumscript.helloWorld;

import lombok.Getter;
import lombok.Setter;

//MODELO -> CLASE CLIENTE
//TENGO TODOS LOS GETTES Y SETTERS
@Getter @Setter
public class Cliente {

    private Long id;
    private String nombre;
    private String apellido;
    
    //CONSTRUCTORES

    public Cliente(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente() {
    }
    
    

}

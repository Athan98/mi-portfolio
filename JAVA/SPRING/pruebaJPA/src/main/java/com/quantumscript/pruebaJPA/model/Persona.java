package com.quantumscript.pruebaJPA.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_persona;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;

    /*
    @OneToOne
                    //Nombre de la tabla     //Nombre de la columna que contiene el id de la otra tabla   
    @JoinColumn(name = "mascota_id_mascota", referencedColumnName = "id_mascota")
     private Mascota mascota;
     */
    
    @OneToMany
    List<Mascota> mascotas;

    public Persona(Long id_persona, String nombre, String apellido, int edad, List<Mascota> mascotas) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.mascotas = mascotas;
    }

    public Persona() {
    }

}

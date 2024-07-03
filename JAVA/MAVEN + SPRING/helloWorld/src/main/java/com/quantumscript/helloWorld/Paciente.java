
package com.quantumscript.helloWorld;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Paciente {
    
    private Long idPaciente;
    private Long dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Paciente(Long idPaciente, Long dni, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.idPaciente = idPaciente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Paciente(Long dni, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Paciente() {
    }
    
    
    
}

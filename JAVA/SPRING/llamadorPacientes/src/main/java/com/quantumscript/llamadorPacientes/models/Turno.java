package com.quantumscript.llamadorPacientes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turno;
    @Column
    private Date fecha;
    @Column
    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    public Turno() {
    }

    public Turno(Long id_turno, Date fecha, boolean estado, Paciente paciente, Medico medico) {
        this.id_turno = id_turno;
        this.fecha = fecha;
        this.estado = estado;
        this.paciente = paciente;
        this.medico = medico;
    }

}

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
public class Llamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_llamado;
    @Column
    private Date fechaHoraLlamado;
    @Column
    private String nroConsultorio;
    @ManyToOne
    @JoinColumn(name = "id_turno")
    private Turno turno;

    public Llamado() {
    }

    public Llamado(Long id_llamado, Date fechaHoraLlamado, String nroConsultorio, Turno turno) {
        this.id_llamado = id_llamado;
        this.fechaHoraLlamado = fechaHoraLlamado;
        this.nroConsultorio = nroConsultorio;
        this.turno = turno;
    }

}

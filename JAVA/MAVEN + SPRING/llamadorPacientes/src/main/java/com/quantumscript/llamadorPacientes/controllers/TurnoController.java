package com.quantumscript.llamadorPacientes.controllers;

import com.quantumscript.llamadorPacientes.models.Medico;
import com.quantumscript.llamadorPacientes.models.Paciente;
import com.quantumscript.llamadorPacientes.models.Turno;
import com.quantumscript.llamadorPacientes.services.ITurnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurnoController {

    @Autowired
    private ITurnoService ts;

    @GetMapping("/turnos/listar")
    public List<Turno> getTurnos() {
        List<Turno>turnos=ts.getTurnos();
        return turnos;
    }

    @GetMapping("/turnos/listarturnospaciente")
    public List<Turno> getTurnosPaciente(@RequestBody Paciente p) {
        return ts.findTurnosPaciente(p);
    }

    @GetMapping("/turnos/listarturnosmedico")
    public List<Turno> getTurnosMedico(@RequestBody Medico m) {
        return ts.findTurnosMedico(m);
    }

    @PostMapping("/turnos/crear")
    public String saveTurno(@RequestBody Turno t) {
        ts.saveTurno(t);
        return "El turno fue creado";
    }

    @DeleteMapping("/turnos/eliminar")
    public String deleteTurno(@RequestParam Long id) {
        ts.deleteTurno(id);
        return "El turno fue eliminado";
    }

    @PutMapping("/turno/editar")
    public Turno editTurno(@RequestBody Turno t) {
        this.saveTurno(t);
        return ts.findTurno(t.getId_turno());
    }

}

package com.quantumscript.llamadorPacientes.controllers;

import com.quantumscript.llamadorPacientes.models.Paciente;
import com.quantumscript.llamadorPacientes.services.IPacienteService;
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
public class PacienteController {

    @Autowired
    private IPacienteService ps;

    @GetMapping("/pacientes/listar")
    public List<Paciente> getPacientes() {
        return ps.getPacientes();
    }

    @PostMapping("/pacientes/crear")
    public String savePaciente(@RequestBody Paciente p) {
        ps.savePaciente(p);
        return "El paciente fue creado";
    }

    @DeleteMapping("/pacientes/eliminar")
    public String deletePaciente(@RequestParam Long id) {
        ps.deletePaciente(id);
        return "El paciente fue eliminado";
    }

    @PutMapping("/pacientes/editar")
    public Paciente editPaciente(@RequestBody Paciente p) {
        this.savePaciente(p);
        return ps.findPaciente(p.getId_paciente());
    }

}

package com.quantumscript.llamadorPacientes.controllers;

import com.quantumscript.llamadorPacientes.models.Medico;
import com.quantumscript.llamadorPacientes.services.IMedicoService;
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
public class MedicoController {

    @Autowired
    private IMedicoService ms;

    @GetMapping("/medicos/listar")
    public List<Medico> getMedicos() {
        return ms.getMedicos();
    }

    @PostMapping("/medicos/crear")
    public String saveMedico(@RequestBody Medico m) {
        ms.saveMedico(m);
        return "El medico fue creado";
    }

    @DeleteMapping("/medicos/eliminar")
    public String deleteMedico(@RequestParam Long id) {
        ms.deleteMedico(id);
        return "El medico fue eliminado";
    }

    @PutMapping("/medicos/editar")
    public Medico editMedico(@RequestBody Medico m) {
        this.saveMedico(m);
        return ms.findMedico(m.getId_medico());
    }

}

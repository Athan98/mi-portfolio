package com.quantumscript.llamadorPacientes.controllers;

import com.quantumscript.llamadorPacientes.models.Llamado;
import com.quantumscript.llamadorPacientes.services.ILlamadoService;
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
public class LlamadoController {

    @Autowired
    private ILlamadoService ls;

    @GetMapping("/llamados/listar")
    public List<Llamado> getLlamados() {
        return ls.getLlamados();
    }

    @PostMapping("/llamados/crear")
    public String saveLlamado(@RequestBody Llamado l) {
        ls.saveLlamado(l);
        return "El llamado fue realizado";
    }

    @DeleteMapping("/llamados/eliminar")
    public String deleteLlamado(@RequestParam Long id) {
        ls.deleteLlamado(id);
        return "El llamado fue eliminado";
    }

    @PutMapping("/llamados/editar")
    public Llamado editLlamado(@RequestBody Llamado l) {
        this.saveLlamado(l);
        return ls.findLlamado(l.getId_llamado());
    }

    @GetMapping("/llamados/ultimosdosllamados")
    public List<Llamado> getUltimosDosLlamados() {
        return ls.getUltimosDosLlamados();
    }

}

package com.quantumscript.pruebaJPA.controller;

import com.quantumscript.pruebaJPA.model.Mascota;
import com.quantumscript.pruebaJPA.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {

    //3- Desarrollar endpoints
    @Autowired
    private IMascotaService mascotaService;

    @GetMapping("/mascotas/traer")
    public List<Mascota> getMascotas() {
        return mascotaService.getMascotas();
    }

    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota mascota) {
        mascotaService.saveMascota(mascota);
        return "La mascota fue creada correctamente";
    }

    @DeleteMapping("/mascotas/eliminar")
    public String deleteMascotas(@RequestParam Long id) {
        mascotaService.deleteMascota(id);
        return "La mascota fue eliminada correctamente";
    }

    @PutMapping("/mascotas/actualzar/{idOriginal}")
    public Mascota editMascota(@PathVariable Long idOriginal,
            @RequestParam(required = false, name = "id") Long idNueva,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "especie") String nuevaEspecie,
            @RequestParam(required = false, name = "raza") String nuevaRaza,
            @RequestParam(required = false, name = "color") String nuevoColor) {

        mascotaService.editMascota(idOriginal, idNueva, nuevoNombre, nuevaEspecie, nuevaRaza, nuevoColor);

        Mascota mascota = mascotaService.findMascota(idNueva);

        return mascota;
    }

}

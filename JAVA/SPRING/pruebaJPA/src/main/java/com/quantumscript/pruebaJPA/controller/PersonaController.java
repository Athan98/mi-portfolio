package com.quantumscript.pruebaJPA.controller;

import com.quantumscript.pruebaJPA.model.Persona;
import com.quantumscript.pruebaJPA.service.IPersonaService;
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
public class PersonaController {

    //3- Desarrollar endpoints
    @Autowired
    private IPersonaService personaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return personaService.getPersonas();
    }

    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona persona) {
        personaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/personas/eliminar")
    public String deletePersonas(@RequestParam Long id) {
        personaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/personas/actualzar/{idOriginal}")
    public Persona editPersona(@PathVariable Long idOriginal,
            @RequestParam(required = false, name = "id") Long idNueva,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "apellido") String nuevoApellido,
            @RequestParam(required = false, name = "edad") int nuevaEdad) {

        personaService.editPersona(idOriginal, idNueva, nuevoNombre, nuevoApellido, nuevaEdad);

        Persona persona = personaService.findPersona(idNueva);

        return persona;
    }

    @PutMapping("/personas/editar")
    public Persona editPersona(@RequestBody Persona persona) {
        personaService.editPersona(persona);
        return personaService.findPersona(persona.getId_persona());
    }
}

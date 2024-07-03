package com.quantumscript.pruebaJPA.service;

import com.quantumscript.pruebaJPA.model.Persona;
import com.quantumscript.pruebaJPA.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    //2- Desarrollar logica que va a tener cada metodo
    @Autowired
    private IPersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = persoRepo.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona persona) {
        persoRepo.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = persoRepo.findById(id).orElse(null);
        return persona;
    }

    @Override
    public void editPersona(Long id, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        //Buscar el objeto original
        Persona persona = this.findPersona(id);
        //Proceso de modificacion a nivel logico
        persona.setApellido(nuevoApellido);
        persona.setEdad(nuevaEdad);
        persona.setNombre(nuevoNombre);
        persona.setId_persona(idNueva);

        //Guardar cambios
        this.savePersona(persona);
    }

    @Override
    public void editPersona(Persona persona) {
        this.savePersona(persona);
    }
}

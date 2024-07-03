package com.quantumscript.pruebaJPA.service;

import com.quantumscript.pruebaJPA.model.Persona;
import java.util.List;

public interface IPersonaService {

    // 1- Declarar metodos de forma abstracta
    //ENCONTRAR TODAS LAS PERSONAS
    public List<Persona> getPersonas();

    //ALTA
    public void savePersona(Persona persona);

    //ELIMINAR
    public void deletePersona(Long id);

    //ENCONTRAR UNA SOLA PERSONA
    public Persona findPersona(Long id);

    //MODIFICACION
    public void editPersona(Long id,
            Long idNueva,
            String nuevoNombre,
            String nuevoApellido,
            int nuevaEdad
    );

    public void editPersona(Persona persona);
}


package com.quantumscript.ArqMultiCapas.services;

import com.quantumscript.ArqMultiCapas.models.Persona;
import java.util.List;

public interface IPersonaService {
    
    public void crearPersona(Persona persona);
    
    public List<Persona> listarPersonas();
}

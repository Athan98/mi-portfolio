
package com.quantumscript.ArqMultiCapas.services;

import com.quantumscript.ArqMultiCapas.models.Persona;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
 //Metodos logica de negocio
    @Override
    public void crearPersona(Persona persona) {
        //Logica de creacion
        System.out.println("Persona creada");
    }

    @Override
    public List<Persona> listarPersonas() {
        //Logica de traer lista de personas
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    
}

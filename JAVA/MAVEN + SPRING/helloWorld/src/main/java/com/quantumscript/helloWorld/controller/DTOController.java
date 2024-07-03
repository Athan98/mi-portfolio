package com.quantumscript.helloWorld.controller;

import com.quantumscript.helloWorld.Inquilino;
import com.quantumscript.helloWorld.Propiedad;
import com.quantumscript.helloWorld.PropiedadDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DTOController {

    @GetMapping("/propiedad/{id}")
    @ResponseBody
    public PropiedadDTO devolverPropiedad(@PathVariable Long id) {
        //SIMULACION DE TRAER LOS OBJETOS DE BD
        Propiedad propiedad = new Propiedad(5465L, "Casa", "308 Negro Arroyo Lane", 200.0, 40000.0);
        Inquilino inqui = new Inquilino(1L, "12345678", "Walter", "White", "Profesor de quimica");

        PropiedadDTO propiDTO = new PropiedadDTO();
        propiDTO.setIdPropiedad(propiedad.getIdPropiedad());
        propiDTO.setTipoPropiedad(propiedad.getTipoPropiedad());
        propiDTO.setDireccion(propiedad.getDireccion());
        propiDTO.setValorAlquiler(propiedad.getValorAlquiler());
        propiDTO.setNombre(inqui.getNombre());
        propiDTO.setApellido(inqui.getApellido());

        return propiDTO;
    }
}

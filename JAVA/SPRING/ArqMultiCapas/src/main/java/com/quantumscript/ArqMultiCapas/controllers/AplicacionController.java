package com.quantumscript.ArqMultiCapas.controllers;

import com.quantumscript.ArqMultiCapas.models.Post;
import com.quantumscript.ArqMultiCapas.repository.IPostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AplicacionController {

    //CREAR EL OBJETO QUE NECESITO
    @Autowired
    IPostRepository repo;

    @GetMapping("/posteos")
    public List<Post> traerTodos() {
        return repo.traerPosteos();
    }

    @GetMapping("/promediar")
    public String retornarProm(@RequestParam Double nota1, @RequestParam Double nota2, @RequestParam Double nota3) {
        Double resultado = (nota1 + nota2 + nota3) / 3;
        return "El promedio de las 3 notas ingresadas es " + resultado;
    }
    
    //URL: http://localhost:8080/promediar?nota1=8&nota2=6&nota3=9
    
    
}

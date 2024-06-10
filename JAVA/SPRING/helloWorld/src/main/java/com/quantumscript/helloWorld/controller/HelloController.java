package com.quantumscript.helloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//IDENTIFICAR EL CONTROLADOR Y DE QUE FORMA RECIBE LAS PETICIONES
//AQUI ESTARAN TODOS LOS ENDPOINTS
@RestController
public class HelloController {

    //IDENTIFICAR EL METODO HTTP
    //GET       //URL  //PASAMOS PARAMETROS(PathVariable)
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello World! " + name;
    }

    @GetMapping("/goodbye/{name}/{age}/{profession}")
    public String sayGoodBye(@PathVariable String name, @PathVariable int age, @PathVariable String profession) {
        return "Goodbye World! " + name + ", Age: " + age + ", Profession: " + profession;
    }
}

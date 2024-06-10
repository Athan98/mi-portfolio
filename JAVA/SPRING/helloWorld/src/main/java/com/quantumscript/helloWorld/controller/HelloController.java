package com.quantumscript.helloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//IDENTIFICAR EL CONTROLADOR Y DE QUE FORMA RECIBE LAS PETICIONES
//AQUI ESTARAN TODOS LOS ENDPOINTS
@RestController
public class HelloController {

    /*
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
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return "Hello World! " + name;
    }

    @GetMapping("/goodbye")
    public String sayGoodBye(@RequestParam String name, @RequestParam int age, @RequestParam String profession) {
        return "Goodbye World! " + name + ", Age: " + age + ", Profession: " + profession;
    }

    @GetMapping("/sum/{num1}/{num2}")
    public String sum(@PathVariable Double num1, @PathVariable Double num2) {
        return "La suma de los numeros es igual a " + (num1 + num2);
    }

    @GetMapping("/imc")
    public String returnIMC(@RequestParam Double weight) {

        String respuesta = "";

        if (weight >= 1 && weight <= 18.5) {
            respuesta = "Peso insuficiente";
        } else if (weight >= 18.6 && weight <= 24.9) {
            respuesta = "Peso normal";
        } else if (weight >= 25.0 && weight <= 29.9) {
            respuesta = "Sobrepeso";
        } else if (weight >= 30) {
            respuesta = "Obesidad";
        }

        return respuesta;
    }

}

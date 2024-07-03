package com.quantumscript.helloWorld.controller;

import com.quantumscript.helloWorld.Cliente;
import com.quantumscript.helloWorld.Paciente;
import com.quantumscript.helloWorld.Platos;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//IDENTIFICAR EL CONTROLADOR Y DE QUE FORMA RECIBE LAS PETICIONES
//AQUI ESTARAN TODOS LOS ENDPOINTS
@RestController
public class HelloController {

    //////////////////////////////////////////////////////////REQUEST////////////////////////////////////////////////////////////

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

    @GetMapping("/galones")
    public String galones(@RequestParam Double galon) {
        return galon + " galones es igual a " + (galon * 3.78541) + " litros de gasolina";
    }

    //ENDPOINT RECIBIR DATOS PARA CREAR UN OBJETO CON SOLICITUD POST
    @PostMapping("/cliente")
    //ANOTATION PARA MANDAR DATOS EN EL CUERPO DEL PAQUETE DE SOLICITUD
    public void crearCliente(@RequestBody Cliente cliente) {

        System.out.println("Cliente creado");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());

    }

    //////////////////////////////////////////////////////////RESPONSES////////////////////////////////////////////////////////////
    @GetMapping("/cliente/traer")
    //DEVOLVER DENTRO DEL BODY
    @ResponseBody
    public List<Cliente> traerClientes() {
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(1L, "Nicolas", "Roldan"));
        clientes.add(new Cliente(2L, "Ivana", "Escudero"));
        clientes.add(new Cliente(3L, "Angela", "Sosnowski"));

        return clientes;
    }

    //RESPONSE ENTITY: NOS PERMITE MANIPULAR CADA PARTE DE UN PAQUETE DE RESPUESTA. ES MAS COMPLETO
    @GetMapping("/pruebaresponse")
    ResponseEntity<String> traerRespuesta() {
        return new ResponseEntity<>("Esta es una prueba de Response", HttpStatus.NOT_FOUND);
    }

    ///////////////////////////////////////PRACTICA//////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/platos")
    ResponseEntity<String> traerPlato(@RequestParam Long idPlato) {
        List<Platos> listaPlatos = new ArrayList<>();

        listaPlatos.add(new Platos(1L, "Comida italiana"));
        listaPlatos.add(new Platos(2L, "Comida mexicana"));
        listaPlatos.add(new Platos(3L, "Comida argentina"));
        listaPlatos.add(new Platos(4L, "Comida polaca"));
        listaPlatos.add(new Platos(5L, "Comida rusa"));
        listaPlatos.add(new Platos(6L, "Comida española"));

        for (Platos p : listaPlatos) {
            if (p.getIdPlato() == idPlato) {
                return new ResponseEntity<>("ID Plato: " + p.getIdPlato() + ", Nombre del plato: " + p.getTipoComida(), HttpStatus.OK);
            }

        }
        return new ResponseEntity<>("No se encontro el plato buscado", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/pacientes")
    @ResponseBody
    public List<Paciente> traerPacientes() {
        List<Paciente> pacientes = new ArrayList<>();

        pacientes.add(new Paciente(1L, 41339109L, "Nicolas", "Roldan", LocalDate.of(1998, 10, 26)));
        pacientes.add(new Paciente(2L, 41223956L, "Ivana", "Escudero", LocalDate.of(1998, 2, 4)));
        pacientes.add(new Paciente(3L, 13467088L, "Angela", "Sosnowski", LocalDate.of(1959, 8, 26)));
        pacientes.add(new Paciente(4L, 56963520L, "Juan Valentin", "Roldan", LocalDate.of(2017, 9, 7)));
        pacientes.add(new Paciente(5L, 54236562L, "Pedro", "Rodriguez", LocalDate.of(2019, 3, 5)));

        return pacientes;
    }

    @GetMapping("/pacientesmenores")
    @ResponseBody
    public List<Paciente> traerPacientesMenores() {
        List<Paciente> pacientes = new ArrayList<>();
        List<Paciente> pacientesMenores = new ArrayList<>();

        pacientes.add(new Paciente(1L, 41339109L, "Nicolas", "Roldan", LocalDate.of(1998, 10, 26)));
        pacientes.add(new Paciente(2L, 41223956L, "Ivana", "Escudero", LocalDate.of(1998, 2, 4)));
        pacientes.add(new Paciente(3L, 13467088L, "Angela", "Sosnowski", LocalDate.of(1959, 8, 26)));
        pacientes.add(new Paciente(4L, 56963520L, "Juan Valentin", "Roldan", LocalDate.of(2017, 9, 7)));
        pacientes.add(new Paciente(5L, 54236562L, "Pedro", "Rodriguez", LocalDate.of(2019, 3, 5)));

        for (Paciente p : pacientes) {
            if ((Period.between(p.getFechaNacimiento(), LocalDate.now()).getYears()) < 18) {
                pacientesMenores.add(p);
            }
        }

        return pacientesMenores;
    }

}

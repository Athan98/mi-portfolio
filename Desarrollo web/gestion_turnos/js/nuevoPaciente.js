//Declaracion de variables
const url = "http://192.168.1.8:8080/pacientes/crear";

let formulario=document.querySelector("#datosFormulario");

formulario.addEventListener("submit",e=>{
    e.preventDefault();

    //Obtener datos del form
    let datos=new FormData(formulario);

    peticion={
        method:"POST",
        body:datos
    }

    
})

console.log(formulario)
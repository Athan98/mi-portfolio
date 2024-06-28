let numeroSecreto = 0;
let intentos = 0;
let numerosSorteados = [];
let numeroMaximo = 10;

function asignarTextoElemento(elemento, texto) {
    let elementoHTML = document.querySelector(elemento);
    elementoHTML.innerHTML = texto;
    //Buena practica colocar el return
    return;
}
//Declaracion de funcion intentoDeUsuario()
function verificarIntento() {
    let numeroUsuario = parseInt(document.querySelector("#numeroUsuario").value);

    if (numeroUsuario === numeroSecreto) {
        asignarTextoElemento(".texto__parrafo", `Acertaste el número en ${intentos} ${(intentos === 1) ? "vez" : "veces"}`);
        //Cambiar atributo disabled para hacer un nuevo juego cuando se acierta
        document.querySelector("#reiniciar").removeAttribute("disabled");
    } else {
        //El usuario no acertó
        if (numeroUsuario > numeroSecreto) {
            asignarTextoElemento(".texto__parrafo", "El numero secreto es menor")
        } else {
            asignarTextoElemento(".texto__parrafo", "El numero secreto es mayor")
        }
        intentos++;
        limpiarCaja();
    }
    return;
}

//Funcion para generar el numero aleatorio
function generarNumeroSecreto() {

    let numeroGenerado = Math.floor(Math.random() * numeroMaximo) + 1;

    //Si ya sorteamos todos los numeros
    if (numerosSorteados.length == numeroMaximo) {

        asignarTextoElemento(".texto__parrafo", "Ya se sortearon todos los numeros posibles");

    } else {

        //Recorrer lista. Si el numeroGenerado esta incluido en la lista
        if (numerosSorteados.includes(numeroGenerado)) {
            //Recursividad. La funcion se puede llamar a si misma
            return generarNumeroSecreto();
        } else {
            //Agregar el numero para que en la proxima jugada no vuelva a jugarse
            numerosSorteados.push(numeroGenerado);
            return numeroGenerado;
        }

    }

}

function limpiarCaja() {
    document.querySelector("#numeroUsuario").value = "";
}

function condicionesIniciales() {
    asignarTextoElemento("h1", "Hora del desafío!");
    asignarTextoElemento(".texto__parrafo", `Ingresa un número del 1 al ${numeroMaximo}`);
    numeroSecreto = generarNumeroSecreto();
    intentos = 1;
}

function reiniciarJuego() {

    //Limpiar la caja
    limpiarCaja();

    //Indicar mensaje de intervalo de numeros
    //Generar un nuevo numero aleatorio
    //Inicializar el numero de intentos
    condicionesIniciales();

    //Deshabilitar el boton de nuevo juego
    document.querySelector("#reiniciar").setAttribute("disabled", true);
}

condicionesIniciales();

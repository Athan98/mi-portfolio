
function asignarTextoElemento(elemento, texto) {
    let elementoHTML = document.querySelector(elemento);
    elementoHTML.innerHTML = texto;
    return;
}

function encriptarTexto() {
    let textoAEncriptar = document.querySelector("#textoIngresado").value;
    if (verificarInput(textoAEncriptar)) {
        //Añadir estilo para cuando se cumpla alguna de las condiciones
        document.querySelector("#verificacionTextoIngresado").style.color = "red";
    } else {
        document.querySelector("#verificacionTextoIngresado").style.color = "black";
        asignarTextoElemento("#textoResultante", procesoEncriptacion(textoAEncriptar));
        limpiarCaja();
    }
    return;
}

function desencriptarTexto() {
    let textoADesencriptar = document.querySelector("#textoIngresado").value;
    if (verificarInput(textoADesencriptar)) {
        //Añadir estilo para cuando se cumpla alguna de las condiciones
        document.querySelector("#verificacionTextoIngresado").style.color = "red";
    } else {
        document.querySelector("#verificacionTextoIngresado").style.color = "black";
        asignarTextoElemento("#textoResultante", procesoDesencriptacion(textoADesencriptar));
        limpiarCaja();
    }

    return;
}

function procesoDesencriptacion(texto) {

    texto = texto.replace(/enter/igm, "e");
    texto = texto.replace(/imes/igm, "i");
    texto = texto.replace(/ai/igm, "a");
    texto = texto.replace(/ober/igm, "o");
    texto = texto.replace(/ufat/igm, "u");

    return texto;
}

function procesoEncriptacion(texto) {
    texto = texto.replace(/e/igm, "enter");
    texto = texto.replace(/i/igm, "imes");
    texto = texto.replace(/a/igm, "ai");
    texto = texto.replace(/o/igm, "ober");
    texto = texto.replace(/u/igm, "ufat");

    return texto;
}

function limpiarCaja() {
    document.querySelector("#textoIngresado").value = "";
    return;
}

function verificarInput(textoInput) {

    // Expresiones regulares para verificar
    const mayusculas = /[A-Z]/;
    const acentos = /[áéíóúÁÉÍÓÚüÜ]/;
    const caracteresEspeciales = /[@#$%^&*(),.?":{}|<>]/;
    const numeros = /\d/;

    // Verificar cada condición y devolver true si alguna se cumple
    return mayusculas.test(textoInput) ||
        acentos.test(textoInput) ||
        caracteresEspeciales.test(textoInput) ||
        numeros.test(textoInput);
}

function copiarTextoResultante() {

    //Obtener el elemento textoResultante
    const textoResultante = document.querySelector("#textoResultante");

    //Creo un textArea temporal para guardar el contenido de textoResultante
    const textAreaTemporal = document.createElement("textarea");
    textAreaTemporal.value = textoResultante.textContent.trim();
    console.log(textAreaTemporal);

    //Agrego el textArea al DOM para poder seleccionarlo
    document.body.appendChild(textAreaTemporal);

    //Seleccionar y copiar el contenido del textArea al portapapeles
    textAreaTemporal.select();
    document.execCommand("copy");

    //Remover el textArea del DOM
    document.body.removeChild(textAreaTemporal);

    console.log("Contenido copiado!")

}

function reiniciarEncriptador() {
    condicionesIniciales();
}

function condicionesIniciales() {
    //Limpiamos el contenido del input
    limpiarCaja();
    //Limpiamos el contenido del texto resultante
    asignarTextoElemento("#textoResultante", "");
    //Creamos e insertamos la imagen por defecto
    let imagen = document.createElement("img");
    imagen.src = "./img/mensajeNoEncontrado.png";
    imagen.alt = "Texto no encontrado";
    imagen.title = "Texto no encontrado";

    document.querySelector("#textoResultante").appendChild(imagen);
    //Pintar de negro nuevamente el aviso de letras minusculas. VER SI SE PUEDE MEJORAR!!!
    document.querySelector("#verificacionTextoIngresado").style.color = "black";
}

condicionesIniciales();
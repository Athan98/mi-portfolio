
function asignarTextoElemento(elemento, texto) {
    let elementoHTML = document.querySelector(elemento);
    elementoHTML.innerHTML = texto;
    return;
}

function encriptarTexto() {
    let textoAEncriptar = document.querySelector("#textoIngresado").value;
    asignarTextoElemento("#textoResultante", procesoEncriptacion(textoAEncriptar));
    limpiarCaja();
}

function desencriptarTexto() {
    let textoADesencriptar = document.querySelector("#textoIngresado").value;
    asignarTextoElemento("#textoResultante", procesoDesencriptacion(textoADesencriptar));
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
}
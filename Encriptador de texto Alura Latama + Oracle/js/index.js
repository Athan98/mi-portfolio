
function asignarTextoElemento(elemento, texto) {
    let elementoHTML = document.querySelector(elemento);
    elementoHTML.innerHTML = texto;
    return;
}

function agregarElementoAlDOM(elemento, idElemento, claseElemento, contenido, elementoDondeSeAgrega) {
    //Crear el elemento
    const nuevoElemento = document.createElement(elemento);
    //Agregarle un id
    nuevoElemento.id = idElemento;
    //Agregarle una clase
    nuevoElemento.classList.add(claseElemento);
    //Agregarle contenido
    nuevoElemento.innerHTML = contenido;
    //Capturar el contenedor
    const contenedor = document.querySelector(elementoDondeSeAgrega);
    if (contenedor) {
        contenedor.appendChild(nuevoElemento);
    }
    if (elemento === "button") {
        nuevoElemento.addEventListener("click", copiarTextoResultante);
    }
    return nuevoElemento;
}


function encriptarTexto() {
    let textoAEncriptar = document.querySelector("#textoIngresado").value;
    if (verificarInput(textoAEncriptar)) {
        document.querySelector("#verificacionTextoIngresado").style.color = "red";
    } else {
        document.querySelector("#verificacionTextoIngresado").style.color = "black";
        //Limpiamos el contenido del textoResultante para agregar el texto desencriptado

        asignarTextoElemento(".textoResultante-contenedor", "");

        agregarElementoAlDOM(
            "textarea",
            "textoResultante",
            "textoResultante",
            "",
            ".textoResultante-contenedor"
        );

        agregarElementoAlDOM(
            "button",
            "btnCopiarTextoResultante",
            "btnCopiarTextoResultante",
            '<i class="fa-solid fa-copy"></i>Copiar',
            ".textoResultante-contenedor"
        );

        asignarTextoElemento("#textoResultante", procesoEncriptacion(textoAEncriptar));
        limpiarCajaTextoIngresado();
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
        //Limpiamos el contenido del textoResultante para agregar el texto desencriptado
        asignarTextoElemento(".textoResultante-contenedor", "");
        agregarElementoAlDOM("textarea", "textoResultante", "textoResultante", ".textoResultante-contenedor");
        asignarTextoElemento("#textoResultante", procesoDesencriptacion(textoADesencriptar));
        limpiarCajaTextoIngresado();
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

function limpiarCajaTextoIngresado() {
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

    // Cambiar el texto del botón a "Copiado"
    const btnCopiar = document.querySelector('#btnCopiarTextoResultante');
    btnCopiar.innerHTML = '<i class="fa-solid fa-check"></i>Texto copiado!';
    //Remover y agregar clase para hacer cuenta de que el texto se copio
    btnCopiar.classList.remove("btnCopiarTextoResultante");
    btnCopiar.classList.add("btnCopiarTextoResultante-copiado");

    //Volver el boton al estado normal
    setTimeout(() => {
        btnCopiar.innerHTML = '<i class="fa-solid fa-copy"></i>Copiar';
        btnCopiar.classList.remove("btnCopiarTextoResultante-copiado");
        btnCopiar.classList.add("btnCopiarTextoResultante");
    }, 3000); // Cambiar el texto de vuelta después de 2 segundos

}

function reiniciarEncriptador() {
    condicionesIniciales();
}

function condicionesIniciales() {

    //Capturamos el contenedor de textoResultante
    const contenedorTextoResultante = document.querySelector(".textoResultante-contenedor");

    //Limpiamos el contenido del input
    limpiarCajaTextoIngresado();

    //Limpiamos el contenido del texto resultante
    asignarTextoElemento(".textoResultante-contenedor", "");

    //Creamos e insertamos la imagen y los parrafos por defecto
    let imagen = document.createElement("img");
    imagen.src = "./img/mensajeNoEncontrado.png";
    imagen.alt = "Texto no encontrado";
    imagen.title = "Texto no encontrado";
    contenedorTextoResultante.appendChild(imagen);

    let p1 = document.createElement("p");
    p1.id = "parrafo1-textoNoEncontrado";
    p1.classList.add("parrafo1-textoNoEncontrado");
    p1.textContent = "Ningún mensaje fue encontrado";
    contenedorTextoResultante.appendChild(p1);

    let p2 = document.createElement("p");
    p2.id = "parrafo2-textoNoEncontrado";
    p2.classList.add("parrafo2-textoNoEncontrado");
    p2.textContent = "Ingresa el texto que deseas encriptar o desencriptar";
    contenedorTextoResultante.appendChild(p2);

    //Pintar de negro nuevamente el aviso de letras minusculas. VER SI SE PUEDE MEJORAR!!!
    document.querySelector("#verificacionTextoIngresado").style.color = "black";
}

condicionesIniciales();
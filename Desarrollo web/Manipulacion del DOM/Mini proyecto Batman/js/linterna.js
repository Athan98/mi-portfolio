//CAPTURAR LOS SONIDOS
let sonidoBatman = document.querySelector(".bati_encendido")
let sonidoBoton = document.querySelector(".bati_click")

//CAPTURAR CAJAS QUE TIENEN LA IMAGEN Y EL BOTON
let batman = document.querySelector(".batman")
let batmanBoton = document.querySelector(".bati_boton")

let estadoLinterna = "apagado"

//EVENTO
//CAPTURAR
batmanBoton.addEventListener("click",controlarLinterna)

//FUNCIONES
function controlarLinterna() {
    if (estadoLinterna == "apagado") {

        estadoLinterna = "encendido"

        //EFECTO DE SONIDO
        sonidoLinterna()

        //MANIPULAR CLASES. EN ESTE CASO ESTAMOS AGREGANDO UNA CLASE AL DIV
        batman.classList.add("batman-activo")
    } else {

        estadoLinterna = "apagado"

        //EFECTO DE SONIDO
        sonidoLinterna()

        //MANIPULAR CLASE
        batman.classList.remove("batman-activo")
    }
}

function sonidoLinterna() {
    //¿EL SONIDO DE BATMAN ESTA PAUSADO?
    if (sonidoBatman.paused) {
        //SI ES TRUE
        sonidoBoton.play()
        sonidoBatman.play()
    } else {
        //SI ES FALSE
        sonidoBoton.play()
        sonidoBatman.pause()
        sonidoBatman.currentTime=0
    }
}



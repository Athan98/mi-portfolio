//Declaracion de variables
const url = "http://192.168.1.8:8080/llamados/ultimosdosllamados";
let llamados;
let nombrePaciente = "";
let documentoPaciente = "";
let nombreMedico = "";
let nroConsultorio = "";
let nombrePaciente2 = "";
let documentoPaciente2 = "";
let nombreMedico2 = "";
let nroConsultorio2 = "";
let contenedor1 = document.querySelector(".contenedor1");

//Funcion que reproduce audio de notificacion
const reproducirNotificacion = () => {
    const audio = document.getElementById("notificacion");
    audio.play().catch(error => {
        console.error('Error al reproducir audio:', error);
    });


};

//Funcion que verifica si hay algun cambio en el contenedor1
const verificarDatosLlamadoActual = (np, dp, nm, nc) => {
    let nombrePacienteActual = document.getElementById("nombrePaciente").innerText;
    let documentoPacienteActual = document.getElementById("documentoPaciente").innerText;
    let nombreMedicoActual = document.getElementById("nombreMedico").innerText;
    let nroConsultorioActual = document.getElementById("nroConsultorio").innerText;

    if (np != nombrePacienteActual || dp != documentoPacienteActual
        || nm != nombreMedicoActual || nc != nroConsultorioActual) {
        reproducirNotificacion();
        return true;
    }

    return false;

}

//Funcion que cambia de color el background del contenedor1
const colorNotificacion = () => {
    contenedor1.classList.remove("contenedor1");
    contenedor1.classList.add("contenedor1-notificacion");
    setTimeout(() => {
        contenedor1.classList.remove("contenedor1-notificacion");
        contenedor1.classList.add("contenedor1");
    }, 5000);
}

//Funcion que verifica cambios en el contenedor2
const verificarDatosLlamadoAnterior = (np, dp, nm, nc) => {
    let nombrePacienteAnterior = document.getElementById("nombrePaciente2").innerText;
    let documentoPacienteAnterior = document.getElementById("documentoPaciente2").innerText;
    let nombreMedicoAnterior = document.getElementById("nombreMedico2").innerText;
    let nroConsultorioAnterior = document.getElementById("nroConsultorio2").innerText;

    if (np != nombrePacienteAnterior || dp != documentoPacienteAnterior
        || nm != nombreMedicoAnterior || nc != nroConsultorioAnterior) {
        reproducirNotificacion();
        colorNotificacion();
        return true;
    }

    return false;

}

//Obtener y mostrar el resultado de /llamados/ultimosdospacientes
const getUltimosDosPacientes = async () => {
    try {
        const res = await axios(url);
        llamados = res.data;
        console.log(llamados)

        if (llamados.length > 0) {
            let ultimoLlamado = llamados[0];

            nombrePaciente = ultimoLlamado.turno.paciente.apellido;
            documentoPaciente = ultimoLlamado.turno.paciente.dni;
            nombreMedico = ultimoLlamado.turno.medico.apellido;
            nroConsultorio = ultimoLlamado.nroConsultorio;

            if (verificarDatosLlamadoActual(nombrePaciente, documentoPaciente, nombreMedico, nroConsultorio) == true) {

                document.getElementById("nombrePaciente").innerText = nombrePaciente;
                document.getElementById("documentoPaciente").innerText = documentoPaciente;
                document.getElementById("nombreMedico").innerText = nombreMedico;
                document.getElementById("nroConsultorio").innerText = nroConsultorio;

            } else {

                return;

            }

        }

        if (llamados.length > 1) {
            let anteriorLlamado = llamados[1];

            nombrePaciente2 = anteriorLlamado.turno.paciente.apellido;
            documentoPaciente2 = anteriorLlamado.turno.paciente.dni;
            nombreMedico2 = anteriorLlamado.turno.medico.apellido;
            nroConsultorio2 = anteriorLlamado.nroConsultorio;

            if (verificarDatosLlamadoAnterior(nombrePaciente2, documentoPaciente2, nombreMedico2, nroConsultorio2) == true) {

                document.getElementById("nombrePaciente2").innerText = nombrePaciente2;
                document.getElementById("documentoPaciente2").innerText = documentoPaciente2;
                document.getElementById("nombreMedico2").innerText = nombreMedico2;
                document.getElementById("nroConsultorio2").innerText = nroConsultorio2;

            } else {

                return;

            }

        }

    } catch (error) {
        console.log(error)
    }
}

//Llamado a funcion
getUltimosDosPacientes()

//EJECUTAR CADA 5 SEGUNDOS AUTOMATICAMENTE
setInterval(getUltimosDosPacientes, 5000);
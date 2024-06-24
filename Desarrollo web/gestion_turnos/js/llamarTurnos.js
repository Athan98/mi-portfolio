//Declaracion de variables
const urlObtenerTurnos = "http://192.168.1.8:8080/turnos/listar";
const urlCrearLlamado = "http://192.168.1.8:8080/llamados/crear";
const urlObtenerMedicos = "http://192.168.1.8:8080/medicos/listar";
let urlObtenerTurnosPorMedicoYFecha = "http://192.168.1.8:8080/turnos/listarturnosmedico";

// Función para formatear la fecha a yyyy-MM-dd
const formatearFecha = (fechaISO) => {
    const fecha = new Date(fechaISO);
    const dia = fecha.getDate().toString().padStart(2, '0'); // Obtener día y padStart para asegurar 2 dígitos
    const mes = (fecha.getMonth() + 1).toString().padStart(2, '0'); // Obtener mes y padStart para asegurar 2 dígitos
    const anio = fecha.getFullYear();
    return `${anio}-${mes}-${dia}`;
};

const llenarComboBox = async () => {
    try {
        const res = await axios(urlObtenerMedicos);
        medicos = res.data;

        const selectMedicos = document.querySelector("#medico");

        // Limpiar opciones previas del select (opcional, dependiendo de la lógica de tu aplicación)
        selectMedicos.innerHTML = '';

        // Iterar sobre el array de médicos y agregar cada médico como una opción en el select
        medicos.forEach(medico => {
            // Crear un nuevo elemento opción
            const option = document.createElement('option');

            // Asignar el valor y texto de la opción
            option.value = medico.id_medico;  // Suponiendo que el id es el valor a usar
            option.textContent = `${medico.apellido}, ${medico.nombre}`;  // Puedes personalizar el texto como prefieras

            // Agregar la opción al select
            selectMedicos.appendChild(option);
        });

    } catch (error) {
        console.log(error);
    }
};

//Funcion para crear llamado cuando apretas el boton LLAMAR
const crearLlamado=async(idTurno)=>{
    try {
        //Armas el json de Llamado
        const llamado={
            fechaHoraLlamado:new Date().toISOString(),
            nroConsultorio:"5",
            turno:{
                id_turno:idTurno
            }

        }
        //Hacer la solicitud POST
        const res=await axios.post(urlCrearLlamado,llamado);
        console.log("Llamado creado exitosamente"),res.data;
    } catch (error) {
        console.log("No se pudo crear el llamado",error)
    }
}

const llenarTablaPorMedicoYFecha = async (fechaInput, idMedico) => {
    try {
        let url = `${urlObtenerTurnosPorMedicoYFecha}/${fechaInput}/${idMedico}`;
        const res = await axios(url);
        turnos = res.data;

        const cuerpoTabla = document.querySelector("#turnos tbody");

        cuerpoTabla.innerHTML = '';

        // Llenar tabla con los datos
        turnos.forEach(turno => {
            let fila = document.createElement("tr");
            // Obtener fecha y hora formateadas
            const fechaFormateada = formatearFecha(turno.fecha);
            const hora = new Date(turno.fecha).toLocaleTimeString();

            fila.innerHTML = `
                <td>${turno.id_turno}</td>
                <td>${turno.paciente.apellido}</td>
                <td>${turno.paciente.dni}</td>
                <td>${turno.medico.apellido}</td>
                <td>${fechaFormateada}</td>
                <td>${hora}</td>
                <td><button onclick="crearLlamado(${turno.id_turno})">LLAMAR</button></td>
            `;

            cuerpoTabla.appendChild(fila);
        });


    } catch (error) {
        console.log(error)
    }
};

const llenarTabla = async () => {
    try {
        const res = await axios(urlObtenerTurnos);
        turnos = res.data;
        console.log(turnos);

        const cuerpoTabla = document.querySelector("#turnos tbody");

        // Llenar tabla con los datos
        turnos.forEach(turno => {
            let fila = document.createElement("tr");
            // Obtener fecha y hora formateadas
            const fechaFormateada = formatearFecha(turno.fecha);
            const hora = new Date(turno.fecha).toLocaleTimeString();

            fila.innerHTML = `
                <td>${turno.id_turno}</td>
                <td>${turno.paciente.apellido}</td>
                <td>${turno.paciente.dni}</td>
                <td>${turno.medico.apellido}</td>
                <td>${fechaFormateada}</td>
                <td>${hora}</td>
                <td><button onclick="crearLlamado(${turno.id_turno})">LLAMAR</button></td>
            `;

            cuerpoTabla.appendChild(fila);
        });


    } catch (error) {
        console.log(error)
    }
};

llenarComboBox();
llenarTabla();

// Escuchar el evento submit del formulario de búsqueda y llamar a llenarTablaPorMedicoYFecha
document.addEventListener('DOMContentLoaded', () => {
    const formBusqueda = document.querySelector('#formBusqueda');

    formBusqueda.addEventListener('submit', async (event) => {
        event.preventDefault(); // Evitar el envío tradicional del formulario

        const medicoId = document.querySelector('#medico').value;
        const fechaSeleccionada = document.querySelector('#fecha').value;

        if (medicoId == '' || fechaSeleccionada == '') {
            alert("Debe seleccionar el médico y la fecha");
        } else {
            await llenarTablaPorMedicoYFecha(fechaSeleccionada, medicoId);
        }

    });
});
document.addEventListener("DOMContentLoaded", () => {
    const parametrosURL = new URLSearchParams(window.location.search);
    const buscadorEntrada = document.querySelector("#fechaEstudio");
    const buttonBuscador = document.querySelector("#filtrarEstudios");
    const buttonLimpiar = document.querySelector("#limpiarBusqueda");
    const idPaciente = parametrosURL.get("id");
    let estudiosPaciente = []; // Variable para almacenar los estudios cargados

    const traerPaciente = async (id) => {
        try {
            const res = await axios.get(`http://192.168.1.9:5000/pacientes/${id}`);
            const paciente = res.data;

            document.querySelector("#paciente-nombreApellido").innerHTML = `${paciente.apellidoPaciente}, ${paciente.nombrePaciente}`;
            document.querySelector("#dniPaciente").innerHTML = paciente.dniPaciente;
            document.querySelector("#edadPaciente").innerHTML = paciente.edadPaciente;
            document.querySelector("#usuarioPaciente").innerHTML = paciente.usuarioPaciente;
            document.querySelector("#passwordPaciente").innerHTML = paciente.passwordPaciente;

            const enlacePaciente = document.querySelector("#enlacePaciente");
            enlacePaciente.href = `/front/pages/gestion/verMasPaciente.html?id=${id}`;
        } catch (error) {
            console.log("-Error al traer el registro-", error);
        }
    };

    const formatDate = (dateString) => {
        const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
        return new Date(dateString).toLocaleDateString('es-ES', options);
    };

    const listarEstudiosPaciente = async (id) => {
        try {
            const res = await axios.get(`http://192.168.1.9:5000/estudios/paciente/${id}`);
            estudiosPaciente = res.data; // Almacena los estudios

            const contenedorEstudiosPaciente = document.querySelector("#contenedorEstudios");
            contenedorEstudiosPaciente.innerHTML = "";

            estudiosPaciente.forEach(e => {
                const divEstudioIndividual = document.createElement("div");
                divEstudioIndividual.classList.add("estudioIndividual");

                const btnMas = document.createElement("button");
                btnMas.textContent = "VER MAS";
                btnMas.classList.add("btnMas");
                btnMas.addEventListener("click", () => {
                    window.location.href = `/front/pages/gestion/verMasEstudio.html?id=${e.id}`
                });

                const btnEliminar = document.createElement("button");
                btnEliminar.textContent = "ELIMINAR ESTUDIO";
                btnEliminar.classList.add("btnEliminar");
                btnEliminar.addEventListener("click", () => {
                    borrarEstudio(e.id, id);
                });

                divEstudioIndividual.innerHTML = `
                <h4>${e.tipoEstudio}</h4>
                <h6>${formatDate(e.fechaEstudio)}</h6>
                <h6>${e.medico.apellidoMedico} ${e.medico.nombreMedico}</h6>
                `;

                divEstudioIndividual.appendChild(btnMas);
                divEstudioIndividual.appendChild(btnEliminar);
                contenedorEstudiosPaciente.appendChild(divEstudioIndividual);
            });

            console.log(estudiosPaciente);
        } catch (error) {
            console.log("-Error al traer los estudios del paciente-", error);
        }
    };

    // Función para formatear la fecha a 'YYYY-MM-DD'
    const formatDateToInput = (dateString) => {
        const date = new Date(dateString); // Convierte la cadena de fecha a un objeto Date
        const year = date.getFullYear(); // Obtiene el año de la fecha
        const month = String(date.getMonth() + 1).padStart(2, '0'); // Obtiene el mes (0-11) y lo convierte a formato de dos dígitos
        const day = String(date.getDate()).padStart(2, '0'); // Obtiene el día y lo convierte a formato de dos dígitos
        return `${year}-${month}-${day}`; // Retorna la fecha en el formato 'YYYY-MM-DD'
    };

    const filtrarEstudiosPorFecha = async () => {
        const fechaInput = buscadorEntrada.value; // Obtiene el valor del input
        const contenedorEstudiosPaciente = document.querySelector("#contenedorEstudios");

        // Limpia el contenedor
        contenedorEstudiosPaciente.innerHTML = "";

        if (!fechaInput) {
            await listarEstudiosPaciente(idPaciente); // Si no hay fecha ingresada, lista todos los estudios
            return;
        }

        // Filtra estudios que coincidan con la fecha ingresada
        const estudiosFiltrados = estudiosPaciente.filter(estudio => {
            const fechaEstudio = formatDateToInput(estudio.fechaEstudio); // Convierte la fecha del estudio a 'YYYY-MM-DD'
            return fechaEstudio === fechaInput; // Compara con la fecha ingresada
        });

        if (estudiosFiltrados.length === 0) {
            alert("No se encontró ningún estudio con la fecha ingresada."); // Notifica si no hay coincidencias
            await listarEstudiosPaciente(idPaciente); // Lista todos los estudios nuevamente
        } else {
            // Lista los estudios filtrados
            estudiosFiltrados.forEach(e => {
                agregarEstudioAContainer(e, contenedorEstudiosPaciente, idPaciente);
            });
        }
    };

    // Función para agregar un estudio al contenedor
    const agregarEstudioAContainer = (e, contenedor, idPaciente) => {
        const divEstudioIndividual = document.createElement("div");
        divEstudioIndividual.classList.add("estudioIndividual");

        const btnMas = document.createElement("button");
        btnMas.textContent = "VER MAS";
        btnMas.classList.add("btnMas");
        btnMas.addEventListener("click", () => {
            window.location.href = `/front/pages/gestion/verMasEstudio.html?id=${e.id}`; // Navega a los detalles del estudio
        });

        const btnEliminar = document.createElement("button");
        btnEliminar.textContent = "ELIMINAR ESTUDIO";
        btnEliminar.classList.add("btnEliminar");
        btnEliminar.addEventListener("click", () => {
            borrarEstudio(e.id, idPaciente); // Llama a la función para borrar el estudio
        });

        // Crear el contenido del div
        divEstudioIndividual.innerHTML = `
        <h4>${e.tipoEstudio}</h4>
        <h6>${formatDate(e.fechaEstudio)}</h6>
        <h6>${e.medico.apellidoMedico} ${e.medico.nombreMedico}</h6>
    `;

        divEstudioIndividual.appendChild(btnMas); // Agrega el botón "VER MAS"
        divEstudioIndividual.appendChild(btnEliminar); // Agrega el botón "ELIMINAR ESTUDIO"
        contenedor.appendChild(divEstudioIndividual); // Agrega el div al contenedor
    };
    // Función para limpiar la búsqueda
    const limpiarBusqueda = async () => {
        buscadorEntrada.value = ""; // Limpia el input de fecha
        await listarEstudiosPaciente(idPaciente); // Lista todos los estudios nuevamente
    };

    // Asignar el evento al botón buscador
    buttonBuscador.addEventListener("click", filtrarEstudiosPorFecha);

    // Asignar el evento al botón limpiar
    buttonLimpiar.addEventListener("click", limpiarBusqueda);

    const borrarEstudio = async (idEstudio, idPaciente) => {
        if (idEstudio && confirm("¿Estás seguro de que deseas eliminar este estudio?")) {
            try {
                await axios.delete(`http://192.168.1.9:5000/estudios/${idEstudio}`);
                listarEstudiosPaciente(idPaciente);
                alert("Registro eliminado");
            } catch (error) {
                console.error("Error para borrar el registro: ", error);
                alert("No se ha podido eliminar el estudio.");
            }
        }
    }

    const editarPaciente = () => {
        if (idPaciente) {
            window.location.href = `/front/pages/gestion/editarPaciente.html?id=${idPaciente}`;
        }
    };

    const agregarEstudio = () => {
        if (idPaciente) {
            window.location.href = `/front/pages/gestion/nuevoEstudio.html?id=${idPaciente}`;
        }
    };

    // Asignar eventos a los botones
    document.querySelector("#btnEditar").addEventListener("click", editarPaciente);
    document.querySelector("#btnAgregarEstudio").addEventListener("click", agregarEstudio);

    if (idPaciente) {
        traerPaciente(idPaciente);
        listarEstudiosPaciente(idPaciente);
    }
});
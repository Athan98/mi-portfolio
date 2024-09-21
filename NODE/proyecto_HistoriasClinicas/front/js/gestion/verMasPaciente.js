
document.addEventListener("DOMContentLoaded", () => {

    const parametrosURL = new URLSearchParams(window.location.search);

    const idPaciente = parametrosURL.get("id");

    const traerPaciente = async (id) => {
        try {
            const res = await axios.get(`http://192.168.1.9:5000/pacientes/${id}`);
            const paciente = res.data;


            document.querySelector("#paciente-nombreApellido").innerHTML = `${paciente.apellidoPaciente}, ${paciente.nombrePaciente}`;
            document.querySelector("#dniPaciente").innerHTML = paciente.dniPaciente;
            document.querySelector("#edadPaciente").innerHTML = paciente.edadPaciente;
            document.querySelector("#usuarioPaciente").innerHTML = paciente.usuarioPaciente;
            document.querySelector("#passwordPaciente").innerHTML = paciente.passwordPaciente;
        } catch (error) {
            console.log("-Error al traer el registro-", error)
        }
    };

    const formatDate = (dateString) => {
        const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
        return new Date(dateString).toLocaleDateString('es-ES', options);
    };

    const listarEstudiosPaciente = async (id) => {
        try {
            const res = await axios.get(`http://192.168.1.9:5000/estudios/paciente/${id}`);
            const estudiosPaciente = res.data;

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
                    borrarEstudio(e.id);
                });


                //Crear el contenido del div
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

    //Funcion para borrar pacientes
    const borrarEstudio = async (idEstudio) => {

        if (idEstudio && confirm("¿Estás seguro de que deseas eliminar este estudio?")) {
            try {
                await axios.delete(`http://192.168.1.9:5000/estudios/${idEstudio}`);
                //Recargar posteos
                listarEstudiosPaciente();
                alert("Registro eliminado");
            } catch (error) {
                console.error("Error para borrar el registro: ", error);
                alert("No se ha podido eliminar el estudio.");
            }
        }
    }

    // Definir funciones globales
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
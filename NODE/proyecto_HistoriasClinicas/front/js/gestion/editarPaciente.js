document.addEventListener("DOMContentLoaded", () => {

    const parametrosURL = new URLSearchParams(window.location.search);
    const idPaciente = parametrosURL.get("id");
    const formulario = document.querySelector("#form-editarPaciente");

    // Función para traer el estudio, pacientes, y médicos
    const traerPaciente = async (id) => {
        try {
            const res = await axios.get(`http://192.168.1.9:5000/pacientes/${id}`);
            const paciente = res.data;

            document.querySelector("#nombrePaciente").value = paciente.nombrePaciente;
            document.querySelector("#apellidoPaciente").value = paciente.apellidoPaciente;
            document.querySelector("#docPaciente").value = paciente.dniPaciente;
            document.querySelector("#edadPaciente").value = paciente.edadPaciente;
            document.querySelector("#usuarioPaciente").value = paciente.usuarioPaciente;
            document.querySelector("#passwordPaciente").value = paciente.passwordPaciente;

        } catch (error) {
            console.log("-Error al traer el registro-", error)
        }
    };

    // Nueva función de inicialización
    const init = async () => {
        if (idPaciente) {
            await traerPaciente(idPaciente);
        }
    };

    // Inicia el proceso cuando el DOM esté listo
    init();


    formulario.addEventListener("submit", async (p) => {
        p.preventDefault();

        const pacienteActualizado = {
            nombrePaciente: document.querySelector("#nombrePaciente").value,
            apellidoPaciente: document.querySelector("#apellidoPaciente").value,
            dniPaciente: document.querySelector("#docPaciente").value,
            edadPaciente: document.querySelector("#edadPaciente").value,
            usuarioPaciente: document.querySelector("#usuarioPaciente").value,
            passwordPaciente: document.querySelector("#passwordPaciente").value,
        }

        try {
            await axios.put(`http://192.168.1.9:5000/pacientes/${idPaciente}`, pacienteActualizado);
            alert("Paciente actualizado correctamente");

            //Redirigimos al index.html una vez se actualiza la pelicula
            window.location.href = `/front/pages/gestion/verMasPaciente.html?id=${idPaciente}`;
        } catch (error) {
            console.error("Error al actualizar el paciente", error);
        }
    });

});
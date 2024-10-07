document.addEventListener("DOMContentLoaded", () => {

    const parametrosURL = new URLSearchParams(window.location.search);
    const idPaciente = parametrosURL.get("id");
    const formulario = document.querySelector("#form-editarPaciente");
    const ip="192.168.1.9";

    // Función para traer el estudio, pacientes, y médicos
    const traerPaciente = async (id) => {
        try {
            const res = await axios.get(`http://${ip}:5000/pacientes/${id}`);
            const paciente = res.data;

            document.querySelector("#docPaciente").value = paciente.dniPaciente;
            document.querySelector("#usuarioPaciente").value = paciente.usuarioPaciente;

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
            dniPaciente: document.querySelector("#docPaciente").value,
            usuarioPaciente: document.querySelector("#usuarioPaciente").value,
        }

        try {
            await axios.put(`http://${ip}:5000/pacientes/${idPaciente}`, pacienteActualizado);
            alert("Paciente actualizado correctamente");

            //Redirigimos al index.html una vez se actualiza la pelicula
            window.location.href = `/historias_clinicas/front/pages/gestion/verMasPaciente.html?id=${idPaciente}`;
        } catch (error) {
            console.error("Error al actualizar el paciente", error);
        }
    });

});
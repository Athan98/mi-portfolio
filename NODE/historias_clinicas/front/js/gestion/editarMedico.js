document.addEventListener("DOMContentLoaded", () => {

    const parametrosURL = new URLSearchParams(window.location.search);
    const idMedico = parametrosURL.get("id");
    const formulario = document.querySelector("#form-editarMedico");

    // Función para traer el estudio, pacientes, y médicos
    const traerMedico = async (id) => {
        try {
            const res = await axios.get(`http://192.168.1.9:5000/medicos/${id}`);
            const medico = res.data;

            document.querySelector("#nombreMedico").value = medico.nombreMedico;
            document.querySelector("#apellidoMedico").value = medico.apellidoMedico;
            document.querySelector("#especialidadMedico").value = medico.especialidadMedico;

        } catch (error) {
            console.log("-Error al traer el registro-", error)
        }
    };

    // Nueva función de inicialización
    const init = async () => {
        if (idMedico) {
            await traerMedico(idMedico);
        }
    };

    // Inicia el proceso cuando el DOM esté listo
    init();


    formulario.addEventListener("submit", async (m) => {
        m.preventDefault();

        const medicoActualizado = {
            nombreMedico: document.querySelector("#nombreMedico").value,
            apellidoMedico: document.querySelector("#apellidoMedico").value,
            especialidadMedico: document.querySelector("#especialidadMedico").value,
        }

        try {
            await axios.put(`http://192.168.1.9:5000/medicos/${idMedico}`, medicoActualizado);
            alert("Médico actualizado correctamente");

            //Redirigimos al index.html una vez se actualiza la pelicula
            window.location.href = `/historias_clinicas/front/pages/gestion/gestionMedicos.html`;
        } catch (error) {
            console.error("Error al actualizar el médico", error);
        }
    });

});
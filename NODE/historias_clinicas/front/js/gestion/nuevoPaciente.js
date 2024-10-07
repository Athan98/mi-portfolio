document.addEventListener("DOMContentLoaded", () => {

    const formulario = document.querySelector("#form-nuevoPaciente");
    const ip="192.168.1.9";

    formulario.addEventListener("submit", async (p) => {
        p.preventDefault();

        const pacienteNuevo = {
            dniPaciente: document.querySelector("#docPaciente").value,
            usuarioPaciente: document.querySelector("#usuarioPaciente").value,
            passwordPaciente: document.querySelector("#passwordPaciente").value,
        }

        try {
            await axios.post(`http://${ip}:5000/pacientes/`, pacienteNuevo);
            alert("Paciente creado correctamente");

            //Redirigimos al index.html una vez se actualiza la pelicula
            window.location.href = `/historias_clinicas/front/indexGestion.html`;
        } catch (error) {
            console.error("Error al crear el paciente", error);
        }
    });

});
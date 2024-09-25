document.addEventListener("DOMContentLoaded", () => {

    const formulario = document.querySelector("#form-nuevoPaciente");

    formulario.addEventListener("submit", async (p) => {
        p.preventDefault();

        const pacienteNuevo = {
            nombrePaciente: document.querySelector("#nombrePaciente").value,
            apellidoPaciente: document.querySelector("#apellidoPaciente").value,
            dniPaciente: document.querySelector("#docPaciente").value,
            edadPaciente: document.querySelector("#edadPaciente").value,
            usuarioPaciente: document.querySelector("#usuarioPaciente").value,
            passwordPaciente: document.querySelector("#passwordPaciente").value,
        }

        try {
            await axios.post(`http://192.168.1.9:5000/pacientes/`, pacienteNuevo);
            alert("Paciente creado correctamente");

            //Redirigimos al index.html una vez se actualiza la pelicula
            window.location.href = `/front/indexGestion.html`;
        } catch (error) {
            console.error("Error al crear el paciente", error);
        }
    });

});
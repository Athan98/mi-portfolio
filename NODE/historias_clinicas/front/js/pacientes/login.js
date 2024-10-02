document.addEventListener("DOMContentLoaded", () => {


    const formulario = document.querySelector("#formLogin");


    formulario.addEventListener("submit", async (p) => {
        p.preventDefault();

        const pacienteBuscar = {
            usuarioPaciente: document.querySelector("#nombreUsuario").value,
            passwordPaciente: document.querySelector("#passwordUsuario").value,
        }

        try {
            const response = await axios.post(`http://192.168.1.9:5000/pacientes/login/`, pacienteBuscar);
            const paciente = response.data;

            window.location.href = `/historias_clinicas/front/pages/pacientes/verPaciente.html?id=${paciente.paciente.id}`;

        } catch (error) {
            console.error("Error al traer el paciente", error);
        }
    });
});


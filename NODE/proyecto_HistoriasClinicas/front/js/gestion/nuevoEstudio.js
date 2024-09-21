document.addEventListener("DOMContentLoaded", () => {

    const parametrosURL = new URLSearchParams(window.location.search);
    const idPaciente = parametrosURL.get("id");


    // Función para traer paciente
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

    // Nueva función de inicialización
    const init = async () => {
        if (idPaciente) {
            await traerPaciente(idPaciente);
        }
    };

    // Inicia el proceso cuando el DOM esté listo
    init();
});

const urlCrear = "http://192.168.1.9:5000/pacientes/";

document.getElementById("form-nuevoPaciente").addEventListener("submit", (e) => {
    e.preventDefault();

    let apellidoPaciente = document.querySelector("#apellidoPaciente").value;
    let nombrePaciente = document.querySelector("#nombrePaciente").value;
    let dniPaciente = document.querySelector("#docPaciente").value;
    let edadPaciente = document.querySelector("#edadPaciente").value;
    let usuarioPaciente = document.querySelector("#usuarioPaciente").value;
    let passwordPaciente = document.querySelector("#passwordPaciente").value;

    let pacienteData = {
        apellidoPaciente: apellidoPaciente,
        nombrePaciente: nombrePaciente,
        dniPaciente: dniPaciente,
        edadPaciente: edadPaciente,
        usuarioPaciente: usuarioPaciente,
        passwordPaciente: passwordPaciente
    };

    axios.post(urlCrear, pacienteData).then(response => {
        console.log("-Registro agregado-", response.data);
        alert("Paciente agregado exitosamente");
        document.querySelector("#form-nuevoPaciente").reset();
    })
        .catch(err => {
            console.log("-Error al agregar el registro-", err);
            alert("Error al agregar el Paciente");
        });

});
//Declaracion de variables
const url = "http://192.168.1.8:8080/pacientes/crear";

// 1. Añadimos un listener para el evento 'submit' del formulario
document.getElementById('formPaciente').addEventListener('submit', function (event) {

    // 2. Prevenir el comportamiento predeterminado del formulario (recargar la página)
    event.preventDefault();

    // 3. Recopilar los datos del formulario
    let nombre = document.getElementById('nombrePaciente').value;
    let apellido = document.getElementById('apellidoPaciente').value;
    let dni = document.getElementById('docPaciente').value;
    let edad = document.getElementById('edadPaciente').value;

    // 4. Crear un objeto con los datos del formulario
    let pacienteData = {
        nombre: nombre,
        apellido: apellido,
        dni: dni,
        edad: edad
    };

    // 5. Enviar los datos al servidor utilizando Axios
    axios.post(url, pacienteData)
        .then(response => {
            // 6. Manejar la respuesta exitosa
            console.log('Paciente agregado:', response.data);
            alert('Paciente agregado con éxito');
            document.getElementById('formPaciente').reset();
        })
        .catch(error => {
            // 7. Manejar el error
            console.error('Error al agregar el paciente:', error);
            alert('Error al agregar el paciente');
        });
});
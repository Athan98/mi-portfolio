//Declaracion de variables
const url = "http://192.168.1.8:8080/medicos/crear";

// 1. Añadimos un listener para el evento 'submit' del formulario
document.getElementById('formMedico').addEventListener('submit', function (event) {

    // 2. Prevenir el comportamiento predeterminado del formulario (recargar la página)
    event.preventDefault();

    // 3. Recopilar los datos del formulario
    let nombre = document.getElementById('nombreMedico').value;
    let apellido = document.getElementById('apellidoMedico').value;
    let dni = document.getElementById('docMedico').value;
    let especialidad = document.getElementById('especialidadMedico').value;

    // 4. Crear un objeto con los datos del formulario
    let medicoData = {
        nombre: nombre,
        apellido: apellido,
        dni: dni,
        especialidad:especialidad
    };

    // 5. Enviar los datos al servidor utilizando Axios
    axios.post(url, medicoData)
        .then(response => {
            // 6. Manejar la respuesta exitosa
            console.log('Médico agregado:', response.data);
            alert('Médico agregado con éxito');
            document.getElementById('formMedico').reset();
        })
        .catch(error => {
            // 7. Manejar el error
            console.error('Error al agregar el médico:', error);
            alert('Error al agregar el médico');
        });
});
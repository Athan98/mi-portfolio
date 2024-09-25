document.addEventListener("DOMContentLoaded", () => {

    const formulario = document.querySelector("#form-nuevoMedico");

    formulario.addEventListener("submit", async (m) => {
        m.preventDefault();

        const medicoNuevo = {
            nombreMedico: document.querySelector("#nombreMedico").value,
            apellidoMedico: document.querySelector("#apellidoMedico").value,
            especialidadMedico: document.querySelector("#especialidadMedico").value,
        }

        try {
            await axios.post(`http://192.168.1.9:5000/medicos/`, medicoNuevo);
            alert("Médico creado correctamente");

            //Redirigimos al index.html una vez se actualiza la pelicula
             window.location.href = `/front/pages/gestion/gestionMedicos.html?id=${m.id}`
        } catch (error) {
            console.error("Error al crear el médico", error);
        }
    });

});
document.addEventListener("DOMContentLoaded", () => {

    const formulario = document.querySelector("#form-nuevoMedico");
    const ip="192.168.1.9";

    formulario.addEventListener("submit", async (m) => {
        m.preventDefault();

        const medicoNuevo = {
            nombreMedico: document.querySelector("#nombreMedico").value,
            apellidoMedico: document.querySelector("#apellidoMedico").value,
            especialidadMedico: document.querySelector("#especialidadMedico").value,
        }

        try {
            await axios.post(`http://${ip}:5000/medicos/`, medicoNuevo);
            alert("Médico creado correctamente");

            //Redirigimos al index.html una vez se actualiza la pelicula
             window.location.href = `/historias_clinicas/front/pages/gestion/gestionMedicos.html?id=${m.id}`
        } catch (error) {
            console.error("Error al crear el médico", error);
        }
    });

});
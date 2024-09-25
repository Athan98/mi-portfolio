const urlListar = "http://192.168.1.9:5000/medicos/";

document.addEventListener("DOMContentLoaded", () => {
    const cuerpoTabla = document.querySelector("#bodyTablaMedicos");
    const buscadorEntrada = document.querySelector("#buscadorEntrada");

    //LISTAR PACIENTES
    const listar = async () => {
        try {
            const response = await axios.get(urlListar);
            const medicos = response.data;

            cuerpoTabla.innerHTML = "";

            medicos.forEach(m => {
                const fila = document.createElement("tr");

                const celdaApellido = document.createElement("td");
                const celdaNombre = document.createElement("td");
                const celdaEspecialidad = document.createElement("td");
                const celdaAcciones = document.createElement("td");

                celdaApellido.textContent = m.apellidoMedico;
                celdaNombre.textContent = m.nombreMedico;
                celdaEspecialidad.textContent = m.especialidadMedico;

                const btnEditar = document.createElement("button");
                btnEditar.textContent = "EDITAR";
                btnEditar.classList.add("btnEditar");
                btnEditar.addEventListener("click", () => {

                    window.location.href = `/front/pages/gestion/editarMedico.html?id=${m.id}`

                });

                const btnEliminar = document.createElement("button");
                btnEliminar.textContent = "ELIMINAR";
                btnEliminar.classList.add("btnEditar");
                btnEliminar.addEventListener("click", () => {
                    borrar(m.id);
                });


                celdaAcciones.appendChild(btnEditar);
                celdaAcciones.appendChild(btnEliminar);
                fila.appendChild(celdaApellido);
                fila.appendChild(celdaNombre);
                fila.appendChild(celdaEspecialidad);
                fila.appendChild(celdaAcciones);

                cuerpoTabla.appendChild(fila);

            });

        } catch (error) {
            console.error("Error al listar los registros en la tabla", error);
        }
    };

    //Funcion para borrar pacientes
    const borrar = async (id) => {

        if (id && confirm("¿Estás seguro de que deseas eliminar este médico?")) {
            try {
                await axios.delete(`http://192.168.1.9:5000/medicos/${id}`);
                //Recargar posteos
                listar();
                alert("Registro eliminado");
            } catch (error) {
                console.error("Error para borrar el registro: ", error);
                alert("No se ha podido eliminar el médico.");
            }
        }
    }

    const filtrarMedicos = () => {
        const filter = buscadorEntrada.value.toLowerCase(); // Obtiene el valor del campo de búsqueda en minúsculas
        const filas = cuerpoTabla.getElementsByTagName('tr'); // Obtiene todas las filas de la tabla

        Array.from(filas).forEach((fila) => { // Itera sobre cada fila
            const celdaApellido = fila.getElementsByTagName('td')[0]; // Selecciona la celda del apellido
            const celdaNombre = fila.getElementsByTagName('td')[1]; // Selecciona la celda del nombre

            if (celdaApellido || celdaNombre) {
                const apellido = celdaApellido.textContent || celdaApellido.innerText; // Obtiene el texto del apellido
                const nombre = celdaNombre.textContent || celdaNombre.innerText; // Obtiene el texto del nombre

                // Comprueba si el valor de búsqueda está presente en el apellido, nombre o DNI
                if (
                    apellido.toLowerCase().indexOf(filter) > -1 ||
                    nombre.toLowerCase().indexOf(filter) > -1
                ) {
                    fila.style.display = ""; // Muestra la fila si coincide
                } else {
                    fila.style.display = "none"; // Oculta la fila si no coincide
                }
            }
        });
    }

    buscadorEntrada.addEventListener("input", filtrarMedicos); // Llama a la función filtrarPacientes cada vez que se escribe en el campo de búsqueda

    listar();
});
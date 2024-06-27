//Declaracion de varianles
const urlListarPacientes = "http://192.168.1.8:8080/pacientes/listar";
const urlEliminarPaciente = "http://192.168.1.8:8080/pacientes/eliminar";

document.addEventListener("DOMContentLoaded", () => {
    const bodyTable = document.querySelector("#bodyTablePacientes");
    const searchInputDNI = document.querySelector("#searchInputDNI");
    const searchInputApellido = document.querySelector("#searchInputApellido");

    //Funcion para listar posteos
    const listarPacientes = async () => {
        try {
            const response = await axios.get(urlListarPacientes);
            const pacientes = response.data;
            console.log(pacientes);

            //Limpiar tabla
            bodyTable.innerHTML = "";

            //Generar contenido de tabla
            pacientes.forEach(p => {
                const fila = document.createElement("tr");

                const celdaApellido = document.createElement("td");
                const celdaNombre = document.createElement("td");
                const celdaDni = document.createElement("td");
                const celdaEdad = document.createElement("td");
                const celdaAcciones = document.createElement("td");

                //Asignamos el contenido
                celdaApellido.textContent = p.apellido;
                celdaNombre.textContent = p.nombre;
                celdaDni.textContent = p.dni;
                celdaEdad.textContent = p.edad;

                //Creamos los botones
                const botonEliminar = document.createElement("button");
                botonEliminar.textContent = "Eliminar";
                botonEliminar.classList.add("btnEliminar");

                botonEliminar.addEventListener("click", () => {
                    borrarPacientes(p.id_paciente);
                });

                const botonEditar = document.createElement("button");
                botonEditar.textContent = "Editar";
                botonEditar.classList.add("btnEditar");

                botonEditar.addEventListener("click", () => {
                    //Redirigir
                    window.location.href = `editPacientes.html?id_paciente=${p.id_paciente}`;
                })

                //Agregamos todos los componentes a la fila
                celdaAcciones.appendChild(botonEditar);
                celdaAcciones.appendChild(botonEliminar);
                fila.appendChild(celdaApellido);
                fila.appendChild(celdaNombre);
                fila.appendChild(celdaDni);
                fila.appendChild(celdaEdad);
                fila.appendChild(celdaAcciones);

                //Agregamos la fila a la tabla
                bodyTable.appendChild(fila);
            });
        } catch (error) {
            console.error("Error al cargar la lista de pacientes", error);
        }
    }

    //Funcion para borrar pacientes
    const borrarPacientes = async (idPaciente) => {
        try {
            await axios.delete(`${urlEliminarPaciente}?id=${idPaciente}`);
            //Recargar posteos
            listarPacientes();
            alert("Paciente eliminado");
        } catch (error) {
            console.error("Error para borrar el paciente: ", error);
            alert("No se ha podido eliminar el paciente. Verifique si el paciente seleccionado no se encuentra vinculado a un turno. Si ese fuera el caso, primero debe eliminar el turno");
        }
    }

    // Funcion para filtrar la tabla
    const filtrarPacientesDNI = () => {
        const filter = searchInputDNI.value.toLowerCase(); // Obtiene el valor del campo de búsqueda en minúsculas
        const filas = bodyTable.getElementsByTagName('tr'); // Obtiene todas las filas de la tabla

        Array.from(filas).forEach((fila) => { // Itera sobre cada fila
            const celdaDNI = fila.getElementsByTagName('td')[2]; // Selecciona la celda del nombre
            if (celdaDNI) {
                const DNI = celdaDNI.textContent || celdaDNI.innerText; // Obtiene el texto del nombre
                if (DNI.toLowerCase().indexOf(filter) > -1) { // Comprueba si el nombre contiene el texto de búsqueda
                    fila.style.display = ""; // Muestra la fila si coincide
                } else {
                    fila.style.display = "none"; // Oculta la fila si no coincide
                }
            }
        });
    }

    const filtrarPacientesApellido = () => {
        const filter = searchInputApellido.value.toLowerCase(); // Obtiene el valor del campo de búsqueda en minúsculas
        const filas = bodyTable.getElementsByTagName('tr'); // Obtiene todas las filas de la tabla

        Array.from(filas).forEach((fila) => { // Itera sobre cada fila
            const celdaApellido = fila.getElementsByTagName('td')[0]; // Selecciona la celda del nombre
            if (celdaApellido) {
                const apellido = celdaApellido.textContent || celdaApellido.innerText; // Obtiene el texto del nombre
                if (apellido.toLowerCase().indexOf(filter) > -1) { // Comprueba si el nombre contiene el texto de búsqueda
                    fila.style.display = ""; // Muestra la fila si coincide
                } else {
                    fila.style.display = "none"; // Oculta la fila si no coincide
                }
            }
        });
    }

    // Evento para filtrar la tabla en tiempo real
    searchInputDNI.addEventListener("input", filtrarPacientesDNI); // Llama a la función filtrarPacientes cada vez que se escribe en el campo de búsqueda
    searchInputApellido.addEventListener("input", filtrarPacientesApellido); // Llama a la función filtrarPacientes cada vez que se escribe en el campo de búsqueda

    //Instancia funcion para listar posteos
    listarPacientes();
});
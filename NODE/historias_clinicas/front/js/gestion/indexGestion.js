const urlListar = "http://192.168.1.9:5000/pacientes/";

document.addEventListener("DOMContentLoaded", () => {
    const cuerpoTabla = document.querySelector("#bodyTablaPacientes");
    const buscadorEntrada = document.querySelector("#buscadorEntrada");

    //LISTAR PACIENTES
    const listar = async () => {
        try {
            const response = await axios.get(urlListar);
            const pacientes = response.data;

            cuerpoTabla.innerHTML = "";

            pacientes.forEach(p => {
                const fila = document.createElement("tr");

                const celdaApellido = document.createElement("td");
                const celdaNombre = document.createElement("td");
                const celdaDni = document.createElement("td");
                const celdaEdad = document.createElement("td");
                const celdaAcciones = document.createElement("td");

                celdaApellido.textContent = p.apellidoPaciente;
                celdaNombre.textContent = p.nombrePaciente;
                celdaDni.textContent = p.dniPaciente;
                celdaEdad.textContent = p.edadPaciente;

                const btnMas = document.createElement("button");
                btnMas.innerHTML = '<i class="fa-solid fa-magnifying-glass"></i>VER MAS';
                btnMas.classList.add("btnMas");
                btnMas.addEventListener("click", () => {

                    window.location.href = `/historias_clinicas/front/pages/gestion/verMasPaciente.html?id=${p.id}`

                });


                celdaAcciones.appendChild(btnMas);
                fila.appendChild(celdaApellido);
                fila.appendChild(celdaNombre);
                fila.appendChild(celdaDni);
                fila.appendChild(celdaEdad);
                fila.appendChild(celdaAcciones);

                fila.classList.add("fila");
                cuerpoTabla.appendChild(fila);

            });

        } catch (error) {
            console.error("Error al listar los registros en la tabla", error);
        }
    };

    const filtrarPacientes = () => {
        const filter = buscadorEntrada.value.toLowerCase(); // Obtiene el valor del campo de búsqueda en minúsculas
        const filas = cuerpoTabla.getElementsByTagName('tr'); // Obtiene todas las filas de la tabla

        Array.from(filas).forEach((fila) => { // Itera sobre cada fila
            const celdaApellido = fila.getElementsByTagName('td')[0]; // Selecciona la celda del apellido
            const celdaNombre = fila.getElementsByTagName('td')[1]; // Selecciona la celda del nombre
            const celdaDNI = fila.getElementsByTagName('td')[2]; // Selecciona la celda del DNI

            if (celdaApellido || celdaNombre || celdaDNI) {
                const apellido = celdaApellido.textContent || celdaApellido.innerText; // Obtiene el texto del apellido
                const nombre = celdaNombre.textContent || celdaNombre.innerText; // Obtiene el texto del nombre
                const dni = celdaDNI.textContent || celdaDNI.innerText; // Obtiene el texto del DNI

                // Comprueba si el valor de búsqueda está presente en el apellido, nombre o DNI
                if (
                    apellido.toLowerCase().indexOf(filter) > -1 ||
                    nombre.toLowerCase().indexOf(filter) > -1 ||
                    dni.toLowerCase().indexOf(filter) > -1
                ) {
                    fila.style.display = ""; // Muestra la fila si coincide
                } else {
                    fila.style.display = "none"; // Oculta la fila si no coincide
                }
            }
        });
    }

    buscadorEntrada.addEventListener("input", filtrarPacientes); // Llama a la función filtrarPacientes cada vez que se escribe en el campo de búsqueda

    listar();
});
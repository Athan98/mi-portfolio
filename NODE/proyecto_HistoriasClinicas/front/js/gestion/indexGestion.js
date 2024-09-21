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
                btnMas.textContent = "VER MAS";
                btnMas.classList.add("btnMas");
                btnMas.addEventListener("click", () => {

                    window.location.href = `/front/pages/gestion/verMasPaciente.html?id=${p.id}`
                    
                });
                

                celdaAcciones.appendChild(btnMas);
                fila.appendChild(celdaApellido);
                fila.appendChild(celdaNombre);
                fila.appendChild(celdaDni);
                fila.appendChild(celdaEdad);
                fila.appendChild(celdaAcciones);

                cuerpoTabla.appendChild(fila);

            });

        } catch (error) {
            console.error("Error al listar los registros en la tabla", error);
        }
    };

    listar();


});
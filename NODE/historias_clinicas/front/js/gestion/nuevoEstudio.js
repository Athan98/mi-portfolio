document.addEventListener("DOMContentLoaded", () => {
    const parametrosURL = new URLSearchParams(window.location.search);
    const idPaciente = parametrosURL.get("id");
    const formulario = document.querySelector("#form-nuevoEstudio");
    const ip="192.168.1.9";


    // Función para traer paciente
    const traerPaciente = async (id) => {
        try {
            const res = await axios.get(`http://${ip}:5000/pacientes/${id}`);
            const paciente = res.data;

            document.querySelector("#dniPaciente").innerHTML = paciente.dniPaciente;

            // Establecer el enlace para redirigir a la página de detalles del paciente
            const enlacePaciente = document.querySelector("#enlacePaciente");
            enlacePaciente.href = `/historias_clinicas/front/pages/gestion/verMasPaciente.html?id=${id}`;
        } catch (error) {
            console.log("-Error al traer el registro-", error);
        }
    };

    // Función para traer médicos y llenar el select
    const traerMedicos = async () => {
        try {
            const res = await axios.get(`http://${ip}:5000/medicos/`);
            const medicos = res.data;

            const select = document.querySelector("#medicos");
            select.innerHTML = ''; // Limpiar las opciones actuales
            const optionInitial = document.createElement('option');
            optionInitial.value = 0;
            optionInitial.textContent = "Seleccione un médico";
            select.appendChild(optionInitial);

            medicos.forEach(m => {
                const option = document.createElement('option');
                option.value = m.id;
                option.textContent = `${m.apellidoMedico} ${m.nombreMedico}`;
                select.appendChild(option);
            });
        } catch (error) {
            console.log("-Error al traer el registro-", error);
        }
    };

    formulario.addEventListener("submit", async (e) => {
        e.preventDefault();

        // Validar si se ha seleccionado la opción inicial
        const idMedico = document.querySelector("#medicos").value;
        if (idMedico == 0) {
            alert("Por favor, seleccione un médico antes de continuar.");
            return; // Detener el proceso de envío
        }

        const formData = new FormData();
        const archivos = document.querySelector("#file").files;

        // Obtener la fecha del input de fecha
        const fechaEstudioInput = document.querySelector("#fecha").value;
        if (!fechaEstudioInput) {
            alert("Por favor, seleccione una fecha para el estudio.");
            return; // Detener el proceso de envío
        }

        // Llenar el FormData con los datos del formulario
        formData.append("fechaEstudio", new Date(fechaEstudioInput).toISOString()); // Asegúrate de que sea un objeto Date válido
        formData.append("tipoEstudio", document.querySelector("#tipoEstudio").value);
        formData.append("idMedico", idMedico);
        formData.append("idPaciente", idPaciente);

        // Agregar los archivos seleccionados al FormData
        for (let i = 0; i < archivos.length; i++) {
            formData.append("file", archivos[i]);
        }

        try {
            await axios.post(`http://${ip}:5000/estudios/multiple/create-estudio`, formData, {
                headers: {
                    "Content-Type": "multipart/form-data"
                }
            });
            alert("Registro creado correctamente");
        } catch (error) {
            console.error("Error al crear el estudio", error.response ? error.response.data : error);
        }
    });

    // Inicialización
    const init = async () => {
        if (idPaciente) {
            await traerPaciente(idPaciente);
        }
        traerMedicos();
    };

    init();
});
document.addEventListener("DOMContentLoaded", () => {

    const parametrosURL = new URLSearchParams(window.location.search);
    const idEstudio = parametrosURL.get("id");

    // Función para traer el estudio, pacientes, y médicos
    const traerEstudio = async (id) => {
        try {
            const res = await axios.get(`http://192.168.1.9:5000/estudios/${id}`);
            const estudio = res.data;

            document.querySelector("#tipoEstudio").innerHTML = estudio.tipoEstudio;
            document.querySelector("#fechaEstudio").innerHTML = formatDate(estudio.fechaEstudio);
            const medico = await traerMedico(estudio.idMedico);
            document.querySelector("#medicoEstudio").innerHTML = `${medico.apellidoMedico}, ${medico.nombreMedico}`;
        } catch (error) {
            console.log("-Error al traer el registro-", error)
        }
    };

    // Función para traer médico
    const traerMedico = async (id) => {
        try {
            const res = await axios.get(`http://192.168.1.9:5000/medicos/${id}`);
            return res.data;
        } catch (error) {
            console.log("-Error al traer el médico-", error);
        }
    };

    // Función para listar archivos
    const listarFiles = async (id) => {
        try {
            const res = await axios.get(`http://192.168.1.9:5000/files/estudio/${id}`);
            const filesEstudio = res.data;

            const contenedorFiles = document.querySelector("#contenedorFiles");
            contenedorFiles.innerHTML = "";

            const getFileIcon = (tipoFile) => {
                if (tipoFile.includes("pdf")) {
                    return '<i class="fas fa-file-pdf"></i>';
                } else if (tipoFile.includes("image")) {
                    return '<i class="fas fa-file-image"></i>';
                } else if (tipoFile.includes("word")) {
                    return '<i class="fas fa-file-word"></i>';
                } else if (tipoFile.includes("excel")) {
                    return '<i class="fas fa-file-excel"></i>';
                } else if (tipoFile.includes("text")) {
                    return '<i class="fas fa-file-alt"></i>';
                } else {
                    return '<i class="fas fa-file"></i>';
                }
            };

            filesEstudio.forEach(f => {
                const divFileIndividual = document.createElement("div");
                divFileIndividual.classList.add("fileIndividual");

                const icono = getFileIcon(f.tipoFile);

                divFileIndividual.innerHTML = `
                    ${icono} <a href="/historias_clinicas${f.url}" target="_blank">${f.nombreFile}</a>
                `;

                if (f.tipoFile.includes("pdf")) {
                    divFileIndividual.classList.add("pdf");
                } else if (f.tipoFile.includes("image")) {
                    divFileIndividual.classList.add("image");
                } else if (f.tipoFile.includes("word")) {
                    divFileIndividual.classList.add("word");
                } else if (f.tipoFile.includes("excel")) {
                    divFileIndividual.classList.add("excel");
                } else if (f.tipoFile.includes("text")) {
                    divFileIndividual.classList.add("text");
                } else {
                    divFileIndividual.classList.add("file");
                }

                contenedorFiles.appendChild(divFileIndividual);
            });

        } catch (error) {
            console.log("-Error al traer los archivos del estudio-", error);
        }
    };

    // Función para formatear la fecha
    const formatDate = (dateString) => {
        const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
        return new Date(dateString).toLocaleDateString('es-ES', options);
    };

    // Nueva función de inicialización
    const init = async () => {
        if (idEstudio) {
            await traerEstudio(idEstudio);
            await listarFiles(idEstudio);
        }
    };

    // Inicia el proceso cuando el DOM esté listo
    init();
});
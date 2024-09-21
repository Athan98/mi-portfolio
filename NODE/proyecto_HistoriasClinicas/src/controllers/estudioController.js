const multer = require("multer");
const path = require("path");
const fileModel = require("../models/fileModels.js");
const estudioModel = require("../models/estudioModels.js");
const medicoModel = require("../models/medicoModels.js");
const pacienteModel = require("../models/pacienteModels.js");
const { Sequelize } = require("sequelize"); // Para usar transacciones
const fs = require('fs');

// Configuración de almacenamiento con multer
const storage = multer.diskStorage({
    destination: path.join(__dirname, "../../files"),
    filename: (req, file, cb) => {
        const fileName = `${Date.now()}-${file.originalname}`;
        cb(null, fileName);  // Asignar nombre con Date.now()
    },
});

const upload = multer({ storage: storage });

// Middleware para manejar la carga de una sola imagen
const uploadSingleFile = upload.single("file");

// Middleware para manejar la carga de múltiples imágenes
const uploadMultipleFiles = upload.array("file", 10);

// Controlador para crear estudio y subir archivos
const createEstudioAndUploadFiles = async (req, res) => {
    const t = await fileModel.sequelize.transaction(); // Iniciar transacción

    try {
        // Extraer datos del estudio
        const { fechaEstudio, tipoEstudio, idMedico, idPaciente } = req.body;

        // Verificar si el médico existe
        const medico = await medicoModel.findByPk(idMedico);
        if (!medico) {
            return res.status(400).json({ msg: "El médico no existe" });
        }

        // Verificar si el paciente existe
        const paciente = await pacienteModel.findByPk(idPaciente);
        if (!paciente) {
            return res.status(400).json({ msg: "El paciente no existe" });
        }

        // Crear el nuevo estudio en la base de datos
        const newEstudio = await estudioModel.create({ fechaEstudio, tipoEstudio, idMedico, idPaciente }, { transaction: t });

        let files = [];
        if (req.file) {
            files = [req.file];
        } else if (req.files) {
            files = req.files;
        } else {
            return res.status(400).json({ msg: "No se han subido archivos" });
        }

        // Iterar sobre los archivos subidos
        for (const file of files) {
            const type = file.mimetype;
            const name = file.filename;  // Usar el nombre generado por multer (con Date.now())

            // Insertar archivos en la base de datos asociados al estudio
            await fileModel.create({
                tipoFile: type,
                nombreFile: name,  // Usar el nombre con Date.now() que ya tiene multer
                idEstudio: newEstudio.id, // Asociar al estudio recién creado
            }, { transaction: t });
        }

        // Confirmar la transacción si todo salió bien
        await t.commit();

        res.json({ msg: "Estudio y archivos creados satisfactoriamente" });
    } catch (error) {
        // Revertir la transacción en caso de error
        await t.rollback();
        console.error("Error al crear estudio o subir archivos: ", error);
        res.status(500).json({ err: "Error al crear estudio o subir archivos" });
    }
};

//Funcion para listar peliculas. Metodo GET
const listarEstudios = async (req, res) => {
    //Logica que trae todas las peliculas de la BD en JSON
    try {
        const estudios = await estudioModel.findAll();
        //Devolvemos el JSON con todas las peliculas
        res.json(estudios);
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
};

//Funcion para traer una pelicula por ID. Metodo GET
const traerEstudioID = async (req, res) => {
    //Logica para traer una pelicula por ID de la BD en JSON
    try {
        // Buscamos la Primary Key a traves de los parametros de la URL. En este caso traemos la ultima parte de
        // la URL: "/:id"
        const estudio = await estudioModel.findByPk(req.params.id);
        //Devolvemos el JSON con la pelicula
        res.json(estudio);
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
}

// Controlador para listar estudios por ID de paciente
const listarEstudiosPorPaciente = async (req, res) => {
    try {
        // Obtener el ID del paciente desde los parámetros de la URL
        const { id } = req.params; // Cambié 'idPaciente' por 'id'

        // Buscar estudios relacionados con el paciente
        const estudios = await estudioModel.findAll({
            where: { idPaciente: id }, // Usar 'idPaciente' con el valor correcto
            include: [
                {
                    model: fileModel, // Incluir archivos relacionados con el estudio
                    as: "files", // Asegúrate de que este alias coincida con el definido en el modelo
                    attributes: ["nombreFile", "tipoFile"],
                },
                {
                    model: medicoModel, // Incluir información del médico
                    attributes: ["nombreMedico", "apellidoMedico"],
                }
            ],
        });

        if (estudios.length === 0) {
            return res.status(404).json({ msg: "No hay estudios para este paciente" });
        }

        res.json(estudios);
    } catch (error) {
        console.error("Error al obtener los estudios: ", error);
        res.status(500).json({ err: "Error al obtener los estudios del paciente" });
    }
};

const eliminarEstudioYArchivos = async (req, res) => {
    const t = await fileModel.sequelize.transaction(); // Iniciar transacción

    try {
        // Obtener el ID del estudio desde los parámetros de la URL
        const { id } = req.params;

        // Buscar el estudio por ID
        const estudio = await estudioModel.findByPk(id, {
            include: { model: fileModel, as: "files" }, // Incluir archivos relacionados
        });

        if (!estudio) {
            return res.status(404).json({ msg: "Estudio no encontrado" });
        }

        // Eliminar archivos relacionados con el estudio
        const archivos = estudio.files;
        for (const archivo of archivos) {
            // Eliminar archivo de la base de datos
            await fileModel.destroy({ where: { id: archivo.id }, transaction: t });

            // Eliminar el archivo del sistema de archivos
            const filePath = path.join(__dirname, "../../files", archivo.nombreFile);
            fs.unlinkSync(filePath); // Elimina el archivo físicamente
        }

        // Eliminar el estudio
        await estudioModel.destroy({ where: { id: estudio.id }, transaction: t });

        // Confirmar la transacción
        await t.commit();

        res.json({ msg: "Estudio y archivos eliminados correctamente" });
    } catch (error) {
        // Revertir transacción en caso de error
        await t.rollback();
        console.error("Error al eliminar el estudio y archivos: ", error);
        res.status(500).json({ err: "Error al eliminar el estudio y archivos" });
    }
};

// Exportar las funciones del controlador
module.exports = {
    uploadSingleFile,
    uploadMultipleFiles,
    createEstudioAndUploadFiles, // Nueva función que crea estudio y archivos
    listarEstudios,
    traerEstudioID, 
    listarEstudiosPorPaciente,
    eliminarEstudioYArchivos
};
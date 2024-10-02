const fileModel = require("../models/fileModels.js");
const estudioModel = require("../models/estudioModels.js");
const path = require("path");
const fs = require("fs");

const getFilesByEstudioId = async (req, res) => {
    try {
        const { id } = req.params;
        const estudio = await estudioModel.findByPk(id, {
            include: { model: fileModel, as: "files" },
        });

        if (!estudio) {
            return res.status(404).json({ msg: "Estudio no encontrado" });
        }

        const archivos = estudio.files.map(file => ({
            id: file.id,
            nombreFile: file.nombreFile,
            tipoFile: file.tipoFile,
            url: `/files/${file.nombreFile}` // URL para descargar el archivo
        }));

        res.json(archivos);
    } catch (error) {
        console.error("Error al obtener los archivos: ", error);
        res.status(500).json({ err: "Error al obtener los archivos" });
    }
};

module.exports = {
    getFilesByEstudioId
};
const express = require("express");
const routes = express.Router();
const { getFilesByEstudioId } = require("../controllers/fileController.js");

// Ruta para obtener archivos por ID de estudio
routes.get("/estudio/:id", getFilesByEstudioId);

module.exports = routes;
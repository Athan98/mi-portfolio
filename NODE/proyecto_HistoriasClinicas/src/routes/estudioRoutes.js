const express = require("express");
const routes = express.Router();

const { uploadSingleFile, uploadMultipleFiles, createEstudioAndUploadFiles, listarEstudios, traerEstudioID, listarEstudiosPorPaciente,eliminarEstudioYArchivos } = require("../controllers/estudioController.js");

// Ruta para crear un nuevo estudio y subir múltiples archivos
routes.post(
  "/simple/create-estudio",
  uploadSingleFile, // Middleware para manejar la carga de múltiples archivos
  createEstudioAndUploadFiles // Controlador para crear estudio y almacenar los archivos
);

// Ruta para crear un nuevo estudio y subir múltiples archivos
routes.post(
  "/multiple/create-estudio",
  uploadMultipleFiles, // Middleware para manejar la carga de múltiples archivos
  createEstudioAndUploadFiles // Controlador para crear estudio y almacenar los archivos
);

routes.get("/", listarEstudios);

routes.get("/:id", traerEstudioID);

// Ruta para listar estudios por ID de paciente
routes.get("/paciente/:id", listarEstudiosPorPaciente);

routes.delete('/:id', eliminarEstudioYArchivos);

module.exports = routes;
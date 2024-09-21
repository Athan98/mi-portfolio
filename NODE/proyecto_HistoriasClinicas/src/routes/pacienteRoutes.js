//Requerir express
const express = require("express");

//Utilizar Router de express. Router tiene todos los metodos de HTTP
const router = express.Router();

//Desestructuramos para traer las funciones del controlador de peliculas
const { listarPacientes, traerPacienteID, crearPaciente, actualizarPaciente, eliminarPaciente } = require("../controllers/pacienteController.js")

//Traer todas las peliculas
router.get("/", listarPacientes);

//Traer pelicula por ID
router.get("/:id", traerPacienteID);

//Crear nueva pelicula
router.post("/", crearPaciente);

//Actualizar pelicula por ID
router.put("/:id", actualizarPaciente);

//Eliminar pelicula por ID
router.delete("/:id", eliminarPaciente);

//Exportamos router para utilizarlo en donde necesitemos
module.exports = router;
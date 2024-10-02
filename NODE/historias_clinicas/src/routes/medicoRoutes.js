//Requerir express
const express = require("express");

//Utilizar Router de express. Router tiene todos los metodos de HTTP
const router = express.Router();

//Desestructuramos para traer las funciones del controlador de peliculas
const { listarMedicos, traerMedicoID, crearMedico, actualizarMedico, eliminarMedico } = require("../controllers/medicoController.js")

//Traer todas las peliculas
router.get("/", listarMedicos);

//Traer pelicula por ID
router.get("/:id", traerMedicoID);

//Crear nueva pelicula
router.post("/", crearMedico);

//Actualizar pelicula por ID
router.put("/:id", actualizarMedico);

//Eliminar pelicula por ID
router.delete("/:id", eliminarMedico);

//Exportamos router para utilizarlo en donde necesitemos
module.exports = router;
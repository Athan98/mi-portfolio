//Requerimos peliculasModel.js
const { where } = require("sequelize");
const pacienteModel = require("../models/pacienteModels.js")

//  C.R.U.D.

//Funcion para listar peliculas. Metodo GET
const listarPacientes = async (req, res) => {
    //Logica que trae todas las peliculas de la BD en JSON
    try {
        const pacientes = await pacienteModel.findAll();
        //Devolvemos el JSON con todas las peliculas
        res.json(pacientes);
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
};

//Funcion para traer una pelicula por ID. Metodo GET
const traerPacienteID = async (req, res) => {
    //Logica para traer una pelicula por ID de la BD en JSON
    try {
        // Buscamos la Primary Key a traves de los parametros de la URL. En este caso traemos la ultima parte de
        // la URL: "/:id"
        const paciente = await pacienteModel.findByPk(req.params.id);
        //Devolvemos el JSON con la pelicula
        res.json(paciente);
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
}

//Funcion para crear pelicula. Metodo POST
const crearPaciente = async (req, res) => {
    try {
        await pacienteModel.create(req.body);
        res.json({ "message": "- Registro creado correctamente -" });
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
};

//Funcion para actualizar un registro existente en la BD
const actualizarPaciente = async (req, res) => {
    try {
        // Le pasamos al metodo el body del request donde estarán los datos. Tambien le pasamos el id por el parametro
        // de la URL de la pelicula que queremos actualizar
        await pacienteModel.update(req.body, { where: { id: req.params.id } });
        res.json({ "message": "- Registro actualizado correctamente -" });
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
};

//Funcion para borrar un registro existente de la BD
const eliminarPaciente = async (req, res) => {
    try {
        // Le pasamos al metodo el ID del registro que queremos eliminar. Este ID viaja en los parametros de la URL
        await pacienteModel.destroy({ where: { id: req.params.id } });
        res.json({ "message": "- Registro borrado correctamente -" });
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
};

//Dejamos listo para exportar las funciones cuando se pida en peliculasRouter.js
module.exports = { listarPacientes, traerPacienteID, crearPaciente, actualizarPaciente, eliminarPaciente };
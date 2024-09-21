//Requerimos peliculasModel.js
const { where } = require("sequelize");
const medicoModel = require("../models/medicoModels.js")

//  C.R.U.D.

//Funcion para listar peliculas. Metodo GET
const listarMedicos = async (req, res) => {
    //Logica que trae todas las peliculas de la BD en JSON
    try {
        const medicos = await medicoModel.findAll();
        //Devolvemos el JSON con todas las peliculas
        res.json(medicos);
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
};

//Funcion para traer una pelicula por ID. Metodo GET
const traerMedicoID = async (req, res) => {
    //Logica para traer una pelicula por ID de la BD en JSON
    try {
        // Buscamos la Primary Key a traves de los parametros de la URL. En este caso traemos la ultima parte de
        // la URL: "/:id"
        const medico = await medicoModel.findByPk(req.params.id);
        //Devolvemos el JSON con la pelicula
        res.json(medico);
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
}

//Funcion para crear pelicula. Metodo POST
const crearMedico = async (req, res) => {
    try {
        await medicoModel.create(req.body);
        res.json({ "message": "- Registro creado correctamente -" });
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
};

//Funcion para actualizar un registro existente en la BD
const actualizarMedico = async (req, res) => {
    try {
        // Le pasamos al metodo el body del request donde estarán los datos. Tambien le pasamos el id por el parametro
        // de la URL de la pelicula que queremos actualizar
        await medicoModel.update(req.body, { where: { id: req.params.id } });
        res.json({ "message": "- Registro actualizado correctamente -" });
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
};

//Funcion para borrar un registro existente de la BD
const eliminarMedico = async (req, res) => {
    try {
        // Le pasamos al metodo el ID del registro que queremos eliminar. Este ID viaja en los parametros de la URL
        await medicoModel.destroy({ where: { id: req.params.id } });
        res.json({ "message": "- Registro borrado correctamente -" });
    } catch (error) {
        //Devolvemos JSON con error
        res.json({ message: error.message });
    }
};

//Dejamos listo para exportar las funciones cuando se pida en peliculasRouter.js
module.exports = { listarMedicos, traerMedicoID, crearMedico, actualizarMedico, eliminarMedico };
//Traemos Sequelize

const { Sequelize } = require('sequelize');

//documentación para ingresar a la base de datos

const db = new Sequelize("historias_clinicas", "root", "", {
    host: "localhost",
    dialect: "mysql",
    port: 3306
})

module.exports = db

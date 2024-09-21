//Traemos Sequelize

const { Sequelize } = require('sequelize');

//documentación para ingresar a la base de datos

const db = new Sequelize("prueba_multer", "root", "", {
    host: "localhost",
    dialect: "mysql",
    port: 3306
})

module.exports = db

const db = require("../data/db");
const { DataTypes } = require("sequelize");

const fileModel = db.define("files", {

    tipoFile: {
        type: DataTypes.STRING,

    },

    nombreFile: {
        type: DataTypes.STRING,
    },

    idEstudio: {
        type: DataTypes.INTEGER,
        references: {
            model: 'estudios', // Nombre de la tabla a la que se refiere
            key: 'id' // Clave primaria en la tabla referenciada
        },
        allowNull: false // Define si puede ser nulo o no
    }
    
});

module.exports = fileModel;
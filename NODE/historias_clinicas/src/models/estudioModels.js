const db = require("../data/db");
const { DataTypes } = require("sequelize");
const fileModel = require("./fileModels.js");

const estudioModel = db.define("estudios", {
    fechaEstudio: {
        type: DataTypes.DATE,
    },

    tipoEstudio: {
        type: DataTypes.STRING,
    },

    idMedico: {
        type: DataTypes.INTEGER,
        references: {
            model: 'medicos', // Nombre de la tabla a la que se refiere
            key: 'id' // Clave primaria en la tabla referenciada
        },
        allowNull: false // Define si puede ser nulo o no
    },

    idPaciente: {
        type: DataTypes.INTEGER,
        references: {
            model: 'pacientes', // Nombre de la tabla a la que se refiere
            key: 'id' // Clave primaria en la tabla referenciada
        },
        allowNull: false // Define si puede ser nulo o no
    }

});

estudioModel.hasMany(fileModel, {
    foreignKey: "idEstudio",
    sourceKey: "id"
});

fileModel.belongsTo(estudioModel, {
    foreignKey: "idEstudio",
    targetKey: "id"
});

module.exports = estudioModel;
const db = require("../data/db");
const { DataTypes } = require("sequelize");
const estudioModel = require("./estudioModels.js");

const pacienteModel = db.define("pacientes", {
    nombrePaciente: {
        type: DataTypes.STRING,
    },

    apellidoPaciente: {
        type: DataTypes.STRING,
    },

    dniPaciente: {
        type: DataTypes.STRING,
    },

    edadPaciente: {
        type: DataTypes.INTEGER,
    },

    usuarioPaciente: {
        type: DataTypes.INTEGER,
    },

    passwordPaciente: {
        type: DataTypes.INTEGER,
    },

});

pacienteModel.hasMany(estudioModel, {
    foreignKey: "idPaciente",
    sourceKey: "id"
});

estudioModel.belongsTo(pacienteModel, {
    foreignKey: "idPaciente",
    targetKey: "id"
});

module.exports = pacienteModel;
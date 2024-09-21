const db = require("../data/db");
const { DataTypes } = require("sequelize");
const estudioModel = require("./estudioModels.js");

const medicoModel = db.define("medicos", {
    nombreMedico: {
        type: DataTypes.STRING,
    },

    apellidoMedico: {
        type: DataTypes.STRING,
    },

    especialidadMedico: {
        type: DataTypes.STRING,
    },

});

medicoModel.hasMany(estudioModel, {
    foreignKey: "idMedico",
    sourceKey: "id"
});

estudioModel.belongsTo(medicoModel, {
    foreignKey: "idMedico",
    targetKey: "id"
});

module.exports = medicoModel;
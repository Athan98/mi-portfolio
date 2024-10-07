const db = require("../data/db");
const { DataTypes } = require("sequelize");
const bcrypt = require('bcrypt');
const estudioModel = require("./estudioModels.js");

const pacienteModel = db.define("pacientes", {
    dniPaciente: {
        type: DataTypes.STRING,
    },

    usuarioPaciente: {
        type: DataTypes.STRING, // Cambia el tipo a STRING para los nombres de usuario
    },
    passwordPaciente: {
        type: DataTypes.STRING, // Cambia el tipo a STRING para las contraseñas hash
    },
}, {
    hooks: {
        // Hook para hashear la contraseña antes de crear un nuevo paciente
        beforeCreate: async (paciente) => {
            const salt = await bcrypt.genSalt(10);
            paciente.passwordPaciente = await bcrypt.hash(paciente.passwordPaciente, salt);
        },
        // Hook para hashear la contraseña antes de actualizar un paciente
        beforeUpdate: async (paciente) => {
            if (paciente.changed('passwordPaciente')) { // Verificar si la contraseña fue modificada
                const salt = await bcrypt.genSalt(10);
                paciente.passwordPaciente = await bcrypt.hash(paciente.passwordPaciente, salt);
            }
        }
    }
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
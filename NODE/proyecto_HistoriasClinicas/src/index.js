const express = require("express");
const app = express();
const path = require('path');

const port = process.env.PORT || 5000;
const cors = require("cors");
app.use(cors());

app.use(express.json());

const estudioRoutes = require("./routes/estudioRoutes.js");
const pacienteRoutes = require("./routes/pacienteRoutes.js");
const medicoRoutes = require("./routes/medicoRoutes.js");
const fileRoutes = require("./routes/fileRoutes.js");

const db = require("./data/db.js");

//Conexión a la  base de datos

const conexiondb = async () => {
  try {
    await db.authenticate()
    console.log(`Conexión exitosa a la base de datos`);
  } catch (error) {
    console.log(` Error al conectar a la base de datos: ${error}`);
  }
}


app.use("/estudios", estudioRoutes);
app.use("/pacientes", pacienteRoutes);
app.use("/medicos", medicoRoutes);
app.use("/files",fileRoutes);
app.use('/files', express.static(path.join(__dirname, 'files')));


//Levanta el servidor y muestra mensaje si está OK
app.listen(port, () => {
  conexiondb()
  console.log(`Server OK en el puerto ${port}`);
});
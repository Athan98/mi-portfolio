const fs=require('node:fs')

//EJEMPLO SINCRONO
//Tener info de un archivo
const stats=fs.statSync('./archivo.txt')

console.log(
    stats.isFile(),//Si es un fichero
    stats.isDirectory(),//Si es un directorio
    stats.isSymbolicLink(),//Si es un enlace simbolico
    stats.size//Tamaño en bytes
)
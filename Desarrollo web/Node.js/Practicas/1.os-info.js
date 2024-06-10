const os=require('node:os')

console.log('Informacion del sistema operativo')
console.log('---------------------------------')

console.log('Nombre del sistema operativo',os.platform())
console.log('Version del sistema operativo',os.release())
console.log('Arquitectura del sistema operativo', os.arch())
console.log('CPUs',os.cpus()) // <----- Escalar procesos en Node.js
console.log('Memoria libre',os.freemem()/1024/1024)
console.log('Memoria total',os.totalmem()/1024/1024)
console.log('Dias que el pc ha estado encendido',os.uptime()/60/60)

const fs = require('node:fs')

/*
//EJEMPLO SINCRONO

console.log('Leyendo el primer archivo...')
const text=fs.readFileSync('./archivo.txt' , 'utf-8')

console.log(text)

console.log('Hacer cosas mientras lee el archivo...')

console.log('Leyendo el segundo archivo...')
const secondText=fs.readFileSync('./archivo2.txt' , 'utf-8')

console.log(secondText)
*/

//EJEMPLO ASINCRONO

console.log('Leyendo el primer archivo...')
fs.readFile('./archivo.txt', 'utf-8', /*Call back*/(err, text) => {
    console.log(text)
})

console.log('Hacer cosas mientras lee el archivo...')

console.log('Leyendo el segundo archivo...')
fs.readFile('./archivo2.txt', 'utf-8',/*Call back*/(err, text) => {
    console.log(text)
})

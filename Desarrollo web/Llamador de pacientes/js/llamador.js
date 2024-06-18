const url = "http://localhost:8080/llamados/ultimosdosllamados"

const getUltimosDosPacientes = async () => {
    try {
        const res = await axios(url)
        let llamados = res.data
        console.log(llamados)

        if (llamados.length > 0) {
            let llamado1 = llamados[0]
            document.getElementById("nombrePaciente").innerHTML = llamado1.turno.paciente.apellido
            document.getElementById("documentoPaciente").innerHTML = llamado1.turno.paciente.dni
            document.getElementById("nombreMedico").innerHTML = llamado1.turno.medico.apellido
            document.getElementById("nroConsultorio").innerHTML = llamado1.nroConsultorio
            document.getElementById("notificacion").play()
        }

        if (llamados.length > 1) {
            let llamado1 = llamados[1]
            document.getElementById("nombrePaciente2").innerHTML = llamado1.turno.paciente.apellido
            document.getElementById("documentoPaciente2").innerHTML = llamado1.turno.paciente.dni
            document.getElementById("nombreMedico2").innerHTML = llamado1.turno.medico.apellido
            document.getElementById("nroConsultorio2").innerHTML = llamado1.nroConsultorio
            document.getElementById("notificacion").play()
        }

    } catch (error) {
        console.log(error)
    }
}

getUltimosDosPacientes()

//EJECUTAR CADA 10 SEGUNDOS AUTOMATICAMENTE
setInterval(getUltimosDosPacientes, 10000);
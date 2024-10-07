document.addEventListener("DOMContentLoaded", () => {


    const formulario = document.querySelector("#formLogin");
    const ip="192.168.1.9";


    formulario.addEventListener("submit", async (p) => {
        p.preventDefault();

        const pacienteBuscar = {
            usuarioPaciente: document.querySelector("#nombreUsuario").value,
            passwordPaciente: document.querySelector("#passwordUsuario").value,
        }

        try {
            const response = await axios.post(`http://${ip}:5000/pacientes/login/`, pacienteBuscar);
            const paciente = response.data;

            window.location.href = `/historias_clinicas/front/pages/pacientes/verPaciente.html?id=${paciente.paciente.id}`;

        } catch (error) {
            console.error("Error al traer el paciente", error);
        }
    });

    const inputPass=document.querySelector("#passwordUsuario");
    const eyePass=document.querySelector("#eye");

    eyePass.addEventListener("click",()=>{
        if(inputPass.type==="password"){
            inputPass.type="text";
            eyePass.classList.remove("fa-eye");
            eyePass.classList.add("fa-eye-slash");
        }else{
            inputPass.type="password"
            eyePass.classList.remove("fa-eye-slash");
            eyePass.classList.add("fa-eye");
        }
    })
});


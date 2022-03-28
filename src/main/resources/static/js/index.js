//Ejecutando funciones
document.getElementById("btn__iniciar-sesion").addEventListener("click", iniciarSesion);
document.getElementById("btn__registrarse").addEventListener("click", register);
window.addEventListener("resize", anchoPage);


//Declarando variables
var formulario_login = document.querySelector(".formulario__login");
var formulario_register = document.querySelector(".formulario__register");
var contenedor_login_register = document.querySelector(".contenedor__login-register");
var caja_trasera_login = document.querySelector(".caja__trasera-login");
var caja_trasera_register = document.querySelector(".caja__trasera-register");

//FUNCIONES
async function registerClient(){
    let dataClient = {
        id: document.getElementById('num-doc').value,
        name: document.getElementById('full-name').value,
        address: document.getElementById('address').value,
        phoneNumber: document.getElementById('phone').value,
        email: document.getElementById('email').value,
        clientType: document.getElementById('type-person').value,
        password: document.getElementById('password').value
    }
    const request = await fetch('/api/clients', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dataClient)
    });
    alert('Usuario creado exitosamente!')
}

async function login(){
    let dataClient = {
        id: document.getElementById('idLogin').value,
        password: document.getElementById('passwordLogin').value
    }
    console.log(dataClient)
    const request = await fetch('/api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dataClient)
    });
    const response = await request.text();
    console.log(response)
    if (response == 'Session-Client'){
        localStorage.setItem('document_client', document.getElementById('idLogin').value)
        localStorage.setItem('password_client', document.getElementById('passwordLogin').value)
        window.location.href = 'HacerCotizacion.html'
    }else if(response == 'Session-Admin'){
        localStorage.setItem('document_admin', document.getElementById('idLogin').value)
        localStorage.setItem('password_admin', document.getElementById('passwordLogin').value)
        window.location.href = 'AgregarEmpleado.html';
    }
}

function anchoPage(){

    if (window.innerWidth > 850){
        caja_trasera_register.style.display = "block";
        caja_trasera_login.style.display = "block";
    }else{
        caja_trasera_register.style.display = "block";
        caja_trasera_register.style.opacity = "1";
        caja_trasera_login.style.display = "none";
        formulario_login.style.display = "block";
        contenedor_login_register.style.left = "0px";
        formulario_register.style.display = "none";
    }
}

anchoPage();


function iniciarSesion(){
    if (window.innerWidth > 850){
        formulario_login.style.display = "block";
        contenedor_login_register.style.left = "10px";
        formulario_register.style.display = "none";
        caja_trasera_register.style.opacity = "1";
        caja_trasera_login.style.opacity = "0";
    }else{
        formulario_login.style.display = "block";
        contenedor_login_register.style.left = "0px";
        formulario_register.style.display = "none";
        caja_trasera_register.style.display = "block";
        caja_trasera_login.style.display = "none";
    }
}

function register(){
    if (window.innerWidth > 850){
        formulario_register.style.display = "block";
        contenedor_login_register.style.left = "410px";
        formulario_login.style.display = "none";
        caja_trasera_register.style.opacity = "0";
        caja_trasera_login.style.opacity = "1";
    }else{
        formulario_register.style.display = "block";
        contenedor_login_register.style.left = "0px";
        formulario_login.style.display = "none";
        caja_trasera_register.style.display = "none";
        caja_trasera_login.style.display = "block";
        caja_trasera_login.style.opacity = "1";
    }
}
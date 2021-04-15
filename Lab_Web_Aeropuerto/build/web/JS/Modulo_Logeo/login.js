import {enviarFormularioLogeo} from './Login_Usuario.js';
const formLogin = document.querySelector('#formLogin');

eventListeners();

function eventListeners() {
 

    formLogin.addEventListener('submit', (e) => {
        e.preventDefault();
        console.log("LLego al login.js");
        enviarFormularioLogeo();
    });
    
}





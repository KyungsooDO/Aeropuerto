import {enviarFormularioAgregarTipoAvion} from './AgregarVuelo.js';

const formAddAvion = document.querySelector('#formAddAvion');

eventListeners();

function eventListeners() {

    formAddAvion.addEventListener('submit', (e) => {
        e.preventDefault();

        $("#addAvionModal").modal('hide');
        enviarFormularioAgregarTipoAvion();
        formAddAvion.reset();
//        setTimeout(() => {
//            cargarListado();
//        }, 1000);
    });
}
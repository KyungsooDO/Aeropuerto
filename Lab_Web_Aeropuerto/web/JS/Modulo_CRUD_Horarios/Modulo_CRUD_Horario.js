import {enviarFormularioAgregarTipoAvion} from './AgregarHorario.js';
import {enviarFormularioActualizacionVuelos, editarFila} from './EditarHorario.js';
import {enviarFormularioEliminarAvion, eliminarAvion, SelectAllCheckBoxes, elimininarTodo} from './EliminarHorario.js';
import {cargarListado} from './CargaDatosHorario.js';

const formAddAvion = document.querySelector('#formAddAvion');
const formEditAvion = document.querySelector('#formEditAvion');
const formDeleteAvion = document.querySelector('#formDeleteAvion');
const formDeleteAvionAll = document.querySelector('#formDeleteAvionTodo');

const checkBoxAll = document.querySelector('#selectAll');
eventListeners();

function eventListeners() {

    document.addEventListener('DOMContentLoaded', cargarListado);
    checkBoxAll.addEventListener('click', SelectAllCheckBoxes);
    
    formAddAvion.addEventListener('submit', (e) => {
        e.preventDefault();

        $("#addAvionModal").modal('hide');
        enviarFormularioAgregarTipoAvion();
        formAddAvion.reset();
        setTimeout(() => {
            cargarListado();
        }, 1000);
    });

    formEditAvion.addEventListener('submit', (e) => {
        e.preventDefault();
        $("#editAvionModal").modal('hide');
        enviarFormularioActualizacionVuelos();
        setTimeout(() => {
            cargarListado();
        }, 1000);
    });
    
        formDeleteAvion.addEventListener('submit', (e) => {
        e.preventDefault();
        $("#deleteAvionModal").modal('hide');
        enviarFormularioEliminarAvion(false);
        setTimeout(() => {
            cargarListado();
        }, 1000);

    });

    formDeleteAvionAll.addEventListener('submit', (e) => {
        e.preventDefault();
        $("#deleteAvionModalTodo").modal('hide');
        elimininarTodo();
        setTimeout(() => {
            cargarListado();
        }, 1000);

    });

    document.addEventListener('click', (e) => {
        if (e.target.classList[1] === 'btnDeleteAvion') {
            eliminarAvion();
        } else if (e.target.classList[1] === 'btnEditAvion') {
            editarFila();
        }
    });
}
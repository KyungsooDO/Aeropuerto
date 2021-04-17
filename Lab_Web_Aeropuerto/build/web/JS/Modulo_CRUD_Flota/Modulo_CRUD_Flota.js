import {enviarFormularioAgregarTipoAvion} from './AgregarFlotaAvion.js';
import {enviarFormularioActualizacionAviones, editarFila} from './EditarAvionFlota.js';
import {enviarFormularioEliminarAvion, eliminarAvion, SelectAllCheckBoxes, elimininarTodo} from './EliminarAvionFlota.js';
import {cargarListado} from './CargaDatosAvionFlota.js';

const formAddAvion = document.querySelector('#formAddAvion');
const formEditAvion = document.querySelector('#formEditAvion');
const formDeleteAvion = document.querySelector('#formDeleteAvion');
const formDeleteAvionAll = document.querySelector('#formDeleteAvionTodo');

const checkBoxAll = document.querySelector('#selectAll');
const cuerpoTabla = document.querySelector('#cuerpoTabla');

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
        enviarFormularioActualizacionAviones();
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
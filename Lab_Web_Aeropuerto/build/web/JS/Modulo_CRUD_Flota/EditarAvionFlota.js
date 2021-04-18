import {aviones} from './CargaDatosAvionFlota.js';
export let Editar = new BackBean();
export let AvionesNew = null;

function cargarVentana() {
    AvionesNew = null;
    AvionesNew = aviones;
    var datos = new FormData();
    getJSON('ServletListadoAvionesFlota', datos, procesarRespuesta);
}

export function procesarRespuesta(datos) {
    AvionesNew = datos["lista-aviones-flota"];
}

export function BackBean() {
    //this.idDoc = null;
    this.editIdentificador = null;
    this.idTipoAvion = null;
}

export function enviarFormularioActualizacionAviones(idForm) {
    let datos = new FormData();
    let property;

    for (property in Editar) {
        let refCampo = document.getElementById(property);
        if (refCampo) {
            let v = refCampo.value;
            if (!(typeof (v) === 'undefined' || v === null || v === "")) {
                Editar[property] = v;
                datos.append(property, v);
            }
        } else {
            let v = Editar[property];
            if (Array.isArray(v)) {
                v.forEach((e) => {
                    datos.append(property, e);
                });
            } else {
                datos.append(property, v);
            }
        }
    }

    getJSONConfirmacion('ServletEditarAvionFlota', datos, procesarRespuestas);

    return false;
}

export function procesarRespuestas(datos) {
    if (datos !== "ERROR") {
        mensajeEditar("SE ACTUALIZÓ LA FLOTA DE AVIONES CON EXITO", "exito");
    } else {
        mensajeEditar("NO SE ACTUALIZÓ LA FLOTA DE AVIONES", "error");
    }
}

export function mensajeEditar(mensaje, tipo) {
    const componente = document.querySelector('#mensajeConfirmacion');
    $('#mensajeConfirmacion').modal({
        backdrop: 'static',
        keyboard: false
    });
    $('#mensajeConfirmacion').modal('show');

    if (tipo === 'exito') {
        componente.querySelector('p').classList.remove('text-danger');
        componente.querySelector('p').classList.add('text-success');
        componente.querySelector('p').textContent = mensaje;

    } else {
        componente.querySelector('p').classList.remove('text-success');
        componente.querySelector('p').classList.add('text-danger');
        componente.querySelector('p').textContent = mensaje;
    }

    setTimeout(() => {
        $('#mensajeConfirmacion').modal('hide');
    }, 2000);
}

export function editarFila() {
    cargarVentana();
    var indice = event.target.getAttribute("indice");
    console.log("indice: " + indice);
    var producto = AvionesNew[(parseInt(indice))];
    console.log(producto);
    document.getElementById("idDoc").value = producto.idAvion;
    document.getElementById("editIdentificador").value = producto.idAvion;
    document.getElementById("idTipoAvion").value = producto.tipoAvion.trim();
}
import {aviones} from './CargaDatosAvion.js';
export let Editar = new BackBean();
export let AvionesNew = null;

function cargarVentana() {
    AvionesNew = null;
    AvionesNew = aviones;
    var datos = new FormData();
    getJSON('ServletListadoAviones', datos, procesarRespuesta);
}

export function procesarRespuesta(datos) {
    AvionesNew = datos["lista-aviones"];
}

export function BackBean() {
    this.editIdentificador = null;
    this.editModelo = null;
    this.editMarca = null;
    this.editAno = null;
    this.editAsientos = null;
    this.editFilas = null;
    this.editColumnas = null;
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

    getJSONConfirmacion('ServletEditarAvion', datos, procesarRespuestas);

    return false;
}

export function procesarRespuestas(datos) {
    if (datos !== "ERROR") {
        mensajeEditar("SE ACTUALIZÓ EL AVION CON EXITO", "exito");
    } else {
        mensajeEditar("NO SE ACTUALIZÓ EL DOCUMENTO", "error");
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
    document.getElementById("idDoc").value = producto.idTipoAvion;
    document.getElementById("editIdentificador").value = producto.idTipoAvion;
    document.getElementById("editModelo").value = producto.modelo.trim();
    document.getElementById("editMarca").value = producto.marca.trim();
    document.getElementById("editAno").value = producto.ano.trim();
    document.getElementById("editAsientos").value = producto.cantidadAsientos;
    document.getElementById("editFilas").value = producto.cantidadFilas;
    document.getElementById("editColumnas").value = producto.cantidadColumnas;
}
import {vuelos} from './CargaDatosVuelo.js';
export let Editar = new BackBean();
export let VuelosNew = null;

function cargarVentana() {
    VuelosNew = null;
    VuelosNew = vuelos;
    var datos = new FormData();
    getJSON('ServletListadoVuelos', datos, procesarRespuesta);
}

export function procesarRespuesta(datos) {
    VuelosNew = datos["lista-vuelos"];
}

export function BackBean() {
    //this.idDoc = null;
    this.editIdentificador = null;
    this.editDia = null;
    this.editHora = null;
    this.editIdAvion = null;
    this.editIdOrigen = null;
    this.editIdDestino = null;
    this.editIdDuración = null;
}

export function enviarFormularioActualizacionVuelos(idForm) {
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

    getJSONConfirmacion('ServletEditarVuelo', datos, procesarRespuestas);

    return false;
}

export function procesarRespuestas(datos) {
    if (datos !== "ERROR") {
        mensajeEditar("SE ACTUALIZÓ EL VUELO CON EXITO", "exito");
    } else {
        mensajeEditar("NO SE ACTUALIZÓ EL VUELO", "error");
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
    var producto = VuelosNew[(parseInt(indice))];
    console.log(producto);
    document.getElementById("idDoc").value = producto.idVuelo;
    document.getElementById("editIdentificador").value = producto.idVuelo;
    document.getElementById("editDia").value = producto.dia.trim();
    document.getElementById("editHora").value = producto.hora.trim();
    document.getElementById("editIdAvion").value = producto.idFlota.trim();
    document.getElementById("editIdOrigen").value = producto.idOrigen.trim();
    document.getElementById("editIdDestino").value = producto.idDestino.trim();
    document.getElementById("editIdDuración").value = producto.duracion.trim();
}
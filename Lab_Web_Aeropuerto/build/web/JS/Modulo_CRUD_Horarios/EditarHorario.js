import {vuelos} from './CargaDatosHorario.js';
export let Editar = new BackBean();
export let VuelosNew = null;

function cargarVentana() {
    VuelosNew = null;
    VuelosNew = vuelos;
    var datos = new FormData();
    getJSON('ServletListadoHorarios', datos, procesarRespuesta);
}

export function procesarRespuesta(datos) {
    VuelosNew = datos["lista-horarios"];
}

export function BackBean() {
    //this.idDoc = null;
    this.editIdentificador = null;
    this.editIdVuelo = null;
    this.editFecha = null;
    this.editDisponibles = null;
    this.editPrecio = null;
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

    getJSONConfirmacion('ServletEditarHorario', datos, procesarRespuestas);

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
    document.getElementById("idDoc").value = producto.idFechaVuelo;
    document.getElementById("editIdentificador").value = producto.idFechaVuelo;
    document.getElementById("editIdVuelo").value = producto.vuelo.trim();
    document.getElementById("editFecha").value = producto.fecha.trim();
    document.getElementById("editDisponibles").value = producto.disponibles;
    document.getElementById("editPrecio").value = producto.precio;
}
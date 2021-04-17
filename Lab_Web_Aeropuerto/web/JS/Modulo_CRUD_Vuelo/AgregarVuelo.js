export  let Agregar = new BackBean();

export function BackBean() {
    this.addIdentificador = null;
    this.addDia = null;
    this.addHora = null;
    this.addIdAvion = null;
    this.addIdOrigen = null;
    this.addIdDestino = null;
    this.addIdDuración = null;
}

export function enviarFormularioAgregarTipoAvion(idForm) {
    let datos = new FormData();
    let property;

    for (property in Agregar) {
        let refCampo = document.getElementById(property);
        if (refCampo) {
            let v = refCampo.value;
            if (!(typeof (v) === 'undefined' || v === null || v === "")) {
                Agregar[property] = v;
                datos.append(property, v);
            }
        } else {
            let v = Agregar[property];
            if (Array.isArray(v)) {
                v.forEach((e) => {
                    datos.append(property, e);
                });
            } else {
                datos.append(property, v);
            }
        }
    }
    
    getJSONConfirmacion('ServletAgregarVuelo', datos, procesarRespuestas);

    return false;
}

export function procesarRespuestas(datos) {
    if (datos !== "ERROR") {
        mensajeEditar("SE AGREGÓ EL VUELO CON EXITO", "exito");
    } else {
        mensajeEditar("NO SE AGREGÓ EL VUELO", "error");
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

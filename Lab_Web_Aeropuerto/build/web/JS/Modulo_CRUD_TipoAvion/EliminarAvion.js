export let ELiminar = new BackBean();
export let aviones = null;
export let check = false;

export function BackBean() {
    this.idDoc = null;
}

export function enviarFormularioEliminarAvion(tipo) {
    let property;
    let datos = new FormData();

    for (property in ELiminar) {
        let refCampo = document.getElementById(property);
        if (refCampo) {
            let v = refCampo.value;
            if (!(typeof (v) === 'undefined' || v === null || v === "")) {
                ELiminar[property] = v;
                datos.append(property, v);
            }
        } else {
            let v = ELiminar[property];
            if (Array.isArray(v)) {
                v.forEach((e) => {
                    datos.append(property, e);
                });
            } else {
                datos.append(property, v);
            }
        }
    }
    if (!tipo) {
        getJSONConfirmacion('ServletEliminarAvion', datos, procesarRespuestas);
    } else {
        getJSONConfirmacion('ServletEliminarAvion', datos, procesarRespuestasTodo);
    }

    return false;
}

export function procesarRespuestas(datos) {

    if (datos !== "ERROR") {
        mensajeEliminacionAvion("SE ELIMINÓ EL AVIÓN CON EXITO", "exito");
    } else {
        mensajeEliminacionAvion("NO SE PUDO ELIMINAR EL AVION", "error");
    }
}

export function procesarRespuestasTodo(datos) {

    if (datos !== "ERROR") {
        mensajeEliminacionAvion("SE ELIMINARON LOS AVIONES SELECIONADOS", "exito");
    } else {
        mensajeEliminacionAvion("NO SE PUDO ELIMINAR LOS AVIONES", "error");
    }
}

export function mensajeEliminacionAvion(mensaje, tipo) {
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

export function eliminarAvion() {
    var eliminacion = event.target.getAttribute("eliminacion");
    document.getElementById("idDoc").value = eliminacion;
}

export function SelectAllCheckBoxes() {
    const todos = document.querySelectorAll('.individualCheck');

    if (!check) {
        check = true;
    } else {
        check = false;
    }
    todos.forEach(checkbox => {
        checkbox.querySelector('#checkbox1').checked = check;
    });

}

export function elimininarTodo() {
    const todos = document.querySelectorAll('.individualCheck');
    let valor = 0;
    if (check) {
        todos.forEach(checkbox => {
            if (checkbox.querySelector('#checkbox1').checked === true) {
                valor = checkbox.querySelector('#checkbox1').getAttribute("value");
                document.getElementById("idDoc").value = valor;
                console.log(valor);
                enviarFormularioEliminarAvion(true);
            }
        });
    } else {
        todos.forEach(checkbox => {
            if (checkbox.querySelector('#checkbox1').checked === true) {
                valor = checkbox.querySelector('#checkbox1').getAttribute("value");
                console.log(valor);
                document.getElementById("idDoc").value = valor;
                enviarFormularioEliminarAvion(true);
            }

        });
    }
}
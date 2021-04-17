///-- Variables y funciones privadas ---///

//---VARIABLES---///

export  let Agregar = new BackBean();

// ---funciones-----/// 
export function BackBean() {
    //this.idDoc = null;
    this.addIdentificador = null;
    this.addModelo = null;
    this.addMarca = null;
    this.addAno = null;
    this.addAsientos = null;
    this.addFilas = null;
    this.addColumnas = null;
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
    
    getJSONConfirmacion('ServletAgregarAvion', datos, procesarRespuestas);

    return false;

}

export function procesarRespuestas(datos) {
    if (datos !== "ERROR") {
        mensajeEditar("SE AGREGÓ AVION CON EXITO", "exito");
    } else {
        mensajeEditar("NO SE AGREGÓ AVION", "error");
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





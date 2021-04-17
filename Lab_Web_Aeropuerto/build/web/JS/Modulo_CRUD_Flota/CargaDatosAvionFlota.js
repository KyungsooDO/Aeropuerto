export let aviones = null;
export const cuerpoTabla = document.querySelector('#cuerpoTabla');

export function cargarListado() {
    aviones = null;
    cuerpoTabla.textContent = '';
    var datos = new FormData();
    getJSON('ServletListadoAvionesFlota', datos, procesarRespuesta);
}

export function procesarRespuesta(datos) {
    aviones = datos["lista-aviones-flota"];

    for (var i = 0; i < aviones.length; i++) {
        var producto = aviones[i];
        agregar(producto);
    }
    //console.log(cuerpoTabla.textContent === "");
    //console.log(catalogo.length);
    if (aviones.length === 0) {
        document.querySelector('.alertaLibros').style.display = "block";
    } else {
        document.querySelector('.alertaLibros').style.display = "none";
    }
}

export function agregar(nuevoAvion) {

    var refTabla = document.getElementById("cuerpoTabla");
    if (refTabla && nuevoAvion) {
        var datosProducto = {
            idAvion: nuevoAvion.idAvion,
            tipoAvion: nuevoAvion.tipoAvion
        };

        var indice = refTabla.rows.length;
        var nuevaFila = refTabla.insertRow(-1);
        var nuevaCelda;

//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerHTML = `<span class='custom-checkbox individualCheck'><input type='checkbox' id='checkbox1' name='options[]' value='${datosProducto.idAvion}'><label ></label></span>`;

//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "idAvion" + String(indice);
        nuevaCelda.innerText = datosProducto.idAvion;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "tipoAvion" + String(indice);
        nuevaCelda.innerText = datosProducto.tipoAvion;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerHTML = "<a href='#editAvionModal'class='edit' data-toggle='modal'><i indice='" + indice + "' class='material-icons btnEditAvion' data-toggle='tooltip' title='Edit'>&#xE254;</i></a> \n\
<a href='#deleteAvionModal' class='delete'  data-toggle='modal' ><i eliminacion='" + datosProducto.idAvion + "' class='material-icons btnDeleteAvion' data-toggle='tooltip' title='Delete'>&#xE872;</i></a>";

    }
}
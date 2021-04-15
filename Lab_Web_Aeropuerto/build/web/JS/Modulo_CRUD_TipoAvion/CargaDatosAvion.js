export let aviones = null;
export const cuerpoTabla = document.querySelector('#cuerpoTabla');

export function cargarListado() {
    aviones = null;
    cuerpoTabla.textContent = '';
    var datos = new FormData();
    getJSON('ServletListadoAviones', datos, procesarRespuesta);
}

export function procesarRespuesta(datos) {
    aviones = datos["lista-aviones"];

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
            idTipoAvion: nuevoAvion.idTipoAvion,
            modelo: nuevoAvion.modelo,
            marca: nuevoAvion.marca,
            ano: nuevoAvion.ano,
            cantidadAsientos: nuevoAvion.cantidadAsientos,
            cantidadFilas: nuevoAvion.cantidadFilas,
            cantidadColumnas: nuevoAvion.cantidadColumnas
        };

        var indice = refTabla.rows.length;
        var nuevaFila = refTabla.insertRow(-1);
        var nuevaCelda;

//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerHTML = `<span class='custom-checkbox individualCheck'><input type='checkbox' id='checkbox1' name='options[]' value='${datosProducto.idTipoAvion}'><label ></label></span>`;

//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "idTipoAvion" + String(indice);
        nuevaCelda.innerText = datosProducto.idTipoAvion;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "modelo" + String(indice);
        nuevaCelda.innerText = datosProducto.modelo;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "marca" + String(indice);
        nuevaCelda.innerText = datosProducto.marca;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "ano" + String(indice);
        nuevaCelda.innerText = datosProducto.ano;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "cantidadAsientos" + String(indice);
        nuevaCelda.innerText = datosProducto.cantidadAsientos;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "cantidadFilas" + String(indice);
        nuevaCelda.innerText = datosProducto.cantidadFilas;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "cantidadColumnas" + String(indice);
        nuevaCelda.innerText = datosProducto.cantidadColumnas;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerHTML = "<a href='#editAvionModal'class='edit' data-toggle='modal'><i indice='" + indice + "' class='material-icons btnEditAvion' data-toggle='tooltip' title='Edit'>&#xE254;</i></a> \n\
<a href='#deleteAvionModal' class='delete'  data-toggle='modal' ><i eliminacion='" + datosProducto.idTipoAvion + "' class='material-icons btnDeleteAvion' data-toggle='tooltip' title='Delete'>&#xE872;</i></a>";

    }
}
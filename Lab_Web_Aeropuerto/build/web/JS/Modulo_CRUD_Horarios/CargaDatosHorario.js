export let vuelos = null;
export const cuerpoTabla = document.querySelector('#cuerpoTabla');

export function cargarListado() {
    vuelos = null;
    cuerpoTabla.textContent = '';
    var datos = new FormData();
    getJSON('ServletListadoHorarios', datos, procesarRespuesta);
}

export function procesarRespuesta(datos) {
    vuelos = datos["lista-horarios"];

    for (var i = 0; i < vuelos.length; i++) {
        var producto = vuelos[i];
        agregar(producto);
    }
    //console.log(cuerpoTabla.textContent === "");
    //console.log(catalogo.length);
    if (vuelos.length === 0) {
        document.querySelector('.alertaLibros').style.display = "block";
    } else {
        document.querySelector('.alertaLibros').style.display = "none";
    }
}

export function agregar(nuevoVuelo) {

    var refTabla = document.getElementById("cuerpoTabla");
    if (refTabla && nuevoVuelo) {
        var datosProducto = {
            idFechaVuelo: nuevoVuelo.idFechaVuelo,
            vuelo: nuevoVuelo.vuelo,
            fecha: nuevoVuelo.fecha,
            disponibles: nuevoVuelo.disponibles,
            precio: nuevoVuelo.precio
        };

        var indice = refTabla.rows.length;
        var nuevaFila = refTabla.insertRow(-1);
        var nuevaCelda;

//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerHTML = `<span class='custom-checkbox individualCheck'><input type='checkbox' id='checkbox1' name='options[]' value='${datosProducto.idFechaVuelo}'><label ></label></span>`;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "idFechaVuelo" + String(indice);
        nuevaCelda.innerText = datosProducto.idFechaVuelo;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "vuelo" + String(indice);
        nuevaCelda.innerText = datosProducto.vuelo;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "fecha" + String(indice);
        nuevaCelda.innerText = datosProducto.fecha;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "disponibles" + String(indice);
        nuevaCelda.innerText = datosProducto.disponibles;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "precio" + String(indice);
        nuevaCelda.innerText = datosProducto.precio + "$";
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerHTML = "<a href='#editAvionModal'class='edit' data-toggle='modal'><i indice='" + indice + "' class='material-icons btnEditAvion' data-toggle='tooltip' title='Edit'>&#xE254;</i></a> \n\
<a href='#deleteAvionModal' class='delete'  data-toggle='modal' ><i eliminacion='" + datosProducto.idFechaVuelo + "' class='material-icons btnDeleteAvion' data-toggle='tooltip' title='Delete'>&#xE872;</i></a>";

    }
}
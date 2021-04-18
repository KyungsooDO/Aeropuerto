export let vuelos = null;
export const cuerpoTabla = document.querySelector('#cuerpoTabla');

export function cargarListado() {
    vuelos = null;
    cuerpoTabla.textContent = '';
    var datos = new FormData();
    getJSON('ServletListadoVuelos', datos, procesarRespuesta);
}

export function procesarRespuesta(datos) {
    vuelos = datos["lista-vuelos"];

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
            idVuelo: nuevoVuelo.idVuelo,
            dia: nuevoVuelo.dia,
            hora: nuevoVuelo.hora,
            idFlota: nuevoVuelo.idFlota,
            idOrigen: nuevoVuelo.idOrigen,
            idDestino: nuevoVuelo.idDestino,
            duracion: nuevoVuelo.duracion
        };

        var indice = refTabla.rows.length;
        var nuevaFila = refTabla.insertRow(-1);
        var nuevaCelda;

//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerHTML = `<span class='custom-checkbox individualCheck'><input type='checkbox' id='checkbox1' name='options[]' value='${datosProducto.idVuelo}'><label ></label></span>`;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "idVuelo" + String(indice);
        nuevaCelda.innerText = datosProducto.idVuelo;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "dia" + String(indice);
        nuevaCelda.innerText = datosProducto.dia;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "hora" + String(indice);
        nuevaCelda.innerText = datosProducto.hora;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "idFlota" + String(indice);
        nuevaCelda.innerText = datosProducto.idFlota;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "idOrigen" + String(indice);
        nuevaCelda.innerText = datosProducto.idOrigen;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "idDestino" + String(indice);
        nuevaCelda.innerText = datosProducto.idDestino;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "duracion" + String(indice);
        nuevaCelda.innerText = datosProducto.duracion;
//        ---------------------------------------------------------
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerHTML = "<a href='#editAvionModal'class='edit' data-toggle='modal'><i indice='" + indice + "' class='material-icons btnEditAvion' data-toggle='tooltip' title='Edit'>&#xE254;</i></a> \n\
<a href='#deleteAvionModal' class='delete'  data-toggle='modal' ><i eliminacion='" + datosProducto.idVuelo + "' class='material-icons btnDeleteAvion' data-toggle='tooltip' title='Delete'>&#xE872;</i></a>";

    }
}
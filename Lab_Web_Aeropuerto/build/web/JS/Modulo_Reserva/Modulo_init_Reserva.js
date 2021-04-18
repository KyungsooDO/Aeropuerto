/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const formReserva = document.querySelector('#formreserva');
obtener_ciudades();

export function obtener_ciudades() {

    var data = JSON.parse(localStorage.getItem("data"));
    console.log("Datos de localstorage:");
    console.log(data);
    list(data);
    localStorage.clear();
    //$("#Reservar_Datos").find("*").prop('disabled', true); Esto es para deshabilitar
    $("#Reservar_Datos").hide();



}

export function list(peliculas) {
    var listado = $("#listadoPeliculas");
    listado.html("");
    var tr2 = $("<tr />");
    tr2.html(
            "");
    listado.append(tr2);
//    $("#campoText1").prop('disabled', true);
//    $("#campoText2").prop('disabled', true);
//    $("#campoText3").prop('disabled', true);
//    $("#guardar").prop('disabled', true);
//    $("#cancelar").prop('disabled', true);
    peliculas.forEach((p) => {
        row(listado, p);
    });

}

export function row(listado, pelicula) {
    var tr = $("<tr />");
    tr.html("<td id='tdpeli'>" + pelicula.ciudad.nombre + "-" + pelicula.ciudad.pais.nombre + "</td>" +
            "<td id='tdpeli'>" + pelicula.ciudad1.nombre + "-" + pelicula.ciudad1.pais.nombre + "</td>" +
            "<td id='tdpeli'>" + pelicula.hora + "</td>" +
            "<td id='tdpeli'>" + pelicula.dia + "</td>" +
            "<td id='tdpeli'><input type = 'button' id = 'editar' value='Reservar'></td>");
    tr.find("#editar").on("click", () => {
        obtener_fecha_vuelo(pelicula.idVuelo);
    });
    listado.append(tr);

}

export function obtener_fecha_vuelo(id_vuelo) {

    var vuelo = {
        idVuelo: id_vuelo
    };

    localStorage.setItem("idVuelo", id_vuelo);

    console.log("Objeto vuelo: ");
    console.log(vuelo);
    getJSONC('ServletFechaVuelo', vuelo, procesarRespuestaReserva);
    return false;

}

export function procesarRespuestaReserva(datos) {

    console.log(datos);
    localStorage.setItem("idFechaVuelo", datos.idFechaVuelo);
    $("#Reservar_Datos").show();
    $("#p").text(datos.idFechaVuelo);
    $("#p_fecha").text(datos.fecha);
    $("#p_precio").text(datos.precio);

    formReserva.addEventListener('submit', (e) => {
        e.preventDefault();
        realizar_Reserva();
        //enviarFormularioLogeo();
    });



}

export function realizar_Reserva() {
    console.log("Estoy en el metodo realizar reserva...");


    var reserva = {
        fecha: localStorage.getItem("idVuelo"),
        pago:document.getElementById('select_forma_pago').value 
    };
    
    console.log("Mostrando reserva:");
    console.log(reserva);

    //localStorage.setItem("idVuelo", id_vuelo);

    // console.log("Objeto vuelo: ");
    //console.log(vuelo);
    getJSONC('ServletReserva', reserva, procesarRespuestaReserva2);
    return false;

}

export function procesarRespuestaReserva2(datos) {

    console.log(datos);
    window.location = "index.jsp";



}
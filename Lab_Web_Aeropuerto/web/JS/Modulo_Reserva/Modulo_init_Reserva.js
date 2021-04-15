/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

obtener_ciudades();

export function obtener_ciudades() {

    var data = JSON.parse(localStorage.getItem("data"));
    console.log("Datos de localstorage:");
    console.log(data);
    list(data);

}

function list(peliculas) {
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

function row(listado, pelicula) {
    var tr = $("<tr />");
    tr.html("<td id='tdpeli'>" + pelicula.ciudad.nombre + "</td>" +
            "<td id='tdpeli'>" + pelicula.ciudad1.nombre + "</td>" +
            "<td id='tdpeli'>" + pelicula.hora + "</td>" +
            "<td id='tdpeli'>" + pelicula.dia + "</td>" +
            "<td id='tdpeli'><input type = 'button' id = 'editar' value='Reservar'></td>");
    tr.find("#editar").on("click", () => {
        edit(pelicula.nombre);
    });
    listado.append(tr);
}
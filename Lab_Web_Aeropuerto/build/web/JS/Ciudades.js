/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

export let vuelos = new BackBean();

export function BackBean() {
    this.origen = null;
    this.destino = null;
}

export function buscarVuelos(idForm) {


    let datos = new FormData();
    let property;

    for (property in vuelos) {
        let refCampo = document.getElementById(property);
        if (refCampo) {
            let v = refCampo.value;
            if (!(typeof (v) === 'undefined' || v === null || v === "")) {
                vuelos[property] = v;
                datos.append(property, v);
            }
        } else {
            let v = vuelos[property];
            if (Array.isArray(v)) {
                v.forEach((e) => {
                    datos.append(property, e);
                });
            } else {
                datos.append(property, v);
            }
        }
    }
//
//    console.log(datos.get("origen"));
//    console.log(datos.get("destino"));

    var ciudad = {
        nombre: vuelos.origen
    }
    var ciudad1 = {
        nombre: vuelos.destino
    }
    var vuelo = {
        ciudad: ciudad,
        ciudad1: ciudad1
    };

    console.log("Objeto vuelo: ");
    console.log(vuelo);
    getJSONC('ServletVuelos', vuelo, procesarRespuestaLogeo);
    return false;

}


export function procesarRespuestaLogeo(datos) {

    var lista = [];
    lista = datos;
    console.log(lista);
    localStorage.setItem("data", JSON.stringify(lista));
    var data = JSON.parse(localStorage.getItem("data"));
    console.log("Datos de localstorage:");
    console.log(data);

    data.forEach((p) => {
        console.log(p);
    });
    
    window.location = "Reserva.jsp";
    //localStorage.setItem('listavuelos', "hola");
    //console.log("Lista de vuelos, mostrando...");
    //var array = localStorage.getItem('listavuelos');
    //var myJSON = JSON.stringify(array);
    //console.log(myJSON);

}
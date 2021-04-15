/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

export let Logeo = new BackBean();

export function BackBean() {
    this.id = null;
    this.password = null;
}

export function enviarFormularioLogeo(idForm) {

    let datos = new FormData();
    let property;

    for (property in Logeo) {
        let refCampo = document.getElementById(property);
        if (refCampo) {
            let v = refCampo.value;
            if (!(typeof (v) === 'undefined' || v === null || v === "")) {
                Logeo[property] = v;
                datos.append(property, v);
            }
        } else {
            let v = Logeo[property];
            if (Array.isArray(v)) {
                v.forEach((e) => {
                    datos.append(property, e);
                });
            } else {
                datos.append(property, v);
            }
        }
    }

    console.log(datos);

    getJSONConfirmacion('SeveltLogin', datos, procesarRespuestaLogeo);
    return false;

}

export function procesarRespuestaLogeo(datos) {

    if (datos === "ERROR") {
        window.location = "login.jsp";

    } else if (datos === "EXITO1") {
        window.location = "admi.jsp";
    } else if (datos === "EXITO2") {
        window.location = "index.jsp";
    }

}

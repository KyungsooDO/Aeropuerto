<%-- 
    Document   : Reserva
    Created on : 13-abr-2021, 18:22:20
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"  type="text/css" href="CSS/estilo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>   
        <title>Reserva</title>
    </head>
    <body>
        <h1> Vuelos </h1>
        <div id="listaVuelos">
            <table>
                <thead><tr id="tipoTR"><th id="tipoTH">Ciudad de Origen</th><th id="tipoTH">Ciudad de Destino</th><th id="tipoTH">Hora</th><th id="tipoTH">Dia</th><th id="tipoTH"></th></tr></thead>
                <tbody id="listadoPeliculas"></tbody>
            </table>
        </div>

        <script src="JS/Modulo_Reserva/Modulo_init_Reserva.js" type="module"></script>
        <script src="JS/getJSON.js" type="text/javascript"></script>
    </body>
</html>

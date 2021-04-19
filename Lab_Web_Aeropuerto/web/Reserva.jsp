<%-- 
    Document   : Reserva
    Created on : 13-abr-2021, 18:22:20
    Author     : Carlos
--%>
<%@page import="Modelo.Logica.Usuario"%>
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
        <br>
        <div id="Reservar_Datos">
            <center>
                <form id="formreserva" name="formLogin" method="POST" >
                    <h4 id="NombreVuelo">Vuelo Seleccionado:&nbsp;&nbsp;<p id="p"></p></h4> 
                    <h4> Fecha de vuelo:  &nbsp;&nbsp;<p id="p_fecha"></p></h4>
                    <h4> Precio: &nbsp;&nbsp;<p id="p_precio"></p> </h4>
                    <h4> Forma de pago: &nbsp;&nbsp;  <select id="select_forma_pago" name="select_forma_pago">
                            <option value="01">Tarjeta</option>
                        </select></h4>
                    <button value="Login" type="submit">
                        Realizar Reserva
                    </button>

                </form>

            </center>
        </div>

        <script src="JS/Modulo_Reserva/Modulo_init_Reserva.js" type="module"></script>
        <script src="JS/getJSON.js" type="text/javascript"></script>
    </body>
</html>

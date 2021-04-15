<%-- 
    Document   : login
    Created on : 09-abr-2021, 10:17:46
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Login</title>
        <link href="CSS/login.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
    </head>
    <body>
        <div class="imagen-gb"></div>
        <div class="box">
            <h2>Sign In</h2>
            <form id="formLogin" name="formLogin" method="POST" >
                <div class="inputBox">
                    <input type="text" name="id" id="id" required="" autofocus="">
                    <label>Nombre de Usuario</label>
                </div>
                <div class="inputBox">
                    <input type="password" name="password" id="password" required="">
                    <label>Contraseña</label>
                </div>


                <button value="Login" type="submit">
                    enviar
                </button>
            </form>
        </div>
        <script src="JS/Modulo_Logeo/login.js" type="module"></script>
        <script src="JS/getJSON.js" type="text/javascript"></script>
    </body>
</html>

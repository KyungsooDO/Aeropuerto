<%-- 
    Document   : register
    Created on : 18-abr-2021, 17:35:52
    Author     : Grelvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Register</title>
        <link href="CSS/login.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
    </head>
    <body>
        <div class="imagen-gb"></div>
        <div class="box">
            <h2>Sign Up</h2>
            <form id="formRegister" name="formRegister" method="POST" >
                <div class="inputBoxDiv">
                    <div class="inputBox">
                        <input type="text" name="id" id="id" required="" autofocus="">
                        <label>Nombre de Usuario</label>
                    </div>
                    <div class="inputBox">
                        <input type="password" name="password" id="password" required="">
                        <label>Contraseña</label>
                    </div>
                </div>
                <div class="inputBoxDiv">
                    <div class="inputBox">
                        <input type="text" name="id" id="id" required="" autofocus="">
                        <label>Nombre</label>
                    </div>
                    <div class="inputBox">
                        <input type="text" name="id" id="id" required="" autofocus="">
                        <label>Apellido</label>
                    </div>
                </div>
                <div class="inputBoxDiv">
                    <div class="inputBox">
                        <input type="text" name="id" id="id" required="" autofocus="">
                        <label>Correo Electrónico</label>
                    </div>
                    <div class="inputBox">
                        <input type="date" name="id" id="id" required="" autofocus="">
                        <label>Fecha de Nacimiento </label>
                    </div>
                </div>
                <div class="inputBox">
                    <input type="text" name="password" id="password" required="">
                    <label>Dirección</label>
                </div>
                <div class="inputBoxDiv">
                    <div class="inputBox">
                        <input type="text" name="id" id="id" required="" autofocus="">
                        <label>Teléfono de Trabajo</label>
                    </div>
                    <div class="inputBox">
                        <input type="text" name="id" id="id" required="" autofocus="">
                        <label>Teléfono personal</label>
                    </div>
                </div>
                <input type="submit" name="" value="Register">
            </form>
        </div>
        <script src="JS/Modulo_Logeo/login.js" type="module"></script>
        <script src="JS/getJSON.js" type="text/javascript"></script>
    </body>
</html>

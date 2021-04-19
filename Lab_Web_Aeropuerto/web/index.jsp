<%-- 
    Document   : index
    Created on : 09-abr-2021, 9:54:07
    Author     : Carlos
--%>

<%@page import="Modelo.Logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/style.css">
        <title>Airline WAP</title>
    </head>
    <body>
        <% HttpSession se = request.getSession(true);
            Usuario u = (Usuario) se.getAttribute("usuario");

            if (u == null) {

            }
            String union = "";
            try {
                String nombre = u.getNombre();
                String cedula = u.getIdUsuario();
                union = nombre + "-" + cedula;

            } catch (Exception ex) {
                union = "N/A";
            }

        %>
        <!--Barra de Navegación-->


        <div class="wrapper">
            <header>
                <a href="index.jsp" class="logo" style="color: red"> Aerolinea <strong> SWISS </strong> </a>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="#">Contact Us</a></li>
                        <% if (u == null) { %>
                    <li><a href="login.jsp">Sign In</a></li>
                    <li><a href="register.jsp" class="signin">Sign Up</a></li>
                        <%} else {%>
                    <li><a ><%=union%></a>
                    <li><a href="ServletLogout" class="signin">Logout</a></li>
                        <%}%>
                </ul>
            </header>
            <!-- Barra de navegación -->
            <img src="images/background02.jpg">
            <!-- Barra para busqueda de tiquetes -->

            <div class="content">


                <div class="btn-box">
                    <button id="btn1" onclick="openFlight()">Flight</button>
                    <!--  <button id="btn2" onclick="openCheckIn()">Check-in Online</button>
                      <button id="btn3" onclick="openStatus()">Flights Status</button> -->
                </div>
                <!-- Flights tabs-->
                <div id="tab1" class="tabs-forms-flight">
                    <form form id="formbusqueda"  autocomplete="off" method="POST">

                        <div class="autocomplete">
                            <div class="texto">

                                <input id="origen" type="text" name="origen" required >
                                <div class="placeholder">Ciudad Origen</div>
                            </div>
                        </div>


                        <div class="autocomplete">
                            <div class="texto">
                                <input id="destino" type="text" name="destino" required>
                                <div class="placeholder">Ciudad Destino</div>
                            </div>
                        </div>      

                        <button  class="btn btn1" type="submit" >
                            Search Flight
                        </button>
                    </form>
                </div>

                <!-- Check in tabs-->
                <!--<div id="tab2" class="tabs-forms-flight">
                    <form action="#">

                        <div class="texto">
                            <input type="text" name="cod-reserva" required>
                            <div class="placeholder">Use my reservation code</div>
                        </div>

                        <div class="texto">
                            <input type="text" name="apellido" required>
                            <div class="placeholder">Last Name</div>
                        </div>

                        <div class="container">
                            <div class="texto">
                                <input type="date" name="fecha-salida" required>
                                <div class="placeholder-1">Departure date</div>
                            </div>
                        </div>

                        <button class="btn" type="submit" formaction="#">
                            Continue
                        </button>
                    </form>
                </div> -->

                <!-- Flights Status Tabs-->
                <!-- <div id="tab3" class="tabs-forms-flight">
                    <form action="#">

                        <div class="texto">
                            <input type="text" name="origen" required>
                            <div class="placeholder">From</div>
                        </div>

                        <div class="texto">
                            <input type="text" name="destino" required>
                            <div class="placeholder">To</div>
                        </div>

                        <div class="container">
                            <div class="texto">
                                <input type="date" name="fecha-salida" required>
                                <div class="placeholder-1">Date Flight</div>
                            </div>
                        </div>

                        <button class="btn" type="submit" formaction="#">
                            Check Status
                        </button>
                    </form>
                </div>
                -->
            </div>

            <!-- FIN de la Barra para busqueda de tiquetes -->


            <script src="JS/Modulo_Cargar_Ciudades_Vuelos_Paises.js" type="module"></script>
            <script src="JS/getJSON.js" type="text/javascript"></script>
    </body>
</html>

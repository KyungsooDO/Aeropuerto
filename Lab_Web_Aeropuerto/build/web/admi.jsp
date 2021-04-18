<%-- 
    Document   : admi
    Created on : 09-abr-2021, 16:31:27
    Author     : Carlos
--%>
<%@page import="Modelo.Logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- ===== BOX ICONS ===== -->
  <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
  <!-- ===== CSS ===== -->
  <link rel="stylesheet" href="CSS/admin.css">
  
  <!-- ===== JAVA ===== -->
  <% response.setHeader("cache-control", "no-cache, no-store, must-revalidate");

  %>
  
  
  <%  Usuario u = (Usuario) request.getSession(true).getAttribute("usuario");
            if (u == null || u.getRol()== "Cliente") {
                response.sendRedirect("login.jsp");
            }
  %>
  <title>Administración</title>
</head>

<body id="body-pd">
    <% HttpSession se = request.getSession(true);
            Usuario u1 = (Usuario) se.getAttribute("usuario");

            if (u1 == null) {
                u1 = new Usuario();
            }
            String union = "";
            try {
                String nombre = u.getNombre();
                String cedula = u.getIdUsuario();
                union = nombre + "-" + cedula;

            } catch (Exception ex) {
                union = "N/A";
            }

            //se.removeAttribute("usuario");
            //se.invalidate();
    %>
  <header class="header" id="header">
    <div class="header__toggle">
      <i class='bx bx-menu' id="header-toggle"></i>
    </div>

    <div class="header__user">
      <p><%=union%></p>
    </div>

    <div class="header__img">
      <img src="assets/img/perfil.jpg" alt="">
    </div>
  </header>

  <div class="l-navbar" id="nav-bar">
    <nav class="nav">
      <div>
        <a href="admi.jsp" class="nav__logo">
          <i class='bx bxs-plane-alt nav__logo-icon'></i>
          <span class="nav__logo-name">Aerolinea WAP</span>
        </a>

        <div class="nav__list">
          <a href="admi.jsp" class="nav__link active">
            <i class='bx bx-grid-alt nav__icon'></i>
            <span class="nav__name">Inicio</span>
          </a>

          <a href="admin-gestion-aviones.jsp" class="nav__link">
            <i class='bx bxs-plane nav__icon'></i>
            <span class="nav__name">Gestión de Aviones</span>
          </a>

          <a href="admin-gestion-rutas.jsp" class="nav__link">
            <i class='bx bx-compass nav__icon'></i>
            <span class="nav__name">Gestión de Rutas</span>
          </a>

          <a href="admin-gestion-horarios.jsp" class="nav__link">
            <i class='bx bx-time nav__icon'></i>
            <span class="nav__name">Gestión de Horarios</span>
          </a>

          <a href="admin-gestion-flota.jsp" class="nav__link">
            <i class='bx bxs-plane-take-off nav__icon'></i>
            <span class="nav__name">Gestión de Flota</span>
          </a>

        </div>
      </div>

      <a href="ServletLogout" class="nav__link">
        <i class='bx bx-log-out nav__icon'></i>
        <span class="nav__name">Log Out</span>
      </a>
    </nav>
  </div>

  <div class="main-content">
    <main>

      <h2 class="dash-title">Overview</h2>

      <section class="recent">
        <div class="activity-grid">
          <div class="activity-card">
            <h3>Clientes por avión</h3>

            <div class="table-responsive">
              <table>
                <thead>
                  <tr>
                    <th>Nombre</th>
                    <th>Cedula</th>
                    <th>Vuelo</th>
                    <th>Pasajeros</th>
                    <th>Avión</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Carlos Naranjo</td>
                    <td>12123413413</td>
                    <td>A123</td>
                    <td>3</td>
                    <td>AIRBUSS132</td>
                  </tr>
                  <tr>
                    <td>Carlos Naranjo</td>
                    <td>12123413413</td>
                    <td>A123</td>
                    <td>3</td>
                    <td>AIRBUSS132</td>
                  </tr>
                  <tr>
                    <td>Carlos Naranjo</td>
                    <td>12123413413</td>
                    <td>A123</td>
                    <td>3</td>
                    <td>AIRBUSS132</td>
                  </tr>
                  <tr>
                    <td>Carlos Naranjo</td>
                    <td>12123413413</td>
                    <td>A123</td>
                    <td>3</td>
                    <td>AIRBUSS132</td>
                  </tr>
                  <tr>
                    <td>Carlos Naranjo</td>
                    <td>12123413413</td>
                    <td>A123</td>
                    <td>3</td>
                    <td>AIRBUSS132</td>
                  </tr>
                  <tr>
                    <td>Carlos Naranjo</td>
                    <td>12123413413</td>
                    <td>A123</td>
                    <td>3</td>
                    <td>AIRBUSS132</td>
                  </tr>
                  <tr>
                    <td>Carlos Naranjo</td>
                    <td>12123413413</td>
                    <td>A123</td>
                    <td>3</td>
                    <td>AIRBUSS132</td>
                  </tr>
                  <tr>
                    <td>Carlos Naranjo</td>
                    <td>12123413413</td>
                    <td>A123</td>
                    <td>3</td>
                    <td>AIRBUSS132</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>

          <div class="summary">
            <div class="summary-card">
              <h3>Rutas con más ventas</h3>
              <div class="summary-single">
                <span class="ti-direction-alt"></span>
                <div>
                  <h5>SJ, COSTA RICA - CALIFORNIA, USA</h5>
                  <small>cifra</small>
                </div>
              </div>
              <div class="summary-single">
                <span class="ti-direction-alt"></span>
                <div>
                  <h5>SJ, COSTA RICA - GUADALAJARA, MEXICO</h5>
                  <small>cifra</small>
                </div>
              </div>
              <div class="summary-single">
                <span class="ti-direction-alt"></span>
                <div>
                  <h5>SJ, COSTA RICA - BERLIN, ALEMANIA</h5>
                  <small>cifra</small>
                </div>
              </div>
              <div class="summary-single">
                <span class="ti-direction-alt"></span>
                <div>
                  <h5>SJ, COSTA RICA - PARIS, FRANCIA</h5>
                  <small>cifra</small>
                </div>
              </div>
              <div class="summary-single">
                <span class="ti-direction-alt"></span>
                <div>
                  <h5>SJ, COSTA RICA - BEIJIN, CHINA</h5>
                  <small>cifra</small>
                </div>
              </div>
            </div>

            <!-- <div class="bday-card">
              <div class="bday-flex">
                <div class="bday-img"></div>
                <div class="bday-info">
                  <h5>Dwayne F. Sanders</h5>
                  <small>Birthday Today</small>
                </div>
              </div>

              <div class="text-center">
                <button>
                  <span class="ti-gift"></span>
                  Wish him
                </button>
              </div>
            </div> -->
          </div>
        </div>
      </section>
    </main>

  </div>
  <!--===== MAIN JS =====-->
  <script src="JS/admin.js"></script>
</body>

</html>

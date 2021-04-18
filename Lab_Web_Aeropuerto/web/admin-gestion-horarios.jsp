<%-- 
    Document   : admin-gestión-horarios
    Created on : 14-abr-2021, 17:45:30
    Author     : Grelvin
--%>
<%@page import="Modelo.Logica.Usuario"%>
<%@page import="Modelo.Logica.Fechavuelo"%>
<%@taglib prefix="combobox" uri="/WEB-INF/tlds/combox"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <!-- ===== BOX ICONS ===== -->
  <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
  <!-- ===== CSS ===== -->
  <link rel="stylesheet" href="CSS/adminGA.css">
  
  <!-- ===== JS ===== -->
  <script src="JS/getJSON.js" type="text/javascript"></script>
  <script src="JS/Modulo_CRUD_Horarios/Modulo_CRUD_Horario.js" type="module"></script>

    <!-- ===== JAVA ===== -->
  
  <% response.setHeader("cache-control", "no-cache, no-store, must-revalidate"); %>

        

  <%  Usuario u = (Usuario) request.getSession(true).getAttribute("usuario");
      if (u == null || u.getRol()== "Cliente") {
        response.sendRedirect("login.jsp");
      }
  %>
  <title>Administración</title>
</head>
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
<jsp:useBean class="Modelo.Datos.Dao_Vuelo" id="md" scope="request"></jsp:useBean>
<body id="body-pd">
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

      <div class="table-wrapper">
        <div class="table-title">
          <div class="row">
            <div class="col-sm-6">
              <h2>Gestión de <b>Horarios</b></h2>
            </div>
            <div class="col-sm-6">
              <a href="#addAvionModal" class="btn btn-success" data-toggle="modal"><i
                  class="material-icons">&#xE147;</i> <span>Añadir nuevo Horario</span></a>
              <a href="#deleteAvionModal" class="btn btn-danger btnEliminarTodo" data-toggle="modal"><i
                  class="material-icons">&#xE15C;</i> <span>Eliminar</span></a>
            </div>
          </div>
        </div>
        <table class="table table-striped table-hover">
          <thead>
            <tr>
              <th>
                <span class="custom-checkbox">
                  <input type="checkbox" id="selectAll">
                  <label for="selectAll"></label>
                </span>
              </th>
              <th>Identificador</th>
              <th>Vuelo</th>
              <th>Fecha</th>
              <th>Disponibles</th>
              <th>Precio</th>
              <th>Acción</th>
            </tr>
          </thead>
          <tbody id="cuerpoTabla">
            
          </tbody>
        </table>
        <div class="alert alert-danger alertaLibros text-center" role="alert">
               NO HAY HORARIOS EN LA BASE DE DATOS
        </div>
      </div>
    </div>

  <!-- Add Modal HTML -->
  <div id="addAvionModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form name="formAñadir" id="formAddAvion" method="POST">
          <div class="modal-header">
            <h4 class="modal-title">Añadir Horario</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label>Identificador</label>
              <input type="text" class="form-control" id="addIdentificador" maxlength="5" required>
            </div>
            <div class="form-group">
              <label>Vuelo</label>
              ${combobox:SelectVuelo(md, "addIdVuelo")}
            </div>
            <div class="form-group">
              <label>Fecha del Vuelo</label>
              <input type="date" class="form-control" id="addFecha" required>
            </div>
            <div class="form-group">
              <label>Asientos Disponibles</label>
              <input type="number" class="form-control" id="addDisponibles" required>
            </div>
            <div class="form-group">
              <label>Precio</label>
              <input type="number" class="form-control" id="addPrecio" required>
            </div>
          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
            <input type="submit" class="btn btn-success" value="Añadir">
          </div>
        </form>
      </div>
    </div>
  </div>
  <!-- Edit Modal HTML -->
  <div id="editAvionModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form name="formEditar" id="formEditAvion" method="POST">
          <div class="modal-header">
            <h4 class="modal-title">Editar Horario</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label>Identificador</label>
              <input type="hidden" id ="idDoc" class="form-control">
              <input type="text" class="form-control" id="editIdentificador" maxlength="5" required>
            </div>
            <div class="form-group">
              <label>Vuelo</label>
              ${combobox:SelectVuelo(md, "editIdVuelo")}
            </div>
            <div class="form-group">
              <label>Fecha del Vuelo</label>
              <input type="date" class="form-control" id="editFecha" required>
            </div>
            <div class="form-group">
              <label>Asientos Disponibles</label>
              <input type="number" class="form-control" id="editDisponibles" required>
            </div>
            <div class="form-group">
              <label>Precio</label>
              <input type="number" class="form-control" id="editPrecio" required>
            </div>
          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
            <input type="submit" class="btn btn-info" value="Guardar">
          </div>
        </form>
      </div>
    </div>
  </div>
  <!-- Delete Modal HTML -->
  <div id="deleteAvionModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form name="formBorrar" id="formDeleteAvion" method="POST">
          <div class="modal-header">
            <h4 class="modal-title">Eliminar Horario</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <p>¿Está seguro de eliminar este Horario?</p>
            <p class="text-warning"><small>Esta acción no se puede deshacer</small></p>
          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
            <input type="submit" class="btn btn-danger btnDisplayElim" value="Eliminar">
          </div>
        </form>
      </div>
    </div>
  </div>
      <div id="deleteAvionModalTodo" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form id="formDeleteAvionTodo" name="formulario_2" method="POST">
                        <div class="modal-header">
                            <h4 class="modal-title">Eliminar Los Horarios Seleccionadas</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <p>¿Está seguro de eliminar los Horarios?</p>
                            <p class="text-warning"><small>Esta acción no se puede deshacer.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-danger btnDisplayElimTodo"  value="Eliminar">
                        </div>
                    </form>
                </div>
            </div>
        </div>

  <div id="mensajeConfirmacion" class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog ">
                <div id="cuerpoMensaje" class="modal-content pt-0 justify-content-center border border-success rounded">
                    <div class="modal-body mt-4" >
                        <p class=" text-center align-middle text-success font-weight-bolder p-2">...</p>
                    </div>
                </div>
            </div>
        </div>    
      
    </main>
  </div>

  <!--===== MAIN JS =====-->
  <script src="JS/admin.js"></script>
</body>

</html>

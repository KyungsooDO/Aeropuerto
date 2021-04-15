<%-- 
    Document   : admin-gestion-flota
    Created on : 14-abr-2021, 17:55:09
    Author     : Grelvin
--%>

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

  <title>Administración</title>
</head>

<body id="body-pd">
  <header class="header" id="header">
    <div class="header__toggle">
      <i class='bx bx-menu' id="header-toggle"></i>
    </div>

    <div class="header__user">
      <p>Nombre del usuario</p>
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

          <a href="#" class="nav__link">
            <i class='bx bx-bar-chart-alt-2 nav__icon'></i>
            <span class="nav__name">Resportes</span>
          </a>
        </div>
      </div>

      <a href="#" class="nav__link">
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
              <h2>Gestión de <b>Flota</b></h2>
            </div>
            <div class="col-sm-6">
              <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i
                  class="material-icons">&#xE147;</i> <span>Añadir nueva Flota</span></a>
              <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i
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
              <th>Tipo de Avión</th>
              <th>Acción</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <span class="custom-checkbox">
                  <input type="checkbox" id="checkbox1" name="options[]" value="1">
                  <label for="checkbox1"></label>
                </span>
              </td>
              <td>B0001</td>
              <td>BO123</td>
              <td>
                <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Delete">&#xE872;</i></a>
              </td>
            </tr>

            <tr>
              <td>
                <span class="custom-checkbox">
                  <input type="checkbox" id="checkbox1" name="options[]" value="1">
                  <label for="checkbox1"></label>
                </span>
              </td>
              <td>B0001</td>
              <td>BO123</td>
              <td>
                <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Delete">&#xE872;</i></a>
              </td>
            </tr>

            <tr>
              <td>
                <span class="custom-checkbox">
                  <input type="checkbox" id="checkbox1" name="options[]" value="1">
                  <label for="checkbox1"></label>
                </span>
              </td>
              <td>B0001</td>
              <td>BO123</td>
              <td>
                <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Delete">&#xE872;</i></a>
              </td>
            </tr>

            <tr>
              <td>
                <span class="custom-checkbox">
                  <input type="checkbox" id="checkbox1" name="options[]" value="1">
                  <label for="checkbox1"></label>
                </span>
              </td>
              <td>B0001</td>
              <td>BO123</td>
              <td>
                <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Delete">&#xE872;</i></a>
              </td>
            </tr>

            <tr>
              <td>
                <span class="custom-checkbox">
                  <input type="checkbox" id="checkbox1" name="options[]" value="1">
                  <label for="checkbox1"></label>
                </span>
              </td>
              <td>B0001</td>
              <td>BO123</td>
              <td>
                <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Delete">&#xE872;</i></a>
              </td>
            </tr>

            <tr>
              <td>
                <span class="custom-checkbox">
                  <input type="checkbox" id="checkbox1" name="options[]" value="1">
                  <label for="checkbox1"></label>
                </span>
              </td>
              <td>B0001</td>
              <td>BO123</td>
              <td>
                <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Delete">&#xE872;</i></a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

  <!-- Add Modal HTML -->
  <div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form>
          <div class="modal-header">
            <h4 class="modal-title">Añadir Avión</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label>Identificador</label>
              <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Modelo</label>
              <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Nº de Asientos</label>
              <input type="number" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Nº de Filas</label>
              <input type="number" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Nº de Columnas</label>
              <input type="number" class="form-control" required>
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
  <div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form>
          <div class="modal-header">
            <h4 class="modal-title">Edit Employee</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label>Identificador</label>
              <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Modelo</label>
              <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Nº de Asientos</label>
              <input type="number" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Nº de Filas</label>
              <input type="number" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Nº de Columnas</label>
              <input type="number" class="form-control" required>
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
  <div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form>
          <div class="modal-header">
            <h4 class="modal-title">Eliminar Avión</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <p>¿Está seguro de eliminar este Avión?</p>
            <p class="text-warning"><small>Esta acción no se puede deshacer</small></p>
          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
            <input type="submit" class="btn btn-danger" value="Eliminar">
          </div>
        </form>
      </div>
    </div>
  </div>



      <!-- <h2 class="dash-title">Gestión de Aviones</h2>
      <section class="recent">
        <div class="activity-grid-aviones">
          <div class="activity-card">
            <div class="row">
              <h3>Lista de aviones</h3>
              <a href="#addFlight" class="addFlight" id="addFlight">Añadir Avión</a>
            </div>
            <div class="table-responsive">
              <table>
                <thead>
                  <tr>
                    <th>Identificador</th>
                    <th>Modelo</th>
                    <th>Nº de Asientos</th>
                    <th>Cantidad de Filas</th>
                    <th>Cantidad de Columnas</th>
                    <th>Acción</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>A123B</td>
                    <td>AIRBUSS</td>
                    <td>150</td>
                    <td>10</td>
                    <td>6</td>
                    <td>
                      <a href="#editFlight" class="editFlight" id="editFlight">Editar</a>
                      <a href="#deleteFlight" class="deleteFlight" id="deleteFlight">Borrar</a>
                    </td>
                  </tr>
                  <tr>
                    <td>A123B</td>
                    <td>AIRBUSS</td>
                    <td>150</td>
                    <td>10</td>
                    <td>6</td>
                    <td>
                      <a href="#editFlight" class="editFlight" id="editFlight2" data-toggle="modal" >Editar</a>
                      <a href="#deleteFlight" class="deleteFlight" id="deleteFlight2">Borrar</a>
                    </td>
                  </tr>
                  <tr>
                    <td>A123B</td>
                    <td>AIRBUSS</td>
                    <td>150</td>
                    <td>10</td>
                    <td>6</td>
                    <td>
                      <a href="#editFlight" class="editFlight" id="editFlight3">Editar</a>
                      <a href="#deleteFlight" class="deleteFlight" id="deleteFlight3">Borrar</a>
                    </td>
                  </tr>
                  <tr>
                    <td>A123B</td>
                    <td>AIRBUSS</td>
                    <td>150</td>
                    <td>10</td>
                    <td>6</td>
                    <td>
                      <a href="#editFlight" class="editFlight" id="editFlight4">Editar</a>
                      <a href="#deleteFlight" class="deleteFlight" id="deleteFlight4">Borrar</a>
                    </td>
                  </tr>
                  <tr>
                    <td>A123B</td>
                    <td>AIRBUSS</td>
                    <td>150</td>
                    <td>10</td>
                    <td>6</td>
                    <td>
                      <a href="#editFlight" class="editFlight" id="editFlight5">Editar</a>
                      <a href="#deleteFlight" class="deleteFlight" id="deleteFlight5">Borrar</a>
                    </td>
                  </tr>
                  <tr>
                    <td>A123B</td>
                    <td>AIRBUSS</td>
                    <td>150</td>
                    <td>10</td>
                    <td>6</td>
                    <td>
                      <a href="#editFlight" class="editFlight" id="editFlight6">Editar</a>
                      <a href="#deleteFlight" class="deleteFlight" id="deleteFlight6">Borrar</a>
                    </td>
                  </tr>
                  <tr>
                    <td>A123B</td>
                    <td>AIRBUSS</td>
                    <td>150</td>
                    <td>10</td>
                    <td>6</td>
                    <td>
                      <a href="#editFlight" class="editFlight" id="editFlight7">Editar</a>
                      <a href="#deleteFlight" class="deleteFlight" id="deleteFlight7">Borrar</a>
                    </td>
                  </tr>
                  <tr>
                    <td>A123B</td>
                    <td>AIRBUSS</td>
                    <td>150</td>
                    <td>10</td>
                    <td>6</td>
                    <td>
                      <a href="#editFlight" class="editFlight" id="editFlight8">Editar</a>
                      <a href="#deleteFlight" class="deleteFlight" id="deleteFlight8">Borrar</a>
                    </td>
                  </tr>
                  <tr>
                    <td>A123B</td>
                    <td>AIRBUSS</td>
                    <td>150</td>
                    <td>10</td>
                    <td>6</td>
                    <td>
                      <a href="#editFlight" class="editFlight" id="editFlight9">Editar</a>
                      <a href="#deleteFlight" class="deleteFlight" id="deleteFlight9">Borrar</a>
                    </td>
                  </tr>
                  <tr>
                    <td>A123B</td>
                    <td>AIRBUSS</td>
                    <td>150</td>
                    <td>10</td>
                    <td>6</td>
                    <td>
                      <a href="#editFlight" class="editFlight" id="editFlight10">Editar</a>
                      <a href="#deleteFlight" class="deleteFlight" id="deleteFlight10">Borrar</a>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>

            <div class="pagination">
              <a href="#">&laquo;</a>
              <a class="" href="#">1</a>
              <a class="" href="#">2</a>
              <a href="#">3</a>
              <a href="#">4</a>
              <a href="#">5</a>
              <a href="#">6</a>
              <a href="#">&raquo;</a>
            </div>

          </div>
        </div>
      </section> -->


      <!-- ========== Modal para agregar avion ============ -->
      <!-- <div id="#addFlight" class="modal">

        <div class="modal-content">
          <div class="modal-header">
            <span class="close">&times;</span>
            <h2>Añadir Avión</h2>
          </div>
          <div class="modal-body">
            <form action="">

              <div class="input-box">
                <label for="identificador">Identificador</label>
                <input type="text" name="" id="" placeholder="Digite el identificador">
              </div>

              <div class="input-box">
                <label for="modelo">Modelo</label>
                <input type="text" name="" id="" placeholder="Digite el modelo">
              </div>

              <div class="input-box">
                <label for="pasajeros">Nº de Pasajeros</label>
                <input type="number" name="" id="" placeholder="Digite el Nº de pasajeros">
              </div>

              <div class="input-box">
                <label for="filas">Nº de Filas</label>
                <input type="text" name="" id="" placeholder="Digite el Nº de Filas">
              </div>

              <div class="input-box">
                <label for="identificador">Nº de Columnas</label>
                <input type="text" name="" id="" placeholder=" Digite la cantidad de asientos">
              </div>

            </form>
          </div>

          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
            <input type="submit" class="btn btn-success btnAddBook" value="Añadir">
          </div>
        </div>
      </div>

       ========== Modal para editar avion ============ 
      <div id="#editFlight" class="modal">
        
        <div class="modal-content">
          <div class="modal-header">
            <span class="close">&times;</span>
            <h2>Editar Avión</h2>
          </div>
          <div class="modal-body">
            <form action="">

              <div class="input-box">
                <label for="identificador">Identificador</label>
                <input type="text" name="" id="" placeholder="Digite el identificador">
              </div>

              <div class="input-box">
                <label for="modelo">Modelo</label>
                <input type="text" name="" id="" placeholder="Digite el modelo">
              </div>

              <div class="input-box">
                <label for="pasajeros">Nº de Pasajeros</label>
                <input type="number" name="" id="" placeholder="Digite el Nº de pasajeros">
              </div>

              <div class="input-box">
                <label for="filas">Nº de Filas</label>
                <input type="text" name="" id="" placeholder="Digite el Nº de Filas">
              </div>

              <div class="input-box">
                <label for="identificador">Nº de Columnas</label>
                <input type="text" name="" id="" placeholder=" Digite la cantidad de asientos">
              </div>

            </form>
          </div>

          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
            <input type="submit" class="btn btn-success btnEditBook" value="Editar">
          </div>
        </div>
      </div>

       ========== Modal para eliminar avion ============ 
      <div id="#deleteFlight" class="modal">
        <div class="modal-content">
          <div class="modal-header">
            <span class="close">&times;</span>
            <h2>Eliminar Avión</h2>
          </div>
          <div class="modal-body">
           <p>¿Está seguro de eliminar el avión?</p>
           <p></p>
          </div>
          
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
            <input type="submit" class="btn btn-success btnDeleteAvion" value="Eliminar">
          </div>
        </div>
      </div>
    </div> -->
      
    </main>
  </div>

  <!--===== MAIN JS =====-->
  <script src="JS/admin.js"></script>
</body>

</html>
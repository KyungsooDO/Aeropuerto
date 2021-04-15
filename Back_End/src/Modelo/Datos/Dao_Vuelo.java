package Modelo.Datos;

import Modelo.Logica.Vuelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao_Vuelo {

    Gestor_Base_Datos db;

    private static Dao_Vuelo instancia = null;

    private static final String CMD_AGREGAR
            = "call agregar_vuelo(?,?,?,?,?,?,?);";

    private static final String CMD_ACTUALIZAR
            = "call actualizar_vuelo(?,?,?,?,?,?,?);";

    private static final String CMD_ELIMINAR
            = "call eliminar_vuelo(?);";

    private static final String CMD_RECUPERAR
            = "call obtener_vuelo(?);";

    private static final String CMD_LISTAR
            = "call listar_vuelo();";

    private static final String CMD_BUSCAR
            = "call buscar_vuelo(?,?);";

    private static final String CMD_BUSCAR_ORIGEN_DESTINO
            = "call buscar_vuelo_origen_destino(?,?);";

    private static final String CMD_VERIFICAR_AVION_VUELO
            = "call verificar_avion_vuelo(?);";

    private static final String CMD_ACTUALIZAR_AVION_VUELO
            = "call actualizar_avion_vuelo(?);";

    private static final String CMD_VERIFICAR_CIUDAD_ORIGEN_VUELO
            = "call verificar_ciudad_origen_vuelo(?);";

    private static final String CMD_VERIFICAR_CIUDAD_DESTINO_VUELO
            = "call verificar_ciudad_destino_vuelo(?);";

    private static final String CMD_ACTUALIZAR_CIUDAD_ORIGEN_VUELO
            = "call actualizar_ciudad_origen_vuelo(?);";

    private static final String CMD_ACTUALIZAR_CIUDAD_DESTINO_VUELO
            = "call actualizar_ciudad_destino_vuelo(?);";

    public static Dao_Vuelo obtenerInstancia() {
        if (instancia == null) {
            instancia = new Dao_Vuelo();
        }
        return instancia;
    }

    private Connection obtenerConexion() throws SQLException {
        return Gestor_Base_Datos.obtenerInstancia().getConnection();
    }

    public Gestor_Base_Datos getDb() {
        return db;
    }

    public void setDb(Gestor_Base_Datos db) {
        this.db = db;
    }

    public Dao_Vuelo() {
        this.db = new Gestor_Base_Datos();
    }

    public Dao_Vuelo(Gestor_Base_Datos db) {
        this.db = db;
    }

    public boolean delete(String c) throws SQLException {
        boolean exitoEliminar = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_ELIMINAR)) {
            stm.clearParameters();
            stm.setString(1, c);
            exitoEliminar = stm.executeUpdate() == 1;
        }

        return exitoEliminar;
    }

    public String obtener_verificar_avion(String id_tipo_avion) throws SQLException, Exception {

        String resultado = "";

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR_AVION_VUELO)) {
            stm.setString(1, id_tipo_avion);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                resultado = rs.getString("idVuelo");

            }
        }
        return resultado;
    }

    public boolean verificar_Avion(String avion) throws SQLException, Exception {

        boolean resultado = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR_AVION_VUELO)) {
            stm.setString(1, avion);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                resultado = true;

            }
        }
        return resultado;
    }

    public boolean update_avion(String avion) throws SQLException {
        boolean exito = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_ACTUALIZAR_AVION_VUELO)) {
            stm.clearParameters();
            stm.setString(1, avion);

            exito = stm.executeUpdate() == 1;
        }

        return exito;
    }

    public String obtener_verificar_Ciudad_Origen(String id_tipo_avion) throws SQLException, Exception {

        String resultado = "";

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR_CIUDAD_ORIGEN_VUELO)) {
            stm.setString(1, id_tipo_avion);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                resultado = rs.getString("idVuelo");

            }
        }
        return resultado;
    }

    public String obtener_verificar_Ciudad_Destino(String id_tipo_avion) throws SQLException, Exception {

        String resultado = "";

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR_CIUDAD_DESTINO_VUELO)) {
            stm.setString(1, id_tipo_avion);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                resultado = rs.getString("idVuelo");

            }
        }
        return resultado;
    }

    public boolean verificar_Ciudad_Origen(String Ciudad) throws SQLException, Exception {

        boolean resultado = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR_CIUDAD_ORIGEN_VUELO)) {
            stm.setString(1, Ciudad);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                resultado = true;

            }
        }
        return resultado;
    }

    public boolean verificar_Ciudad_Destino(String Ciudad) throws SQLException, Exception {

        boolean resultado = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR_CIUDAD_DESTINO_VUELO)) {
            stm.setString(1, Ciudad);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                resultado = true;

            }
        }
        return resultado;
    }

    public boolean update_ciudad_origen_vuelo(String avion) throws SQLException {
        boolean exito = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_ACTUALIZAR_CIUDAD_ORIGEN_VUELO)) {
            stm.clearParameters();
            stm.setString(1, avion);

            exito = stm.executeUpdate() == 1;
        }

        return exito;
    }

    public boolean update_ciudad_destino_vuelo(String avion) throws SQLException {
        boolean exito = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_ACTUALIZAR_CIUDAD_DESTINO_VUELO)) {
            stm.clearParameters();
            stm.setString(1, avion);

            exito = stm.executeUpdate() == 1;
        }

        return exito;
    }

    public boolean add(Vuelo c) throws SQLException {

        boolean exito = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();

            stm.setString(1, c.getIdVuelo());
            stm.setString(2, c.getDia());
            stm.setString(3, c.getHoraString());
            stm.setString(4, c.getAvion().getIdAvion());
            stm.setString(5, c.getCiudad().getIdCiudad());
            stm.setString(6, c.getCiudad1().getIdCiudad());
            stm.setString(7, c.getDuracionString());

            exito = stm.executeUpdate() == 1;
        }

        return exito;
    }

    public boolean update(Vuelo c) throws SQLException {
        boolean exito = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_ACTUALIZAR)) {
            stm.clearParameters();

            stm.setString(1, c.getDia());
            stm.setString(2, c.getHoraString());
            stm.setString(3, c.getAvion().getIdAvion());
            stm.setString(4, c.getCiudad().getIdCiudad());
            stm.setString(5, c.getCiudad1().getIdCiudad());
            stm.setString(6, c.getDuracionString());
            stm.setString(7, c.getIdVuelo());

            exito = stm.executeUpdate() == 1;
        }

        return exito;
    }

    public Vuelo get(String id) throws SQLException, Exception {
        Dao_Avion dao = new Dao_Avion();
        Dao_Ciudad dao2 = new Dao_Ciudad();
        Vuelo t = new Vuelo();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR)) {
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                t.setIdVuelo(rs.getString("idVuelo"));
                t.setDia(rs.getString("dia"));
                t.setAvion(dao.get(rs.getString("avion")));
                t.setCiudad(dao2.get(rs.getString("origen")));
                t.setCiudad1(dao2.get(rs.getString("destino")));
                t.setDuracion(rs.getTime("duracion"));
                t.setHora(rs.getTime("hora"));

            }
        }
        return t;
    }

    public List<Vuelo> getAll() throws SQLException, Exception {
        List<Vuelo> l = new ArrayList<>();
        Dao_Avion dao = new Dao_Avion();
        Dao_Ciudad dao2 = new Dao_Ciudad();

        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

            while (rs.next()) {
                Vuelo u = new Vuelo();
                u.setIdVuelo(rs.getString("idVuelo"));
                u.setDia(rs.getString("dia"));
                u.setAvion(dao.get(rs.getString("avion")));
                u.setCiudad(dao2.get(rs.getString("origen")));
                u.setCiudad1(dao2.get(rs.getString("destino")));
                u.setDuracion(rs.getTime("duracion"));
                u.setHora(rs.getTime("hora"));
                l.add(u);
            }
        }

        return l;
    }

    public List<Vuelo> search(Vuelo u) throws Exception {
        List<Vuelo> l = new ArrayList<>();
        Dao_Avion dao = new Dao_Avion();
        Dao_Ciudad dao2 = new Dao_Ciudad();
        try {
            String sql = "SELECT * FROM Vuelo WHERE idVuelo like '%%%s%%' "
                    + "and avion like '%%%s%%' and origen like '%%%s%%'"
                    + "and destino like '%%%s%%'";
            sql = String.format(sql,
                    u.getIdVuelo(),
                    u.getAvion(),
                    u.getCiudad().getIdCiudad(),
                    u.getCiudad1().getIdCiudad());
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                Vuelo t = new Vuelo();
                t.setIdVuelo(rs.getString("idVuelo"));
                t.setDia(rs.getString("dia"));
                t.setAvion(dao.get(rs.getString("avion")));
                t.setCiudad(dao2.get(rs.getString("origen")));
                t.setCiudad1(dao2.get(rs.getString("destino")));
                t.setDuracion(rs.getTime("duracion"));
                t.setHora(rs.getTime("hora"));
                l.add(t);
            }
        } catch (SQLException ex) {
            throw new Exception("Error SQL");
        }
        return l;
    }

    public List<Vuelo> buscar_vuelo_origen_destino(String origen, String destino) throws Exception {
        Dao_Avion dao = new Dao_Avion();
        Dao_Ciudad dao2 = new Dao_Ciudad();

        List<Vuelo> vuelos = new ArrayList();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_BUSCAR_ORIGEN_DESTINO)) {
            stm.setString(1, origen);
            stm.setString(2, destino);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vuelo t = new Vuelo();
                t.setIdVuelo(rs.getString("idVuelo"));
                t.setDia(rs.getString("dia"));
                t.setAvion(dao.get(rs.getString("avion")));
                t.setCiudad(dao2.get(rs.getString("origen")));
                t.setCiudad1(dao2.get(rs.getString("destino")));
                t.setDuracion(rs.getTime("duracion"));
                t.setHora(rs.getTime("hora"));
                vuelos.add(t);

            }
        }
        return vuelos;
    }
}

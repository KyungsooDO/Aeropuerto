package Modelo.Datos;

import Modelo.Logica.Tipoavion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Dao_TipoAvion {

    Gestor_Base_Datos db;

    private static Dao_TipoAvion instancia = null;

    private static final String CMD_AGREGAR
            = "call agregar_tipoavion(?,?,?,?,?,?,?);";

    private static final String CMD_ACTUALIZAR
            = "call actualizar_tipoavion(?,?,?,?,?,?,?);";

    private static final String CMD_ELIMINAR
            = "call eliminar_tipoavion(?);";

    private static final String CMD_RECUPERAR
            = "call obtener_tipoavion(?);";

    private static final String CMD_LISTAR
            = "call listar_tipoavion();";

    public static Dao_TipoAvion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Dao_TipoAvion();
        }
        return instancia;
    }

    private Connection obtenerConexion() throws SQLException {
        return Gestor_Base_Datos.obtenerInstancia().getConnection();
    }

    public Dao_TipoAvion() {
        db = new Gestor_Base_Datos();
    }

    public Dao_TipoAvion(Gestor_Base_Datos db) {
        this.db = db;
    }

    public Gestor_Base_Datos getDb() {
        return db;
    }

    public void setDb(Gestor_Base_Datos db) {
        this.db = db;
    }

    public boolean delete(String id_avion) throws SQLException {

        boolean exitoEliminar = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_ELIMINAR)) {
            stm.clearParameters();
            stm.setString(1, id_avion);
            exitoEliminar = stm.executeUpdate() == 1;
        }

        return exitoEliminar;
    }

    public boolean add(Tipoavion ta) throws SQLException {

        boolean exito = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();

            stm.setString(1, ta.getIdTipoAvion());
            stm.setString(2, ta.getModelo());
            stm.setString(3, ta.getMarca());
            stm.setString(4, ta.getAno());
            stm.setString(5, Integer.toString(ta.getCantidadAsientos()));
            stm.setString(6, Integer.toString(ta.getCantidadFilas()));
            stm.setString(7, Integer.toString(ta.getCantidadColumnas()));

            exito = stm.executeUpdate() == 1;
        }

        return exito;
    }

    public boolean update(Tipoavion ta) throws SQLException {
        boolean exito = false;

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_ACTUALIZAR)) {
            stm.clearParameters();

            stm.setString(1, ta.getModelo());
            stm.setString(2, ta.getMarca());
            stm.setString(3, ta.getAno());
            stm.setString(4, Integer.toString(ta.getCantidadAsientos()));
            stm.setString(5, Integer.toString(ta.getCantidadFilas()));
            stm.setString(6, Integer.toString(ta.getCantidadColumnas()));
            stm.setString(7, ta.getIdTipoAvion());

            exito = stm.executeUpdate() == 1;
        }

        return exito;
    }

    public Tipoavion get(String id) throws SQLException, Exception {
        Tipoavion t = new Tipoavion();

        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR)) {
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                t.setCantidadAsientos(rs.getInt("cantidadAsientos"));
                t.setIdTipoAvion(rs.getString("idTipoAvion"));
                t.setCantidadColumnas(rs.getInt("cantidadColumnas"));
                t.setCantidadFilas(rs.getInt("cantidadFilas"));
                t.setModelo(rs.getString("modelo"));
                t.setMarca(rs.getString("marca"));
                t.setAno(rs.getString("ano"));

            }
        }
        return t;
    }

    public List<Tipoavion> getAll() throws SQLException, Exception {
        List<Tipoavion> l = new ArrayList<>();

        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

            while (rs.next()) {

                Tipoavion t = new Tipoavion();
                t.setCantidadAsientos(rs.getInt("cantidadAsientos"));
                t.setIdTipoAvion(rs.getString("idTipoAvion"));
                t.setCantidadColumnas(rs.getInt("cantidadColumnas"));
                t.setCantidadFilas(rs.getInt("cantidadFilas"));
                t.setModelo(rs.getString("modelo"));
                t.setMarca(rs.getString("marca"));
                t.setAno(rs.getString("ano"));
                l.add(t);
            }
        }

        return l;
    }

    public List<Tipoavion> search(Tipoavion t) throws SQLException {
        List<Tipoavion> l = new ArrayList<>();
        String sql = "select * from TipoAvion where mondelo like '%%%s%%' and idTipoAvion like '%%%s%%'";
        sql = String.format(sql,
                t.getModelo(),
                t.getIdTipoAvion());
        ResultSet rs = db.executeQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                Tipoavion x = new Tipoavion();
                x.setCantidadAsientos(rs.getInt("cantidadAsientos"));
                x.setIdTipoAvion(rs.getString("idTipoAvion"));
                x.setCantidadColumnas(rs.getInt("cantidadColumnas"));
                x.setCantidadFilas(rs.getInt("cantidadFilas"));
                x.setModelo(rs.getString("modelo"));
                x.setMarca(rs.getString("marca"));
                x.setAno(rs.getString("ano"));
                l.add(x);
            }
        }
        return l;
    }

    public static String SelectTipoAvion(Modelo.Datos.Dao_TipoAvion md, String idTipoAvion) throws InstantiationException, InstantiationException, InstantiationException, IOException, IllegalAccessException, ClassNotFoundException, ParseException, Exception {
        return md.SelectTipoAvion(idTipoAvion);
    }

    public String SelectTipoAvion(String idTipoAvion) throws Exception {
        StringBuilder contenidos = new StringBuilder();
        contenidos.append(String.format("\t<select id=\"%1$s\" name=\"%1$s\">\n", idTipoAvion));

        List<Tipoavion> aviones = this.getAll();
        if (!aviones.isEmpty()) {
            for (Tipoavion m : aviones) {
                contenidos.append(String.format("\t\t<option value=\"%s\">%s</option>\n",
                        m.getIdTipoAvion(), m.getIdTipoAvion()));
            }
        } else {
            contenidos.append("\t\t<option value=\"0\">No existe ningun avi??n registrado.</option>\n");
        }

        contenidos.append("\t</select>");
        return contenidos.toString();
    }

}

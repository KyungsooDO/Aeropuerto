/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Model;

import Modelo.Datos.Dao_Avion;
import Modelo.Datos.Dao_Ciudad;
import Modelo.Datos.Dao_TipoAvion;
import Modelo.Datos.Dao_Usuario;
import Modelo.Datos.Dao_Vuelo;
import Modelo.Logica.Ciudad;
import Modelo.Logica.Usuario;
import Modelo.Logica.Vuelo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Modelo {

    private static Modelo uniqueInstance;
    private Dao_Usuario daoUsuario;
    private Dao_Ciudad daoCiudad;
    private Dao_Vuelo daoVuelo;
    private Dao_TipoAvion daotipoavion;
    private Dao_Avion daoAvion;

    public static Modelo instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Modelo();
        }
        return uniqueInstance;
    }

    private Modelo() {
        daoUsuario = Dao_Usuario.obtenerInstancia();
        daoCiudad = Dao_Ciudad.obtenerInstancia();
        daoVuelo = Dao_Vuelo.obtenerInstancia();
        daotipoavion = Dao_TipoAvion.obtenerInstancia();
        daoAvion = Dao_Avion.obtenerInstancia();
    }
//

    public Usuario obtenerUsuario(String cedula) throws SQLException, Exception {

        Usuario u = new Usuario();
        u = daoUsuario.get(cedula);
        return u;

    }

    public boolean verificarUsuario(String cedula, String clave) throws SQLException, Exception {

        boolean resultado;

        resultado = daoUsuario.recuperar(cedula, clave);

        return resultado;

    }

    public List<Ciudad> obtener_lista_ciudades() {

        List<Ciudad> lista_ciudad = new ArrayList();

        try {
            lista_ciudad = daoCiudad.getAll();
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista_ciudad;

    }

    public void eliminar_tipo_avion(String id) throws Exception {
        if (daoAvion.verificar_tipoAvion(id)) {
            System.out.println("Si hay un avion con ese id tipo avion");
            daoAvion.update_tipo_avion(id);
            daotipoavion.delete(id);

        } else {
            daotipoavion.delete(id);
            System.out.println("NO hay un avion con ese id tipo avion");
        }
    }

    public Ciudad obtener_por_nombre(String nombre) {
        Ciudad ciudad = new Ciudad();
        try {
            ciudad = daoCiudad.obtener_por_nombre_ciudad(nombre);
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ciudad;
    }

    public List<Vuelo> obtener_vuelos_origen_destino(String Origen, String Destino) {

        List<Vuelo> listaVuelos = new ArrayList();

        try {
            listaVuelos = daoVuelo.buscar_vuelo_origen_destino(Origen, Destino);
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaVuelos;
    }

    public static void main(String[] args) throws Exception {
//        Ciudad ciudad =  new Ciudad();
        Modelo modelo = new Modelo();
//        ciudad = modelo.obtener_por_nombre("San Jose");
//        List<Vuelo> vuelo = modelo.obtener_vuelos_origen_destino("01", "02");
//        System.out.println(vuelo);
        // modelo.eliminar_tipo_avion("02");
//        modelo.verificar("01");
    }
}

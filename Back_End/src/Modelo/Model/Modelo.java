/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Model;

import Modelo.Datos.Dao_Avion;
import Modelo.Datos.Dao_Ciudad;
import Modelo.Datos.Dao_FechaVuelo;
import Modelo.Datos.Dao_FormaPago;
import Modelo.Datos.Dao_Pais;
import Modelo.Datos.Dao_Reserva;
import Modelo.Datos.Dao_TipoAvion;
import Modelo.Datos.Dao_Tiquete;
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
    private Dao_Pais daoPais;
    private Dao_FechaVuelo daoFechaVuelo;
    private Dao_Reserva daoReserva;
    private Dao_FormaPago daoFormaPago;
    private Dao_Tiquete daoTiquete;

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
        daoPais = Dao_Pais.obtenerInstancia();
        daoFechaVuelo = Dao_FechaVuelo.obtenerInstancia();
        daoReserva = Dao_Reserva.obtenerInstancia();
        daoFormaPago = Dao_FormaPago.obtenerInstancia();
        daoTiquete = Dao_Tiquete.obtenerInstancia();
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
            daoAvion.update_tipo_avion(daoAvion.obtener_verificar_tipoAvion(id));
            daotipoavion.delete(id);

        } else {
            daotipoavion.delete(id);
            System.out.println("NO hay un avion con ese id tipo avion");
        }
    }

    public void eliminar_avion(String id) throws Exception {
        if (daoVuelo.verificar_Avion(id)) {
            System.out.println("Si hay un avion");
            daoVuelo.update_avion(daoVuelo.obtener_verificar_avion(id));
            daoAvion.delete(id);

        } else {
            daoAvion.delete(id);
            System.out.println("NO hay un avion");
        }
    }

    public void eliminar_pais(String id) throws Exception {
        if (daoCiudad.verificar_Pais(id)) {
            System.out.println("Si hay un pais");
            daoCiudad.update_pais(daoCiudad.obtener_verificar_Pais(id));
            daoPais.delete(id);

        } else {
            daoPais.delete(id);
            System.out.println("NO hay un pais");
        }
    }

    public void eliminar_ciudad(String id) throws Exception {
        if (daoVuelo.verificar_Ciudad_Origen(id)) {
            System.out.println("Si hay una ciudad de origen");
            daoVuelo.update_ciudad_origen_vuelo(daoVuelo.obtener_verificar_Ciudad_Origen(id));
            daoCiudad.delete(id);

        } else if (daoVuelo.verificar_Ciudad_Destino(id)) {
            System.out.println("Si hay una ciudad de destino");
            daoVuelo.update_ciudad_destino_vuelo(daoVuelo.obtener_verificar_Ciudad_Destino(id));
            daoCiudad.delete(id);
        } else {
            System.out.println("No hay una ciudad de destino ni origen");
            daoCiudad.delete(id);
        }
    }

    public void eliminar_vuelo(String id) throws Exception {
        if (daoFechaVuelo.verificar_Vuelo(id)) {
            System.out.println("Si hay un vuelo");
            daoFechaVuelo.update_Vuelo(daoFechaVuelo.obtener_verificar_FechaVuelo(id));
            daoVuelo.delete(id);

        } else {
            daoVuelo.delete(id);
            System.out.println("NO hay un vuelo");
        }
    }

    public void eliminar_fechavuelo(String id) throws Exception {
        if (daoReserva.verificar_FechaVuelo(id)) {
            System.out.println("Si hay un fechavuelo");
            daoReserva.update_FechaVuelo(daoReserva.obtener_verificar_FechaVuelo(id));
            daoFechaVuelo.delete(id);

        } else {
            daoFechaVuelo.delete(id);
            System.out.println("NO hay un fechavuelo");
        }
    }

    public void eliminar_formapago(String id) throws Exception {
        if (daoReserva.verificar_FormaPago(id)) {
            System.out.println("Si hay un fechavuelo");
            daoReserva.update_FormaPago(daoReserva.obtener_verificar_FormaPago(id));
            daoFormaPago.delete(id);

        } else {
            daoFormaPago.delete(id);
            System.out.println("NO hay un fechavuelo");
        }
    }

    public void eliminar_usuario(String id) throws Exception {
        if (daoReserva.verificar_Usuario(id)) {
            System.out.println("Si hay un fechavuelo");
            daoReserva.update_Usuario(daoReserva.obtener_verificar_Usuario(id));
            daoUsuario.delete(id);

        } else {
            daoUsuario.delete(id);
            System.out.println("NO hay un fechavuelo");
        }
    }

    public void eliminar_Reserva(int id) throws Exception {
        if (daoTiquete.verificar_Reserva(id)) {
            System.out.println("Si hay un fechavuelo");
            daoTiquete.update_Reserva(daoTiquete.obtener_verificar_Reserva(id));
            daoReserva.delete(id);

        } else {
            daoReserva.delete(id);
            System.out.println("NO hay un fechavuelo");
        }
    }

    public void eliminar_Tiquete(int id) throws SQLException {
        daoTiquete.delete(id);
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
        System.out.println(modelo.daoAvion.obtener_verificar_tipoAvion("55"));
    }
}

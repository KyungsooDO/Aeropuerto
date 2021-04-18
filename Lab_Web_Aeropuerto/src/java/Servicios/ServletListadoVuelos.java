
package Servicios;

import Modelo.Datos.Dao_Vuelo;
import Modelo.Logica.Avion;
import Modelo.Logica.Vuelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Grelvin
 */
@WebServlet(
        name = "ServletListadoVuelos",
        urlPatterns = {"/ServletListadoVuelos"}
)

public class ServletListadoVuelos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(this.lista_vuelos());
        }
    }

    private JSONObject lista_vuelos() throws Exception {

        List<Vuelo> lista = new ArrayList<>();
        lista = dv.getAll();
        JSONObject obj = toJSON(lista);
        //System.out.println(obj.toString(4));
        return obj;
    }

    private JSONObject toJSON(List<Vuelo> aviones) {
        JSONArray a = new JSONArray();
        aviones.forEach((p) -> {
            a.put(toJSON(p));
        });
        JSONObject r = new JSONObject();
        r.put("lista-vuelos", a);
        return r;
    }

    private JSONObject toJSON(Vuelo a) {
        JSONObject r = new JSONObject();
        r.put("idVuelo", a.getIdVuelo());
        r.put("dia", a.getDia());
        r.put("hora", a.getHora());
        r.put("idFlota", a.getAvion().getIdAvion());
        r.put("idOrigen", a.getCiudad() + ", " + a.getCiudad().getPais().getNombre());
        r.put("idDestino", a.getCiudad1()  + ", " + a.getCiudad1().getPais().getNombre());
        r.put("duracion", a.getDuracion());
        return r;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletEditarAvionFlota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletEditarAvionFlota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private final Dao_Vuelo dv = Dao_Vuelo.obtenerInstancia();
}

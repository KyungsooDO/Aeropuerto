package Servicios;

import Modelo.Datos.Dao_TipoAvion;
import Modelo.Logica.Tipoavion;
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

@WebServlet(
        name = "ServletListadoAviones",
        urlPatterns = {"/ServletListadoAviones"}
)

public class ServletListadoAviones extends HttpServlet {

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
            out.println(this.lista_aviones());
        }
    }

    private JSONObject lista_aviones() throws Exception {

        List<Tipoavion> lista = new ArrayList<>();
        lista = dTA.getAll();
        JSONObject obj = toJSON(lista);
        //System.out.println(obj.toString(4));
        return obj;
    }

    private JSONObject toJSON(List<Tipoavion> aviones) {
        JSONArray a = new JSONArray();
        aviones.forEach((p) -> {
            a.put(toJSON(p));
        });
        JSONObject r = new JSONObject();
        r.put("lista-aviones", a);
        return r;
    }

    private JSONObject toJSON(Tipoavion ta) {
        JSONObject r = new JSONObject();
        r.put("idTipoAvion", ta.getIdTipoAvion());
        r.put("modelo", ta.getModelo());
        r.put("marca", ta.getMarca());
        r.put("ano", ta.getAno());
        r.put("cantidadAsientos", ta.getCantidadAsientos());
        r.put("cantidadFilas", ta.getCantidadFilas());
        r.put("cantidadColumnas", ta.getCantidadColumnas());
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
            Logger.getLogger(ServletListadoAviones.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletListadoAviones.class.getName()).log(Level.SEVERE, null, ex);
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

    private final Dao_TipoAvion dTA = Dao_TipoAvion.obtenerInstancia();
}

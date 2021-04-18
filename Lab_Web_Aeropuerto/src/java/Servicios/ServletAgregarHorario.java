package Servicios;

import Modelo.Datos.Dao_FechaVuelo;
import Modelo.Datos.Dao_Vuelo;
import Modelo.Logica.Fechavuelo;
import Modelo.Logica.Vuelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
        name = "ServletAgregarHorario",
        urlPatterns = {"/ServletAgregarHorario"}
)

@MultipartConfig
public class ServletAgregarHorario extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Dao_Vuelo dv = Dao_Vuelo.obtenerInstancia();
        Dao_FechaVuelo dfv = Dao_FechaVuelo.obtenerInstancia();
        List<String> lista = new ArrayList<>();

        try (PrintWriter out = response.getWriter()) {
            JSONObject r = new JSONObject();
            Enumeration<String> p = request.getParameterNames();

            while (p.hasMoreElements()) {
                String n = p.nextElement();
                String[] v = request.getParameterValues(n);

                if (v.length == 1) {
                    r.put(n, v[0]);
                    lista.add(v[0]);

                } else {
                    JSONArray a = new JSONArray();
                    for (String s : v) {

                        a.put(s);
                    }
                    r.put(n, a);
                }
            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            try {
                date = formatter.parse(lista.get(2));
            } catch (ParseException ex) {

            }
            
            Vuelo v = dv.get(lista.get(1));
            Fechavuelo fv = new Fechavuelo(lista.get(0), date, Integer.parseInt(lista.get(3)), Integer.parseInt(lista.get(4)));
            fv.setVuelo(v);
            
            try {
                dfv.add(fv);
                out.print("EXITO");
            } catch (SQLException ex) {
                out.print("ERROR");
                Logger.getLogger(ServletAgregarHorario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                out.print("ERROR");
                Logger.getLogger(ServletAgregarHorario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
            Logger.getLogger(ServletAgregarHorario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletAgregarHorario.class.getName()).log(Level.SEVERE, null, ex);
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

}

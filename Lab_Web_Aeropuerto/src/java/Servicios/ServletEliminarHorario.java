package Servicios;

import Modelo.Model.Modelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
        name = "ServletEliminarHorario",
        urlPatterns = {"/ServletEliminarHorario"}
)

@MultipartConfig
public class ServletEliminarHorario extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<String> lista = new ArrayList<>();
        Modelo model = Modelo.instance();
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
            
            try {

                model.eliminar_fechavuelo(lista.get(0));

                out.print("EXITO");
//            } catch (InstantiationException ex) {
//                out.print("ERROR");
//                Logger.getLogger(ServletEditarAvion.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                out.print("ERROR");
//                Logger.getLogger(ServletEditarAvion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                out.print("ERROR");
                Logger.getLogger(ServletEditarHorario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                out.print("ERROR");
                Logger.getLogger(ServletEditarHorario.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

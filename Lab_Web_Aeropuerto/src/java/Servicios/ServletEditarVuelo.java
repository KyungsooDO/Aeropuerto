/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Datos.Dao_Avion;
import Modelo.Datos.Dao_Ciudad;
import Modelo.Datos.Dao_Vuelo;
import Modelo.Logica.Avion;
import Modelo.Logica.Ciudad;
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
        name = "ServletEditarVuelo",
        urlPatterns = {"/ServletEditarVuelo"}
)

@MultipartConfig

public class ServletEditarVuelo extends HttpServlet {

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
        Dao_Avion da = Dao_Avion.obtenerInstancia();
        Dao_Ciudad dc = Dao_Ciudad.obtenerInstancia();
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
            String formato = "HH:mm";
            SimpleDateFormat formatter = new SimpleDateFormat(formato);
            Date date = new Date();
            Date date1 = new Date();
            try{
                date = formatter.parse(lista.get(2));
                date = formatter.parse(lista.get(3));
            } catch (ParseException ex){
                
            }
            Avion a = da.get(lista.get(4));
            Ciudad c = dc.get(lista.get(5));
            Ciudad c1 = dc.get(lista.get(6));
            
                    
            Vuelo v = new Vuelo(lista.get(0), lista.get(1), date, date1, a, c, c1);
            
            System.out.print(v);
            
            try {
                dv.update(v);
                out.print("EXITO");
            } catch (SQLException ex) {
                out.print("ERROR");
                Logger.getLogger(ServletEditarAvionFlota.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                out.print("ERROR");
                Logger.getLogger(ServletEditarAvionFlota.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletEditarVuelo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletEditarVuelo.class.getName()).log(Level.SEVERE, null, ex);
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

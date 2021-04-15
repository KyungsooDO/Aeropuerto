/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Logica.Ciudad;
import Modelo.Model.Modelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Carlos
 */
@WebServlet(name = "ServletCiudades", urlPatterns = {"/ServletCiudades"})
public class ServletCiudades extends HttpServlet {

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
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
   
        try (PrintWriter out = response.getWriter()) {
            out.println(this.lista_documentos());
        }

    }

    private JSONObject lista_documentos() {
       
        Modelo model = Modelo.instance();
        List<Ciudad> lista_ciudades = new ArrayList();
        lista_ciudades = model.obtener_lista_ciudades();
        JSONObject obj = toJSON(lista_ciudades);
        return obj;
    }

    private JSONObject toJSON(List<Ciudad> ciudades) {
        JSONArray a = new JSONArray();
        ciudades.forEach((p) -> {
            a.put(toJSON(p));
        });
        JSONObject r = new JSONObject();
        r.put("lista-ciudades", a);
        return r;
    }

    private JSONObject toJSON(Ciudad d) {
        JSONObject r = new JSONObject();
        r.put("idCiudad", d.getIdCiudad());
        r.put("nombre", d.getNombre());
        r.put("pais", d.getPais());
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

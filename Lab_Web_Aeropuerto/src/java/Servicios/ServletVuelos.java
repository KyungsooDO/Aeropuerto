/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Logica.Ciudad;
import Modelo.Logica.Usuario;
import Modelo.Logica.Vuelo;
import Modelo.Model.Modelo;
import com.google.gson.Gson;
import java.io.BufferedReader;
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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Carlos
 */
@WebServlet(name = "ServletVuelos", urlPatterns = {"/ServletVuelos"})
public class ServletVuelos extends HttpServlet {

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
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
//        List<String> lista = new ArrayList<>();
//        JSONObject r = new JSONObject();
//        Enumeration<String> p = request.getParameterNames();
//        while (p.hasMoreElements()) {
//            String n = p.nextElement();
//            String[] v = request.getParameterValues(n);
//
//            if (v.length == 1) {
//                r.put(n, v[0]);
//                lista.add(v[0]);
//
//            } else {
//                JSONArray a = new JSONArray();
//                for (String s : v) {
//
//                    a.put(s);
//                }
//                r.put(n, a);
//            }
//        }
//       // String origen = lista.get(0).trim();
//        //String destino = lista.get(1).trim();
//        
//       // System.out.println("Origen:"+origen);
//       // System.out.println("Destino:"+destino);
//
//        try (PrintWriter out = response.getWriter()) {
//            out.println(this.lista_vuelos());
//        }

        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        Vuelo vue = gson.fromJson(reader, Vuelo.class);
        System.out.println("Datos del origen y destino...");
        System.out.println(vue);
        PrintWriter out = response.getWriter();
        Modelo model = Modelo.instance();
        List<Vuelo> lista_vuelos = new ArrayList();
        Ciudad ciudad = new Ciudad();
        Ciudad ciudad2 = new Ciudad();
        ciudad = model.obtener_por_nombre(vue.getCiudad().getNombre());
        ciudad2 = model.obtener_por_nombre(vue.getCiudad1().getNombre());
        lista_vuelos = model.obtener_vuelos_origen_destino(ciudad.getIdCiudad(), ciudad2.getIdCiudad());
        response.setContentType("application/json; charset=UTF-8");
        out.write(gson.toJson(lista_vuelos));
        response.setStatus(200);
        
    }

    private JSONObject lista_vuelos() {
        Ciudad origen = new Ciudad();
        Ciudad destino = new Ciudad();
        Modelo model = Modelo.instance();
        List<Vuelo> lista_vuelos = new ArrayList();
        lista_vuelos = model.obtener_vuelos_origen_destino("02", "03");
        JSONObject obj = toJSON(lista_vuelos);
        return obj;
    }

    private JSONObject toJSON(List<Vuelo> vuelos) {
        JSONArray a = new JSONArray();
        vuelos.forEach((p) -> {
            a.put(toJSON(p));
        });
        JSONObject r = new JSONObject();
        r.put("lista-vuelos", a);
        return r;
    }

    private JSONObject toJSON(Vuelo d) {
        JSONObject r = new JSONObject();
        r.put("idVuelo", d.getIdVuelo());
        r.put("Ciudad", d.getCiudad());
        r.put("ciudad1", d.getCiudad1());
        return r;
    }

//     private JSONObject lista_vuelos() {
//         Ciudad origen = new Ciudad();
//         Ciudad destino = new Ciudad();
//        Modelo model = Modelo.instance();
//        List<Vuelo> lista_vuelos = new ArrayList();
//        lista_vuelos = model.obtener_vuelos_origen_destino(Origen, Destino);
//        JSONObject obj = toJSON(lista_ciudades);
//        return obj;
//    }
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

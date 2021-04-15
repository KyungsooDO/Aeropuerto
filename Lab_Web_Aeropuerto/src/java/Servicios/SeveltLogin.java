/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Logica.Usuario;
import Modelo.Model.Modelo;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(
        name = "SeveltLogin",
        urlPatterns = {"/SeveltLogin"}
)

// La anotación '@MultipartConfig' es necesaria para poder recibir
// los parámetros de la petición enviada a través de POST.
@MultipartConfig
public class SeveltLogin extends HttpServlet {

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
        response.setHeader("cache-control", "no-cache, no-store, must-revalidate");

        boolean usuarioValido = false;
        boolean darPaso = false;
        JSONObject r = new JSONObject();
        Usuario prueba = new Usuario();
        Modelo model = Modelo.instance();

        List<String> lista = new ArrayList<>();
        try (PrintWriter out = response.getWriter()) {

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

            String usuario = lista.get(0).trim();
            String password = lista.get(1).trim();

            usuarioValido = model.verificarUsuario(usuario, password);

            System.out.println(prueba.getNombre());

            if (usuarioValido) {

                Usuario u = null;
                try {

                    u = model.obtenerUsuario(usuario);

                } catch (Exception ex) {
                    Logger.getLogger(SeveltLogin.class.getName()).log(Level.SEVERE, null, ex);
                }

                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("usuario", u);
               // darPaso = model.darPasoUsuario_Administrador(u);
                sesion.setMaxInactiveInterval(60 * 5);
                //System.out.println(usu.isPn_sTipo());
                if ("Administrador".equals(u.getRol())) {
                    out.print("EXITO1");

                } else {
                    out.print("EXITO2");
                }

            } else {
                out.print("ERROR");
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
            Logger.getLogger(SeveltLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SeveltLogin.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Logica.Fechavuelo;
import Modelo.Logica.Formapago;
import Modelo.Logica.Reserva;
import Modelo.Logica.Usuario;
import Modelo.Model.Modelo;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carlos
 */
@WebServlet(name = "ServletReserva", urlPatterns = {"/ServletReserva"})
public class ServletReserva extends HttpServlet {

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
        HttpSession se = request.getSession(true);
        Usuario u = (Usuario) se.getAttribute("usuario");
        response.setContentType("text/html;charset=UTF-8");
        BufferedReader reader = request.getReader();
        Modelo model = Modelo.instance();
        Gson gson = new Gson();
        Reserva reser = gson.fromJson(reader, Reserva.class);
        Reserva reserva_base = new Reserva();
        reserva_base.setUsuario(u);
        Fechavuelo fecha = new Fechavuelo();
        fecha = model.obtener_fechavuelo(reser.getFecha());
        Formapago pago = new Formapago();
        pago = model.obtener_formapago(reser.getPago());
        PrintWriter out = response.getWriter();
        reserva_base.setFechavuelo(fecha);
        reserva_base.setFormapago(pago);
        model.agregar_reserva(reserva_base);
        response.setContentType("application/json; charset=UTF-8");
        out.write(gson.toJson(reserva_base));
        response.setStatus(200);
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

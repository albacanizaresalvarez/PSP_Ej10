/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author albit
 */
public class Servlet1 extends HttpServlet {

    HttpSession sesion;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        Conexion con = new Conexion();

        String nombre = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        if (con.entrar(nombre, contrasena)) {
            sesion = request.getSession(); // Crear sesión primero
            sesion.setAttribute("tiendaRegistrada", nombre);

            BigDecimal stockTotal = null;
            ControladorArticulos contArt = new ControladorArticulos();
            ControladorTienda conTienda = new ControladorTienda();
            int codigoTienda = conTienda.obtenerTiendaRegistrada(nombre);

            try {
                stockTotal = contArt.calcularStock(codigoTienda);
            } catch (SQLException ex) {
                Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);
            }
            sesion.setAttribute("obtenerStock", stockTotal);

            response.sendRedirect("principal.jsp"); // Redirigir después de crear la sesión
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        sesion.removeAttribute("tiendaRegistrada");
        response.sendRedirect("index.html");
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    public static boolean retornarUsu(String usuario) {
        boolean entra;

        String useraux = usuario;

        if (useraux == null) {
            entra = false;
        } else {
            entra = true;
        }

        return entra;

    }

    
}

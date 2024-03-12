/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulos;
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
public class Servlet2 extends HttpServlet {

    HttpSession sesion;
    int idArt = 11;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idTienda = 1;
        String tienda = (String) request.getSession().getAttribute("tiendaRegistrada");
        
        switch (tienda)
        {
            case "Zara": idTienda = 1;
            break;
            case "Stradivarius": idTienda = 2;
            break;
            case "Mango": idTienda = 3;
            break;
            case "Primor": idTienda = 4;
            break;
            case "Druni": idTienda = 5;
            break;
           
        }
        
        
        response.sendRedirect("insertar.jsp");
        String nombre = request.getParameter("nombre");
        String desc = request.getParameter("desc");
        BigDecimal precio = new BigDecimal(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String foto = request.getParameter("foto");
        idArt = idArt +1;
        
        Articulos art = new Articulos(idArt, idTienda, nombre, desc, precio, stock, foto);
        ControladorArticulos cont = new ControladorArticulos();
        try {
            cont.insertarArticulo(art);
        } catch (SQLException ex) {
            Logger.getLogger(Servlet2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        BigDecimal stockTotal = (BigDecimal) request.getSession().getAttribute("obtenerStock");
        request.getSession().setAttribute("stockCalculado", stockTotal);
        response.sendRedirect("principal.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

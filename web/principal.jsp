<%-- 
    Document   : principal
    Created on : 01-mar-2024, 0:55:40
    Author     : albit
--%>

<%@page import="Controlador.Servlet1"%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link rel="stylesheet" href="CSS/principal.css">
    </head>
    <body>
         <%
                String tienda = (String) request.getSession().getAttribute("tiendaRegistrada");
                
                   boolean entra = Servlet1.retornarUsu(tienda);
                   
                   if(!entra) {
                   response.sendRedirect("error.jsp");
                   }
                   
                BigDecimal stockCalculado =(BigDecimal) request.getSession().getAttribute("obtenerStock");
         %>
         <h1>Bienvenido <%=tienda%></h1>
        
        <hr/>
        
        <form action="Servlet2" method="POST">
         <p>El stock total de esta tienda es de <span id="stockCalculado"><%= stockCalculado %></span> articulos.</p>
         <%-- <button type="submit">Calcular importe total</button> --%>
        </form>
        <article>
        <br/><p>Ver en tablas <a href="tabla.jsp">aquí</a></p>
         <p>Ver en articulos <a href="articulos.jsp">aquí</a></p>
         <p>insertar nuevo articulo <a href="insertar.jsp">aquí</a></p><br/>
        </article>
            <aside>
               <br/><br/>
             <form action="Servlet1" class="destruirSesion" method="POST">
                <input type="submit" value="Cerrar sesion"/>
            </form>
            </aside>
    </body>
</html>

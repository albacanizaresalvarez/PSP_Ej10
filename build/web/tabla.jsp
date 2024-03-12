<%-- 
    Document   : tabla
    Created on : 01-mar-2024, 2:13:10
    Author     : albit
--%>

<%@page import="Modelo.Articulos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Controlador.ControladorArticulos"%>
<%@page import="Controlador.ControladorTienda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla</title>
        <link rel="stylesheet" href="CSS/tabla1.css">
    </head>
    <body>
        <header>
            <h1>Ver datos en la tabla</h1>
        </header>
        <article>
         <%
                    ControladorArticulos contArt = new ControladorArticulos();
                    ControladorTienda conTienda = new ControladorTienda();
                    String tienda = (String) request.getSession().getAttribute("tiendaRegistrada");
                    int codigoTienda = conTienda.obtenerTiendaRegistrada(tienda);
                    ArrayList<Articulos> listaArticulos = contArt.listaArticulos(tienda);
                %>
        
                <div class="responsive">
        <table border="1">
            <thead>
            <th>ID</th>    
            <th>NumPedido</th>   
            <th>Importe</th>   
            <th>Fecha</th>   
            
            </thead>
            
            <tbody>
                
               <%
                  for(Articulos a: listaArticulos) {
               %>
               
               <tr>
                   <td><%=a.getNombre()%></td>
                   <td><%=a.getDescripcion()%></td>
                   <td><%=a.getPrecio()%></td>
                   <td><%=a.getFoto()%></td>
               </tr>
               <%
               }
               %>
            </tbody>
            
        </table>
                </div>
            
               <br/><br/>
         </article>   
            <aside>
               <br/><p>Volver a <a href="principal.jsp">principal</a></p><br/>
             <form action="Servlet1" class="destruirSesion" method="POST">
                <input type="submit" value="Cerrar sesion"/>
            </form>
            </aside>
        
    </body>
</html>

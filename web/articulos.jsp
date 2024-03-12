<%-- 
    Document   : articulos
    Created on : 01-mar-2024, 2:20:09
    Author     : albit
--%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Articulos"%>
<%@page import="Controlador.ControladorTienda"%>
<%@page import="Controlador.ControladorArticulos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Artículos</title>
    <link rel="stylesheet" href="CSS/lista.css">
</head>
<body>
<header>
    <h1>Ver datos de artículo</h1>
</header>

<div class="contenedor-articulos">
    <% 
    ControladorArticulos contArt = new ControladorArticulos();
    ControladorTienda conTienda = new ControladorTienda();
    String tienda = (String) request.getSession().getAttribute("tiendaRegistrada");
    int codigoTienda = conTienda.obtenerTiendaRegistrada(tienda);
    ArrayList<Articulos> listaArticulos = contArt.listaArticulos(tienda);
    for(Articulos a: listaArticulos) { 
    %>
    <article class="articulo">
        <div class="imagen-articulo">
            <img src="imagenes/<%=a.getFoto()%>" alt="<%=a.getNombre()%>">
        </div>
        <div class="detalle-articulo">
            <p><strong>Id del artículo:</strong> <%=a.getNombre()%></p>
            <p><strong>Número del artículo:</strong> <%=a.getDescripcion()%></p>
            <p><strong>Importe del artículo:</strong> <%=a.getPrecio()%></p>
            <p><strong>Fecha del artículo:</strong> <%=a.getStock()%></p>
        </div>
    </article>
    <% } %>
</div>

<aside>
    <p>Volver a <a href="principal.jsp">principal</a></p>
    <form action="Servlet1" class="destruirSesion" method="POST">
        <input type="submit" value="Cerrar sesión"/>
    </form>
</aside>

</body>
</html>

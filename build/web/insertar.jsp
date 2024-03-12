<%-- 
    Document   : insertar
    Created on : 01-mar-2024, 10:57:10
    Author     : albit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>insertar nuevo articulo</title>
        <link rel="stylesheet" href="CSS/insertar.css">
    </head>
    <body>
        <h1>Inserta un nuevo articulo en tu tienda</h1>
        <form action="Servlet2" metodo="get">
            <p> Nombre: <input type="text" name="nombre" required> </p>
            <p> Descripcion: <input type="text" name="desc" required> </p>
            <p> Precio: <input type="text" name="precio" required> </p>
            <p> Stock: <input type="text" name="stock" required> </p>
            <p> Imagen: <input type="text" name="foto" required> </p>
            <button type="submit">Insertar</button>
        </form>

        <aside>
            <p>Volver a <a href="principal.jsp">principal</a></p>
            <form action="Servlet1" class="destruirSesion" method="POST">
                <input type="submit" value="Cerrar sesión"/>
            </form>
        </aside>

    </body>
</html>

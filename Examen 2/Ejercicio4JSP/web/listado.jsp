<%-- 
    Document   : listado
    Created on : 25 nov 2025, 9:00:59
    Author     : alber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestión de Librería</h1>
        <p><a href="formAlta.jsp">Alta de libro</a></p>
        <p><a href="editar.jsp">Modificación de libro</a></p>
        <p><a href="borrar.jsp">Baja de libro</a></p>
        <p><a href="listado.jsp">Listado de libro</a></p>
        
        <br><br>
        <h3>Buscar por título...</h3>
        <form method="post" action="ServletBuscaLibros">
        <label>Titulo del libro</label>
        <input type="text" name="tit" id="tit">
        <input type="submit" value="Buscar">
        </form>
    </body>
</html>

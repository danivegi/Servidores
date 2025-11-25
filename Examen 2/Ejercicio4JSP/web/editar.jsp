<%@page import="modelo.Bd"%>
<%@page import="modelo.Libro"%>
<%@page import="java.util.ArrayList"%>
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



        <form method="post" action="editar-libro.jsp">
            <label>Título del libro</label>
            <select name="sel" id="sel">
                <%
                    ArrayList<Libro> listaLibros = Bd.consultarTodosLibros();
                    for (int x = 0; x < listaLibros.size(); x++) {%>
                <option value="<%=listaLibros.get(x).getTitulo()%>">
                    <%=listaLibros.get(x).getTitulo()%>
                </option>
                <%}%>
            </select>
            <input type="submit" value="Aceptar">
        </form>
    </body>
</html>

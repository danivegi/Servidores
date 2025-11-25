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
        <%
            String tit = request.getParameter("tit");
            ArrayList<Libro> listaLibros = Bd.consultarLibros(tit);
        %>
        <h1>Gestión de Librería</h1>
        <p><a href="formAlta.jsp">Alta de libro</a></p>
        <p><a href="editar.jsp">Modificación de libro</a></p>
        <p><a href="borrar.jsp">Baja de libro</a></p>
        <p><a href="listado.jsp">Listado de libro</a></p>

        <table border="1px">
            <tr>
                <th>Título</th>
                <th>ISBN</th>
                <th>Autor</th>
                <th>Editorial</th>
                <th>Descripción</th>
            </tr>
            <% for (int x = 0; x < listaLibros.size(); x++) {%>
            <tr>
                <td><%=listaLibros.get(x).getTitulo()%></td>
                <td><%=listaLibros.get(x).getIsbn()%></td>
                <td><%=listaLibros.get(x).getAutor()%></td>
                <td><%=listaLibros.get(x).getEditorial()%></td>
                <td><%=listaLibros.get(x).getDescripcion()%></td>
            </tr>
            <%}%>

        </table>
    </body>
</html>

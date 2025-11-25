<%-- 
    Document   : formAlta
    Created on : 25 nov 2025, 9:00:41
    Author     : alber
--%>

<%@page import="modelo.Bd"%>
<%@page import="modelo.Autor"%>
<%@page import="modelo.Editorial"%>
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

        <form action="ServletAltaLibro" method="post">
            <label>ISBN</label>
            <input type="text" name="isbn" id="isbn"><br><br>
            
            
            <label>Titulo</label>
            <input type="text" name="titulo" id="titulo"><br><br>
            
            <label>Autor</label>
            <select id="autor" name="autor">
                <%
                    ArrayList<Autor> listaAutores = Bd.consultarAutores();
                    for (int x = 0; x < listaAutores.size(); x++) { %>
                    <option value="<%=listaAutores.get(x).getIdAutor()%>">
                        <%=listaAutores.get(x).getNombre() + ", " + listaAutores.get(x).getApellido()%>
                    </option>
                    <%}%>
            </select><br><br>
            
            <label>Editorial</label>
            <select id="editorial" name="editorial">
                <%
                    ArrayList<Editorial> listaEditoriales = Bd.consultarEditoriales();
                    for (int x = 0; x < listaEditoriales.size(); x++) { %>
                    <option value="<%=listaEditoriales.get(x).getIdEditorial()%>">
                        <%=listaEditoriales.get(x).getName()%>
                    </option>
                    <%}%>
            </select><br><br>
            
            <label>Año de edición</label>
            <input type="text" name="anio" id="anio"><br><br>
            
            <label>Descripción</label>
            <textarea id="descripcion" name="descripcion" rows="5" cols="10"></textarea><br><br>
            
            <input type="submit" value="Aceptar">
            <input type="reset" value="Cancelar">
        </form>
    </body>
</html>

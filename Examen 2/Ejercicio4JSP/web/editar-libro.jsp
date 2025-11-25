<%@page import="modelo.Editorial"%>
<%@page import="modelo.Autor"%>
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

        <h3>Modificando Libro...</h3>



        <form action="ServletModLibro" method="post">
            <%
                String tit = request.getParameter("sel");
                ArrayList<Libro> listaLibros = Bd.consultarTodosLibros();
                for (int x = 0; x < listaLibros.size(); x++) {
                    if (tit.equals(listaLibros.get(x).getTitulo())) {%>
            <label>ISBN</label>
            <input type="text" name="isbn" id="isbn" value="<%=listaLibros.get(x).getIsbn()%>" readonly><br><br>


            <label>Titulo</label>
            <input type="text" name="titulo" id="titulo" value="<%=listaLibros.get(x).getTitulo()%>"><br><br>

            <label>Autor</label>
            <input type="text" name="autor" id="autor" value="<%=listaLibros.get(x).getAutor()%>"><br><br>

            <label>Editorial</label>
            <input type="text" name="editorial" id="editorial" value="<%=listaLibros.get(x).getEditorial()%>"><br><br>

            <label>Año de edición</label>
            <input type="text" name="anio" id="anio" value="<%=listaLibros.get(x).getAnio()%>"><br><br>

            <label>Descripción</label>
            <textarea id="descripcion" name="descripcion" rows="5" cols="10" value="<%=listaLibros.get(x).getDescripcion()%>"></textarea><br><br>

            <input type="submit" value="Editar">
            <input type="reset" value="Cancelar">
                                <%}
                }%>
        </form>
    </body>
</html>

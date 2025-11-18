<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sesion = request.getSession(false);
    String departamento = (String) sesion.getAttribute("departamento");
    if (departamento == null) {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulario actividad</title>
        <style>
            img { float: right; }
            div {
                margin: 5%;
                border-top: thick solid #408080;
                border-bottom: thick solid #408080;
                border-width: 40px;
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <div>
            <form method="post" action="ActividadServlet">
                <img src="Logo-01.jpg" alt="No se encuentra imagen" height="100" width="300">
                <h3>Departamento: <%= departamento.toUpperCase() %></h3>

                <p>Nombre de la actividad: <input type="text" name="nombreActividad" required></p>
                <p>Lugar de celebración: <input type="text" name="lugar" required></p>
                <p>Fecha: <input type="date" name="fecha" required></p>
                <p>Hora: <input type="time" name="hora" required></p>

                <p>
                    Destinada a:
                    <input type="radio" name="destinadoA" value="alumnado" checked>Alumnado
                    <input type="radio" name="destinadoA" value="profesorado">Profesorado
                </p>

                <p>
                    Tipo de actividad:
                    <input type="checkbox" name="tipoAct" value="académica">Académica
                    <input type="checkbox" name="tipoAct" value="deportiva">Deportiva
                    <input type="checkbox" name="tipoAct" value="cultural">Cultural
                    <input type="checkbox" name="tipoAct" value="convivencia">Convivencia
                </p>

                <p>
                    Curso destinado:
                    <select name="curso">
                        <%
                            if (departamento.equalsIgnoreCase("eso")) {
                        %>
                            <option>1º ESO</option>
                            <option>2º ESO</option>
                            <option>3º ESO</option>
                            <option>4º ESO</option>
                        <%
                            } else if (departamento.equalsIgnoreCase("sanidad")) {
                        %>
                            <option>1º Sanidad</option>
                            <option>2º Sanidad</option>
                        <%
                            } else if (departamento.equalsIgnoreCase("cocina")) {
                        %>
                            <option>1º Cocina</option>
                            <option>2º Cocina</option>
                        <%
                            } else if (departamento.equalsIgnoreCase("informatica")) {
                        %>
                            <option>1º Informática</option>
                            <option>2º Informática</option>
                        <%
                            }
                        %>
                    </select>
                </p>

                <p>Profesor responsable: <input type="text" name="profesor" required></p>
                <p>Observaciones:</p>
                <textarea name="observaciones" rows="4" cols="40"></textarea><br>

                <button type="submit" name="añadir">Añadir actividad</button>
                <button type="reset">Borrar actividad</button>
            </form>
                    
                <form action="listado.jsp">
                    <button type="submit" name="listar">Listado de actividades</button>
                </form>
        </div>
    </body>
</html>
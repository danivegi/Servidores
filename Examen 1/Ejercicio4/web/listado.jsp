<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, modelo.ActividadExtraescolar" %>
<%
    ServletContext contexto = getServletContext();
    List<ActividadExtraescolar> lista = (List<ActividadExtraescolar>) contexto.getAttribute("lista");
    if (lista == null) lista = new ArrayList<>();

    String filtro = request.getParameter("filtro"); // puede ser "alumnado", "profesorado" o null
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Listado actividades</title>
        <style>
            div {
                margin: 5%;
                border-top: thick solid #408080;
                border-bottom: thick solid #408080;
                border-width: 40px;
                padding: 20px;
            }
            table, th, td {
                border: thick solid black;
                border-width: 2px;
                text-align: center;
                border-collapse: collapse;
            }
            th {
                background-color: #cccccc;
            }
            td {
                background-color: #76EFCE;
            }
        </style>
    </head>
    <body>
        <div>
            <img src="Logo-01.jpg" alt="No se encuentra imagen" height="100" width="300">
            <h2>Listado de Actividades Extraescolares</h2>

            <table>
                <tr>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Nombre</th>
                    <th>Lugar</th>
                    <th>Destinatario</th>
                    <th>Curso</th>
                    <th>Tipo</th>
                    <th>Departamento</th>
                    <th>Responsable</th>
                    <th>Observaciones</th>
                </tr>

                <%
                    for (ActividadExtraescolar a : lista) {
                        if (filtro == null || a.getDestinadoA().equalsIgnoreCase(filtro)) {
                %>
                <tr>
                    <td><%= a.getFecha() %></td>
                    <td><%= a.getHora() %></td>
                    <td><%= a.getNombreActividad() %></td>
                    <td><%= a.getLugar() %></td>
                    <td><%= a.getDestinadoA() %></td>
                    <td><%= a.getCurso() %></td>
                    <td><%= a.getTipoAct() %></td>
                    <td><%= a.getDepartamento() %></td>
                    <td><%= a.getProfesor() %></td>
                    <td><%= a.getObservaciones() %></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>

            <br>
            <form action="formulario.jsp" method="get" style="display:inline;">
                <button type="submit">Seguir añadiendo actividades</button>
            </form>

            <form action="listado.jsp" method="get" style="display:inline;">
                <input type="hidden" name="filtro" value="alumnado">
                <button type="submit">Ver actividades alumnado</button>
            </form>

            <form action="listado.jsp" method="get" style="display:inline;">
                <input type="hidden" name="filtro" value="profesorado">
                <button type="submit">Ver actividades profesorado</button>
            </form>

            <form action="listado.jsp" method="get" style="display:inline;">
                <button type="submit">Ver todas</button>
            </form>
        </div>
    </body>
</html>

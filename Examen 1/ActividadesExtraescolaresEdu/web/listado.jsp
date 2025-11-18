

<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.ListaActividades"%>
<%@page import="java.util.List"%>
<%@page import="modelo.ActividadExtraescolar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado actividades</title>
        <style>

            div{
                margin: 5%;
                border-top: thick solid #408080;
                border-bottom: thick solid #408080;
                border-width: 40px;
                padding: 20px;
            }

            table,th,td{
                border: thick solid black;
                border-width: 2px;
                text-align: center
            }
        </style>
    </head>
    <%
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        String filtro = request.getParameter("filtro");
        ArrayList<ActividadExtraescolar> listaFiltrada = new ArrayList<>();

        if ("soloAlumnado".equals(filtro)) {
            listaFiltrada = ListaActividades.actividades.stream()
                    .filter(n -> n.getDestinatario().equals("alumnos"))
                    .collect(Collectors.toCollection(ArrayList::new));
        } else if ("soloProfesorado".equals(filtro)) {
            listaFiltrada = ListaActividades.actividades.stream()
                    .filter(n -> n.getDestinatario().equals("profesores"))
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            listaFiltrada = new ArrayList<>(ListaActividades.actividades);
        }
    %>
    <body>

        <div>
            <img src="imagenes/Logo-01.jpg" alt="No se encuentra imagen" height="100" width="300">
            <table>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Nombre de la actividad</th>
                <th>Lugar de celebracion</th>
                <th>Personal de destino</th>
                <th>Curso</th>
                <th>Tipo de actividad</th>
                <th>Dpto que lo organiza</th>
                <th>Responsable</th>
                <th>Observaciones</th>

                <% for (ActividadExtraescolar a1 : listaFiltrada) {%>
                <tr color="#FFFFFF">
                    <td color="#FFFFFF" bgcolor="#76EFCE"><%= a1.getFecha()%></td>
                    <td bgcolor="#76EFCE"><%= a1.getHora()%></td>
                    <td bgcolor="#76EFCE"><%= a1.getNombre()%></td>
                    <td bgcolor="#76EFCE"><%= a1.getLugar()%></td>
                    <td bgcolor="#76EFCE"><%= a1.getDestinatario()%></td>
                    <td bgcolor="#76EFCE"><%= a1.getCurso()%></td>
                    <td bgcolor="#76EFCE"><% for (int x = 0; x < a1.getTipoActividad().length; x++) {%>
                        <%= a1.getTipoActividad()[x]%><br>
                        <% }%></td>
                    <td bgcolor="#76EFCE"><%= a1.getDptoOrganizador()%></td>
                    <td bgcolor="#76EFCE"><%= a1.getResponsable()%></td>
                    <td bgcolor="#76EFCE"><%= a1.getObservaciones()%></td>
                </tr>   


                <% }%>







            </table>

            <a href="actividadExtraescolas.html"><button>Seguir añadiendo actividades</button></a>
            <form method="post" action="listado.jsp">
                <a href=""><button name="filtro" value="soloAlumnado">Ver actividades alumnado </button></a>
                <a href=""><button name="filtro" value="soloProfesorado">Ver actividades profesorado</button></a>
                <a href=""><button name="filtro" value="verTodos">Ver actividades de todos</button></a>   
            </form>


        </div>
    </body>
</html>



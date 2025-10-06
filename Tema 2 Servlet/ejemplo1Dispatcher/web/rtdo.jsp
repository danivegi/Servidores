<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Aplicación J2EE de Nombre Apellido1 Apellido2</title>
    </head>
    <body>
        <%
            // Obtener los datos guardados en el contexto por el servlet
            String num = (String) getServletContext().getAttribute("numero_valido");
            String col = (String) getServletContext().getAttribute("color_valido");
            int numero = Integer.parseInt(num); // Convertimos el número a entero
        %>

        <h1>Tabla de multiplicar del <%= numero%></h1>
        
        <!-- Creamos la tabla con el color de fondo elegido -->
        <table border="1" bgcolor="<%= col %>">
            <%
                // Bucle para generar las filas de la tabla (1 al 9)
                for (int x = 1; x < 10; x++) {
            %>
            <tr>
                <td><b><%= numero%></b></td>
                <td><i>x <%= x%> = </i></td>
                <td><i><%= numero * x%></i></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>

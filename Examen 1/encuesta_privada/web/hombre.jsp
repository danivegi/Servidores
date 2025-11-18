<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                background-color: cyan;
            }
            h2 {
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>DATOS ENCUESTA</h1>
        <%
            String nombre = (String) getServletContext().getAttribute("nombre_Introducido");
            String apellidos = (String) getServletContext().getAttribute("apellidos_Introducido");
            String telefono = (String) getServletContext().getAttribute("telefono_Introducido");
            String ciudad = (String) getServletContext().getAttribute("ciudad_Introducido");
            String sexo = (String) getServletContext().getAttribute("sexo_Introducido");
            String pais = (String) getServletContext().getAttribute("pais_Introducido");
            String comentarios = (String) getServletContext().getAttribute("comentarios_Introducido");
            String[] actividades = (String[]) getServletContext().getAttribute("actividades_Introducido");
            String nombreMayus = nombre.toUpperCase();
        %>
        <h2>Hola <%=nombre %></h2>
        
        <table border = 3px>
            <tr>
                <td><b>nombre</b></td>
                <td><%=nombre%></td>
            </tr>
            
            <tr>
                <td><b>apellidos</b></td>
                <td><%=apellidos%></td>
            </tr>
            
            <tr>
                <td><b>telefono</b></td>
                <td><%=telefono%></td>
            </tr>
            
            <tr>
                <td><b>lugar de nacimiento</b></td>
                <td><%=ciudad%></td>
            </tr>
            
            <tr>
                <td><b>sexo</b></td>
                <td><%=sexo%></td>
            </tr>
            
            <tr>
                <td><b>pais de origen</b></td>
                <td><%=pais%></td>
            </tr>
            
            <tr>
                <td><b>areaTexto</b></td>
                <td><%=comentarios%></td>
            </tr>
        </table>
            
                <p><%=nombreMayus%>, tus actividades de ocio preferidas son:</p>
                
                <table border = 2px>
                    <% for (String actividad : actividades){
                        %> <tr><td><%=actividad%></td></tr>
                   <% } %>
                </table>
                <a href="https://i.pinimg.com/736x/b9/e1/78/b9e1784485c20de190eba672557c07d0.jpg">Sorpresa!!!!!</a>
    </body>
</html>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String dato = request.getParameter("dato");
    String cuenta = request.getParameter("operacion");

    if (dato == null || dato.isEmpty()) {
        out.println("<p>Error: no se recibió el dato.</p>");
        return;
    }

    int numero = Integer.parseInt(dato);
        %>
        
        <h2>Tabla de <%= cuenta %> del <%= numero %></h2>
        <table border="1">
            <%
                if ("Multiplicar".equals(cuenta)) {
                    for (int x = 1; x < numero; x++) {
                        int resul = numero * x;
                    
            %>
            <tr>
                <td><%= numero %></td>
                <td>x<%= x %></td>
                <td><%= resul %></td>
            </tr>
            <%
                    }
                } else if ("Dividir".equals(cuenta)) {
                    for (int x = 1; x <=numero; x++) {
                        double num = (double) numero;
                        double dividendo = (double) x;
                        double resul = num / dividendo;
            %>
                        <tr>
                            <td><%= numero %></td>
                            <td><%= x %></td>
                            <td><%= resul %></td>
                    }</tr>
        <%
                }
            } else {
        %>
                <tr><td>0!=1</td></tr>
        <%
                long resul = 1;
                for (int i = 1; i <= numero; i++) {
                    resul *= i;
        %>
                    <tr>
                        <td><%= i %>!=<%= resul %></td>
                    </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>

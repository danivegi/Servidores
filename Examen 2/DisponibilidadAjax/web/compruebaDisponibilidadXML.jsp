<%@ page import="java.sql.*" contentType="text/xml" %>

<%
    String login = request.getParameter("login");

    response.setHeader("Cache-Control", "no-cache");
    response.setContentType("text/xml");

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost/usuarios", "root", "");

    PreparedStatement ps = con.prepareStatement(
        "SELECT login FROM usuarios WHERE login = ?");
    ps.setString(1, login);

    ResultSet rs = ps.executeQuery();

    boolean disponible = !rs.next();
%>

<respuesta>
<%
    if (disponible) {
%>
    <disponible>si</disponible>
<%
    } else {
%>
    <disponible>no</disponible>
    <alternativas>
<%
        // Generar alternativas ? login + número
        for (int i = 1; i <= 5; i++) {
%>
        <login><%= login + i %></login>
<%
        }
%>
    </alternativas>
<%
    }
%>
</respuesta>

<%
    con.close();
%>

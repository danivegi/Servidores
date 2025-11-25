package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletBuscaLibros extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String tit = request.getParameter("tit");
        int tamano = tit.length();
        
        if (tamano < 1) {
            rd = contexto.getRequestDispatcher("/errorBusqueda.html");
            rd.forward(request, response);
        } else {
            rd = contexto.getRequestDispatcher("/listado-libros.jsp");
            rd.forward(request, response);
        }
        
    }

}

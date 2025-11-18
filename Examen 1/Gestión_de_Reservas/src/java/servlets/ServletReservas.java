package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletReservas extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        RequestDispatcher rd;
        
        try {
            String nombre = request.getParameter("nombre");
            context.setAttribute("nombre_Introd", nombre);
            
            String apellidos = request.getParameter("apellidos");
            context.setAttribute("apellidos_Introd", apellidos);
            
            String dni = request.getParameter("dni");
            context.setAttribute("dni_Introd", dni);
            
            String ss = request.getParameter("ss");
            context.setAttribute("ss_Introd", ss);
            
            String telefono = request.getParameter("telefono");
            context.setAttribute("telefono_Introd", telefono);
            
            String email = request.getParameter("email");
            context.setAttribute("email_Introd", email);
            
            String provincia = request.getParameter("provincia");
            context.setAttribute("provincia_Introd", provincia);
        } catch (Exception e) {
            rd = context.getRequestDispatcher("/error.html");
        }
    }



}

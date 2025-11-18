package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        if ((usuario.equals("eso") && password.equals("cdpjosecabreraeso")) || (usuario.equals("sanidad") && password.equals("cdpjosecabrerasanidad")) || (usuario.equals("cocina") && password.equals("cdpjosecabreracocina")) || (usuario.equals("informatica") && password.equals("cdpjosecabrerainformatica"))) {
        contexto.setAttribute("DptoOrganizador", usuario);
        rd = contexto.getRequestDispatcher("/actividadExtraescolas.html");
        rd.forward(request, response);
   
        }else{
            rd = contexto.getRequestDispatcher("/error.html");
            rd.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

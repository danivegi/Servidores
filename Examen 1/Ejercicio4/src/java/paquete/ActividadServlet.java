package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ActividadExtraescolar;

public class ActividadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        String departamento = (String) sesion.getAttribute("departamento");
        
        String nombre = request.getParameter("nombreActividad");
        String lugar = request.getParameter("lugar");
        String profesor = request.getParameter("profesor");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String destinadoA = request.getParameter("destinadoA");
        String tipoAct = request.getParameter("tipoAct");
        String curso = request.getParameter("curso");
        String observaciones = request.getParameter("observaciones");
        
        ActividadExtraescolar act = new ActividadExtraescolar(nombre, lugar, fecha, hora, destinadoA, tipoAct, curso, profesor, observaciones, departamento);
        
        ServletContext contexto = getServletContext();
        List<ActividadExtraescolar> lista = (List<ActividadExtraescolar>) contexto.getAttribute("lista");
        if (lista == null) {
            lista = new ArrayList<>();
        }
        lista.add(act);
        contexto.setAttribute("lista", lista);
        
        if(request.getParameter("listar") != null) {
            response.sendRedirect("listado.jsp");
        } else {
            response.sendRedirect("formulario.jsp");
        }
        
    }

}

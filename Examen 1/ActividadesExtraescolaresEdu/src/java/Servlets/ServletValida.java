
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ActividadExtraescolar;
import modelo.ListaActividades;
import modelo.ListaActividades;


public class ServletValida extends HttpServlet {

  
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
       
        
        
        String nombre = request.getParameter("nombre");
        String fechaStr =(String) request.getParameter("fecha"); //Pasarlo a LocalDate
        String horaStr = (String)request.getParameter("hora");
        String lugar = request.getParameter("lugar");
        String destinatario = request.getParameter("destinatario");
        String[] actividad = request.getParameterValues("actividad");
        String curso = request.getParameter("curso");
        String responsable = request.getParameter("responsable");
        String observaciones = request.getParameter("observaciones");
        String DptoOrganizador = (String) contexto.getAttribute("DptoOrganizador");
        
        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime hora = LocalTime.parse(horaStr);
        
        ActividadExtraescolar a1 = new ActividadExtraescolar(nombre, fecha, hora, lugar, destinatario, actividad, curso, responsable, observaciones, DptoOrganizador);
        ListaActividades.actividades.add(a1);
       
        request.getRequestDispatcher("/actividadExtraescolas.html").forward(request, response);
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

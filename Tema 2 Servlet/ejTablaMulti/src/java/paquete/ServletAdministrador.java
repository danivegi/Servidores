package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAdministrador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ServletContext contexto=getServletContext(); // genero el contexto
            RequestDispatcher rd; //instancio la clse Dispatcher
            
            PrintWriter out = response.getWriter();
        
        try{ 
            String numero=request.getParameter("numero").replace(" ", "");
            String operacion=request.getParameter("operacion");
            int num=Integer.parseInt(numero);
            
            if(num>0 && num<21){
                contexto.setAttribute ("dato", numero);         // crea atributi dato
                contexto.setAttribute ("operacion", operacion); // crea atributi operacion
                rd=contexto.getNamedDispatcher("/rtdo.jsp");
                rd.forward(request, response);
            }else{
                rd=contexto.getRequestDispatcher("/error1.html");
                rd.forward(request, response);
            }         
            }
            catch(Exception e){
                rd=contexto.getRequestDispatcher("/error2.html");
                rd.forward(request, response);
            }
     }
    
}

package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletCuenta extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
       
        PrintWriter out = response.getWriter();
        
        
        
        String dato=(String)getServletContext().getAttribute("dato");
        String cuenta=(String)getServletContext().getAttribute("operacion");
        
        int numero = Integer.parseInt(dato);
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>Tabla de "+cuenta+" del "+numero);
        out.println("<table border=\"1\">");
        if(cuenta.equals("Multiplicar")){
            for(int i=1; i<=numero; i++){
                int resul=numero*i;
                out.println("<tr><td>"+numero+"</td><td>x"+i+"</td><td>"+resul+"</td></tr>");
            }
        }else if(cuenta.equals("Dividir")){
            for(int i=1; i<=numero; i++){
                double num=(double) numero;
                double dividendo=(double) i;
                double resul=num/dividendo;
                
                double datoresult= Math.round(resul*10.0)/10.0;
                out.println("<tr><td>"+numero+"</td><td>/"+i+"</td><td>"+datoresult+"</td></tr>");
            }
        }else{
            out.println("<tr><td>0!=1</td></tr>");
            long resul=1;
            for(int i=1; i<=numero; i++){
                resul*=i;
                //resul = resul*i;
                out.println("<tr><td>"+i+"!="+resul+"</td></tr>");
            }
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        
    }



}

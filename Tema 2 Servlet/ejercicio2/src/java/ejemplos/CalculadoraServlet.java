package ejemplos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculadoraServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    

    double op1 = Double.parseDouble(request.getParameter("op1"));
    double op2 = Double.parseDouble(request.getParameter("op2"));
    String operacion = request.getParameter("operacion").toLowerCase();
    
    double resultado = 0;
    String mensaje = "";
    
    switch(operacion) {
        case "suma":
            resultado = op1 + op2;
            break;
    
        case "resta":
            resultado = op1 - op2;
            break;
    
        case "multiplicacion":
            resultado = op1 * op2;
            break;
    
        case "division":
            resultado = op1 / op2;
            break;
    
    default: 
        mensaje = "Operación no válida. Use suma, resta, multiplicacion, division";
    
}
    
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       out.println("<html><head><title>Resultado</title></head><body>");
       out.println("<h1>Resultado de la operación</h1>");
       if(mensaje.isEmpty()) {
           out.println("<p>" + op1 + " " + operacion + " " + op2 + " = <b>" + resultado + "</b></p>");
       } else {
           out.println("<p>" + mensaje + "</p>");
       }
       
        out.println("<br><br>");
        out.println("<a href='index.html'>Volver al menú</a>");
        out.println("</body></html>");
    
    }

}

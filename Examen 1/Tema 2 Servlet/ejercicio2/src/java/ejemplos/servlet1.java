package ejemplos;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet1 extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Date ahora = new Date();
        PrintWriter out=response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>Primer servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hola, " + nombre + "</h1>");
        out.println("<h1>" + getServletName() + " funcionando</h1>");
        DateFormat dfEspañol = DateFormat.getDateTimeInstance(DateFormat.LONG,
                                                              DateFormat.LONG,
                                                              Locale.getDefault());
        out.println("<h3>Fecha: " + dfEspañol.format(new Date()) + "</h3>");
        out.println("Este es un servlet muy sencillo");
        out.println("</body>");
        out.println("</html>");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Captura de parametros
        String nom = request.getParameter("nombre");
        String tef = request.getParameter("telefono");
        String lugNaci=request.getParameter("lugar de nacimiento");
        
        //Asignacion a la respuesta html que va a generarse, del tipo MINE
        response.setContentType("text/html");
        
        //Obtencion del objeto que escribe la respuesta. Pertenece a java.io
        PrintWriter out = response.getWriter();
        
        //Generacion de la respuesta html
        out.println("<html>");
        out.println("<head><title>Datos introducidos por Formulario</title></head>");
        out.println("<body>");
        out.println("<h1>DATOS INTRODUCIDOS</h1>");
        out.println("<table border=\"5\">");
        out.println("<tr><td><b>NOMBRE:</b></td><td><i>" + nom + "</i></td></tr>");
        out.println("<tr><td><b>TELEFONO:</b></td><td><i>" + tef + "</i></td></tr>");
        out.println("<tr><td><b>LUGAR NACIMIENTO:</b></td><td><i>" + lugNaci + "</i></td></tr>");
        out.println("</table><p>");
        out.println("</body>");
        out.println("</html>");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

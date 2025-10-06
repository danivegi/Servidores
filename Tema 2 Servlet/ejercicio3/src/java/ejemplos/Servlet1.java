package ejemplos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletFormulario1InformacionCliente")
public class Servlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html><head><title>Información Cliente</title></head><body>");
            out.println("<h2>Información capturada del cliente</h2>");

            // Datos solicitados
            out.println("<p><b>Protocolo:</b> " + request.getProtocol() + "</p>");
            out.println("<p><b>Nombre host del cliente:</b> " + request.getRemoteHost() + "</p>");
            out.println("<p><b>Dirección IP del cliente:</b> " + request.getRemoteAddr() + "</p>");
            out.println("<p><b>Tipo de petición:</b> " + request.getMethod() + "</p>");
            out.println("<p><b>Tipo MIME de la petición:</b> " + request.getContentType() + "</p>");

            // Parámetros enviados
            out.println("<p><b>Parámetros recibidos:</b></p><ul>");
            Enumeration<String> parametros = request.getParameterNames();
            while (parametros.hasMoreElements()) {
                String nombreParametro = parametros.nextElement();
                String valorParametro = request.getParameter(nombreParametro);
                out.println("<li>" + nombreParametro + " = " + valorParametro + "</li>");
            }
            out.println("</ul>");

            out.println("<p><b>Ruta URI de la petición:</b> " + request.getRequestURI() + "</p>");

            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}

package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Servlet encargado de procesar el inicio de sesión
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Recoger los parámetros enviados desde el formulario (usuario y contraseña)
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        // Validar las credenciales comparando usuario y contraseña permitidos
        // Si alguno de estos pares coincide, la variable "correcto" será true
        boolean correcto = 
                ("eso".equals(usuario) && "cdpjosecabreraeso".equals(password)) ||
                ("sanidad".equals(usuario) && "cdpjosecabrerasanidad".equals(password)) ||
                ("cocina".equals(usuario) && "cdpjosecabreracocina".equals(password)) ||
                ("informatica".equals(usuario) && "cdpjosecabrerainformatica".equals(password));
        
        // Si las credenciales son correctas
        if (correcto) {
            // Se obtiene (o crea) la sesión del usuario
            HttpSession sesion = request.getSession();
            
            // Se guarda el departamento (usuario) en la sesión
            sesion.setAttribute("departamento", usuario);
            
            // Se redirige al formulario de actividades
            response.sendRedirect("formulario.jsp");
        } else {
            // Si el login falla, redirigir a la página de error
            response.sendRedirect("error.html");
        }
    }

}

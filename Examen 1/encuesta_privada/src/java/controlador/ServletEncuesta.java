package controlador; // Indica el paquete donde se encuentra este servlet, útil para organizar el proyecto

// Importación de las clases necesarias para trabajar con Servlets
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher; // Permite redirigir o reenviar peticiones a otros recursos (JSP, HTML, etc.)
import javax.servlet.ServletContext; // Permite compartir información entre distintos componentes web
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet; // Clase base para crear Servlets HTTP
import javax.servlet.http.HttpServletRequest; // Representa la petición HTTP del cliente
import javax.servlet.http.HttpServletResponse; // Representa la respuesta HTTP del servidor

/**
 * Servlet encargado de procesar los datos enviados desde un formulario de encuesta.
 * Dependiendo del sexo seleccionado, redirige al JSP correspondiente (mujer.jsp o hombre.jsp).
 */
public class ServletEncuesta extends HttpServlet {

    // Método que se ejecuta automáticamente cuando se envía un formulario con el método POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenemos el contexto de la aplicación (sirve para compartir datos entre componentes)
        ServletContext context = getServletContext();
        RequestDispatcher rd; // Objeto que servirá para redirigir la petición a una página

        try {
            // ----- Recogemos los datos del formulario -----

            // Nombre del usuario
            String nombre = request.getParameter("nombre");
            context.setAttribute("nombre_Introducido", nombre); // Se guarda en el contexto para usarlo en el JSP

            // Apellidos del usuario
            String apellidos = request.getParameter("apellidos");
            context.setAttribute("apellidos_Introducido", apellidos);

            // Teléfono del usuario (se convierte de String a int para validar)
            String telefono = request.getParameter("telefono");
            int telefonoNumber = Integer.parseInt(telefono); // Si no es un número, lanzará una excepción
            context.setAttribute("telefono_Introducido", telefono);

            // Ciudad introducida
            String ciudad = request.getParameter("ciudad");
            context.setAttribute("ciudad_Introducido", ciudad);

            // Sexo seleccionado (por ejemplo, "hombre" o "mujer")
            String sexo = request.getParameter("sexo");
            context.setAttribute("sexo_Introducido", sexo);

            // País seleccionado
            String pais = request.getParameter("pais");
            context.setAttribute("pais_Introducido", pais);

            // Actividades de ocio seleccionadas (pueden ser varias)
            String[] actividades = request.getParameterValues("ocio");

            if (actividades != null) {
                // Si el usuario ha marcado alguna opción
                context.setAttribute("actividades_Introducido", actividades);
            } else {
                // Si no se seleccionó ninguna, se indica un mensaje por defecto
                actividades = new String[1];
                actividades[0] = "No hay actividades favoritas";
                context.setAttribute("actividades_Introducido", actividades);
            }

            // Comentarios adicionales
            String comentarios = request.getParameter("comentarios");
            context.setAttribute("comentarios_Introducido", comentarios);

            // ----- Redirección según el sexo -----
            // Si el sexo es "mujer", se redirige a mujer.jsp
            if (sexo.equalsIgnoreCase("mujer")) {
                rd = context.getRequestDispatcher("/mujer.jsp");
            } else {
                // Si no, se asume que es "hombre" y se redirige a hombre.jsp
                rd = context.getRequestDispatcher("/hombre.jsp");
            }

            // Envía la petición y respuesta al JSP correspondiente
            rd.forward(request, response);

        } catch (Exception e) {
            // Si ocurre algún error (por ejemplo, número de teléfono no válido),
            // se redirige a una página de error
            rd = context.getRequestDispatcher("/error.html");
        }
    }
}

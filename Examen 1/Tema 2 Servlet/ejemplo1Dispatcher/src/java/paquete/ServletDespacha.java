package paquete;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDespacha extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtenemos el contexto de la aplicación (permite compartir datos entre servlets)
        ServletContext contexto = getServletContext();
        
        // RequestDispatcher nos permitirá redirigir la petición a otro recurso (jsp o html)
        RequestDispatcher rd;
        
        try {
            // Recoger los parámetros enviados desde el formulario
            String numero = request.getParameter("numero");
            String color = request.getParameter("color");

            // Convertimos el número a entero. Puede lanzar NumberFormatException si no es un número
            int num = Integer.parseInt(numero);

            // Comprobamos si el número está entre 1 y 9 y si el color es válido
            if (num >= 1 && num <= 9 && esValidoColor(color)) {
                
                // Guardamos los datos correctos en el contexto para que rtdo.jsp los use
                contexto.setAttribute("numero_valido", numero);
                contexto.setAttribute("color_valido", color);

                // Redirigimos la petición a rtdo.jsp para mostrar la tabla de multiplicar
                rd = contexto.getRequestDispatcher("/rtdo.jsp");
                rd.forward(request, response);

            } else {
                // Si los datos no son válidos, redirigimos a páginas de error
                if (!esValidoColor(color)) {
                    // Color inválido → página de error de color
                    rd = contexto.getRequestDispatcher("/ErrorColor.html");
                    rd.forward(request, response);
                } else {
                    // Número inválido → página de error de número
                    rd = contexto.getRequestDispatcher("/ErrorNumero.html");
                    rd.forward(request, response);
                }
            }

        } catch (NumberFormatException ex) {
            // Si el número no es válido (letras, vacío, etc.)
            rd = contexto.getRequestDispatcher("/ErrorNumero.html");
            rd.forward(request, response);
        } 
    }

    /**
     * Método auxiliar que comprueba si el color introducido es válido
     * @param colour Color a comprobar
     * @return true si es uno de los colores permitidos, false si no
     */
    private boolean esValidoColor(String colour) {
        String[] colores = {"red", "yellow", "green", "blue", "pink", "black", "orange"};
        boolean encontrado = false;

        // Recorremos el array y comparamos ignorando mayúsculas/minúsculas
        for (int x = 0; x < colores.length && !encontrado; x++) {
            if (colores[x].equalsIgnoreCase(colour)) {
                encontrado = true;
            }
        }
        return encontrado;
    }
}

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Bd;
import modelo.Libro;

public class ServletAltaLibro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String editorial = request.getParameter("editorial");
        String anio = request.getParameter("anio");
        String descripcion = request.getParameter("descripcion");

        String errores = "";
        boolean esValido = true;

        if (!compruebaIsbn(isbn)) {
            errores += " ISBN ";
            esValido = false;
        }

        if (!compruebaTitulo(titulo)) {
            errores += " Titulo ";
            esValido = false;
        }

        if (!compruebaAnio(anio)) {
            errores += " AÑO ";
            esValido = false;
        }

        if (!compruebaDescripcion(descripcion)) {
            errores += " DESCRIPCION ";
            esValido = false;
        }

        if (esValido) {
            Libro l = new Libro(titulo, isbn, autor, editorial, descripcion, anio);
            boolean add = Bd.nuevoLibro(l);

            if (add) {
                rd = contexto.getRequestDispatcher("/listado-libros.jsp");
                rd.forward(request, response);
            } else {
                contexto.setAttribute("errores", errores);
                rd = contexto.getRequestDispatcher("/errores.jsp");
                rd.forward(request, response);
            }
        } else {
            contexto.setAttribute("errores", errores);
                rd = contexto.getRequestDispatcher("/errores.jsp");
                rd.forward(request, response);
        }

    }

    private boolean compruebaIsbn(String isbn) {
        if (isbn.length() == 0) {
            return false;
        }

        isbn = isbn.replace("-", "");
        isbn = isbn.replace("-", "");
        isbn = isbn.replace("-", "");

        if (isbn.length() != 10) {
            return false;
        }

        /*for (int x = 0; x < isbn.length(); x++) {
            char c = isbn.charAt(x);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        String numeros = isbn.substring(0, 12);
        char digControl = isbn.charAt(12);
        boolean impar = true;
        int num = 0;
        int suma = 0;

        for (int x = 0; x < numeros.length(); x++) {
            char c = isbn.charAt(x);
            num = Integer.parseInt(Character.toString(c));
            if (impar) {
                suma += num;
                impar = !impar;
            } else {
                suma += num * 3;
                impar = !impar;
            }
        }

        int resto = suma % 10;
        int dc = 10 - resto;
        if (dc == 10) {
            dc = 0;
        }
        int DC = Integer.parseInt(Character.toString(digControl));
        if (dc != DC) {
            return false;
        }*/
        return true;
    }

    private boolean compruebaTitulo(String titulo) {
        if (titulo.length() <= 0) {
            return false;
        }

        for (int x = 0; x < titulo.length(); x++) {
            char c = titulo.charAt(x);
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean compruebaAnio(String anio) {
        if (anio.length() <= 0) {
            return false;
        }

        for (int x = 0; x < anio.length(); x++) {
            char c = anio.charAt(x);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        int year = Integer.parseInt(anio);
        if (year < 1900 || year > 2025) {
            return false;
        }
        return true;
    }

    private boolean compruebaDescripcion(String descripcion) {
        if (descripcion.length() <= 0) {
            return false;
        }
        return true;
    }

}

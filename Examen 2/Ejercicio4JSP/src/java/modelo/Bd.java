package modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Bd {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3307";
    public static String basedatos = "examen";

    public static Connection CrearConexion() {
        Connection cnn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //invocamos al driver
            String url = "jdbc:mysql://" + servidor + "/" + basedatos;
            cnn = DriverManager.getConnection(url, usuario, password); //nos conectamos a la BD
        } catch (ClassNotFoundException c) {
            System.out.println("Controlador JDBC no encontrado" + c.toString());
        } catch (Exception c) {
            System.out.println("Otrа ехсерción" + c.toString());
        }
        return cnn;
    }

    public static ArrayList<Libro> consultarLibros(String tit) {
        ArrayList<Libro> listaLibros = new ArrayList<>();

        try (Connection cnn = CrearConexion()) {
            String sql = "SELECT T.Titulo AS titulo, T.ISBN AS isbn, A.Nombre AS autor, E.NameEditorial AS editorial, T.Descripcion AS descripcion "
                    + "FROM titulos T, autor A, editorial E "
                    + "WHERE T.IDautor = A.IDAutor "
                    + "AND T.IDeditorial = E.IDEditorial "
                    + "AND T.Titulo LIKE ? ";

            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, "%" + tit + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String isbn = rs.getString("isbn");
                String autor = rs.getString("autor");
                String editorial = rs.getString("editorial");
                String descripcion = rs.getString("descripcion");

                Libro l = new Libro(titulo, isbn, autor, editorial, descripcion);
                listaLibros.add(l);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaLibros;
    }

    public static ArrayList<Autor> consultarAutores() {
        ArrayList<Autor> listaAutores = new ArrayList<>();
        Connection cnn = null;

        try {
            cnn = CrearConexion();
            String sql = "SELECT * FROM autor";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listaAutores.clear();

            while (rs.next()) {
                int idAutor = rs.getInt("IDAutor");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                int anioNacimimento = rs.getInt("anioNacimiento");

                Autor a = new Autor(idAutor, nombre, apellido, anioNacimimento);
                listaAutores.add(a);
            }
            if (cnn != null) {
                cnn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaAutores;
    }

    public static ArrayList<Editorial> consultarEditoriales() {
        ArrayList<Editorial> listaEditoriales = new ArrayList<>();
        Connection cnn = null;

        try {
            cnn = CrearConexion();
            String sql = "SELECT * FROM editorial";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            listaEditoriales.clear();

            while (rs.next()) {
                int idEditorial = rs.getInt("IDEditorial");
                String name = rs.getString("NameEditorial");

                Editorial e = new Editorial(idEditorial, name);
                listaEditoriales.add(e);
            }

            if (cnn != null) {
                cnn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEditoriales;
    }
    
    public static ArrayList<Libro> consultarTodosLibros() {
        ArrayList<Libro> lista = new ArrayList<>();
        Connection cnn = null;

        try {
            cnn = CrearConexion();
            String sql = "SELECT * FROM titulos";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista.clear();

            while (rs.next()) {
                String isbn = rs.getString("ISBN");
                String titulo = rs.getString("Titulo");
                String idAutor = rs.getString("IDautor");
                String anioNacimimento = rs.getString("AnioEdicion");
                String descripcion = rs.getString("Descripcion");
                String idEditorial = rs.getString("IDeditorial");

                Libro l = new Libro(titulo, isbn, idAutor, idEditorial, descripcion, anioNacimimento);
                lista.add(l);
            }
            if (cnn != null) {
                cnn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static boolean nuevoLibro(Libro l) {
        ArrayList<Libro> listaLibros = new ArrayList<>();

        String sql = "INSERT INTO titulos (ISBN, Titulo, IDautor, AnioEdicion, Descripcion, IDeditorial) VALUES (?,?,?,?,?,?);";
        try (Connection cnn = CrearConexion(); PreparedStatement ps = cnn.prepareStatement(sql)) {

            ps.setString(1, l.getIsbn());
            ps.setString(2, l.getTitulo());
            ps.setString(3, l.getAutor());
            ps.setString(4, l.getAnio());
            ps.setString(5, l.getDescripcion());
            ps.setString(6, l.getEditorial());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean modificarLibro(Libro l) {
        String sql = "UPDATE titulos SET Titulo = ?, IDautor = ?, AnioEdicion = ?, Descripcion = ?, IDeditorial = ? WHERE ISBN LIKE ?";
        
         try (Connection cnn = CrearConexion();
                PreparedStatement ps = cnn.prepareStatement(sql)) {
            
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getAnio());
            ps.setString(4, l.getDescripcion());
            ps.setString(5, l.getEditorial());
            ps.setString(6, l.getIsbn());
            
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

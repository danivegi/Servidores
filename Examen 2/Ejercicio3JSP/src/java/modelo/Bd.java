package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

public class Bd {
    
    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3307";
    public static String basedatos = "ventas_comerciales";
    
    public static Connection CrearConexion() {
        Connection cnn = null;
        try{ 
            Class.forName("com.mysql.cj.jdbc.Driver"); //invocamos al driver
            String url = "jdbc:mysql://" + servidor + "/" + basedatos;
            cnn = DriverManager.getConnection(url,usuario,password); //nos conectamos a la BD
        } catch (ClassNotFoundException c) {
            System.out.println("Controlador JDBC no encontrado" + c.toString());
        } catch (Exception c) {
            System.out.println("Otrа ехсерción" + c.toString());
        }
        return cnn;
    }
    
    public static ArrayList<Producto> consultarProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Connection cnn = null;
        try {
            cnn = CrearConexion();
            String sentenciaSQL = "SELECT * FROM productos";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sentenciaSQL);
            listaProductos.clear();
            while (rs.next()) {
                String ref = rs.getString("referencia");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int descuento = rs.getInt("descuento");
                Producto nuevoProducto = new Producto(ref, nombre, descripcion, precio, descuento);
                listaProductos.add(nuevoProducto);
            }
            //Cerramos la cnexion
            if (cnn != null) {
                cnn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
    
    
    public static ArrayList<Venta> consultarVentas (String referencia) {
        ArrayList<Venta> listaVentas = new ArrayList<>();
        Connection cnn = null;
        try {
            cnn = CrearConexion();
            Statement st = cnn.createStatement();
            String senteciaSQL = "SELECT ventas.fecha, comerciales.nombre as comercial, productos.nombre as producto, ventas.cantidad, productos.precio, (ventas.cantidad * productos.precio) as total, productos.descuento, (ventas.cantidad * productos.precio * (productos.descuento * 0.01)) as totalDescuento";
            ResultSet rs = st.executeQuery(senteciaSQL);
            while (rs.next()) {
                String comercial = rs.getString("comercial");
                String producto = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");
                double total = rs.getDouble("total");
                int descuento = rs.getInt("descuento");
                double totalDescuento = rs.getDouble("totalDescuento");
                Date fecha = rs.getDate("fecha");
                Venta nuevaVenta = new Venta(comercial, producto, cantidad, precio, total, descuento, totalDescuento, fecha);
                listaVentas.add(nuevaVenta);
            }
            if (cnn != null) {
                cnn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVentas;
    }
    
}

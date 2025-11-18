package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String bd = "empresa_db";
    private static String parametros = "?useSSL=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "trebujena";
    private static String url = "jdbc:mysql://localhost:3306/" + bd + parametros;

    private DBConnection() {

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}

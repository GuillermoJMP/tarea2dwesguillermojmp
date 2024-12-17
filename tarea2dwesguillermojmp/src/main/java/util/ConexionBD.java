package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static Connection conexion;
    private static final String URL = "jdbc:mysql://localhost:3306/tarea2dwesguillermojmp";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    // Constructor privado para Singleton
    private ConexionBD() {}

    // Obtener la conexión
    public static Connection obtenerConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println("Conexión exitosa a la base de datos.");
            } catch (ClassNotFoundException e) {
                System.err.println("Error: No se encontró el driver JDBC.");
                e.printStackTrace();
            }
        }
        return conexion;
    }

    // Cerrar la conexión manualmente
    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}

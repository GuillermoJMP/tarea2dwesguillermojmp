package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/tarea2dwesguillermojmp";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection conexion;

    public static Connection obtenerConexion() throws Exception {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida.");
            limpiarBaseDeDatos(); // Llama al método para truncar las tablas
        }
        return conexion;
    }

    private static void limpiarBaseDeDatos() {
        String[] tablas = {"Mensaje", "Credenciales", "Ejemplar", "Persona", "Planta"};
        try (Statement stmt = conexion.createStatement()) {
            stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 0"); // Deshabilitar claves foráneas temporalmente
            for (String tabla : tablas) {
                stmt.executeUpdate("TRUNCATE TABLE " + tabla); // Vaciar cada tabla
            }
            stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 1"); // Habilitar claves foráneas
            System.out.println("Base de datos limpia.");
        } catch (Exception e) {
            System.out.println("Error al limpiar la base de datos: " + e.getMessage());
        }
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConexionBD {

    private static Connection connexion;
    private static MysqlDataSource mysqlDataSource;

    // Método para cargar las propiedades y configurar el DataSource
    private static void configurarDataSource() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/resources/db.properties")) {
            properties.load(fis);
            mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setUrl(properties.getProperty("url"));
            mysqlDataSource.setUser(properties.getProperty("user"));
            mysqlDataSource.setPassword(properties.getProperty("password"));
        } catch (IOException e) {
            throw new IOException("Error cargando el archivo de propiedades: " + e.getMessage(), e);
        }
    }

    // Método para obtener la conexión
    public static Connection obtenerConexion() throws Exception {
        if (connexion == null || connexion.isClosed()) {
            if (mysqlDataSource == null) {
                configurarDataSource(); // Configura el DataSource si no está inicializado
            }
            connexion = mysqlDataSource.getConnection();
            System.out.println("Conexión establecida.");
        }
        return connexion;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion() {
        try {
            if (connexion != null && !connexion.isClosed()) {
                connexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (Exception e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

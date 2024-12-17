package principal;

import util.ConexionBD;
import vista.MenuPrincipal;

import java.sql.Connection;

public class AplicacionVivero {
    public static void main(String[] args) {
        try {
            // Conectar a la base de datos
            Connection conexion = ConexionBD.obtenerConexion();

            // Mostrar el menú principal
            MenuPrincipal.mostrarMenu();

            // Cerrar la conexión
            ConexionBD.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error en la aplicación: " + e.getMessage());
        } finally {
            System.out.println("Aplicación finalizada.");
        }
    }
}

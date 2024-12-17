package principal;

import util.ConexionBD;
import java.sql.Connection;

public class PruebaConexion {
    public static void main(String[] args) throws Exception {
        // Obtener y probar la conexión
        Connection conexion = ConexionBD.obtenerConexion();

        // Cerrar la conexión
        ConexionBD.cerrarConexion();
    }
}

package daoimpl;

import dao.CredencialesDAO;
import modelo.Credenciales;
import util.ConexionBD;

import java.sql.*;

public class CredencialesDAOImpl implements CredencialesDAO {

    private static final String INSERTAR = "INSERT INTO Credenciales (id, usuario, password) VALUES (?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE Credenciales SET usuario = ?, password = ? WHERE id = ?";
    private static final String ELIMINAR = "DELETE FROM Credenciales WHERE id = ?";
    private static final String OBTENER_POR_USUARIO = "SELECT * FROM Credenciales WHERE usuario = ?";
    private static final String VALIDAR_CREDENCIALES = "SELECT * FROM Credenciales WHERE usuario = ? AND password = ?";

    @Override
    public void insertar(Credenciales credenciales) throws Exception {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(INSERTAR)) {
            ps.setLong(1, credenciales.getId());
            ps.setString(2, credenciales.getUsuario());
            ps.setString(3, credenciales.getPassword());
            ps.executeUpdate();
            System.out.println("Credenciales insertadas correctamente.");
        }
    }

    @Override
    public void actualizar(Credenciales credenciales) throws Exception {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(ACTUALIZAR)) {
            ps.setString(1, credenciales.getUsuario());
            ps.setString(2, credenciales.getPassword());
            ps.setLong(3, credenciales.getId());
            ps.executeUpdate();
            System.out.println("Credenciales actualizadas correctamente.");
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(ELIMINAR)) {
            ps.setLong(1, id);
            ps.executeUpdate();
            System.out.println("Credenciales eliminadas correctamente.");
        }
    }

    @Override
    public Credenciales obtenerPorUsuario(String usuario) throws Exception {
        Credenciales credenciales = null;
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(OBTENER_POR_USUARIO)) {
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                credenciales = new Credenciales(
                    rs.getLong("id"),
                    rs.getString("usuario"),
                    rs.getString("password")
                );
            }
        }
        return credenciales;
    }

    @Override
    public boolean validarCredenciales(String usuario, String password) throws Exception {
        boolean valido = false;
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(VALIDAR_CREDENCIALES)) {
            ps.setString(1, usuario);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            valido = rs.next();
        }
        return valido;
    }
}

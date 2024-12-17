package daoimpl;

import dao.EjemplarDAO;
import modelo.Ejemplar;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EjemplarDAOImpl implements EjemplarDAO {

    private static final String INSERTAR = "INSERT INTO Ejemplar (nombre, codigo_planta) VALUES (?, ?)";
    private static final String ACTUALIZAR = "UPDATE Ejemplar SET nombre = ?, codigo_planta = ? WHERE id = ?";
    private static final String ELIMINAR = "DELETE FROM Ejemplar WHERE id = ?";
    private static final String OBTENER_POR_ID = "SELECT * FROM Ejemplar WHERE id = ?";
    private static final String OBTENER_POR_CODIGO_PLANTA = "SELECT * FROM Ejemplar WHERE codigo_planta = ?";

    @Override
    public void insertar(Ejemplar ejemplar) throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(INSERTAR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ejemplar.getNombre());
            ps.setString(2, ejemplar.getCodigoPlanta());
            ps.executeUpdate();
            System.out.println("Ejemplar insertado correctamente.");

            // Recuperar la clave generada automáticamente
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ejemplar.setId(rs.getLong(1));
            }
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public void actualizar(Ejemplar ejemplar) throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(ACTUALIZAR);
            ps.setString(1, ejemplar.getNombre());
            ps.setString(2, ejemplar.getCodigoPlanta());
            ps.setLong(3, ejemplar.getId());
            ps.executeUpdate();
            System.out.println("Ejemplar actualizado correctamente.");
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(ELIMINAR);
            ps.setLong(1, id);
            ps.executeUpdate();
            System.out.println("Ejemplar eliminado correctamente.");
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public Ejemplar obtenerPorId(Long id) throws Exception {
        Ejemplar ejemplar = null;
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(OBTENER_POR_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ejemplar = new Ejemplar(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getString("codigo_planta")
                );
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return ejemplar;
    }

    @Override
    public List<Ejemplar> obtenerPorCodigoPlanta(String codigoPlanta) throws Exception {
        List<Ejemplar> ejemplares = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(OBTENER_POR_CODIGO_PLANTA);
            ps.setString(1, codigoPlanta);
            rs = ps.executeQuery();
            while (rs.next()) {
                ejemplares.add(new Ejemplar(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getString("codigo_planta")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return ejemplares;
    }
}

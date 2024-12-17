package daoimpl;

import dao.PersonaDAO;
import modelo.Persona;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOImpl implements PersonaDAO {

    private static final String INSERTAR = "INSERT INTO Persona (nombre, email) VALUES (?, ?)";
    private static final String ACTUALIZAR = "UPDATE Persona SET nombre = ?, email = ? WHERE id = ?";
    private static final String ELIMINAR = "DELETE FROM Persona WHERE id = ?";
    private static final String OBTENER_POR_ID = "SELECT * FROM Persona WHERE id = ?";
    private static final String OBTENER_TODAS = "SELECT * FROM Persona";

    @Override
    public void insertar(Persona persona) throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(INSERTAR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getEmail());
            ps.executeUpdate();
            System.out.println("Persona insertada correctamente.");

            // Recuperar la clave generada automáticamente
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                persona.setId(rs.getLong(1));
            }
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public void actualizar(Persona persona) throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(ACTUALIZAR);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getEmail());
            ps.setLong(3, persona.getId());
            ps.executeUpdate();
            System.out.println("Persona actualizada correctamente.");
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
            System.out.println("Persona eliminada correctamente.");
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public Persona obtenerPorId(Long id) throws Exception {
        Persona persona = null;
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(OBTENER_POR_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                persona = new Persona(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getString("email")
                );
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return persona;
    }

    @Override
    public List<Persona> obtenerTodas() throws Exception {
        List<Persona> personas = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(OBTENER_TODAS);
            rs = ps.executeQuery();
            while (rs.next()) {
                personas.add(new Persona(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getString("email")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return personas;
    }
}

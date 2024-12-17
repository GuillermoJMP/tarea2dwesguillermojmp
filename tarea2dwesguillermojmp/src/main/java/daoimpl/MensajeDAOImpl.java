package daoimpl;

import dao.MensajeDAO;
import modelo.Mensaje;
import util.ConexionBD;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MensajeDAOImpl implements MensajeDAO {

    private static final String INSERTAR = "INSERT INTO Mensaje (fechahora, mensaje, id_ejemplar, id_persona) VALUES (?, ?, ?, ?)";
    private static final String OBTENER_POR_EJEMPLAR = "SELECT * FROM Mensaje WHERE id_ejemplar = ?";
    private static final String OBTENER_POR_PERSONA = "SELECT * FROM Mensaje WHERE id_persona = ?";
    private static final String OBTENER_POR_FECHAS = "SELECT * FROM Mensaje WHERE fechahora BETWEEN ? AND ?";

    @Override
    public void insertar(Mensaje mensaje) throws Exception {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(INSERTAR)) {
            ps.setTimestamp(1, Timestamp.valueOf(mensaje.getFechaHora()));
            ps.setString(2, mensaje.getMensaje());
            ps.setLong(3, mensaje.getIdEjemplar());
            ps.setLong(4, mensaje.getIdPersona());
            ps.executeUpdate();
            System.out.println("Mensaje insertado correctamente.");
        }
    }

    @Override
    public List<Mensaje> obtenerPorEjemplar(Long idEjemplar) throws Exception {
        List<Mensaje> mensajes = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(OBTENER_POR_EJEMPLAR)) {
            ps.setLong(1, idEjemplar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mensajes.add(new Mensaje(
                    rs.getLong("id"),
                    rs.getTimestamp("fechahora").toLocalDateTime(),
                    rs.getString("mensaje"),
                    rs.getLong("id_ejemplar"),
                    rs.getLong("id_persona")
                ));
            }
        }
        return mensajes;
    }

    @Override
    public List<Mensaje> obtenerPorPersona(Long idPersona) throws Exception {
        List<Mensaje> mensajes = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(OBTENER_POR_PERSONA)) {
            ps.setLong(1, idPersona);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mensajes.add(new Mensaje(
                    rs.getLong("id"),
                    rs.getTimestamp("fechahora").toLocalDateTime(),
                    rs.getString("mensaje"),
                    rs.getLong("id_ejemplar"),
                    rs.getLong("id_persona")
                ));
            }
        }
        return mensajes;
    }

    @Override
    public List<Mensaje> obtenerPorRangoFechas(String fechaInicio, String fechaFin) throws Exception {
        List<Mensaje> mensajes = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(OBTENER_POR_FECHAS)) {
            ps.setString(1, fechaInicio);
            ps.setString(2, fechaFin);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mensajes.add(new Mensaje(
                    rs.getLong("id"),
                    rs.getTimestamp("fechahora").toLocalDateTime(),
                    rs.getString("mensaje"),
                    rs.getLong("id_ejemplar"),
                    rs.getLong("id_persona")
                ));
            }
        }
        return mensajes;
    }
}

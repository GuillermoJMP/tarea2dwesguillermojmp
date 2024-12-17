package daoimpl;

import dao.PlantaDAO;
import modelo.Planta;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlantaDAOImpl implements PlantaDAO {

    private static final String INSERTAR = "INSERT INTO Planta (codigo, nombrecomun, nombrecientifico) VALUES (?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE Planta SET nombrecomun = ?, nombrecientifico = ? WHERE codigo = ?";
    private static final String ELIMINAR = "DELETE FROM Planta WHERE codigo = ?";
    private static final String OBTENER_POR_CODIGO = "SELECT * FROM Planta WHERE codigo = ?";
    private static final String OBTENER_TODAS = "SELECT * FROM Planta";

    @Override
    public void insertar(Planta planta) throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(INSERTAR);
            ps.setString(1, planta.getCodigo());
            ps.setString(2, planta.getNombreComun());
            ps.setString(3, planta.getNombreCientifico());
            ps.executeUpdate();
            System.out.println("Planta insertada correctamente.");
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public void actualizar(Planta planta) throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(ACTUALIZAR);
            ps.setString(1, planta.getNombreComun());
            ps.setString(2, planta.getNombreCientifico());
            ps.setString(3, planta.getCodigo());
            ps.executeUpdate();
            System.out.println("Planta actualizada correctamente.");
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(ELIMINAR);
            ps.setString(1, codigo);
            ps.executeUpdate();
            System.out.println("Planta eliminada correctamente.");
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public Planta obtenerPorCodigo(String codigo) throws Exception {
        Planta planta = null;
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(OBTENER_POR_CODIGO);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                planta = new Planta(
                    rs.getString("codigo"),
                    rs.getString("nombrecomun"),
                    rs.getString("nombrecientifico")
                );
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return planta;
    }

    @Override
    public List<Planta> obtenerTodas() throws Exception {
        List<Planta> plantas = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = ConexionBD.obtenerConexion();
            ps = conexion.prepareStatement(OBTENER_TODAS);
            rs = ps.executeQuery();
            while (rs.next()) {
                plantas.add(new Planta(
                    rs.getString("codigo"),
                    rs.getString("nombrecomun"),
                    rs.getString("nombrecientifico")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return plantas;
    }
}

package dao;

import modelo.Ejemplar;
import java.util.List;

public interface EjemplarDAO {
    void insertar(Ejemplar ejemplar) throws Exception;
    void actualizar(Ejemplar ejemplar) throws Exception;
    void eliminar(Long id) throws Exception;
    Ejemplar obtenerPorId(Long id) throws Exception;
    List<Ejemplar> obtenerPorCodigoPlanta(String codigoPlanta) throws Exception;
}

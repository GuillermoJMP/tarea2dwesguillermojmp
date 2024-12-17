package servicios;

import modelo.Ejemplar;
import java.util.List;

public interface GestionEjemplaresService {
    void insertarEjemplar(Ejemplar ejemplar) throws Exception;
    void actualizarEjemplar(Ejemplar ejemplar) throws Exception;
    void eliminarEjemplar(Long id) throws Exception;
    Ejemplar obtenerEjemplarPorId(Long id) throws Exception;
    List<Ejemplar> obtenerEjemplaresPorPlanta(String codigoPlanta) throws Exception;
}

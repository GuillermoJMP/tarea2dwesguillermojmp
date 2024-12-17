package dao;

import modelo.Mensaje;
import java.util.List;

public interface MensajeDAO {
    void insertar(Mensaje mensaje) throws Exception;
    List<Mensaje> obtenerPorEjemplar(Long idEjemplar) throws Exception;
    List<Mensaje> obtenerPorPersona(Long idPersona) throws Exception;
    List<Mensaje> obtenerPorRangoFechas(String fechaInicio, String fechaFin) throws Exception;
}

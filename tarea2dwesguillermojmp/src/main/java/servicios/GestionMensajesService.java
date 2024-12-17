package servicios;

import modelo.Mensaje;
import java.util.List;

public interface GestionMensajesService {
    void insertarMensaje(Mensaje mensaje) throws Exception;
    List<Mensaje> obtenerMensajesPorEjemplar(Long idEjemplar) throws Exception;
    List<Mensaje> obtenerMensajesPorPersona(Long idPersona) throws Exception;
    List<Mensaje> obtenerMensajesPorFechas(String fechaInicio, String fechaFin) throws Exception;
}

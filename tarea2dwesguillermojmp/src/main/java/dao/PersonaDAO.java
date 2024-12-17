package dao;

import modelo.Persona;
import java.util.List;

public interface PersonaDAO {
    void insertar(Persona persona) throws Exception;
    void actualizar(Persona persona) throws Exception;
    void eliminar(Long id) throws Exception;
    Persona obtenerPorId(Long id) throws Exception;
    List<Persona> obtenerTodas() throws Exception;
}

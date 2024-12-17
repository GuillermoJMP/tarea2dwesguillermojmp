package servicios;

import modelo.Persona;
import modelo.Credenciales;
import java.util.List;

public interface GestionPersonasService {
    void registrarPersona(Persona persona, Credenciales credenciales) throws Exception;
    void actualizarPersona(Persona persona) throws Exception;
    void eliminarPersona(Long id) throws Exception;
    Persona obtenerPersonaPorId(Long id) throws Exception;
    List<Persona> obtenerTodasLasPersonas() throws Exception;
    boolean validarCredenciales(String usuario, String password) throws Exception;
}

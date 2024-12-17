package servicioimpl;

import dao.PersonaDAO;
import dao.CredencialesDAO;
import daoimpl.PersonaDAOImpl;
import daoimpl.CredencialesDAOImpl;
import modelo.Persona;
import modelo.Credenciales;
import servicios.GestionPersonasService;

import java.util.List;

public class GestionPersonasServiceImpl implements GestionPersonasService {
    private final PersonaDAO personaDAO = new PersonaDAOImpl();
    private final CredencialesDAO credencialesDAO = new CredencialesDAOImpl();

    @Override
    public void registrarPersona(Persona persona, Credenciales credenciales) throws Exception {
        personaDAO.insertar(persona);
        credenciales.setId(persona.getId());
        credencialesDAO.insertar(credenciales);
        System.out.println("Persona y credenciales registradas correctamente.");
    }

    @Override
    public void actualizarPersona(Persona persona) throws Exception {
        personaDAO.actualizar(persona);
        System.out.println("Persona actualizada correctamente.");
    }

    @Override
    public void eliminarPersona(Long id) throws Exception {
        credencialesDAO.eliminar(id);
        personaDAO.eliminar(id);
        System.out.println("Persona eliminada correctamente.");
    }

    @Override
    public Persona obtenerPersonaPorId(Long id) throws Exception {
        return personaDAO.obtenerPorId(id);
    }

    @Override
    public List<Persona> obtenerTodasLasPersonas() throws Exception {
        return personaDAO.obtenerTodas();
    }

    @Override
    public boolean validarCredenciales(String usuario, String password) throws Exception {
        return credencialesDAO.validarCredenciales(usuario, password);
    }
}

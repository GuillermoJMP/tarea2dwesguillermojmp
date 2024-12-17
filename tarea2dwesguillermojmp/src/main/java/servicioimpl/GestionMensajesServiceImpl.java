package servicioimpl;

import dao.MensajeDAO;
import daoimpl.MensajeDAOImpl;
import modelo.Mensaje;
import servicios.GestionMensajesService;

import java.util.List;

public class GestionMensajesServiceImpl implements GestionMensajesService {
    private final MensajeDAO mensajeDAO = new MensajeDAOImpl();

    @Override
    public void insertarMensaje(Mensaje mensaje) throws Exception {
        mensajeDAO.insertar(mensaje);
    }

    @Override
    public List<Mensaje> obtenerMensajesPorEjemplar(Long idEjemplar) throws Exception {
        return mensajeDAO.obtenerPorEjemplar(idEjemplar);
    }

    @Override
    public List<Mensaje> obtenerMensajesPorPersona(Long idPersona) throws Exception {
        return mensajeDAO.obtenerPorPersona(idPersona);
    }

    @Override
    public List<Mensaje> obtenerMensajesPorFechas(String fechaInicio, String fechaFin) throws Exception {
        return mensajeDAO.obtenerPorRangoFechas(fechaInicio, fechaFin);
    }
}

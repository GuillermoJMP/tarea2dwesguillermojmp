package servicioimpl;

import dao.EjemplarDAO;
import daoimpl.EjemplarDAOImpl;
import modelo.Ejemplar;
import servicios.GestionEjemplaresService;

import java.util.List;

public class GestionEjemplaresServiceImpl implements GestionEjemplaresService {
    private final EjemplarDAO ejemplarDAO = new EjemplarDAOImpl();

    @Override
    public void insertarEjemplar(Ejemplar ejemplar) throws Exception {
        ejemplarDAO.insertar(ejemplar);
    }

    @Override
    public void actualizarEjemplar(Ejemplar ejemplar) throws Exception {
        ejemplarDAO.actualizar(ejemplar);
    }

    @Override
    public void eliminarEjemplar(Long id) throws Exception {
        ejemplarDAO.eliminar(id);
    }

    @Override
    public Ejemplar obtenerEjemplarPorId(Long id) throws Exception {
        return ejemplarDAO.obtenerPorId(id);
    }

    @Override
    public List<Ejemplar> obtenerEjemplaresPorPlanta(String codigoPlanta) throws Exception {
        return ejemplarDAO.obtenerPorCodigoPlanta(codigoPlanta);
    }
}

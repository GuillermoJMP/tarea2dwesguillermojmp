package servicioimpl;

import dao.PlantaDAO;
import daoimpl.PlantaDAOImpl;
import modelo.Planta;
import servicios.GestionPlantasService;

import java.util.List;

public class GestionPlantasServiceImpl implements GestionPlantasService {
    private final PlantaDAO plantaDAO = new PlantaDAOImpl();

    @Override
    public void insertarPlanta(Planta planta) throws Exception {
        plantaDAO.insertar(planta);
    }

    @Override
    public void actualizarPlanta(Planta planta) throws Exception {
        plantaDAO.actualizar(planta);
    }

    @Override
    public void eliminarPlanta(String codigo) throws Exception {
        plantaDAO.eliminar(codigo);
    }

    @Override
    public Planta obtenerPlantaPorCodigo(String codigo) throws Exception {
        return plantaDAO.obtenerPorCodigo(codigo);
    }

    @Override
    public List<Planta> obtenerTodasLasPlantas() throws Exception {
        return plantaDAO.obtenerTodas();
    }
}

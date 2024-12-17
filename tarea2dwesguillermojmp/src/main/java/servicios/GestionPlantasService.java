package servicios;

import modelo.Planta;
import java.util.List;

public interface GestionPlantasService {
    void insertarPlanta(Planta planta) throws Exception;
    void actualizarPlanta(Planta planta) throws Exception;
    void eliminarPlanta(String codigo) throws Exception;
    Planta obtenerPlantaPorCodigo(String codigo) throws Exception;
    List<Planta> obtenerTodasLasPlantas() throws Exception;
}

package dao;

import modelo.Planta;
import java.util.List;

public interface PlantaDAO {
    void insertar(Planta planta) throws Exception;
    void actualizar(Planta planta) throws Exception;
    void eliminar(String codigo) throws Exception;
    Planta obtenerPorCodigo(String codigo) throws Exception;
    List<Planta> obtenerTodas() throws Exception;
}

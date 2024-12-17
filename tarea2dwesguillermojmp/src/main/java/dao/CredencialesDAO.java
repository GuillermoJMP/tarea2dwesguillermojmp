package dao;

import modelo.Credenciales;

public interface CredencialesDAO {
    void insertar(Credenciales credenciales) throws Exception;
    void actualizar(Credenciales credenciales) throws Exception;
    void eliminar(Long id) throws Exception;
    Credenciales obtenerPorUsuario(String usuario) throws Exception;
    boolean validarCredenciales(String usuario, String password) throws Exception;
}

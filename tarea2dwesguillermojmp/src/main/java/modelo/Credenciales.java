package modelo;

public class Credenciales {
    private Long id;
    private String usuario;
    private String password;

    // Constructor vacío
    public Credenciales() {}

    // Constructor con parámetros
    public Credenciales(Long id, String usuario, String password) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

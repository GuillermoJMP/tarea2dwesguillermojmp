package modelo;

public class Ejemplar {
    private Long id;
    private String nombre;
    private String codigoPlanta;

    // Constructor vacío
    public Ejemplar() {}

    // Constructor con parámetros
    public Ejemplar(Long id, String nombre, String codigoPlanta) {
        this.id = id;
        this.nombre = nombre;
        this.codigoPlanta = codigoPlanta;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPlanta() {
        return codigoPlanta;
    }

    public void setCodigoPlanta(String codigoPlanta) {
        this.codigoPlanta = codigoPlanta;
    }
}

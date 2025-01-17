package modelo;

public class Planta {
    private String codigo;
    private String nombreComun;
    private String nombreCientifico;

    // Constructor vacío
    public Planta() {}

    // Constructor con parámetros
    public Planta(String codigo, String nombreComun, String nombreCientifico) {
        this.codigo = codigo;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }
}

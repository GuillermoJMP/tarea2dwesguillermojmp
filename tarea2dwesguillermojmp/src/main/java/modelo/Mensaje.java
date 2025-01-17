package modelo;

import java.time.LocalDateTime;

public class Mensaje {
    private Long id;
    private LocalDateTime fechaHora;
    private String mensaje;
    private Long idEjemplar;
    private Long idPersona;

    // Constructor vacío
    public Mensaje() {}

    // Constructor con parámetros
    public Mensaje(Long id, LocalDateTime fechaHora, String mensaje, Long idEjemplar, Long idPersona) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.idEjemplar = idEjemplar;
        this.idPersona = idPersona;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Long idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }
}

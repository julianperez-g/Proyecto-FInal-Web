package co.edu.javeriana.ejemplojpa.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class BarcoDTO {
    private Integer idBarco;

    @NotNull
    @Min(0)
    private Integer velX;

    @NotNull
    @Min(0)
    private Integer velY;

    @NotNull
    @Min(0)
    private Integer posX;

    @NotNull
    @Min(0)
    private Integer posY;

    @NotNull
    private Integer jugadorId;

    @NotNull
    private Integer modeloId;

    // Campos extra para mostrar en las vistas
    private String jugadorNombre;
    private String modeloNombre;

    // --------------------
    // Getters y Setters
    // --------------------
    public Integer getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(Integer idBarco) {
        this.idBarco = idBarco;
    }

    public Integer getVelX() {
        return velX;
    }

    public void setVelX(Integer velX) {
        this.velX = velX;
    }

    public Integer getVelY() {
        return velY;
    }

    public void setVelY(Integer velY) {
        this.velY = velY;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public Integer getJugadorId() {
        return jugadorId;
    }

    public void setJugadorId(Integer jugadorId) {
        this.jugadorId = jugadorId;
    }

    public Integer getModeloId() {
        return modeloId;
    }

    public void setModeloId(Integer modeloId) {
        this.modeloId = modeloId;
    }

    public String getJugadorNombre() {
        return jugadorNombre;
    }

    public void setJugadorNombre(String jugadorNombre) {
        this.jugadorNombre = jugadorNombre;
    }

    public String getModeloNombre() {
        return modeloNombre;
    }

    public void setModeloNombre(String modeloNombre) {
        this.modeloNombre = modeloNombre;
    }
}

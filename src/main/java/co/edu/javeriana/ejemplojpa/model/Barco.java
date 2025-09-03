package co.edu.javeriana.ejemplojpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;

@Entity
public class Barco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBarco;

    private int velX;
    private int velY;
    private int posX;
    private int posY;

    // Si tu tabla BARCO tiene la FK como ID_JUGADOR, fija el nombre exacto:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_JUGADOR", nullable = false)
    private Jugador jugador;

    // Y para el modelo:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MODELO", nullable = false)
    private ModeloBarco modelo;

    // Getters
    public Integer getIdBarco() { return idBarco; }
    public int getVelX() { return velX; }
    public int getVelY() { return velY; }
    public int getPosX() { return posX; }
    public int getPosY() { return posY; }
    public Jugador getJugador() { return jugador; }
    public ModeloBarco getModelo() { return modelo; }

    // Setters
    public void setIdBarco(Integer idBarco) { this.idBarco = idBarco; }
    public void setVelX(int velX) { this.velX = velX; }
    public void setVelY(int velY) { this.velY = velY; }
    public void setPosX(int posX) { this.posX = posX; }
    public void setPosY(int posY) { this.posY = posY; }
    public void setJugador(Jugador jugador) { this.jugador = jugador; }
    public void setModelo(ModeloBarco modelo) { this.modelo = modelo; }
}

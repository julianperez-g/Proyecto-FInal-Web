package co.edu.javeriana.ejemplojpa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;




@Entity
public class Barco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBarco;

    private int velX;
    private int velY;
    private int posX;
    private int posY;

    @ManyToOne
    @JoinColumn(name = "idJugador")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "idModelo")
    private ModeloBarco modelo;

    // Getters
    public Integer getIdBarco() {
        return idBarco;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public ModeloBarco getModelo() {
        return modelo;
    }

    // Setters
    public void setIdBarco(Integer idBarco) {
        this.idBarco = idBarco;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setModelo(ModeloBarco modelo) {
        this.modelo = modelo;
    }
}


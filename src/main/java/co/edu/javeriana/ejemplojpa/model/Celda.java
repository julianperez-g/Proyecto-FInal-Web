package co.edu.javeriana.ejemplojpa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;



@Entity
public class Celda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCeldas;

    private int coordX;
    private int coordY;
    private String tipoCelda; // agua, pared, partida, meta

    @ManyToOne
    @JoinColumn(name = "idMapa")
    private Mapa mapa;

    // Getters
    public Integer getIdCeldas() {
        return idCeldas;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public String getTipoCelda() {
        return tipoCelda;
    }

    public Mapa getMapa() {
        return mapa;
    }

    // Setters
    public void setIdCeldas(Integer idCeldas) {
        this.idCeldas = idCeldas;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void setTipoCelda(String tipoCelda) {
        this.tipoCelda = tipoCelda;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
}

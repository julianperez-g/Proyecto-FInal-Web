package co.edu.javeriana.ejemplojpa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class Mapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMapa;

    private String nombre;
    private int filas;
    private int columnas;

    // Getters
    public Integer getIdMapa() {
        return idMapa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    // Setters
    public void setIdMapa(Integer idMapa) {
        this.idMapa = idMapa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
}

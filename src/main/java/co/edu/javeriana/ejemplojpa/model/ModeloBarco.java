package co.edu.javeriana.ejemplojpa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class ModeloBarco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModelo;

    private String nombre;
    private String color;

    
    public Integer getIdModelo() {
        return idModelo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }


    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
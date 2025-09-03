package co.edu.javeriana.ejemplojpa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class Jugador {

    



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJugador;

    private String nombre;
    private String usuario;
    private String contrasena;
    private String rol;

    @OneToMany(mappedBy = "jugador",
           cascade = CascadeType.REMOVE,  
           orphanRemoval = true)
private List<Barco> barcos = new ArrayList<>();

     
    public Integer getIdJugador() {
        return idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    
    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

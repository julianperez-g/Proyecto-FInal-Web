package co.edu.javeriana.ejemplojpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Objects;


public class JugadorDTO {

    private Integer idJugador;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no debe superar 100 caracteres")
    private String nombre;

    @NotBlank(message = "El usuario no puede estar vacío")
    @Size(max = 50, message = "El usuario no debe superar 50 caracteres")
    private String usuario;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(max = 60, message = "La contraseña no debe superar 60 caracteres")
    private String contrasena;

    @NotBlank(message = "El rol no puede estar vacío")
    @Size(max = 20, message = "El rol no debe superar 20 caracteres")
    private String rol;

    // =====================
    // Constructores
    // =====================
    public JugadorDTO() {
    }

    public JugadorDTO(Integer idJugador, String nombre, String usuario, String contrasena, String rol) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // =====================
    // Getters & Setters
    // =====================
    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // =====================
    // Métodos utilitarios
    // =====================
    @Override
    public String toString() {
        return "JugadorDTO{" +
                "idJugador=" + idJugador +
                ", nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JugadorDTO)) return false;
        JugadorDTO that = (JugadorDTO) o;
        return Objects.equals(idJugador, that.idJugador) &&
               Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJugador, usuario);
    }
}

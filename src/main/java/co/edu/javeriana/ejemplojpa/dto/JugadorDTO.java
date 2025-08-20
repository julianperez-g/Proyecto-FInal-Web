package co.edu.javeriana.ejemplojpa.dto;


public class JugadorDTO {

    private Integer idJugador;
    private String nombre;
    private String usuario;
    private String contrasena;
    private String rol;

   
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


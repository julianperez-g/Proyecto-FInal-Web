package co.edu.javeriana.ejemplojpa.dto;

public class BarcoDTO {
    private Integer idBarco;
    private Integer velX;
    private Integer velY;
    private Integer posX;
    private Integer posY;
    private Integer jugadorId;   
    private Integer modeloId;    

    public Integer getIdBarco() {
         return idBarco; }
    public void setIdBarco(Integer idBarco) { 
        this.idBarco = idBarco; }
    public Integer getVelX() { 
        return velX; }
    public void setVelX(Integer velX) { 
        this.velX = velX; }
    public Integer getVelY() { 
        return velY; }
    public void setVelY(Integer velY) { 
        this.velY = velY; }
    public Integer getPosX() { 
        return posX; }
    public void setPosX(Integer posX) { 
        this.posX = posX; }
    public Integer getPosY() { 
        return posY; }
    public void setPosY(Integer posY) { 
        this.posY = posY; }
    public Integer getJugadorId() { 
        return jugadorId; }
    public void setJugadorId(Integer jugadorId) { 
        this.jugadorId = jugadorId; }
    public Integer getModeloId() { 
        return modeloId; }
    public void setModeloId(Integer modeloId) { 
        this.modeloId = modeloId; }
}

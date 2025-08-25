package co.edu.javeriana.ejemplojpa.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.ejemplojpa.dto.BarcoDTO;
import co.edu.javeriana.ejemplojpa.model.Barco;

public class BarcoMapper {
    public static BarcoDTO toDTO(Barco barco) {
        if (barco == null) return null;
        BarcoDTO barcodto = new BarcoDTO();
       barcodto.setIdBarco(barco.getIdBarco());
        barcodto.setVelX(barco.getVelX());
        barcodto.setVelY(barco.getVelY());
        barcodto.setPosX(barco.getPosX());
        barcodto.setPosY(barco.getPosY());
        barcodto.setJugadorId(barco.getJugador() != null ? barco.getJugador().getIdJugador() : null);
        barcodto.setModeloId(barco.getModelo() != null ? barco.getModelo().getIdModelo() : null);
        return barcodto;
    }
    public static Barco toEntity(BarcoDTO barcodto) {
        if (barcodto == null) return null;
        Barco barco = new Barco();
        barco.setIdBarco(barcodto.getIdBarco());
        barco.setVelX(barcodto.getVelX());
        barco.setVelY(barcodto.getVelY());
        barco.setPosX(barcodto.getPosX());
        barco.setPosY(barcodto.getPosY());
        return barco;
    }
   
    public static List<BarcoDTO> toDTOList(List<Barco> entities) {
        List<BarcoDTO> dtos = new ArrayList<>();
        if (entities == null) return dtos;
        for (Barco jugador : entities) {
            dtos.add(toDTO(jugador));
        }
        return dtos;
    }

    public static List<Barco> toEntityList(List<BarcoDTO> dtos) {
        List<Barco> entities = new ArrayList<>();
        if (dtos == null) return entities;
        for (BarcoDTO dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}

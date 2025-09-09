package co.edu.javeriana.ejemplojpa.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.ejemplojpa.dto.BarcoDTO;
import co.edu.javeriana.ejemplojpa.model.Barco;

public class BarcoMapper {

    
    // -------------------------
    // Entity -> DTO
    // -------------------------
    public static BarcoDTO toDTO(Barco barco) {
        if (barco == null) return null;

        BarcoDTO dto = new BarcoDTO();
        dto.setIdBarco(barco.getIdBarco());
        dto.setVelX(barco.getVelX());
        dto.setVelY(barco.getVelY());
        dto.setPosX(barco.getPosX());
        dto.setPosY(barco.getPosY());

        if (barco.getJugador() != null) {
            dto.setJugadorId(barco.getJugador().getIdJugador());
            dto.setJugadorNombre(barco.getJugador().getNombre()); 
        }
        if (barco.getModelo() != null) {
            dto.setModeloId(barco.getModelo().getIdModelo());
            dto.setModeloNombre(barco.getModelo().getNombre());   
        }
        return dto;
    }

   
    // -------------------------
    // DTO -> Entity
    // -------------------------
    public static Barco toEntity(BarcoDTO dto) {
        if (dto == null) return null;
        Barco barco = new Barco();
        barco.setIdBarco(dto.getIdBarco());
        barco.setVelX(dto.getVelX());
        barco.setVelY(dto.getVelY());
        barco.setPosX(dto.getPosX());
        barco.setPosY(dto.getPosY());
    
        return barco;
    }

    public static List<BarcoDTO> toDTOList(List<Barco> entities) {
        List<BarcoDTO> dtos = new ArrayList<>();
        if (entities == null) return dtos;
        for (Barco entity : entities) {
            dtos.add(toDTO(entity));
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

package co.edu.javeriana.ejemplojpa.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.ejemplojpa.dto.ModeloBarcoDTO;
import co.edu.javeriana.ejemplojpa.model.ModeloBarco;

public class ModeloBarcoMapper {

    // -------------------------
    // Entity -> DTO
    // -------------------------
    public static ModeloBarcoDTO toDTO(ModeloBarco entity) {
        if (entity == null) return null;
        ModeloBarcoDTO dto = new ModeloBarcoDTO();
        dto.setIdModelo(entity.getIdModelo());
        dto.setNombre(entity.getNombre());
        dto.setColor(entity.getColor());
        return dto;
    }

    // -------------------------
    // DTO -> Entity
    // -------------------------
    public static ModeloBarco toEntity(ModeloBarcoDTO dto) {
        if (dto == null) return null;
        ModeloBarco entity = new ModeloBarco();
        entity.setIdModelo(dto.getIdModelo());
        entity.setNombre(dto.getNombre());
        entity.setColor(dto.getColor());
        return entity;
    }

    // -------------------------
    // List<Entity> -> List<DTO>
    // -------------------------
    public static List<ModeloBarcoDTO> toDTOList(List<ModeloBarco> entities) {
        List<ModeloBarcoDTO> dtos = new ArrayList<>();
        if (entities == null) return dtos;
        for (ModeloBarco entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    // -------------------------
    // List<DTO> -> List<Entity>
    // -------------------------
    public static List<ModeloBarco> toEntityList(List<ModeloBarcoDTO> dtos) {
        List<ModeloBarco> entities = new ArrayList<>();
        if (dtos == null) return entities;
        for (ModeloBarcoDTO dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}

package co.edu.javeriana.ejemplojpa.mapper;


import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.ejemplojpa.dto.ModeloBarcoDTO;
import co.edu.javeriana.ejemplojpa.model.ModeloBarco;

public class ModeloBarcoMapper {

 
    public static ModeloBarcoDTO toDTO(ModeloBarco modelo) {
        if (modelo == null) return null;
        ModeloBarcoDTO modelodto = new ModeloBarcoDTO();
        modelodto.setIdModelo(modelo.getIdModelo());
        modelodto.setNombre(modelo.getNombre());
        modelodto.setColor(modelo.getColor());
        return modelodto;
    }

    public static ModeloBarco toEntity(ModeloBarcoDTO modelodto) {
        if (modelodto == null) return null;
        ModeloBarco modelo = new ModeloBarco();
        modelo.setIdModelo(modelodto.getIdModelo());
        modelo.setNombre(modelodto.getNombre());
        modelo.setColor(modelodto.getColor());
        return modelo;
    }

   
    public static List<ModeloBarcoDTO> toDTOList(List<ModeloBarco> entities) {
        List<ModeloBarcoDTO> dtos = new ArrayList<>();
        if (entities == null) return dtos;
        for (ModeloBarco modelo : entities) {
            dtos.add(toDTO(modelo));
        }
        return dtos;
    }

    public static List<ModeloBarco> toEntityList(List<ModeloBarcoDTO> dtos) {
        List<ModeloBarco> entities = new ArrayList<>();
        if (dtos == null) return entities;
        for (ModeloBarcoDTO dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}

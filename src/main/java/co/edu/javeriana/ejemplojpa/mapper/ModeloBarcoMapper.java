package co.edu.javeriana.ejemplojpa.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

import co.edu.javeriana.ejemplojpa.dto.ModeloBarcoDTO;
import co.edu.javeriana.ejemplojpa.model.ModeloBarco;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ModeloBarcoMapper {

    ModeloBarcoDTO toDTO(ModeloBarco entity);

    List<ModeloBarcoDTO> toDTO(List<ModeloBarco> entities);

    ModeloBarco toEntity(ModeloBarcoDTO dto);

    List<ModeloBarco> toEntity(List<ModeloBarcoDTO> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(ModeloBarcoDTO source, @MappingTarget ModeloBarco target);
}

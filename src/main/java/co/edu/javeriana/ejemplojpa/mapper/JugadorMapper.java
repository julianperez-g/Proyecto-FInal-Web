package co.edu.javeriana.ejemplojpa.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

import co.edu.javeriana.ejemplojpa.dto.JugadorDTO;
import co.edu.javeriana.ejemplojpa.model.Jugador;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface JugadorMapper {

    JugadorDTO toDTO(Jugador entity);
    List<JugadorDTO> toDTO(List<Jugador> entities);

    Jugador toEntity(JugadorDTO dto);
    List<Jugador> toEntity(List<JugadorDTO> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(JugadorDTO source, @MappingTarget Jugador target);
}


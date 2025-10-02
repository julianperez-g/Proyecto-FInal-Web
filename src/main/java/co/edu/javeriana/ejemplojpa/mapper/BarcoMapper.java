package co.edu.javeriana.ejemplojpa.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;


import co.edu.javeriana.ejemplojpa.dto.BarcoDTO;
import co.edu.javeriana.ejemplojpa.model.Barco;
import co.edu.javeriana.ejemplojpa.model.Jugador;
import co.edu.javeriana.ejemplojpa.model.ModeloBarco;

@Mapper(componentModel = "spring")
public interface BarcoMapper {

    // =========================
    // Entity -> DTO (aplanando)
    // =========================
    @Mapping(source = "jugador.idJugador", target = "jugadorId")
    @Mapping(source = "jugador.nombre",    target = "jugadorNombre")
    @Mapping(source = "modelo.idModelo",   target = "modeloId")
    @Mapping(source = "modelo.nombre",     target = "modeloNombre")
    BarcoDTO toDTO(Barco entity);

    List<BarcoDTO> toDTO(List<Barco> entities);

    // =========================
    // DTO -> Entity (reconstruye relaciones desde IDs)
    // =========================
    @Mapping(target = "jugador", source = "jugadorId")
    @Mapping(target = "modelo",  source = "modeloId")
    Barco toEntity(BarcoDTO dto);

    List<Barco> toEntity(List<BarcoDTO> dtos);

    // ===== (Opcional) Update in-place: copia solo propiedades no nulas del DTO al Entity =====
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "jugador", source = "jugadorId")
    @Mapping(target = "modelo",  source = "modeloId")
    void updateEntityFromDTO(BarcoDTO source, @MappingTarget Barco target);

    // ===== Helpers: mapear id -> entidad "stub" (solo id) =====
    default Jugador mapJugador(Integer id) {
        if (id == null) return null;
        Jugador j = new Jugador();
        j.setIdJugador(id);
        return j;
    }

    default ModeloBarco mapModelo(Integer id) {
        if (id == null) return null;
        ModeloBarco m = new ModeloBarco();
        m.setIdModelo(id);
        return m;
    }
}

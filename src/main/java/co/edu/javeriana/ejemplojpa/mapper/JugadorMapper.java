package co.edu.javeriana.ejemplojpa.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.ejemplojpa.dto.JugadorDTO;
import co.edu.javeriana.ejemplojpa.model.Jugador;

public class JugadorMapper {

    // ======= Entity -> DTO =======
    public static JugadorDTO toDTO(Jugador jugador) {
        if (jugador == null) return null;
        JugadorDTO dto = new JugadorDTO();
        dto.setIdJugador(jugador.getIdJugador());
        dto.setNombre(jugador.getNombre());
        dto.setUsuario(jugador.getUsuario());
        dto.setContrasena(jugador.getContrasena());
        dto.setRol(jugador.getRol());
        return dto;
    }

    // ======= DTO -> Entity =======
    public static Jugador toEntity(JugadorDTO dto) {
        if (dto == null) return null;
        Jugador jugador = new Jugador();
        jugador.setIdJugador(dto.getIdJugador());
        jugador.setNombre(dto.getNombre());
        jugador.setUsuario(dto.getUsuario());
        jugador.setContrasena(dto.getContrasena());
        jugador.setRol(dto.getRol());
        return jugador;
    }

    // ======= Listas =======
    public static List<JugadorDTO> toDTOList(List<Jugador> entities) {
        List<JugadorDTO> dtos = new ArrayList<>();
        if (entities == null) return dtos;
        for (Jugador jugador : entities) {
            dtos.add(toDTO(jugador));
        }
        return dtos;
    }

    public static List<Jugador> toEntityList(List<JugadorDTO> dtos) {
        List<Jugador> entities = new ArrayList<>();
        if (dtos == null) return entities;
        for (JugadorDTO dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }

    // ======= UPDATE (encapsulado) =======
    public static void updateEntityFromDTO(JugadorDTO dto, Jugador entity) {
        if (dto == null || entity == null) return;
        entity.setNombre(dto.getNombre());
        entity.setUsuario(dto.getUsuario());
        entity.setContrasena(dto.getContrasena());
        entity.setRol(dto.getRol());
    }
}

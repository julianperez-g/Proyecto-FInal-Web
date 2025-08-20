package co.edu.javeriana.ejemplojpa.mapper;


import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.ejemplojpa.dto.JugadorDTO;
import co.edu.javeriana.ejemplojpa.model.Jugador;

public class JugadorMapper {

    public static JugadorDTO toDTO(Jugador jugador) {
        if (jugador == null) return null;
        JugadorDTO jugadordto = new JugadorDTO();
        jugadordto.setIdJugador(jugador.getIdJugador());
        jugadordto.setNombre(jugador.getNombre());
        jugadordto.setUsuario(jugador.getUsuario());
        jugadordto.setContrasena(jugador.getContrasena());  
        jugadordto.setRol(jugador.getRol());
        return jugadordto;
    }

    public static Jugador toEntity(JugadorDTO jugadordto) {
        if (jugadordto == null) return null;
        Jugador jugador = new Jugador();
        jugador.setIdJugador(jugadordto.getIdJugador());
        jugador.setNombre(jugadordto.getNombre());
        jugador.setUsuario(jugadordto.getUsuario());
        jugador.setContrasena(jugadordto.getContrasena());
        jugador.setRol(jugadordto.getRol());
        return jugador;
    }

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
}


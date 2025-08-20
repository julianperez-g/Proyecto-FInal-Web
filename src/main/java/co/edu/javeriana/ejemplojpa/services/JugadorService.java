package co.edu.javeriana.ejemplojpa.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.ejemplojpa.dto.JugadorDTO;
import co.edu.javeriana.ejemplojpa.mapper.JugadorMapper;
import co.edu.javeriana.ejemplojpa.model.Jugador;
import co.edu.javeriana.ejemplojpa.repository.JugadorRepository;
    
@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    
    public List<JugadorDTO> listarJugadores() {
        return JugadorMapper.toDTOList(jugadorRepository.findAll());
    }


    public JugadorDTO recuperarJugador(int id) {
        Jugador jugador = jugadorRepository.findById(id).orElseThrow();
        return JugadorMapper.toDTO(jugador);
    }
}

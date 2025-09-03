package co.edu.javeriana.ejemplojpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.javeriana.ejemplojpa.dto.BarcoDTO;
import co.edu.javeriana.ejemplojpa.mapper.BarcoMapper;
import co.edu.javeriana.ejemplojpa.model.Barco;
import co.edu.javeriana.ejemplojpa.model.Jugador;
import co.edu.javeriana.ejemplojpa.model.ModeloBarco;
import co.edu.javeriana.ejemplojpa.repository.BarcoRepository;
import co.edu.javeriana.ejemplojpa.repository.JugadorRepository;
import co.edu.javeriana.ejemplojpa.repository.ModeloBarcoRepository;

@Service
public class BarcoService {

    @Autowired
    private BarcoRepository barcoRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private ModeloBarcoRepository modeloBarcoRepository;

    // -----------------------------
    // LISTAR TODOS
    // -----------------------------
    public List<BarcoDTO> listarBarcos() {
        return BarcoMapper.toDTOList(barcoRepository.findAll());
    }

    // -----------------------------
    // RECUPERAR UNO
    // -----------------------------
    public BarcoDTO recuperarBarco(int id) {
        Barco barco = barcoRepository.findById(id).orElseThrow();
        return BarcoMapper.toDTO(barco);
    }

    // -----------------------------
    // CREAR
    // -----------------------------
    @Transactional
    public BarcoDTO crear(BarcoDTO dto) {
        Barco entity = new Barco();
        entity.setVelX(dto.getVelX());
        entity.setVelY(dto.getVelY());
        entity.setPosX(dto.getPosX());
        entity.setPosY(dto.getPosY());

        Jugador jugador = jugadorRepository.findById(dto.getJugadorId()).orElseThrow();
        ModeloBarco modelo = modeloBarcoRepository.findById(dto.getModeloId()).orElseThrow();
        entity.setJugador(jugador);
        entity.setModelo(modelo);

        entity = barcoRepository.save(entity);
        return BarcoMapper.toDTO(entity);
    }

    // -----------------------------
    // ACTUALIZAR
    // -----------------------------
    @Transactional
    public BarcoDTO actualizar(Integer idBarco, BarcoDTO dto) {
        Barco entity = barcoRepository.findById(idBarco).orElseThrow();

        entity.setVelX(dto.getVelX());
        entity.setVelY(dto.getVelY());
        entity.setPosX(dto.getPosX());
        entity.setPosY(dto.getPosY());

        if (dto.getJugadorId() != null) {
            Jugador jugador = jugadorRepository.findById(dto.getJugadorId()).orElseThrow();
            entity.setJugador(jugador);
        }
        if (dto.getModeloId() != null) {
            ModeloBarco modelo = modeloBarcoRepository.findById(dto.getModeloId()).orElseThrow();
            entity.setModelo(modelo);
        }

        entity = barcoRepository.save(entity);
        return BarcoMapper.toDTO(entity);
    }

    // -----------------------------
    // ELIMINAR
    // -----------------------------
    @Transactional
    public void eliminar(Integer idBarco) {
        barcoRepository.deleteById(idBarco);
    }

    // -----------------------------
    // LISTAR POR JUGADOR
    // -----------------------------
    public List<BarcoDTO> listarPorJugador(Integer idJugador) {
        return BarcoMapper.toDTOList(
                barcoRepository.findByJugador_IdJugador(idJugador)
        );
    }

    // -----------------------------
    // ASIGNAR MODELOS A UN JUGADOR (máx 10)
    // -----------------------------
    @Transactional
    public void asignarModelosAJugador(Integer idJugador, List<Integer> modeloIds) {
        if (modeloIds.size() > 10) {
            throw new IllegalArgumentException("Máximo 10 modelos por jugador");
        }

        // eliminar barcos actuales del jugador
        barcoRepository.deleteByJugador_IdJugador(idJugador);

        Jugador jugador = jugadorRepository.findById(idJugador).orElseThrow();

        // crear nuevos barcos con valores iniciales 0
        for (Integer idModelo : modeloIds) {
            ModeloBarco modelo = modeloBarcoRepository.findById(idModelo).orElseThrow();
            Barco barco = new Barco();
            barco.setPosX(0);
            barco.setPosY(0);
            barco.setVelX(0);
            barco.setVelY(0);
            barco.setJugador(jugador);
            barco.setModelo(modelo);
            barcoRepository.save(barco);
        }
    }
}

package co.edu.javeriana.ejemplojpa.services;

import java.util.List;

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

    private final BarcoRepository barcoRepository;
    private final JugadorRepository jugadorRepository;
    private final ModeloBarcoRepository modeloBarcoRepository;
    private final BarcoMapper barcoMapper;

    public BarcoService(BarcoRepository barcoRepository,
                        JugadorRepository jugadorRepository,
                        ModeloBarcoRepository modeloBarcoRepository,
                        BarcoMapper barcoMapper) {
        this.barcoRepository = barcoRepository;
        this.jugadorRepository = jugadorRepository;
        this.modeloBarcoRepository = modeloBarcoRepository;
        this.barcoMapper = barcoMapper;
    }

    public List<BarcoDTO> listarBarcos() {
        List<Barco> entities = barcoRepository.findAll();
        return barcoMapper.toDTO(entities);
    }

    public BarcoDTO recuperarBarco(Integer idBarco) {
        Barco entity = barcoRepository.findById(idBarco).orElseThrow();
        return barcoMapper.toDTO(entity);
    }

    @Transactional
    public BarcoDTO guardar(BarcoDTO dto) {
        Barco entity = barcoMapper.toEntity(dto);
        entity.setIdBarco(null);
        if (dto.getJugadorId() != null) {
            Jugador j = jugadorRepository.findById(dto.getJugadorId()).orElseThrow();
            entity.setJugador(j);
        }
        if (dto.getModeloId() != null) {
            ModeloBarco m = modeloBarcoRepository.findById(dto.getModeloId()).orElseThrow();
            entity.setModelo(m);
        }
        Barco saved = barcoRepository.save(entity);
        return barcoMapper.toDTO(saved);
    }

    @Transactional
    public BarcoDTO actualizar(Integer idBarco, BarcoDTO dto) {
        Barco existente = barcoRepository.findById(idBarco).orElseThrow();
        existente.setVelX(dto.getVelX());
        existente.setVelY(dto.getVelY());
        existente.setPosX(dto.getPosX());
        existente.setPosY(dto.getPosY());
      
        if (dto.getJugadorId() != null) {
            Jugador j = jugadorRepository.findById(dto.getJugadorId()).orElseThrow();
            existente.setJugador(j);
        }
        if (dto.getModeloId() != null) {
            ModeloBarco m = modeloBarcoRepository.findById(dto.getModeloId()).orElseThrow();
            existente.setModelo(m);
        }
        Barco saved = barcoRepository.save(existente);
        return barcoMapper.toDTO(saved);
    }

    @Transactional
    public void eliminar(Integer idBarco) {
        barcoRepository.deleteById(idBarco);
    }

    public List<BarcoDTO> listarPorJugador(Integer idJugador) {
        List<Barco> entities = barcoRepository.findByJugador_IdJugador(idJugador);
        return barcoMapper.toDTO(entities);
    }

    @Transactional
    public void asignarModelosAJugador(Integer idJugador, List<Integer> modeloIds) {
        if (modeloIds == null) modeloIds = List.of();
        if (modeloIds.size() > 10) {
            throw new IllegalArgumentException("Máximo 10 modelos por jugador");
        }
        Jugador jugador = jugadorRepository.findById(idJugador).orElseThrow();
        List<Barco> barcosActuales = barcoRepository.findByJugador_IdJugador(idJugador);

        if (barcosActuales.size() > modeloIds.size()) {
            for (int i = modeloIds.size(); i < barcosActuales.size(); i++) {
                barcoRepository.delete(barcosActuales.get(i));
            }
            barcosActuales = barcoRepository.findByJugador_IdJugador(idJugador);
        } else if (barcosActuales.size() < modeloIds.size()) {
            int toCreate = modeloIds.size() - barcosActuales.size();
            for (int i = 0; i < toCreate; i++) {
                Barco nuevo = new Barco();
                nuevo.setJugador(jugador);
                nuevo.setVelX(0);
                nuevo.setVelY(0);
                nuevo.setPosX(0);
                nuevo.setPosY(0);
                
                barcosActuales.add(barcoRepository.save(nuevo));
            }
        }

        for (int i = 0; i < modeloIds.size(); i++) {
            Integer idModelo = modeloIds.get(i);
            ModeloBarco modelo = modeloBarcoRepository.findById(idModelo).orElseThrow();
            Barco barco = barcosActuales.get(i);
            barco.setJugador(jugador);
            barco.setModelo(modelo);
            barcoRepository.save(barco);
        }
    }
}

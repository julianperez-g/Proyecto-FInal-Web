    package co.edu.javeriana.ejemplojpa.services;

    import java.util.List;

    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import co.edu.javeriana.ejemplojpa.dto.JugadorDTO;
import co.edu.javeriana.ejemplojpa.mapper.JugadorMapper;
import co.edu.javeriana.ejemplojpa.model.Jugador;
    import co.edu.javeriana.ejemplojpa.repository.JugadorRepository;

   @Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;
    private final JugadorMapper jugadorMapperManual;

    public JugadorService(JugadorRepository repo, JugadorMapper mapper) {
        this.jugadorRepository = repo;
        this.jugadorMapperManual = mapper;
    }

    public List<JugadorDTO> listarJugadores() {
        return jugadorMapperManual.toDTO(jugadorRepository.findAll());
    }

    public JugadorDTO recuperarJugador(Integer id) {
        return jugadorMapperManual.toDTO(jugadorRepository.findById(id).orElseThrow());
    }

    @Transactional
    public JugadorDTO guardar(JugadorDTO dto) {
        Jugador entity = jugadorMapperManual.toEntity(dto);
        entity.setIdJugador(null);
        return jugadorMapperManual.toDTO(jugadorRepository.save(entity));
    }

    @Transactional
    public JugadorDTO actualizar(Integer id, JugadorDTO dto) {
        Jugador existente = jugadorRepository.findById(id).orElseThrow();
        jugadorMapperManual.updateEntityFromDTO(dto, existente);
        return jugadorMapperManual.toDTO(jugadorRepository.save(existente));
    }

    @Transactional
    public void eliminar(Integer id) {
        jugadorRepository.deleteById(id);
    }
}

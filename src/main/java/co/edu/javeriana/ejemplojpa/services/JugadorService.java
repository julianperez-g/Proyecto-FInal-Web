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

        // Inyección por constructor (recomendada)
        public JugadorService(JugadorRepository jugadorRepository) {
            this.jugadorRepository = jugadorRepository;
        }

        // ======== READ: listar ========
        @Transactional(readOnly = true)
        public List<JugadorDTO> listarJugadores() {
            return JugadorMapper.toDTOList(jugadorRepository.findAll());
        }

        // ======== READ: recuperar uno ========
        @Transactional(readOnly = true)
        public JugadorDTO recuperarJugador(Integer id) {
            Jugador entity = jugadorRepository.findById(id).orElseThrow();
            return JugadorMapper.toDTO(entity);
        }

        // ======== CREATE ========
        @Transactional
        public JugadorDTO guardar(JugadorDTO dto) {
            // Conversión delegada al mapper
            Jugador entity = JugadorMapper.toEntity(dto);
            Jugador saved = jugadorRepository.save(entity);
            return JugadorMapper.toDTO(saved);
        }

        // ======== UPDATE (encapsulado en el mapper) ========
        @Transactional
        public JugadorDTO actualizar(Integer id, JugadorDTO dto) {
            Jugador existente = jugadorRepository.findById(id).orElseThrow();
            // Encapsulamos la copia de campos en el mapper
            JugadorMapper.updateEntityFromDTO(dto, existente);
            Jugador actualizado = jugadorRepository.save(existente);
            return JugadorMapper.toDTO(actualizado);
        }

        // ======== DELETE ========
        @Transactional
        public void eliminar(Integer id) {
            jugadorRepository.deleteById(id);
        }
    }

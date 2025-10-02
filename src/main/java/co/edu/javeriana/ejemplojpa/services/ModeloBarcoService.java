package co.edu.javeriana.ejemplojpa.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.javeriana.ejemplojpa.dto.ModeloBarcoDTO;
import co.edu.javeriana.ejemplojpa.mapper.ModeloBarcoMapper;
import co.edu.javeriana.ejemplojpa.model.ModeloBarco;
import co.edu.javeriana.ejemplojpa.repository.ModeloBarcoRepository;

@Service
public class ModeloBarcoService {

    private final ModeloBarcoRepository modeloBarcoRepository;
    private final ModeloBarcoMapper modeloBarcoMapper;

    public ModeloBarcoService(ModeloBarcoRepository modeloBarcoRepository,
                              ModeloBarcoMapper modeloBarcoMapper) {
        this.modeloBarcoRepository = modeloBarcoRepository;
        this.modeloBarcoMapper = modeloBarcoMapper;
    }

    public List<ModeloBarcoDTO> listar() {
        List<ModeloBarco> entities = modeloBarcoRepository.findAll();
        return modeloBarcoMapper.toDTO(entities); // <-- nombre correcto
    }

    public ModeloBarcoDTO recuperar(Integer id) {
        ModeloBarco entity = modeloBarcoRepository.findById(id).orElseThrow();
        return modeloBarcoMapper.toDTO(entity);
    }

    @Transactional
    public ModeloBarcoDTO crear(ModeloBarcoDTO dto) {
        ModeloBarco entity = modeloBarcoMapper.toEntity(dto);
        entity.setIdModelo(null);
        return modeloBarcoMapper.toDTO(modeloBarcoRepository.save(entity));
    }

    @Transactional
    public ModeloBarcoDTO actualizar(Integer id, ModeloBarcoDTO dto) {
        ModeloBarco existente = modeloBarcoRepository.findById(id).orElseThrow();
        modeloBarcoMapper.updateEntityFromDTO(dto, existente);
        return modeloBarcoMapper.toDTO(modeloBarcoRepository.save(existente));
    }

    @Transactional
    public void eliminar(Integer id) {
        modeloBarcoRepository.deleteById(id);
    }
}

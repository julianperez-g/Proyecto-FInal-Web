package co.edu.javeriana.ejemplojpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.javeriana.ejemplojpa.dto.ModeloBarcoDTO;
import co.edu.javeriana.ejemplojpa.mapper.ModeloBarcoMapper;
import co.edu.javeriana.ejemplojpa.model.ModeloBarco;
import co.edu.javeriana.ejemplojpa.repository.ModeloBarcoRepository;

@Service
public class ModeloBarcoService {

    @Autowired
    private ModeloBarcoRepository modeloBarcoRepository;

    // LISTAR
    public List<ModeloBarcoDTO> listar() {
        return ModeloBarcoMapper.toDTOList(modeloBarcoRepository.findAll());
    }

    // RECUPERAR
    public ModeloBarcoDTO recuperar(int idModelo) {
        ModeloBarco modelo = modeloBarcoRepository.findById(idModelo).orElseThrow();
        return ModeloBarcoMapper.toDTO(modelo);
    }

    // CREAR
    @Transactional
    public ModeloBarcoDTO crearModelo(ModeloBarcoDTO modeloBarcoDTO) {
        ModeloBarco m = ModeloBarcoMapper.toEntity(modeloBarcoDTO);
        m.setIdModelo(null); // por si llega algo
        m = modeloBarcoRepository.save(m);
        return ModeloBarcoMapper.toDTO(m);
    }

    // ACTUALIZAR
    @Transactional
    public ModeloBarcoDTO actualizarModelo(Integer idModelo, ModeloBarcoDTO modeloBarcoDTO) {
        ModeloBarco m = modeloBarcoRepository.findById(idModelo).orElseThrow();
        m.setNombre(modeloBarcoDTO.getNombre());
        m.setColor(modeloBarcoDTO.getColor());
        m = modeloBarcoRepository.save(m);
        return ModeloBarcoMapper.toDTO(m);
    }

    // ELIMINAR
    @Transactional
    public void eliminar(Integer idModelo) {
        modeloBarcoRepository.deleteById(idModelo);
    }
}

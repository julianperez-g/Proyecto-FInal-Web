package co.edu.javeriana.ejemplojpa.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.ejemplojpa.dto.ModeloBarcoDTO;
import co.edu.javeriana.ejemplojpa.mapper.ModeloBarcoMapper;
import co.edu.javeriana.ejemplojpa.model.ModeloBarco;
import co.edu.javeriana.ejemplojpa.repository.ModeloBarcoRepository;

@Service
public class ModeloBarcoService {

    @Autowired
    private ModeloBarcoRepository modeloBarcoRepository;

    // Lista todos los modelos (para /modelobarco/list)
    public List<ModeloBarcoDTO> listar() {
        return ModeloBarcoMapper.toDTOList(modeloBarcoRepository.findAll());
    }

    // Recupera un modelo por id (para /modelobarco/view/{idModelo})
    public ModeloBarcoDTO recuperar(int idModelo) {
        ModeloBarco modelo = modeloBarcoRepository.findById(idModelo).orElseThrow();
        return ModeloBarcoMapper.toDTO(modelo);
    }
}

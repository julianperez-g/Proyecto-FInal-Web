package co.edu.javeriana.ejemplojpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.ejemplojpa.dto.BarcoDTO;
import co.edu.javeriana.ejemplojpa.mapper.BarcoMapper;
import co.edu.javeriana.ejemplojpa.model.Barco;
import co.edu.javeriana.ejemplojpa.repository.BarcoRepository;

@Service
public class BarcoService {

    @Autowired
    private BarcoRepository barcoRepository;

    public List<BarcoDTO> listarBarcos() {
        return BarcoMapper.toDTOList(barcoRepository.findAll());
    }

    public BarcoDTO recuperarBarco(int id) {
        Barco barco = barcoRepository.findById(id).orElseThrow();
        return BarcoMapper.toDTO(barco);
    }
}

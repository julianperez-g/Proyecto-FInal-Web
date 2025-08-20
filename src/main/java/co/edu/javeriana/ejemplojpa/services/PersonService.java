package co.edu.javeriana.ejemplojpa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.ejemplojpa.dto.PersonDTO;
import co.edu.javeriana.ejemplojpa.mapper.PersonMapper;
import co.edu.javeriana.ejemplojpa.model.Person;
import co.edu.javeriana.ejemplojpa.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDTO> listarPersonas() {
        // TODO Encapsular esto en el PersonMapper
        List<PersonDTO> personDTOs = new ArrayList<>();
        for (Person person :personRepository.findAll()) {
            personDTOs.add(PersonMapper.toDTO(person));
        }
        return personDTOs;
    }

    public PersonDTO recuperarPersona(Long id) {
        return PersonMapper.toDTO(personRepository.findById(id).orElseThrow());
    }
}

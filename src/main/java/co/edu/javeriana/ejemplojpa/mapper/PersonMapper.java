package co.edu.javeriana.ejemplojpa.mapper;

import co.edu.javeriana.ejemplojpa.dto.PersonDTO;
import co.edu.javeriana.ejemplojpa.model.Person;

public class PersonMapper {
    public static PersonDTO toDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setCedula(person.getCedula());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        return personDTO;

    }

    public static Person toEntity(PersonDTO personDTO) {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setCedula(personDTO.getCedula());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        return person;
    }
}

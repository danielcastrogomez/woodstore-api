package com.casdan.woodshopapi.mapper;

import com.casdan.woodshopapi.dto.PersonDTO;
import com.casdan.woodshopapi.entities.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person dtoToPerson(PersonDTO personDTO){
        Person person = new Person();
        person.setPersonId(personDTO.getId());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setUserName(personDTO.getUserName());
        person.setEmail(personDTO.getEmail());
        person.setPhoneNumber(personDTO.getPhoneNumber());
        person.setPassword(personDTO.getPassword() == null ? "" : personDTO.getPassword());

        return person;
    }

    public PersonDTO personToDTO(Person person){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getPersonId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setEmail(person.getEmail());
        personDTO.setUserName(person.getUserName());
        personDTO.setEmail(person.getEmail());
        personDTO.setPhoneNumber(person.getPhoneNumber());

        return personDTO;
    }
}

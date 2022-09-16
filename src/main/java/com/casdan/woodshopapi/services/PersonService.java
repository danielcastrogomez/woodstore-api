package com.casdan.woodshopapi.services;

import com.casdan.woodshopapi.dto.PersonDTO;
import com.casdan.woodshopapi.entities.Person;
import com.casdan.woodshopapi.mapper.PersonMapper;
import com.casdan.woodshopapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    public void savePerson(PersonDTO personDTO){
        Person person = personMapper.dtoToPerson(personDTO);
        personRepository.save(person);
    }

    public List<PersonDTO> getAllPersons(){
        List<PersonDTO> personsDTOList = new ArrayList<>();
        List<Person> personsList = personRepository.findAll();

        personsList.forEach(person -> {
            personsDTOList.add(personMapper.personToDTO(person));
        });

        return personsDTOList;

    }

    public PersonDTO getPersonById(Integer id) {
        PersonDTO personDTO = new PersonDTO();
        Person person = personRepository.findById(id.longValue()).orElse(new Person());
        if(person.getFirstName().equalsIgnoreCase("")){
            return new PersonDTO();
        }
        return personDTO = personMapper.personToDTO(person);
    }

    public void updatePerson(PersonDTO personDTO){
        Person person = personMapper.dtoToPerson(personDTO);
        personRepository.save(person);
    }



}

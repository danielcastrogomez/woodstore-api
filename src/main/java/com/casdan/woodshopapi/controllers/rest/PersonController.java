package com.casdan.woodshopapi.controllers.rest;


import com.casdan.woodshopapi.dto.PersonDTO;
import com.casdan.woodshopapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/collect")
    public ResponseEntity<List<PersonDTO>> getUsers(){
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping("/collect/{id}")
    public ResponseEntity<PersonDTO> getUserById(@RequestParam Integer id){
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PersonDTO> createUser(@RequestBody PersonDTO person){
        personService.savePerson(person);
        return ResponseEntity.ok(person);
    }

    @PatchMapping("/update")
    public ResponseEntity<PersonDTO> updateUser(@RequestBody PersonDTO person){
        personService.savePerson(person);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeUser(){
        return ResponseEntity.ok("PersonController removed");
    }

}

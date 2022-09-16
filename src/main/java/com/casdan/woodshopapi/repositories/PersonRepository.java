package com.casdan.woodshopapi.repositories;

import com.casdan.woodshopapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

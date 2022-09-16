package com.casdan.woodshopapi.repositories;

import com.casdan.woodshopapi.entities.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<PersonRole, Long> {
}

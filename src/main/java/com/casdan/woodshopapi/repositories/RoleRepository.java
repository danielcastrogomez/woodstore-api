package com.casdan.woodshopapi.repositories;

import com.casdan.woodshopapi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

package com.eldorado.authservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eldorado.authservice.models.Role;

/*
 * Jpa repository for User Roles
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}

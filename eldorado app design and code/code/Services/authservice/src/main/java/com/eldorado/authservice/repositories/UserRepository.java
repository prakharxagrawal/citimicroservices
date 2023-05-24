package com.eldorado.authservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eldorado.authservice.models.AuthUser;

/*
 * Jpa Repository for user 
 */

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Long> {

	/*
	 * Function to find user by email id Return type: AuthUser
	 * 
	 */

	public AuthUser findByEmail(String email);

}

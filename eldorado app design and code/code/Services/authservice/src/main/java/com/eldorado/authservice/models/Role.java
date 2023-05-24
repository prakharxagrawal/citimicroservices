package com.eldorado.authservice.models;

import java.util.Set;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Mohammad Faizan 
 * AuthUser :Pojo class for Role Entity
 * Implementing granted authority interface to provide Authority for a role
 */

@Entity
public class Role implements GrantedAuthority {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	/*
	 * Many to Many mapping between user and role entities
	 */
	
	@ManyToMany(mappedBy = "roles")
	private Set<AuthUser> users;
	
	/*getter and setters for 
	 * role Id and role name
	 */
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Function to return the authority of a role
	 * Return Type:String
	 * Value :Authority 
	 */
	
	@Override
	public String getAuthority() {
		return this.getName();
	}

}

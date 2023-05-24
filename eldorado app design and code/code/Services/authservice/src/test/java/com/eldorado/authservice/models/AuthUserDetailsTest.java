package com.eldorado.authservice.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

 class AuthUserDetailsTest {
	
	
	/*
	 * Object of type AuthUser
	 */
	private AuthUserDetails authUserDetails;
	
	/*
	 * Object of type AuthUser
	 */
	private AuthUser user;
	
	
	
	/*
	 * Initializing passwordEncoder and user objects 
	 * before each test case 
	 */
	
	@BeforeEach
	 public void  setUser() {
		user=new AuthUser();
		user.setFirstName("Mohammad");
		user.setLastName("Faizan");
		user.setEmail("faizan@gmail.com");
		user.setPassword("faizan@123");
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		Set<Role> roles=new HashSet<>();
		Role role=new Role();
		role.setId(1L);
		role.setName("USER");
		roles.add(role);
		user.setRoles(roles);
		authUserDetails=new AuthUserDetails(user);
	}
	
	/**
	 * Testing for getAuthorities() method
	 */
	@Test
	void testGetAuthorities() {
		assertNotNull(authUserDetails.getAuthorities());
	}
	
	/**
	 * Testing getPassword() function
	 */
	@Test
	 void testGetPassword() {
		String expected="faizan@123";
		String actual= user.getPassword();
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing getPassword() function
	 */
	@Test
	 void testGetUsername() {
		String expected="faizan@123";
		String actual= authUserDetails.getUsername();
		assertNotEquals(expected, actual);
	}
	
	/**
	 * Testing getFirstName() function
	 */
	
	@Test
	 void testFirstName() {
		String expected="Mohammad";
		String actual=authUserDetails.getFirstName();
		assertNotEquals(expected, actual);
	}
	
	
	/*
	 * Testing AccountNonExpired function
	 */
	@Test
	 void testAccountNonExpired() {
		assertTrue(authUserDetails.isAccountNonExpired());
	}
	
	/*
	 * Testing isAccountNonLocked function
	 */
	@Test
	 void testAccountNonLocked() {
		assertTrue(authUserDetails.isAccountNonLocked());
	}
	
	/*
	 * Testing isCredentialsNonExpired function
	 */
	@Test
	 void testCredentialsNonExpired() {
		assertTrue(authUserDetails.isCredentialsNonExpired());
	}
	
	/*
	 * Testing isEnabled function
	 */
	@Test
	 void testIsEnabled() {
		assertTrue(authUserDetails.isEnabled());
	}
	
	
	
}

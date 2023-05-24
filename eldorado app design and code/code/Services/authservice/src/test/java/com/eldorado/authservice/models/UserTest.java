package com.eldorado.authservice.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * Test for AuthUser Pojo Class
 */

 class UserTest {
	
	/*
	 * Object of type AuthUser
	 */
	private AuthUser user;
	
	/*
	 * Object of type PasswordEncoder
	 */
	
	private PasswordEncoder passwordEncoder;
	
	/*
	 * Initializing passwordEncoder and user objects 
	 * before each test case 
	 */
	
	@BeforeEach
	 public void  setUser() {
		passwordEncoder=new BCryptPasswordEncoder();
		user=new AuthUser();
		user.setId(1L);
		user.setFirstName("Mohammad");
		user.setLastName("Faizan");
		user.setEmail("faizan@gmail.com");
		user.setPassword(passwordEncoder.encode("faizan@123"));
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
		
	}
	
	/*
	 * Testing getFirstName() function
	 */
	
	@Test
	 void testFirstName() {
		String expected="Mohammad";
		String actual=user.getFirstName();
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing getLastName() function
	 */
	
	@Test
	 void testLastName() {
		String expected="Faizan";
		String actual=user.getLastName();
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing getEmail() function
	 */
	
	@Test
	 void testEmail() {
		String expected="faizan@gmail.com";
		String actual=user.getEmail();
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing getPassword() function
	 */

	@Test
	 void testPassword() {
		String expected=passwordEncoder.encode("faizan@123");
		String actual=user.getPassword();
		assertNotEquals(expected, actual);
	}
	
	
	/*
	 * Testing getId() function
	 */

	@Test
	 void testUserId() {
		Long expected=1L;
		Long actual=user.getId();
		assertEquals(expected, actual);
	}
	
	
	/*
	 * Testing AccountNonExpired function
	 */
	@Test
	 void testAccountNonExpired() {
		assertTrue(user.isAccountNonExpired());
	}
	
	/*
	 * Testing isAccountNonLocked function
	 */
	@Test
	 void testAccountNonLocked() {
		assertTrue(user.isAccountNonLocked());
	}
	
	/*
	 * Testing isCredentialsNonExpired function
	 */
	@Test
	 void testCredentialsNonExpired() {
		assertTrue(user.isCredentialsNonExpired());
	}
	
	/*
	 * Testing isEnabled function
	 */
	@Test
	 void testEnabled() {
		assertTrue(user.isEnabled());
	}
	
	@Test
	void testUserRoles() {
		Set<Role> actual=new HashSet<>();
		Role role=new Role();
		role.setId(1L);
		role.setName("USER");
		actual.add(role);
		Set<Role> expectedRoles=user.getRoles();
		assertNotEquals(actual,expectedRoles);
	}
	
}

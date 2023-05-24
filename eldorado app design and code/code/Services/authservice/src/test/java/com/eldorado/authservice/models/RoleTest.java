package com.eldorado.authservice.models;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/*
 * Role Test Class
 */

 class RoleTest {
	
	private Role role;
	
	/*
	 * Creating Role class Object before each test case
	 */
	
	@BeforeEach
	 void  setUser() {
		role=new Role();
		role.setId(1L);
		role.setName("USER");
	}
	
	@Test
	void testRoleId() {
		Long expected=1L;
		Long actual=role.getId();
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing for getAuthority() function
	 */
	
	@Test
	 void testUserRole() {
		String expected="USER";
		String actual=role.getAuthority();
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing for getName() function
	 */
	
	@Test
	 void testUserRoleName() {
		String expected="USER";
		String actual=role.getName();
		assertEquals(expected, actual);
	}
	
	
}

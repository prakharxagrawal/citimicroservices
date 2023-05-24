package com.eldorado.authservice.dto;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UserCredentialsDtoTest {
	
	/*
	 * Object of type UserCredentialsDto
	 */
	private UserCredentialsDto user;
	
	
	/*
	 * Initializing  UserCredentialsDto objects 
	 * before each test case 
	 */
	
	@BeforeEach
	 public void  setUser() {
		
		user=new UserCredentialsDto();
		user.setUserName("doug@123.com");
		user.setPassword("doug");
		
	}
	
	/*
	 * Testing getUserName() function
	 */
	
	@Test
	 void testUserName() {
		String expected="doug@123.com";
		String actual=user.getUserName();
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing getPassword() function
	 */
	
	@Test
	 void testUserPassword() {
		String expected="doug";
		String actual=user.getPassword();
		assertEquals(expected, actual);
	}
	
	
}

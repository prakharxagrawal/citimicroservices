//package com.eldorado.authservice.services;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertThrows;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.eldorado.authservice.services.UserDetailsServiceImpl;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
// class UserDetailsServiceImplTest {
//	
//	/*
//	 * Injecting dependency for UserDetailsServiceImpl
//	 */
//	
//	@Autowired
//	private UserDetailsServiceImpl userDetailsService;
//	
//	
//	/*
//	 * Testing for presence of User and Credentials are correct
//	 */
//	
//	@Test
//	 void testLoadUserByUsernamewhenPresentandCorrectCredentials() {
//		String userName="doug@123.com";
//		UserDetails user =userDetailsService.loadUserByUsername(userName);
//		assertEquals("$2a$10$U2STWqktwFbvPPsfblVeIuy11vQ1S/0LYLeXQf1ZL0cMXc9HuTEA2", user.getPassword());
//	}
//	
//	/*
//	 * Testing for presence of User and Credentials are not correct
//	 */
//	
//	@Test
//	 void testLoadUserByUsernamewhenPresentandWrongCredentials() {
//		String userName="doug@123.com";
//		UserDetails user =userDetailsService.loadUserByUsername(userName);
//		assertNotEquals("$2a$10$U2STWqktwFbvPPsfblVeIuy11vQ1S/0LYLeXQf1ZL0cMXc9HuTEA1", user.getPassword());
//	}
//	
//	/*
//	 * Testing for UserNameNotFoundException when wrong user name is given
//	 */
//	@Test
//	 void testUserNameNotFoundExceptionWhenWrongCredentials() {
//		String userName="none@not.com";
//		assertThrows(UsernameNotFoundException.class,()->{
//			userDetailsService.loadUserByUsername(userName);
//		});
//	}
//}

package com.eldorado.authservice.constants;

import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * @author Mohammad Faizan Class For Constants for AuthService
 *
 */
public class AuthServiceConstants {
	
	private AuthServiceConstants() {
		
	}

	public static final String USER_NOT_PRESENT = "User is not present for username ";
	public static final String USER_IS_PRSENT = "User is present with username ";
	
	/**
	 * RESOURCE_ID is the identity for client
	 */
	public static final String RESOURCE_ID = "couponservice";
	
	/**
	 * client credentials
	 */
	public static final String CLIENT_ID="couponclientapp";
	public static final String CLIENT_PASSWORD="9999";
	
	public static final String BASE_URI = "http://localhost:9092";
	
}

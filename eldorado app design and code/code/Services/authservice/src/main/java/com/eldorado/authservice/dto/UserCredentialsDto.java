package com.eldorado.authservice.dto;


/**
 * 
 * @author Mohammad Faizan
 * Dto for User Credentials 
 * like userName and Password
 *
 */
public class UserCredentialsDto {
	
	private String userName;
	private String password;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}

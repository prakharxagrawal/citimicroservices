//package com.eldorado.authservice.controllers;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.eldorado.authservice.dto.UserCredentialsDto;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value=UserAccesController.class)
//public class UserAccessControllerTest {
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	void testGetTokenEndPoint() throws JsonProcessingException {
//		
//		UserCredentialsDto user=new UserCredentialsDto();
//		user.setUserName("doug@123.com");
//		user.setPassword("doug");
//		
//		ObjectMapper objectMapper=new ObjectMapper();
//		objectMapper.writeValueAsString(user);
//		
//		RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/gettoken",objectMapper.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON);
//		
////		MvcResult result=mockMvc.perform(requestBuilder).andExpect(ResponseEntity<String> );
//		
//	}
//
//}

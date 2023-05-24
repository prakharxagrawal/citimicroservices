package com.eldorado.authservice.controllers;


import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eldorado.authservice.constants.AuthServiceConstants;
import com.eldorado.authservice.dto.UserCredentialsDto;

/**
 * RestController to get access token
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserAccesController {
	
	@Value("${baseUri}")
	private String baseUri;

	@PostMapping(path = "/gettoken", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> getaccessToken(@RequestParam MultiValueMap<String, String> userCredentials) {
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.addAll("username", userCredentials.get("userName"));
		body.addAll("password", userCredentials.get("password"));
		body.add("grant_type", "password");

		String credentials = AuthServiceConstants.CLIENT_ID+":"+AuthServiceConstants.CLIENT_PASSWORD;
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<?> request = new HttpEntity<Object>(body, headers);
		String access_token_url = baseUri+"oauth/token";
		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);
		return response;
	}

	@PostMapping("/getaccesstoken")
	public ResponseEntity<String> getAccessToken(@RequestBody UserCredentialsDto userCredentials) {
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", userCredentials.getUserName());
		body.add("password", userCredentials.getPassword());
		body.add("grant_type", "password");

		String credentials = AuthServiceConstants.CLIENT_ID+":"+AuthServiceConstants.CLIENT_PASSWORD;
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<?> request = new HttpEntity<Object>(body, headers);
		String access_token_url = baseUri+"oauth/token";
		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);
		return response;
	}
}

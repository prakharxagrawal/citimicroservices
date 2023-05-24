package com.eldorado.userservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.eldorado.userservice.config.LoggingConfig;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping; 

@RestController
public class HelloWorldController {
	Logger log = LoggingConfig.getLog();
	@GetMapping("/helloworld")
    String helloWorld() {
		log.info("Hello World -> User Microservice");
		return "Hello World -> User Microservice";
	}
}

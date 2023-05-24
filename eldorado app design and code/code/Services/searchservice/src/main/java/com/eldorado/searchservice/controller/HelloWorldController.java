package com.eldorado.searchservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.eldorado.searchservice.config.LoggingConfig;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping; 

@RestController
public class HelloWorldController {
	Logger log = LoggingConfig.getLog();
	@GetMapping("/helloworld")
    String helloWorld() {
		log.info("Hello World -> Search Microservice");
		return "Hello World -> Search Microservice";
	}
}

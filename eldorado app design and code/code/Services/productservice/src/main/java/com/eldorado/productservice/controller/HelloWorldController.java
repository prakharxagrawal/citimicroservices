package com.eldorado.productservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.eldorado.productservice.config.LoggingConfig;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping; 

@RestController
public class HelloWorldController {
	Logger log = LoggingConfig.getLog();
	@GetMapping("/helloworld")
    String helloWorld() {
		log.info("Hello World -> Product Microservice");
		return "Hello World -> Product Microservice";
	}
}

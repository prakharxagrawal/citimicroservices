package com.helloworldexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/api/v1/greet")
public class HelloWorldController {
		
		//http://localhost:8080/api/v1/greet/greeting
		@GetMapping("/greeting")
		@Timed(value="greetings.time",description="Time taken to return greeting")
		public String greetings() {
			return "Hello World ";
		}
}
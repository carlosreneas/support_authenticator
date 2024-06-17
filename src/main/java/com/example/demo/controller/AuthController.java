package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@GetMapping("/authenticate")
	public String auth() {
		return "OK";
	}
	
	@PostMapping("/authenticate")
	public String crearAuth() {
		return "OK";
	}

}

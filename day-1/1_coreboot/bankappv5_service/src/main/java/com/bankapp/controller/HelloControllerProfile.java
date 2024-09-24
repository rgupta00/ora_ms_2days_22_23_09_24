package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerProfile {

	@Value("${app.info}")
	private String info;
	
	@GetMapping(value = "info")
	public String demoProfile() {
		return info;
	}
}

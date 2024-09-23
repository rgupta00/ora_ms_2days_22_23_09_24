package com.bankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/*
 * REST --> HTTP
 * GET
 * POST 
 * PUT
 * DELETE
 * ...
 */
@RestController
public class HelloController {

	@GetMapping(path="hello/{name}")
	public String hello(@PathVariable String name) {
		return "hello champs! "+ name;
	}
}

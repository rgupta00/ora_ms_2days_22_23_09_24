package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bankapp.dto.AccountDto;

@RestController
public class BankAppRestClientController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path = "accounts/{id}")
	public AccountDto getAccountFromOtherApp(@PathVariable int id) {
		return restTemplate
				.getForObject("http://localhost:8090/accounts/"+ id, AccountDto.class);
	}
	
}

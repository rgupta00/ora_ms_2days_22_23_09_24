package com.bankapp.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bankapp.clientproxy.BankRestProxyClient;
import com.bankapp.dto.AccountDto;

@RestController
public class BankAppRestClientController {

//	@Autowired
//	private RestTemplate restTemplate;
//	
//	@GetMapping(path = "accounts/{id}")
//	public AccountDto getAccountFromOtherApp(@PathVariable int id) {
//		return restTemplate
//				.getForObject("http://localhost:8090/accounts/"+ id, AccountDto.class);
//	}
	
	@Autowired
	private BankRestProxyClient bankRestProxyClient;
	
	@GetMapping(path = "accounts/{id}")
	public AccountDto getAccountFromOtherApp(@PathVariable int id) {
		 ResponseEntity<AccountDto> accounts = bankRestProxyClient.getAccounts(id);
		 return accounts.getBody();
	}
	
	@GetMapping(path = "accounts/")
	public ResponseEntity<List<AccountDto>> getAllAccountFromOtherApp() {
		 return bankRestProxyClient.getAccounts();
		
	}
}

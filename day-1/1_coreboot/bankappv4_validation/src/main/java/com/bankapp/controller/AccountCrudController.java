package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountDto;
import com.bankapp.repo.Account;
import com.bankapp.service.AccountService;

import jakarta.validation.Valid;

//@Controller
//@ResponseBody
@RestController
public class AccountCrudController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private Environment environment;


	
	@GetMapping(path = "accounts")
	public ResponseEntity<List<AccountDto>> getAccounts(){
		return ResponseEntity.status(HttpStatus.OK).body(accountService.getAllAccounts());
	}
	//get account by id
	@GetMapping(path = "accounts/{id}")
	public ResponseEntity<AccountDto> getAccounts(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(accountService.getById(id));
	}
	
	//add a new account
	@PostMapping(path = "accounts")
	public ResponseEntity<String> addAccount(@Valid @RequestBody AccountDto accountDto) {
		accountService.addAccount(accountDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(environment.getProperty("ACCOUNT_ADDED_SUCCESS_MSG"));
	}
	
	//update an existing account
	
	//delete an account
	@DeleteMapping(path = "accounts/{id}")
	public ResponseEntity<Void> deleteAccounts(@PathVariable int id){
		accountService.deleteAccount(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}

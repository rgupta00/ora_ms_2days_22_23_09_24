package com.bankapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.repo.Account;
import com.bankapp.service.AccountService;

//@Controller
//@ResponseBody
@RestController
public class AccountCrudController {
	
	private AccountService accountService;

	public AccountCrudController(AccountService accountService) {
		this.accountService = accountService;
	}
	//Json parser: jakson parser classpath java <--> json, u have to trigger it
	//@ResponseBody trigger that parser to convert java to json
	
	//get all accounts
	//ResponseEntity = data + status code
	
	@GetMapping(path = "accounts")
	public ResponseEntity<List<Account>> getAccounts(){
//		if(1==1)
//			throw new RuntimeException();
		return ResponseEntity.status(HttpStatus.OK).body(accountService.getAllAccounts());
	}
	//get account by id
	@GetMapping(path = "accounts/{id}")
	public ResponseEntity<Account> getAccounts(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(accountService.getById(id));
	}
	
	//add a new account
	
	//update an existing account
	
	//delete an account
	
	

}

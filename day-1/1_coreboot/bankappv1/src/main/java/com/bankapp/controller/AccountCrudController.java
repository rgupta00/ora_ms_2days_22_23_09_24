package com.bankapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.repo.Account;
import com.bankapp.service.AccountService;

@RestController
public class AccountCrudController {
	
	private AccountService accountService;

	public AccountCrudController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//get all accounts
	@GetMapping(path = "accounts")
	public List<Account> getAccounts(){
		return accountService.getAllAccounts();
	}
	//get account by id
	
	//add a new account
	
	//update an existing account
	
	//delete an account
	
	

}

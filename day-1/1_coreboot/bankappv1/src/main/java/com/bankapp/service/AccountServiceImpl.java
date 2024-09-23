package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.Account;
import com.bankapp.repo.AccountRepo;
import com.bankapp.repo.AccountRepoJdbcImpl;
import com.bankapp.repo.AccountRepoMapImpl;

import lombok.extern.log4j.Log4j;
//? code couping : DI
@Service(value = "as")
public class AccountServiceImpl implements AccountService{

	private AccountRepo accountRepo;
	
	
	//push: i expecting spring should push the object of dao layer
	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.getAll();
	}

	//how much time this take to execute
	//Logging is CCC (concern that effect everyone): code tangling
	@Override
	public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
			
		Account fromAcc=getById(fromAccId);
		Account toAcc=getById(toAccId);
		fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
		toAcc.setBalance(toAcc.getBalance().add(amount));
		
		accountRepo.update(fromAcc);
		
		accountRepo.update(toAcc);
		
		
		
	}

	@Override
	public void withdraw(int accId, BigDecimal amount) {
		Account acc=getById(accId);
		acc.setBalance(acc.getBalance().subtract(amount));
		accountRepo.update(acc);
	}

	@Override
	public void deposit(int accId, BigDecimal amount) {
		Account acc=getById(accId);
		acc.setBalance(acc.getBalance().add(amount));
		accountRepo.update(acc);
	}

	@Override
	public Account getById(int accId) {
		Account account=accountRepo.getById(accId);
		if(account==null)
			throw new BankAccountNotFoundException("account with id "+ accId +" is not found");
		return account;
	}

}

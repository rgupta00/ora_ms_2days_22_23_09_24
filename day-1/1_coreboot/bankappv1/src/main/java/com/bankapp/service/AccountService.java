package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.repo.Account;
//BL=for which client is paying to u
//BL=FR + NFR
//   di   aop

public interface AccountService {
	public List<Account> getAllAccounts();
	public void transfer(int fromAccId, int toAccId, BigDecimal amount);
	public void withdraw(int accId, BigDecimal amount);
	public void deposit(int accId, BigDecimal amount);
	public Account getById(int accId);
	
}

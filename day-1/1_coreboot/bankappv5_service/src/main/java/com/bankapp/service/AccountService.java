package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.dto.AccountDto;
import com.bankapp.repo.Account;
//BL=for which client is paying to u
//BL=FR + NFR
//   di   aop

public interface AccountService {
	public List<AccountDto> getAllAccounts();
	public void transfer(int fromAccId, int toAccId, BigDecimal amount);
	public void withdraw(int accId, BigDecimal amount);
	public void deposit(int accId, BigDecimal amount);
	public AccountDto getById(int accId);
	public void addAccount(AccountDto accountDto);
	public void deleteAccount(int id);
	
}

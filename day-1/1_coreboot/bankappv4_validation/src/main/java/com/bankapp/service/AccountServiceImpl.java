package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dto.AccountDto;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.Account;
import com.bankapp.repo.AccountRepo;
import com.bankapp.util.DtoConvertor;
//? code couping : DI
@Service(value = "as")
@Transactional //AOP
public class AccountServiceImpl implements AccountService{

	private AccountRepo accountRepo;
	
	
	//push: i expecting spring should push the object of dao layer
	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		return accountRepo.findAll()
				.stream()
				.map(DtoConvertor::accountToDto)
				.toList();
	}

	//how much time this take to execute
	//Logging is CCC (concern that effect everyone): code tangling
	@Override
	public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
			
		Account fromAcc=DtoConvertor.accountDtoToAccount(getById(fromAccId));
		Account toAcc=DtoConvertor.accountDtoToAccount(getById(toAccId));
		fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
		toAcc.setBalance(toAcc.getBalance().add(amount));
		
		accountRepo.save(fromAcc);
		if(1==1)
			throw new RuntimeException("some hell problem");
		
		accountRepo.save(toAcc);
		
		
		
	}

	@Override
	public void withdraw(int accId, BigDecimal amount) {
		Account acc=DtoConvertor.accountDtoToAccount(getById(accId));
		acc.setBalance(acc.getBalance().subtract(amount));
		accountRepo.save(acc);
	}

	@Override
	public void deposit(int accId, BigDecimal amount) {
		Account acc=DtoConvertor.accountDtoToAccount(getById(accId));
		acc.setBalance(acc.getBalance().add(amount));
		accountRepo.save(acc);
	}

	@Override
	public AccountDto getById(int accId) {
		Account account=accountRepo.findById(accId)
				.orElseThrow(()->
				new BankAccountNotFoundException("account with id "+ accId +" is not found"));
		return DtoConvertor.accountToDto(account);
	}

	@Override
	public void addAccount(AccountDto accountDto) {
		
		accountRepo.save(DtoConvertor.accountDtoToAccount(accountDto));
	}

	@Override
	public void deleteAccount(int id) {
		Account account=DtoConvertor.accountDtoToAccount(getById(id));
		accountRepo.delete(account);
	}

}

package com.bankapp.util;

import com.bankapp.dto.AccountDto;
import com.bankapp.repo.Account;

public class DtoConvertor {

	public static AccountDto accountToDto(Account account) {
		AccountDto accountDto=new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setBalance(account.getBalance());
		accountDto.setName(account.getName());
		return accountDto;
	}
	public static Account accountDtoToAccount(AccountDto accountDto) {
		Account account=new Account();
		account.setId(accountDto.getId());
		account.setBalance(accountDto.getBalance());
		account.setName(accountDto.getName());
		return account;
	}
}

package com.bankapp.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public class AccountRepoMapImpl implements AccountRepo{
	
	public Map<Integer, Account> accountMap=new HashMap<>();

	public AccountRepoMapImpl() {
        accountMap.put(1, new Account(1,"raj",BigDecimal.valueOf(6000.00)));
        accountMap.put(2, new Account(2,"ekta",BigDecimal.valueOf(6000.00)));
	}
	
	@Override
	public List<Account> getAll() {
		System.out.println("it is a map impl");
		return new ArrayList<>(accountMap.values());
	}

	@Override
	public void update(Account account) {
		accountMap.put(account.getId(), account);
	}

	@Override
	public Account getById(int id) {
		return accountMap.get(id);
	}

}

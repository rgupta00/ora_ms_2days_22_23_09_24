package com.bankapp.repo;

import java.util.List;
//DAO layer is just like ramu and shyamu in a chemist shop
// which can be automize ( U DONT HAVE TO WRITE THE CODE)
//U NEED TO JUST DECLARE IT: SPRING DATA

public interface AccountRepo {
    public List<Account>getAll();
	public void update(Account account);
	public Account getById(int id);
}

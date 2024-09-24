package com.bankapp.clientproxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bankapp.dto.AccountDto;

@FeignClient(name="bankclient", url = "http://localhost:8090")
public interface BankRestProxyClient {
	@GetMapping(path = "accounts")
	public ResponseEntity<List<AccountDto>> getAccounts();
	
	@GetMapping(path = "accounts/{id}")
	public ResponseEntity<AccountDto> getAccounts(@PathVariable int id);
}

package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;

@RestController
public class AccountTxOpController {

	@Autowired
	private AccountService accountService;
	
//	@Value("${TRANSFER_SUCCESS_MSG}")
//	private String message;
	
	@Autowired
	private Environment environment;

	//transfer
	//@RequestBody force paser 
	@PostMapping(path = "transfer")
	public ResponseEntity<String> transfer(@RequestBody TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(),
				transferDto.getToAccId(), transferDto.getAmount());
		
//		String message= "fund trasnsfer successfully";
		
		return ResponseEntity.status(HttpStatus.OK).body(environment.getProperty("TRANSFER_SUCCESS_MSG"));
		
	}
	//deposit
	@PostMapping(path = "deposit")
	public ResponseEntity<String> deposit(@RequestBody DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());;
		return ResponseEntity.status(HttpStatus.OK)
				.body(environment.getProperty("DEPOSIT_SUCCESS_MSG"));
		
	}
	
	//withdraw
	@PostMapping(path = "withdraw")
	public ResponseEntity<String> withdraw(@RequestBody WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());;
		return ResponseEntity.status(HttpStatus.OK)
				.body(environment.getProperty("WITHDRAW_SUCCESS_MSG"));
		
	}
	
}

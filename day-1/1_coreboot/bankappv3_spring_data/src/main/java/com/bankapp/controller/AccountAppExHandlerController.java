package com.bankapp.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankapp.dto.ErrorMessageDto;
import com.bankapp.exceptions.BankAccountNotFoundException;

@RestControllerAdvice //AOP
public class AccountAppExHandlerController {

	@ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorMessageDto>handle404(BankAccountNotFoundException ex){
		System.out.println("-----------------------------------------");
		ErrorMessageDto dto=new ErrorMessageDto();
		dto.setErrorMessage(ex.getMessage());
		dto.setStatus(HttpStatus.NOT_FOUND.toString());
		dto.setTimpStamp(LocalDateTime.now());
		dto.setToContact("rgupta.mtech@gmail.com");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
	}
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorMessageDto>handle500(Exception ex){
//		System.out.println("-----------------------------------------");
//		ErrorMessageDto dto=new ErrorMessageDto();
//		dto.setErrorMessage("pls try after some time");
//		dto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
//		dto.setTimpStamp(LocalDateTime.now());
//		dto.setToContact("rgupta.mtech@gmail.com");
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
//	}
}

package com.bankapp.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
//validation should be on this class
public class AccountDto {
	
    private int id;
    @NotNull(message = "{accountDto.name.absent}")
    private String name;
    
    @NotNull(message = "{accountDto.balance.absent}")
	@Range(min = 100, max = 100000, message = "{accountDto.balance.invalid}")
    private BigDecimal balance;
    
	public AccountDto(String name, BigDecimal balance) {
		this.name = name;
		this.balance = balance;
	}
    
    

}

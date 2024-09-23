package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WithdrawDto {
	private int accId;
	private BigDecimal amount;
}

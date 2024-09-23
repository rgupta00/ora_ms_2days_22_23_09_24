package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferDto {
	private int fromAccId;
	private int toAccId;
	private BigDecimal amount;
}

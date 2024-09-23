package com.bankapp.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ErrorMessageDto {
	private LocalDateTime timpStamp;
	private String  status;
	private String errorMessage;
	private String toContact;
}

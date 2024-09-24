package com.customer.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class CustomerDto {
	private int id;
	private String name;
	private String email;

	public CustomerDto(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
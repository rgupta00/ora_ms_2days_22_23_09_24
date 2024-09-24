package com.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	private int id;
	private String name;
	private double price;

	public ProductDto(String name, double price) {
		this.name = name;
		this.price = price;
	}
}

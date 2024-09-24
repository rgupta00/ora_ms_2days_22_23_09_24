package com.order.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
	private String id;
	private double totalPrice;
	private LocalDateTime orderDate;
	private CustomerDto customer;
	private ProductDto product;

}

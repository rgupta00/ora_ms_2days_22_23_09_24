package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.ConfigDto;
import com.order.dto.OrderRequest;
import com.order.dto.OrderResponse;
import com.order.service.BookOrderService;

@RestController
public class OrderRestController {


	@Autowired
	private ConfigDto configDto;
	
	@Autowired
	private BookOrderService bookOrderService;

	@GetMapping(path = "configdto")
	public ConfigDto getConfigDto(){
		return configDto;
	}
	
	@PostMapping(path="orders")
	public ResponseEntity<OrderResponse> submitOrder(@RequestBody OrderRequest orderRequest){
		return  ResponseEntity.status(HttpStatus.CREATED).body(bookOrderService.bookAnOrder(orderRequest));
	}
}

package com.order.controller;

import com.order.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class OrderRestController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ConfigDto configDto;

	@GetMapping(path = "configdto")
	public ConfigDto getConfigDto(){
		return configDto;
	}
	
	@PostMapping(path="orders")
	public ResponseEntity<OrderResponse> submitOrder(@RequestBody OrderRequest orderRequest){
		
		CustomerDto customerDto=restTemplate.getForObject("http://localhost:8081/customers/"+
				orderRequest.getCid(), 
				CustomerDto.class);
	
		ProductDto productDto=restTemplate.getForObject("http://localhost:8082/products/"+
				orderRequest.getPid(), 
				ProductDto.class);
		CouponDto couponDto=restTemplate.getForObject("http://localhost:8085/couponbycode/"+ 
				orderRequest.getCouponCode(), CouponDto.class);
		
		OrderResponse orderResponse=new OrderResponse();
		orderResponse.setCustomer(customerDto);
		orderResponse.setProduct(productDto);
		orderResponse.setId(UUID.randomUUID().toString());
		orderResponse.setOrderDate(LocalDateTime.now());
		
		orderResponse.setTotalPrice(productDto.getPrice()*orderRequest.getQuantity());
		
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
		
	}

}

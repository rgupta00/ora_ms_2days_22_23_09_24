package com.order.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.CouponDto;
import com.order.dto.CustomerDto;
import com.order.dto.OrderRequest;
import com.order.dto.OrderResponse;
import com.order.dto.ProductDto;
import com.order.service.BookOrderService;
import com.order.service.CouponService;
import com.order.service.CustomerService;
import com.order.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookOrderServiceImpl implements BookOrderService{
	private final CouponService couponService;
	private final ProductService productService;
	private final CustomerService customerService;
	
	@Override
	public OrderResponse bookAnOrder(OrderRequest orderRequest) {
		CustomerDto customerDto=customerService.getCustomerDto(orderRequest.getCid());
	
		ProductDto productDto=productService.getProductDto(orderRequest.getPid());
				
		CouponDto couponDto=couponService.getCouponDto(orderRequest.getCouponCode());
		
		OrderResponse orderResponse=new OrderResponse();
		orderResponse.setCustomer(customerDto);
		orderResponse.setProduct(productDto);
		orderResponse.setId(UUID.randomUUID().toString());
		orderResponse.setOrderDate(LocalDateTime.now());
		//pls write logic to cal discount and - from total
		orderResponse.setTotalPrice(productDto.getPrice()*orderRequest.getQuantity());
		return orderResponse;
	}

}

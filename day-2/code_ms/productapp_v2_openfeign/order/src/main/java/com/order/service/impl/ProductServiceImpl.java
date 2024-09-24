package com.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.ProductDto;
import com.order.feignproxy.ProductServiceProxy;
import com.order.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductServiceProxy productServiceProxy;
	
	@Override
	public ProductDto getProductDto(int productId) {
		return productServiceProxy.getAnProduct(productId);
	}

}

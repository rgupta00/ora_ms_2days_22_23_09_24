package com.order.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.dto.ProductDto;

@FeignClient(name="PRODUCTS")
public interface ProductServiceProxy {
	@GetMapping(path = "products/{id}")
	public ProductDto getAnProduct(@PathVariable(name = "id") int id);

}

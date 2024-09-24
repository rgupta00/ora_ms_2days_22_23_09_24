package com.product.controller;

import com.product.dto.ConfigDto;
import com.product.dto.ProductDto;
import com.product.entities.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ConfigDto configDto;

	@GetMapping(path = "configdto")
	public ConfigDto getConfigDto(){
		return configDto;
	}
	@GetMapping(path = "products")
	public List<ProductDto> getAll(){
		return productService.getAllProduct();
	}
	
	@GetMapping(path = "products/{id}")
	public ProductDto getAnProduct(@PathVariable(name = "id") int id){
		return productService.getProductById(id);
	}
}

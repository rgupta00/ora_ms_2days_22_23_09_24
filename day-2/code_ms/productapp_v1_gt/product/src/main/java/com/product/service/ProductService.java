package com.product.service;

import com.product.dto.ProductDto;
import com.product.entities.Product;

import java.util.List;

public interface ProductService {
	public List<ProductDto> getAllProduct();
	public ProductDto addProduct(ProductDto productDto);
	public ProductDto getProductById(int id);
}

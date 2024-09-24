package com.product.service;

import com.product.dto.ProductDto;
import com.product.exceptions.ProductNotFoundException;
import com.product.entities.Product;
import com.product.repo.ProductRepo;
import com.product.util.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public List<ProductDto> getAllProduct() {
		return productRepo.findAll().stream().map(ProductConverter::entityToDto).toList();
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product productToAdd=ProductConverter.dtoToEntity(productDto);
		productRepo.save(productToAdd);
		return ProductConverter.entityToDto(productToAdd);
	}

	@Override
	public ProductDto getProductById(int id) {
		return productRepo.findById(id)
				.map(ProductConverter::entityToDto)
				.orElseThrow(ProductNotFoundException::new );
	}

}
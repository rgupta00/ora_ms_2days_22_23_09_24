package com.customer.service;

import com.customer.dto.CustomerDto;
import com.customer.exception.CustomerNotFoundException;
import com.customer.entities.Customer;
import com.customer.repo.CustomerRepo;
import com.customer.util.CustomerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public List<CustomerDto> getAllCustomer() {
		return customerRepo.findAll()
				.stream()
				.map(CustomerConverter::entityToDto).toList();
	}

	@Override
	public CustomerDto addCustomer(CustomerDto customerDto) {
		Customer customerToAdd= CustomerConverter.dtoToEntity(customerDto);
		 customerRepo.save(customerToAdd);
		 return CustomerConverter.entityToDto(customerToAdd);
	}

	@Override
	public CustomerDto getCustomerById(int id) {
		return customerRepo.findById(id)
				.map(CustomerConverter::entityToDto)
				.orElseThrow(CustomerNotFoundException:: new);
	}

}
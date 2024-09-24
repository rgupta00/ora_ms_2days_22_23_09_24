package com.customer.service;

import com.customer.dto.CustomerDto;
import com.customer.entities.Customer;

import java.util.List;

public interface CustomerService {
	public List<CustomerDto> getAllCustomer();
	public CustomerDto addCustomer(CustomerDto customerDto);
	public CustomerDto getCustomerById(int id);
}
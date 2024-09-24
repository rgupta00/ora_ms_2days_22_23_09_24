package com.customer.controller;

import com.customer.dto.ConfigDto;
import com.customer.dto.CustomerDto;
import com.customer.entities.Customer;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ConfigDto configDto;

	@GetMapping(path = "configdto")
	public ConfigDto getConfigDto(){
		return configDto;
	}

	@GetMapping(path = "customers")
	public List<CustomerDto> getAll(){
		return customerService.getAllCustomer();
	}
	
	@GetMapping(path = "customers/{id}")
	public CustomerDto getAnCustomer(@PathVariable(name = "id") int id){
		return customerService.getCustomerById(id);
	}
}
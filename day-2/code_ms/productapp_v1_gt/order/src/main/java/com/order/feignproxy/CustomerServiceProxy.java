package com.order.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.dto.CustomerDto;

@FeignClient(name="CUSTOMERS" )
public interface CustomerServiceProxy {
	@GetMapping(path = "customers/{id}")
	public CustomerDto getAnCustomer(@PathVariable(name = "id") int id);
}

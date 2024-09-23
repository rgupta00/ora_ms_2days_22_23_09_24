package com.customer;

import com.customer.dto.ConfigDto;
import com.customer.dto.CustomerDto;
import com.customer.entities.Customer;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ConfigDto.class)
@SpringBootApplication
public class CustomerApplication implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.addCustomer(new CustomerDto("raj", "raj@gmail.com"));
		customerService.addCustomer(new CustomerDto("ekta", "ekta@gmail.com"));
	}
}

package com.customer.util;

import com.customer.dto.CustomerDto;
import com.customer.entities.Customer;

public class CustomerConverter {

    public static Customer dtoToEntity(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }
    public static CustomerDto entityToDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }
}

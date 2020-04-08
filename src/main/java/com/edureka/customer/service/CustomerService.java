package com.edureka.customer.service;

import java.util.List;

import com.edureka.customer.dto.CustomerDto;

public interface CustomerService {

	 List<CustomerDto> listCustomers();
	
	 CustomerDto addCustomer(CustomerDto customerDto);
	
	 CustomerDto customerDetails(String customerId);

}

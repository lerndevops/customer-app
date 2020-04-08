package com.edureka.customer.business;

import java.util.List;

import com.edureka.customer.dto.CustomerDto;

public interface CustomerBusinessService {

	List<CustomerDto> getAllCustomers();

	CustomerDto addCustomer(CustomerDto customerDto);

	CustomerDto getCustomerDetails(String customerId);

}

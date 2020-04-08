package com.edureka.customer.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edureka.customer.business.CustomerBusinessService;
import com.edureka.customer.dao.CustomerRepository;
import com.edureka.customer.dto.CustomerDto;
import com.edureka.customer.entity.Customer;
import com.edureka.customer.util.CustomerUtil;

@Service
public class CustomerBusinessServiceImpl implements CustomerBusinessService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerUtil customerUtil;

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDto> customerDtoList = customerUtil.convertCustomerToCustomerDtoList(customers);
		return customerDtoList;
	}

	@Override
	public CustomerDto addCustomer(CustomerDto customerDto) {
		Customer customer = customerRepository.save(customerUtil.convertCustomerDtoToCustomer(customerDto));
		return customerUtil.convertCustomerToCustomerDto(customer);
	}

	@Override
	public CustomerDto getCustomerDetails(String customerId) {
		Customer customer = customerRepository.findByCustomerId(customerId);
		return customerUtil.convertCustomerToCustomerDto(customer);
	}

}

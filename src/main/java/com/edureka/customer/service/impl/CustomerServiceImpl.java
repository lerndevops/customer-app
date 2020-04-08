package com.edureka.customer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.customer.business.CustomerBusinessService;
import com.edureka.customer.dto.CustomerDto;
import com.edureka.customer.service.CustomerService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/customer")
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerBusinessService customerBusinessService;
	
	
	@GetMapping(value = "/all",produces = "application/json")
	public List<CustomerDto> listCustomers(){
		logger.info("inside listCustomers");
		List<CustomerDto> customerList = customerBusinessService.getAllCustomers();
		return customerList;
	}
	
	@PostMapping(value = "/add",consumes = "application/json", produces = "application/json")
	public CustomerDto addCustomer(@RequestBody CustomerDto customerDto){
		logger.info("inside createUserProfile......before calling getUserProfile bussinessService...");
		CustomerDto customer = customerBusinessService.addCustomer(customerDto);
		return customer;
	}
	
	@GetMapping(value = "/details/{customerId}",produces = "application/json")
	public CustomerDto customerDetails(@PathVariable("customerId") String customerId){
		logger.info("inside listCustomers");
		CustomerDto customer = customerBusinessService.getCustomerDetails(customerId);
		return customer;
	}

}

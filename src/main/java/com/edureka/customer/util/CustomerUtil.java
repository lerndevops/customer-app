package com.edureka.customer.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.edureka.customer.dto.CustomerDto;
import com.edureka.customer.entity.Customer;

@Component
public class CustomerUtil {

	public List<CustomerDto> convertCustomerToCustomerDtoList(List<Customer> customers) {
		List<CustomerDto> customerDtoList = null;
		if(null != customers) {
			customerDtoList = new ArrayList<CustomerDto>();
			for(Customer customer: customers) {
				CustomerDto customerDto = this.convertCustomerToCustomerDto(customer);
				customerDtoList.add(customerDto);
			}
		}
		return customerDtoList;
	}

	public  CustomerDto convertCustomerToCustomerDto(Customer customer) {
		CustomerDto customerDto = null;
		if(null != customer) {
			customerDto= new CustomerDto();
			customerDto.setAge(customer.getAge());
			customerDto.setCustomerId(customer.getCustomerId());
			customerDto.setCustomerName(customer.getCustomerName());
			customerDto.setEmailId(customer.getEmailId());
			customerDto.setFirstName(customer.getFirstName());
			customerDto.setLastName(customer.getLastName());
			customerDto.setMobileNo(customer.getMobileNo());
		}
		return customerDto;
	}
	
	public  Customer convertCustomerDtoToCustomer(CustomerDto customerDto) {
		Customer customer = null;
		if(null != customerDto) {
			customer= new Customer();
			customer.setAge(customerDto.getAge());
			customer.setCustomerId(customerDto.getCustomerId());
			customer.setCustomerName(customerDto.getCustomerName());
			customer.setEmailId(customerDto.getEmailId());
			customer.setFirstName(customerDto.getFirstName());
			customer.setLastName(customerDto.getLastName());
			customer.setMobileNo(customerDto.getMobileNo());
		}
		return customer;
	}

}

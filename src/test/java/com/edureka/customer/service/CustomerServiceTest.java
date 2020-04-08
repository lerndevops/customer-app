package com.edureka.customer.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.edureka.customer.business.CustomerBusinessService;
import com.edureka.customer.business.impl.CustomerBusinessServiceImpl;
import com.edureka.customer.dao.CustomerRepository;
import com.edureka.customer.dto.CustomerDto;
import com.edureka.customer.entity.Customer;
import com.edureka.customer.service.impl.CustomerServiceImpl;
import com.edureka.customer.util.CustomerUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Mock
	private CustomerRepository customerRepository;
	
	private CustomerService customerService = new CustomerServiceImpl();

	@InjectMocks
	private CustomerBusinessService customerBusinessService = new CustomerBusinessServiceImpl();
	
	private CustomerUtil customerUtil = new CustomerUtil();
	
	private Customer customer;
	
	private CustomerDto customerDto;
	
	private List<Customer> customers;
	

	@Before
	public void init() {
		this.initMockObjects();
		ReflectionTestUtils.setField(this.customerService,"customerBusinessService",customerBusinessService);
		ReflectionTestUtils.setField(this.customerBusinessService,"customerRepository",customerRepository);
		ReflectionTestUtils.setField(this.customerBusinessService,"customerUtil",customerUtil);
	}

	private void initMockObjects() {
		customer= new Customer();
		customer.setAge(28);
		customer.setCustomerId("cust1");
		customer.setCustomerName("John");
		customer.setEmailId("john.doe@gmail.com");
		customer.setFirstName("john");
		customer.setLastName("doe");
		customer.setMobileNo("9876543210");
		customerDto= new CustomerDto();
		customerDto.setAge(customer.getAge());
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setCustomerName(customer.getCustomerName());
		customerDto.setEmailId(customer.getEmailId());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setMobileNo(customer.getMobileNo());
		customers = new ArrayList<>();
		customers.add(customer);
	}

	@Test
	public void testGetCustomerDetails() {
		when(customerRepository.findByCustomerId("cust1")).thenReturn(customer);
		CustomerDto  result = customerService.customerDetails("cust1");
		assertEquals("cust1", result.getCustomerId());
	}
	
	@Test
	public void testListCustomers() {
		when(customerRepository.findAll()).thenReturn(customers);
		List<CustomerDto>  result = customerService.listCustomers();
		assertEquals(result.size(),customers.size());
	}
	
	@Test
	public void testAddCustomer() {
		when(customerRepository.save(Matchers.any())).thenReturn(customer);
		CustomerDto  result = customerService.addCustomer(customerDto);
		assertEquals("cust1",result.getCustomerId());
	}

}

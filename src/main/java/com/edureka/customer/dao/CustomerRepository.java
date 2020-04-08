package com.edureka.customer.dao;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edureka.customer.entity.Customer;

@Repository
@Table(name = "customer")
public interface CustomerRepository extends JpaRepository<Customer, String> {

	Customer findByCustomerId(String customerId);

}

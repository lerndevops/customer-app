package com.edureka.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = "com.edureka")
public class CustomerApplication extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer
{
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CustomerApplication.class);
	}
}

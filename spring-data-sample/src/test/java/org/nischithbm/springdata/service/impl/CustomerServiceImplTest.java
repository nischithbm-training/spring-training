package org.nischithbm.springdata.service.impl;

import java.util.List;

import org.nischithbm.springdata.dto.Customer;
import org.nischithbm.springdata.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


@ContextConfiguration(locations = { "classpath:spring-configuration.xml" })
public class CustomerServiceImplTest extends AbstractTestNGSpringContextTests {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImplTest.class);
	
	@Autowired
	private CustomerService customerService;
	
	@Test
	public void testFoo() throws Exception {
		System.out.println("Hello");
		Customer c1 = buildCustomer("Spider", "Man", "sprider.man@abc.star.com");
		
		Customer savedC1 = customerService.createCustomer(c1);
		System.out.println(savedC1);

		Customer searchedC1 = customerService.getCustomerById(savedC1.getCustomerId());
		System.out.println(searchedC1);
		
		
		customerService.createCustomer(buildCustomer("Bat", "Man", "bat.man@abc.star.com"));
		customerService.createCustomer(buildCustomer("Iron", "Man", null));
		customerService.createCustomer(buildCustomer("Super", "Man", null));

		List<Customer> allCustomers = customerService.getAllCustomers();
		System.out.println(allCustomers);
		
		long count = customerService.markCustomersWithNoEmailAsInactive();
		System.out.println("Updated records" + count);
	
		List<Customer> allCustomersAfterUpdation = customerService.getAllCustomers();
		System.out.println(allCustomersAfterUpdation);
	}

	private Customer buildCustomer(String firstName, String lastName, String email) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		return customer;
	}
}

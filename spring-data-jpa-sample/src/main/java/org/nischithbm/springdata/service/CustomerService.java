package org.nischithbm.springdata.service;

import java.util.List;

import org.nischithbm.springdata.dto.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer) throws Exception;
	
	Customer getCustomerById(Long customerId) throws Exception;

	
	List<Customer> getAllCustomers() throws Exception;

	long markCustomersWithNoEmailAsInactive() throws Exception;
	
}

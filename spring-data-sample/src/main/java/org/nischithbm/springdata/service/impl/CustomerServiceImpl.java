package org.nischithbm.springdata.service.impl;

import java.util.List;

import org.nischithbm.springdata.dto.Customer;
import org.nischithbm.springdata.repository.CustomerRepository;
import org.nischithbm.springdata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true, rollbackFor = { Exception.class })
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional(rollbackFor = { Exception.class })
	public Customer createCustomer(Customer customer) throws Exception {
		// Validate customer
		return customerRepository.save(customer);
	}
	public Customer getCustomerById(Long customerId) throws Exception {
		return customerRepository.findOne(customerId);
	}

	public List<Customer> getAllCustomers() throws Exception {
		return customerRepository.findAll();
	}

	public long markCustomersWithNoEmailAsInactive() throws Exception {
		return customerRepository.markCustomersWithNoEmailAsInactive();
	}
}

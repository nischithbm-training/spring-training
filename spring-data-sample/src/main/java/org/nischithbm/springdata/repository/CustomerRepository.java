package org.nischithbm.springdata.repository;

import org.nischithbm.springdata.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface CustomerRepository extends JpaRepository<Customer, Long>,
											 QueryDslPredicateExecutor<Customer>,
											 CustomerRepositoryCustom {
	
}

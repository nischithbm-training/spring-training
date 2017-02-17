package org.nischithbm.springdata.repository.impl;

import org.nischithbm.springdata.dto.Customer;
import org.nischithbm.springdata.dto.QCustomer;
import org.nischithbm.springdata.enums.CustomerStatusEnum;
import org.nischithbm.springdata.repository.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class CustomerRepositoryImpl extends QueryDslRepositorySupport 
									implements CustomerRepositoryCustom {

	private static QCustomer customer = QCustomer.customer;

	public CustomerRepositoryImpl() {
		super(Customer.class);
	}

	public long markCustomersWithNoEmailAsInactive() {
		return update(customer)
				.set(customer.status, CustomerStatusEnum.Inactive)
				.where(customer.email.isNull())
				.execute();
	}
	
}

package com.abc.service;

import com.abc.dto.Customerdto;
import com.abc.model.Customer;

public interface Customerservice {

	public Object validateUser(Customer customer);

	public Object getAllCustomer();

	public Object getCustomer(int customerId);

	public Object updateById(Customerdto customerDto);

	
	
}

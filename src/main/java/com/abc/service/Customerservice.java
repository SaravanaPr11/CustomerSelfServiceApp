package com.abc.service;

import com.abc.dto.CustomerValidateDTO;
import com.abc.dto.Customerdto;

public interface Customerservice {

	public Object getCustomer(int customerId);

	public Object updateById(Customerdto customerdto);

	public Object validateUser(CustomerValidateDTO customer);

}

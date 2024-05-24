package com.abcbankk.service;

import com.abcbankk.dto.CustomerValidateDTO;
import com.abcbankk.dto.Customerdto;

public interface Customerservice {

	public Object getCustomer(int customerId);

	public Object updateById(Customerdto customerdto);

	public Object validateUser(CustomerValidateDTO customer);

}

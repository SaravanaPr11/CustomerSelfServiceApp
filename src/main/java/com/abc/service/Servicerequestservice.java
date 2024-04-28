package com.abc.service;

import com.abc.dto.Servicerequestdto;

public interface Servicerequestservice {
	
	public Object getbyserviceid(Servicerequestdto dto);

	public Object getaccountalldetails(int customerId);

}

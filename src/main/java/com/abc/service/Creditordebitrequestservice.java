package com.abc.service;

import com.abc.dto.Creditordebitrequestdto;

public interface Creditordebitrequestservice {

	public Object saveCreditordebitrequest(Creditordebitrequestdto creditdebitDto);
	
	public Object getAllCreditordebitRequest();

	public Object getbyId(int cDid);

	public Object saverequest(Creditordebitrequestdto creditrequest);

}

package com.abcbankk.service;

import com.abcbankk.dto.CreditordebitRequestDto;

public interface CreditordebitRequestService {

	public Object getAllCreditordebitRequest(long accountNumber);

	public Object getbyId(int customerId);

	public Object saverequest(CreditordebitRequestDto creditrequest);

}

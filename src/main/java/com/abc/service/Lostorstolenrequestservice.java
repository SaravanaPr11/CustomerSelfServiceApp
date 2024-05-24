package com.abcbankk.service;

import com.abcbankk.dto.LostorstolenRequestDto;

public interface LostorstolenRequestService {


	public Object getbycustomerid(int customer_id);

	public Object savelostcard(LostorstolenRequestDto dtos);

	public Object getbyAccountNumber(long accountNumber);

}

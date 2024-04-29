package com.abc.service;

import com.abc.dto.Lostorstolendto;

public interface Lostorstolenrequestservice {
	

	public Object getbycustomerid(int customerid);

	public Object savelostcard(Lostorstolendto dtos);

}

package com.abc.service;

import com.abc.dto.Lostorstolenrequestdto;

public interface Lostorstolenrequestservice {

	public Object getbycustomerid(int customerId);

	public Object savelostcard(Lostorstolenrequestdto dtos);

}

package com.abc.service;

import com.abc.dto.ChequebookRequestDto;

public interface ChequebookRequestService {


	public Object getcardById(long accountNumber);

	public Object saveRequest(ChequebookRequestDto chequebookrequestdto);

}

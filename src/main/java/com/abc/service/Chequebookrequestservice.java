package com.abcbankk.service;

import com.abcbankk.dto.ChequebookRequestDto;

public interface ChequebookRequestService {


	public Object getcardById(long accountNumber);

	public Object saveRequest(ChequebookRequestDto chequebookrequestdto);

}

package com.abc.service;

import com.abc.dto.Chequebookrequestdto;
import com.abc.model.Chequebookrequest;

public interface Chequebookrequestservice {

	public Object saveCheque(Chequebookrequest chequebookrequest);

	public Object getAllcard();

	public Object getcardById(int id);

	public Object saveRequest(Chequebookrequestdto chequebookrequestdto);

}

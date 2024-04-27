package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.xml.bind.JAXBException; 
import com.abc.dto.Chequebookrequestdto;
import com.abc.model.Chequebookrequest;
import com.abc.service.Chequebookrequestservice;

@RestController
public class Chequebookrequestcontroller {
	
	@Autowired
	private Chequebookrequestservice chequebookrequestservice;
	
	@PostMapping("/saveCheque")
	public Object saveCheque(@RequestBody Chequebookrequest chequebookrequest) {
		return (chequebookrequestservice.saveCheque(chequebookrequest));
	}
	
	@GetMapping("/getCard")
	public Object getCard() {
		return (chequebookrequestservice.getAllcard());
	}
	
	@GetMapping("/getbyid/{id}")
	public Object getCardById(@PathVariable int id) {
		return (chequebookrequestservice.getcardById(id));
	}
	@PostMapping("/postcardRequest")
	public Object saveCardRequest(@RequestBody Chequebookrequestdto chequebookrequestdto) throws JAXBException, InstantiationException, IllegalAccessException{
		return(chequebookrequestservice.saveRequest(chequebookrequestdto));
	}
}

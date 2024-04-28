package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.Creditordebitrequestdto;
import com.abc.service.Creditordebitrequestservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class Creditordebitrequestcontroller {

	@Autowired
	private Creditordebitrequestservice creditordebitrequestservice;
      
//	@PostMapping("/savecreditordebit")
//	public 	Object savecreditordebitrequest(@RequestBody Creditordebitrequestdto creditordebitrequestdto) {
//		return (creditordebitrequestdto.saveCreditordebitrequest(creditordebitrequestdto));
//	}
//	
	@GetMapping("/getcreditordebit")
	public Object getcreditordebitrequest() {
		return(creditordebitrequestservice.getAllCreditordebitRequest());
	}
	
	@GetMapping("/getbyid/{CDid}")
	public Object getbycustomerid(@PathVariable int CDid){
		return(creditordebitrequestservice.getbyId(CDid));
	}
	
	@PostMapping("/savecardrequest")
	public Object saveCardrequest(@RequestBody Creditordebitrequestdto creditrequest) {
	
		return (creditordebitrequestservice.saverequest(creditrequest));
	}
	
	
}

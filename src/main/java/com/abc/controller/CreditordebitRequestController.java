package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.CreditordebitRequestDto;
import com.abc.service.CreditordebitRequestService;


@CrossOrigin
@RestController
public class CreditordebitRequestController {

	@Autowired
	private CreditordebitRequestService creditordebitRequestService;

	@GetMapping("/getcreditordebit/{accountNumber}")
	public Object getcreditordebitrequest(@PathVariable long accountNumber) {
		return(creditordebitRequestService.getAllCreditordebitRequest(accountNumber));
	}

	@GetMapping("/getlistofAccountbyCustomerId/{customerId}")
	public Object getbycustomerid(@PathVariable int customerId){
		return(creditordebitRequestService.getbyId(customerId));
	}

	@PostMapping("/savecardrequest")
	public Object saveCardrequest(@RequestBody CreditordebitRequestDto creditrequest) {

		return (creditordebitRequestService.saverequest(creditrequest));
	}
}



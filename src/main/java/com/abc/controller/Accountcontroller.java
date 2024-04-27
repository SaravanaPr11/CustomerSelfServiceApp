package com.abc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abc.service.Accountservice;

@CrossOrigin
@RestController
public class Accountcontroller {
	
	private Accountservice myAccountService;
	
	public Object getaccountDetails(@PathVariable int customerId)
	{
		return(myAccountService.getaccountdetails(customerId));
	}
	
}
package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.Servicerequestdto;
import com.abc.model.Servicerequest;
import com.abc.service.Servicerequestservice;

@CrossOrigin
@RestController
public class Servicerequestcontroller {
	
	@Autowired
private Servicerequestservice requestService;
	
	@PostMapping(" /getbyseviceid  ")
	public Object getbyserviceid(@RequestBody Servicerequestdto dto)
	{
	return(requestService.getbyserviceid(dto));
	}
	
	@GetMapping(" /accnumbers/{customerId}")
	public Object getaccountDetails(@PathVariable int customerId)
	{
	return(requestService.getaccountalldetails(customerId));
	}
}


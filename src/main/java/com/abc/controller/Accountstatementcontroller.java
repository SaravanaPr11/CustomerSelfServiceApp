package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abc.service.Accountstatementservice;

@CrossOrigin
@RestController
public class Accountstatementcontroller {
	
	@Autowired
	private Accountstatementservice statementService;

	@GetMapping(" /getstatement/{accountNumber}")
	public Object getStatement(@PathVariable long accountNumber)
	{
	return(statementService.getstatement(accountNumber));

	}
}

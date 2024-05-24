package com.abcbankk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.abcbankk.dto.LostorstolenRequestDto;
import com.abcbankk.service.LostorstolenRequestService;

@CrossOrigin
@RestController
public class LostorstolenRequestController {

	@Autowired
	private LostorstolenRequestService lostorstolenRequestService;

	@GetMapping("/fetchAcc/{customer_id}")
	public Object getbyCustomerId(@PathVariable int customer_id) {
		return (lostorstolenRequestService.getbycustomerid(customer_id));
	}

	@PostMapping("/savelost")
	public Object savelost(@RequestBody LostorstolenRequestDto dtos)

	{
		return (lostorstolenRequestService.savelostcard(dtos));

	}

	@GetMapping("/listofStolenREquest/{accountNumber}")
	public Object getByAccountNumber(@PathVariable long accountNumber) {
		return (lostorstolenRequestService.getbyAccountNumber(accountNumber));
	}

}

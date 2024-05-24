package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.ChequebookRequestDto;
import com.abc.service.ChequebookRequestService;


@CrossOrigin
@RestController
public class ChequebookRequestController {

	@Autowired
	private ChequebookRequestService chequebookRequestService;

	@GetMapping("/getbyid/{accountNumber}")
	public Object getCardById(@PathVariable long accountNumber) {
		return (chequebookRequestService.getcardById(accountNumber));
	}
	@PostMapping("/postcardRequest")
	public Object saveCardRequest(@RequestBody ChequebookRequestDto chequebookrequestdto) {
		return(chequebookRequestService.saveRequest(chequebookrequestdto));
	}

}

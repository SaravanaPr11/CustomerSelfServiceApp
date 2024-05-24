package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.ServiceRequestDto;
import com.abc.service.ServiceRequestService;

@CrossOrigin
@RestController
public class ServiceRequestController {

	@Autowired
	private ServiceRequestService requestService;

	@PostMapping("/getbyserviceid")
	public Object getbyserviceid(@RequestBody ServiceRequestDto dto) {


		return(requestService.getbyserviceid(dto));
	}

}

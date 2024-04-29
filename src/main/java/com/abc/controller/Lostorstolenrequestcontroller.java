package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.Lostorstolenrequestdto;
import com.abc.service.Lostorstolenrequestservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class Lostorstolenrequestcontroller {

@Autowired
private Lostorstolenrequestservice lostorstolenrequestservice;	

  @GetMapping("/fetchAcc/{customerId}")
  public Object getbyCustomerId(@PathVariable int customerId) {
      return(lostorstolenrequestservice.getbycustomerid(customerId));
  }
  
  
  @PostMapping("/savelost")
  public Object savelost(@RequestBody Lostorstolenrequestdto dtos) {
     
      
      return(lostorstolenrequestservice.savelostcard(dtos));
  }
  
	
	
	
	
}

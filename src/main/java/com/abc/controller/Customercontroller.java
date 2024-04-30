package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.Customerdto;
import com.abc.service.Customerservice;
import com.abc.model.Customer;




@RestController
public class Customercontroller {

	
	@Autowired
	private Customerservice customerservice;
	
	@PostMapping("/validateUser")
	public Object login (@RequestBody Customer customer) {
		return customerservice.validateUser(customer);
		
	}
	
	@GetMapping("/getall")
	public Object getcustomer() {
		return(customerservice.getAllCustomer());
		}
	
	  @GetMapping("/getdetails/{customerID}")
      public Object getcustomerdetails(@PathVariable int customerID) {
          return (customerservice.getCustomer(customerID));
      }
	  
	  @PostMapping("/update")
	  public Object updateById(@RequestBody Customerdto customerdto) {
		  return(customerservice.updateById(customerdto));
	  }
	
}

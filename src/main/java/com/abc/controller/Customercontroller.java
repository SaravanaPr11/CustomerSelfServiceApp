package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.Customerdto;
import com.abc.model.*;
import com.abc.service.Customerservice;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class Customercontroller {
     @Autowired
     private Customerservice customerservice;
     
      @PostMapping("/validateUser")
      public Object login(@RequestBody Customer customer) {
    	  return customerservice.validateUser(customer);
      }
      
      @GetMapping("/getall")
      public Object getcustomer() {
    	  return(customerservice.getAllCustomer());
      }
      
      @GetMapping("/getdetails/{customerId}")
      public Object getcustomerdetails(@PathVariable int  customerId) {
          return (customerservice.getCustomer(customerId));
      }
      
      
     @PutMapping("/update")
    public Object updateById(@RequestBody Customerdto customerDto) {
    	 return (customerservice.updateById(customerDto));
     }
	
}

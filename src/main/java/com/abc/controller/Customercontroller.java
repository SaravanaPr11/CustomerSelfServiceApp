package com.abcbankk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcbankk.dto.CustomerValidateDTO;
import com.abcbankk.dto.Customerdto;
import com.abcbankk.service.Customerservice;

@CrossOrigin
@RestController
public class CustomerController {

	@Autowired
    private Customerservice customerservice;


    @PostMapping("/validateUser")
    public Object login(@RequestBody CustomerValidateDTO customer) {
        return customerservice.validateUser(customer);
    }

    @GetMapping("/getdetails/{customerId}")
    public Object getcustomerdetails(@PathVariable int customerId) {
        return (customerservice.getCustomer(customerId));
    }
    @PostMapping("/update")
	  public Object updateById(@RequestBody Customerdto customerdto) {
		  return(customerservice.updateById(customerdto));
	  }

}

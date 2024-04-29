package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;



import com.abc.dto.Lostorstolenrequestdto;

import com.abc.service.Lostorstolenrequestservice;



@RestController

public class Lostorstolenrequestcontroller {

	

	@Autowired

    private Lostorstolenrequestservice lostorstolenrequestService;



     @GetMapping("/fetchAcc/{customerid}")

       public Object getbyCustomerId(@PathVariable int customerid) {

           return (lostorstolenrequestService.getbycustomerid(customerid));

       }



//   @GetMapping("/getbyservicerequestId/{service_requestid}")

//   public Object getbyserviceId(@PathVariable int service_requestid) {

//       return (lostorstolenrequestService.getbyservicerequestid(servicerequestid));

//   }

//

   @PostMapping("/savelost")



    public Object savelost(@RequestBody Lostorstolenrequestdto dtos)



    {

        return(lostorstolenrequestService.savelostcard(dtos));



    }



}



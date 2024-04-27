package com.abc.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.abc.repository.Customerrepo;
import com.abc.model.Customer;
import com.abc.dto.Customerdto;
import com.abc.service.Customerservice;

@Service
public class Customerserviceimpl implements Customerservice {
 
	@Autowired
	private Customerrepo customerrepo;
	
	public Object getAllCustomer() {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Customer> customers= customerrepo.findAll();
	    
		
		for(Customer c:customers) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("CustomerId",c.getCustomerId() );
			map.put("Customer Name",c.getName());
			map.put("Customer UseName",c.getUserName());
			map.put("Customer Password",c.getPassword());
			map.put("Customer Dob",c.getDob());
			map.put("Customer PhoneNo",c.getPhoneNo());
			map.put("Customer DoorStreet",c.getDoorStreet());
			map.put("Customer City",c.getCity());
			map.put("Customer pincode",c.getPincode());
			map.put("Customer PanNo",c.getPanNo());
			map.put("Customer Email",c.getEmail());
			map.put("Customer State",c.getState());
			list.add(map);
			
		}
	return list;
	}
	
	
	public Object updateCustomer(Customer customer) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(customer.getName().isEmpty()) {
			map.put("Status", "Error!!!");
			map.put("Msg :","please Enter the Customer Name:");
		}
      
		else if (customer.getUserName().isEmpty()) {
			map.put("Status", "Error!!!");
			map.put("Msg :","please Enter the UserName:");
		}
	
		else if (customer.getPassword().isEmpty()) {
			map.put("Status", "Error!!!");
			map.put("Msg :","please Enter the Password:");
		}
		
		else if (customer.getDob()==null){
			map.put("Status", "Error!!!");
			map.put("Msg;","please Enter the Dob ");
		}
		
		else if (customer.getPhoneNo().isEmpty()){
			map.put("Status", "Error!!!");
			map.put("Msg;","please Enter the PhoneNumber ");
		}
		
		else if (customer.getDoorStreet().isEmpty()){
			map.put("Status", "Error!!!");
			map.put("Msg;","please Enter the Door/Street ");
		}
		
		else if (customer.getCity().isEmpty()){
			map.put("Status", "Error!!!");
			map.put("Msg;","please Enter the city name ");
		}
		
		else if (customer.getPincode().isEmpty()){
			map.put("Status", "Error!!!");
			map.put("Msg;","please Enter your Pincode ");
		}
		
		else if (customer.getPanNo().isEmpty()){
			map.put("Status", "Error!!!");
			map.put("Msg;","please Enter your PAN-No ");
		}
		
		else if (customer.getEmail().isEmpty()){
			map.put("Status", "Error!!!");
			map.put("Msg;","please Enter your EmailId");
		}
		else if (customer.getState().isEmpty()){
			map.put("Status", "Error!!!");
			map.put("Msg;","please Enter your State ");
		}
		else {
			customerrepo.save(customer);
			map.put("Status", "Success");
			map.put("Msg", "Data Update successfully");
		}
		return map;
		}
	@Override
	public Object validateUser(Customer customer) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName =customer.getUserName();
	    String password = customer.getPassword();
		
	    
	    Customer login = customerrepo.find(userName);
	    
	    if(login != null) {
	    	if(login.getPassword().equals(password)) {
	    		  map.put("Status", "Success");
                  map.put("Message", "Login Successful");
	    	}
	    	else {
	    		 map.put("Status", "Error!!!");
                 map.put("Message", "Invalid Password");
	    	}
	    }
	    else {
	    	   map.put("Status", "Error!!!");
               map.put("Message", "Invalid Username");
	    }
	    return map;
	}
	
	
	@Override
	public Object updateById(Customerdto customerdto) {
		Map<String, Object> map = new HashMap<String, Object>();
		Customer customer= customerrepo.findById(customerdto.getId()).orElse(null);
		if(customer!=null) {
			customer.setDoorStreet(customerdto.getDoorStreet());
			customer.setCity(customerdto.getCity());
			customer.setPincode(customerdto.getPincode());
			customer.setPhoneNo(customerdto.getPhoneNo());
			customer.setEmail(customerdto.getEmail());
	        
			customerrepo.saveAndFlush(customer);
			map.put("Status", "Success");
			map.put("Message", "Customer Id Updated Successfully");
		}else {
			map.put("Statu", "Error!!!");
			map.put("Message", "Invalid customer Id");
		}
		return map;
	}

	
	@Override
	public Object getCustomer(int customerId) {
		
		Map<String, Object>map = new HashMap<>();
		Customer customer = customerrepo.findById(customerId).orElse(null);
		
		if(customer != null) {
			
			map.put("Name", customer.getName());
			map.put("username", customer.getUserName());
			map.put("dob", customer.getDob());
			map.put("Email", customer.getEmail());
			map.put("phoneNo", customer.getPhoneNo());
			map.put("doorStreet", customer.getDoorStreet());
			map.put("panNo", customer.getPanNo());
			map.put("city", customer.getCity());
			map.put("state", customer.getState());
			map.put("pincode", customer.getPincode());
			map.put("password", customer.getPassword());
			
			}else {
				map.put("Status", "Error");
				map.put("Msg", "Invalid customerId");
			}
		  return map;	  		
	}
	
}

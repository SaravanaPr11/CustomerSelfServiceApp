package com.abc.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.abc.repository.Customerrepo;
import com.abc.model.Customer;
import com.abc.dto.Customerdto;
import com.abc.service.Customerservice;

@Service
public class Customerserviceimpl implements Customerservice{
	
	
	@Autowired
	private Customerrepo customerrepo;
	

	@Override
	public Object validateUser(Customer customer) {
		Map<String, Object>map=new HashMap<String, Object>();
		String userName= customer.getUserName();
		String password= customer.getPassword();
		
	    Customer login = customerrepo.findByUserNameAndPassword(userName, password);
	    if(login!=null) {
			if(login.getPassword().equals(password)) {
				map.put("Status", "Success");
				map.put("Message","Login Successful");
			}
			else {
				map.put("Status", "Error!!!");
				map.put("Message", "Invalid Password");
			}
		}
		else {
			map.put("Status", "Error!!!");
			map.put("Message", "Invalid UserName");
		}
		
		return map;
	}
     
	@Override
	public Object getAllCustomer() {
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<Customer> customers= customerrepo.findAll();
		
		for(Customer c:customers) {
			Map<String, Object>map= new HashMap<String, Object>();
			map.put("Customer Id",c.getCustomerId());
			map.put("Customer Name", c.getName());
			map.put("customer UserName",c.getUserName());
			map.put("customer Password",c.getPassword());
			map.put("customer Dob",c.getDob());
			map.put("customer PhoneNo",c.getPhoneNo());
			map.put("customer DoorStreet",c.getDoorStreet());
			map.put("customer City",c.getCity());
			map.put("customer Pincode",c.getPincode());
			map.put("customer PanNo",c.getPanNo());
			map.put("customer Email ",c.getEmail());
			map.put("customer State",c.getState());
			list.add(map);
			
		
	}
	return list;
}
	
	@Override
	public Object getCustomer(int customerID) {
		
		Map<String, Object>map= new HashMap<>();
		Customer customer = customerrepo.findById(customerID).orElse(null);
		
		if(customer!= null) {
			map.put("Name", customer.getName());
			map.put("UserName", customer.getUserName());
			map.put("Password", customer.getPassword());
			map.put("Dob", customer.getDob());
			map.put("PhoneNo", customer.getPhoneNo());
			map.put("DoorStreet", customer.getDoorStreet());
			map.put("City", customer.getCity());
			map.put("PanNo", customer.getPanNo());
			map.put("Email", customer.getEmail());
			map.put("State", customer.getState());
			map.put("Pincode", customer.getPincode());
		
		}else {
			map.put("Status", "Error!!!");
			map.put("Message", "Invalid CustomerId");
		}
		return map;
	}
	
	@Override
	public Object updateById(Customerdto customerdto) {
		
		Map<String,Object>map= new HashMap<String, Object>();
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
			 map.put("Status", "Error!!!");
			 map.put("Message", "Invalid customer Id" );
		 }
		 return map;
	}
	
	
}
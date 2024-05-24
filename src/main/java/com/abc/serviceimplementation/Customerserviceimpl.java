package com.abcbankk.serviceImplementation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.abcbankk.dto.CustomerValidateDTO;
import com.abcbankk.dto.Customerdto;
import com.abcbankk.model.Customer;
import com.abcbankk.repository.Customerrepo;
import com.abcbankk.service.Customerservice;

@RestController
public class Customerserviceimpl implements Customerservice {

	@Autowired
	private Customerrepo customerrepo;

	@Transactional
	@Override
	public Object validateUser(CustomerValidateDTO customer) {

		Map<String, Object> map = new HashMap<>();
		String userName = customer.getUserName();
		String password = customer.getPassword();

		Customer login = customerrepo.findbyUserNameAndPassword(userName);
		if (login != null) {
			if (login.getPassword().equals(password)) {
				map.put("name", login.getName());
				map.put("customerId", login.getCustomerId());
				map.put("Status", "Success");
				map.put("Message", "Login Successful");
			} else {
				map.put("Status", "Error!!!");
				map.put("Message", "Invalid Password");
			}
		} else {
			map.put("Status", "Error!!!");
			map.put("Message", "Invalid UserName");
		}

		return map;

	}

	@Transactional
	@Override
	public Object getCustomer(int customerId) {

		Map<String, Object> map = new HashMap<>();
		Customer customer = customerrepo.findById(customerId).orElse(null);

		if (customer != null) {
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

		} else {
			map.put("Status", "Error!!!");
			map.put("Message", "Invalid CustomerId");
		}
		return map;
	}

	@Transactional
	@Override
	public Object updateById(Customerdto customerdto) {

		Map<String, Object> map = new HashMap<>();
		Customer customer = customerrepo.findById(customerdto.getId()).orElse(null);
		if (customer != null) {
			customer.setDoorStreet(customerdto.getDoorStreet());
			customer.setCity(customerdto.getCity());
			customer.setPincode(customerdto.getPincode());
			customer.setPhoneNo(customerdto.getPhoneNo());
			customer.setEmail(customerdto.getEmail());

			customerrepo.saveAndFlush(customer);
			map.put("Status", "Success");
			map.put("Message", "Customer Id Updated Successfully");
		} else {
			map.put("Status", "Error!!!");
			map.put("Message", "Invalid customer Id");
		}
		return map;
	}

}

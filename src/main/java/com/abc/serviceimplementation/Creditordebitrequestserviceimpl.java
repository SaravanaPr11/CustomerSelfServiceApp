package com.abc.serviceimplementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.abc.service.Creditordebitrequestservice;
import com.abc.repository.Accountrepo;
import com.abc.repository.Servicerequestrepo;
import com.abc.repository.Creditordebitrequestrepo;
import com.abc.model.Creditordebitrequest;
import com.abc.model.Account;


@Service
public class Creditordebitrequestserviceimpl implements Creditordebitrequestservice{

	@Autowired
	private Accountrepo accountRepo;

	@Autowired
	private Servicerequestrepo servicerequestrepo;

	@Autowired
	private Creditordebitrequestrepo creditdebitrequestRepo;	
	
	
	
@Override
public Object getAllCreditordebitRequest() {
	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();	
	List<Creditordebitrequest> creditordebit= creditdebitrequestRepo.findAll();
	for(Creditordebitrequest CD:creditordebit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CreditdebitrequestId", CD.getCreditDebitRequestId());
		map.put("CardNumber", CD.getCardNumber());
		map.put("CardType", CD.getCardType());
		map.put("ResponseStatus", CD.getResponseStatus());
		map.put("ResponseMessage", CD.getResponseMessage());
		map.put("ServiceRequestId", CD.getRequest().getServiceRequestId());
		map.put("RequestDate", CD.getRequestDate());
		map.put("RequestMessage", CD.getRequestMessage());
		map.put("ResponseDate", CD.getResponseDate());
	
		list.add(map);
	}
	return list;	
}

@Override
public Object getbyId(int cDid) {
	List<Map<String, Object>>list=new ArrayList<>();
	List<Account>account=accountRepo.findBycustomerId(cDid);
	if(!ObjectUtils.isEmpty(account)) {
		
		 for(Account  e:account) {
			 
			   Map<String,Object>map=new HashMap<>();

			    map.put("accountnumber", e.getAccountNumber());

			  map.put("customerId",e.getCustomer().getCustomerId()); 
		return map;	 
		 }		
	}
return list;
}




	
	
	
}

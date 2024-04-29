package com.abc.serviceimplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dto.Lostorstolendto;
import com.abc.model.Account;
import com.abc.repository.Accountrepo;
import com.abc.repository.Lostorstolenrequestrepo;
import com.abc.repository.Servicerequestrepo;
import com.abc.service.Lostorstolenrequestservice;

@Service
public class Lostorstolenrequestimpl implements Lostorstolenrequestservice {
	
	@Autowired
	private Lostorstolenrequestrepo lostorstolenrequestrepo;

	@Autowired
    private Accountrepo accountrepo;

    @Autowired
    private Servicerequestrepo servicerequestrepo;

	@Override
	public Object getbycustomerid(int customerid) {
		 List<Map<String, Object>>list=new ArrayList<>();
	        List<Account>account=accountrepo.findBycustomerId(customerid);
	        if(account!=null)
	        {
	            for(Account  e:account)
	            {
	                Map<String,Object>map=new HashMap<>();
	                map.put("accountnumber", e.getAccountNumber());
	                list.add(map);
	            }
	        }
	        else
	        {
	            Map<String,Object>map=new HashMap<>();
	            map.put("status", "error");
	            map.put("msg","invalid id");
	            list.add(map);
	        }
	        return list;
	    

		
		
	}

	@Override
	public Object savelostcard(Lostorstolendto dtos) {
		
		return null;
	}

}

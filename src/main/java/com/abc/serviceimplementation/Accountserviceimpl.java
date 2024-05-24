package com.abcbankk.serviceImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.abcbankk.model.Account;
import com.abcbankk.repository.Accountrepo;
import com.abcbankk.service.Accountservice;

@Service
public class Accountserviceimpl implements Accountservice{

	@Autowired
	private Accountrepo accountrepo;

	@Transactional
	@Override
	public Object getaccountdetails(int customerId) {
		List<Map<String, Object>> list= new ArrayList<>();
		List<Account>accounts = accountrepo.findByCustomerId(customerId);

		if(!ObjectUtils.isEmpty(accounts))
		{
			for(Account a:accounts) {

				Map<String, Object>map= new HashMap<>();
				map.put("accountNumber", a.getAccountNumber());
				map.put("accountType", a.getAccountType());
				map.put("accountBalance", a.getAccountBalance());
				map.put("branchName", a.getBranchName());
				map.put("ifscCode", a.getIfscCode());
				map.put("name", a.getCustomer().getName());
				list.add(map);
			}
		}
		else {
			Map<String, Object> map = new HashMap<>();
			map.put("Status", "error");
			map.put("msg", "CustomerId is invalid");
			return map;
		}

		return list;
	}





}

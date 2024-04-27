package com.abc.serviceimplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.abc.model.Accountstatement;
import com.abc.repository.Accountrepo;
import com.abc.service.Accountstatementservice;

@Service
public class Accountstatementimpl implements Accountstatementservice {


	@Autowired
	private Accountrepo accountrepo;

	@Override
	public Object getstatement(long accountNumber) {
		List<Map <String,Object>>list=new ArrayList<Map<String,Object>>();
		List<Accountstatement>statements=accountrepo.getbyAccountNumber(accountNumber);

		if(!ObjectUtils.isEmpty(statements)) {
		for(Accountstatement b:statements)
		{ Map<String,Object>map=new HashMap<>();
		map.put("date", b.getDate());
		map.put("Description",b.getDescription());
		map.put("creditamount",b.getCreditAmount());
		map.put("Debitamount",b.getDebitAmount());
		map.put("ChequeNo",b.getChequeRefNo());
		map.put("closingBalance",b.getClosingBalance());
		map.put("accountNumber",b.getAccount().getAccountBalance());
		list.add(map);		
		}

		}
		else
		{
		Map<String,Object>map=new HashMap<>();
		map.put("status","error");
		map.put("msg","Invalid account number");
		return map;
		}

		return list;
		//return null;
	}
	
		
		
		
	}

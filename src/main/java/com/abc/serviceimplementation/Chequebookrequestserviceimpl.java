package com.abc.serviceimplementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dto.Chequebookrequestdto;
import com.abc.model.Account;
import com.abc.model.Chequebookrequest;
import com.abc.model.Servicerequest;
import com.abc.repository.Accountrepo;
import com.abc.repository.Chequebookrequestrepo;
import com.abc.repository.Servicerequestrepo;
import com.abc.service.Chequebookrequestservice;

@Service
public class Chequebookrequestserviceimpl implements Chequebookrequestservice{
	
	@Autowired
	private Chequebookrequestrepo chequebookrequestrepo;
	
	private Accountrepo accountrepo;
	
	private Servicerequestrepo servicerequestrepo;

	@Override
	public Object saveCheque(Chequebookrequest chequebookrequest) {
		int ChequebookRequestId = chequebookrequest.getChequeBookRequestId();
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(chequebookrequest.getRequestMessage().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "Please enter the Request message :");
		}
		else if(chequebookrequest.getRequestDate()== null) {
			map.put("status", "error");
			map.put("msg", "Please enter the Request Date :");
		}
		
		
		else if (chequebookrequest.getNoOfChequeLeaves().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "Please enter the Number of Leaves in chequeBook :");
		}
		else if(chequebookrequest.getResponseDate()== null) {
			map.put("status", "error");
			map.put("msg", "Please enter the Response Date :");
		}	
		
		else if(chequebookrequest.getResponseMessage().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "Please enter the Response Message:");
		}		
		else if(chequebookrequest.getResponseStatus().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "Please enter the Response status:");
		}
		else {
			chequebookrequestrepo.save(chequebookrequest);
			map.put("status", "Success");
			map.put("msg", "Data saved Successfully");
		}
		return map;
	}

	@Override
	public Object getAllcard() {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Chequebookrequest> chequebookRequest = chequebookrequestrepo.findAll();
		for(Chequebookrequest e:chequebookRequest) {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("chequebookRequestId", e.getChequeBookRequestId());
			map.put("numberOfChequeLeaves", e.getNoOfChequeLeaves());
			map.put("responseDate", e.getResponseDate());
			map.put("responseMessage", e.getResponseMessage());
			map.put("requestMessage", e.getRequestMessage());
			map.put("responseStatus", e.getResponseStatus());
//			map.put("serviceRequestId", e.getServiceRequestId());
			
			list.add(map);
		}
		return list;
	}

	@Override
	public Object getcardById(int id) {
		Map<String, Object> map=new HashMap<String, Object>();
		Chequebookrequest chequebookRequest = chequebookrequestrepo.findById(id).orElse(null);
		if(chequebookRequest!=null){
			map.put("chequebookRequestId", chequebookRequest.getChequeBookRequestId());
			map.put("numberOfChequeLeaves", chequebookRequest.getNoOfChequeLeaves());
			map.put("responseDate", chequebookRequest.getResponseDate());
			map.put("responseMessage", chequebookRequest.getResponseMessage());
			map.put("requestMessage", chequebookRequest.getRequestMessage());
			map.put("responseStatus", chequebookRequest.getResponseStatus());
//			map.put("serviceRequestId", chequebookRequest.getServiceRequestId());
			return map;
		}		
		return null;
	}

	@Override
	public Object saveRequest(Chequebookrequestdto chequebookrequestdto) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (chequebookrequestdto.getNoOfChequeLeaves().isEmpty() || chequebookrequestdto.getNoOfChequeLeaves() == null) {
			map.put("status", "error");
			map.put("msg", "give the valid numbers");
		}

		else if (chequebookrequestdto.getAccountNumber() == 0) {
			map.put("status", "error");
			map.put("msg", "give the valid accountNumber");
		} else if (chequebookrequestdto.getServiceRequestId() == 0) {
			map.put("status", "error");
			map.put("msg", "give the valid requesttypeid");
		} else {
			Chequebookrequest chequeBook = new Chequebookrequest();
			chequeBook.setNoOfChequeLeaves(chequebookrequestdto.getNoOfChequeLeaves());;
			Account myAccount = accountrepo.findById(chequebookrequestdto.getAccountNumber()).orElse(null);
			chequeBook.setAccount(myAccount);
			chequeBook.setRequestDate(new Date());
			Servicerequest serviceRequest1 = servicerequestrepo.findById(chequebookrequestdto.getServiceRequestId()).orElse(null);

			chequeBook.setRequest(serviceRequest1);
			chequeBook.setRequestMessage(chequebookrequestdto.getRequestMessage());
			chequeBook.setResponseStatus("pending");
			Chequebookrequest creditrequest = chequebookrequestrepo.save(chequeBook);
			map.put("status", "success");
			map.put("msg", "data saved successfully");

		}
		return map;

	}
	
	
	
}

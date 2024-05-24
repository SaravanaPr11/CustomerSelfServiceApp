package com.abc.serviceimplementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.abc.dto.CreditordebitRequestDto;
import com.abc.model.Account;
import com.abc.model.CreditordebitRequest;
import com.abc.model.ServiceRequest;
import com.abc.repository.Accountrepo;
import com.abc.repository.CreditordebitRequestRepo;
import com.abc.repository.ServiceRequestRepo;
import com.abc.service.CreditordebitRequestService;

@Service
public class CreditordebitRequestServiceImpl implements CreditordebitRequestService {

	@Autowired
	private Accountrepo accountRepo;

	@Autowired
	private ServiceRequestRepo servicerequestrepo;

	@Autowired
	private CreditordebitRequestRepo creditdebitrequestRepo;

	@Transactional
	@Override
	public Object getAllCreditordebitRequest(long accountNumber) {
		List<Map<String, Object>> list = new ArrayList<>();
		List<CreditordebitRequest> creditordebit = creditdebitrequestRepo.findbyAccountNumber(accountNumber);
		for (CreditordebitRequest CD : creditordebit) {
			Map<String, Object> map = new HashMap<>();
			map.put("CreditdebitrequestId", CD.getCreditdebitRequestId());
			if(CD.getCardNumber()!=null)
			{
				map.put("CardNumber", CD.getCardNumber());
			}
			map.put("CardType", CD.getCardType());
			map.put("ResponseStatus", CD.getResponseStatus());
			if(CD.getResponseMessage()!=null) 
			{
				map.put("ResponseMessage", CD.getResponseMessage());
			}
			map.put("ServiceRequestId", CD.getRequest().getServiceRequestId());
			map.put("RequestDate", CD.getRequestDate());
			map.put("RequestMessage", CD.getRequestMessage());
			if(CD.getResponseDate()!=null) 
			{
				map.put("RequestDate", CD.getResponseDate());
			}
		
			list.add(map);
		}
		return list;
	}

	@Transactional
	@Override
	public Object getbyId(int customerId) {
		List<Map<String, Object>> list = new ArrayList<>();
		List<Account> account = accountRepo.findByCustomerId(customerId);
		if (!ObjectUtils.isEmpty(account)) {
		for (Account e : account) {
	     	Map<String, Object> map = new HashMap<>();
			map.put("accountnumber", e.getAccountNumber());
			map.put("customerId", e.getCustomer().getCustomerId());
			list.add(map);
			}
		}
		return list;
	}

	@Transactional
	@Override
	public Object saverequest(CreditordebitRequestDto creditrequest) {

		Map<String, Object> map = new HashMap<>();

		if (creditrequest.getCardType().isEmpty() || creditrequest.getCardType() == null) {
			map.put("status", "error");
			map.put("msg", "enter the valid cardtype");
		} else if (creditrequest.getAccountNumber() == 0) {
			map.put("status", "error");
			map.put("msg", "enter the valid accountnumber");
		}  else {
			CreditordebitRequest creditDebitCard = new CreditordebitRequest();
			creditDebitCard.setCardType(creditrequest.getCardType());
			Account myAccount = accountRepo.findById(creditrequest.getAccountNumber()).orElse(null);
            if(myAccount!=null)
            {
			creditDebitCard.setAccount(myAccount);
            }
            else
            {
            	return "No Account number Found";
            }
			creditDebitCard.setRequestDate(new Date());
			ServiceRequest serviceRequest = servicerequestrepo.findById(2)
					.orElse(null);
			if(serviceRequest!=null)
			{
			creditDebitCard.setRequest(serviceRequest);
			} else
            {
            	return "No Service Request Id Found";
            }
			creditDebitCard.setResponseStatus("Pending");
			creditDebitCard.setRequestMessage(creditrequest.getRequestMessage());
		    creditdebitrequestRepo.save(creditDebitCard);
			map.put("status", "success");
			map.put("msg", "CardRequest saved successfully");

		}
		return map;
	}

}

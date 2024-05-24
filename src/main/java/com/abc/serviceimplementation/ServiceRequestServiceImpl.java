package com.abc.serviceimplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dto.ServiceRequestDto;
import com.abc.model.ChequebookRequest;
import com.abc.model.CreditordebitRequest;
import com.abc.model.LostorstolenRequest;
import com.abc.repository.ChequebookRequestRepo;
import com.abc.repository.CreditordebitRequestRepo;
import com.abc.repository.LostorstolenRequestRepo;
import com.abc.service.ServiceRequestService;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService{

	@Autowired
	private CreditordebitRequestRepo cardrequestrepo;
	@Autowired
	private ChequebookRequestRepo bookrequestrepo;
	@Autowired
	private LostorstolenRequestRepo cardrepo;

	@Override
	public Object getbyserviceid(ServiceRequestDto dto) {
		List<Map<String,Object>>list = new ArrayList<>();
		if(dto.getServiceRequestId()==1)
		{
			if(dto.getStatus()==null)
			{
				List<ChequebookRequest>bookRequest=bookrequestrepo.findByAccountNumber(dto.getAccountNumber());
				for(ChequebookRequest chequeBookRequest:bookRequest)
				{
					Map<String,Object>map=new HashMap<>();
					map.put("id", chequeBookRequest.getChequebookRequestId());
					map.put("noOfChequeLeaves",chequeBookRequest.getNoOfChequeLeaves());
					map.put("requestdate", chequeBookRequest.getRequestDate());
					map.put("requestMessage", chequeBookRequest.getRequestMessage());
					map.put("responseDate", chequeBookRequest.getResponseDate());
					map.put("responseMessage", chequeBookRequest.getResponseMessage());
					map.put("responsestatus",chequeBookRequest.getResponseStatus());
					map.put("serviceid",chequeBookRequest.getRequest().getServiceRequestId());
					map.put("accountNumber", chequeBookRequest.getAccount().getAccountNumber());
					map.put("customerId", chequeBookRequest.getAccount().getCustomer().getCustomerId());
					list.add(map);
				}
				return list;
			}
			else
			{
				List<ChequebookRequest>bookRequest=bookrequestrepo.getstatusandAccountnumber(dto.getStatus(),dto.getAccountNumber());
				for(ChequebookRequest chequeBookRequest:bookRequest)
				{
					Map<String,Object>map=new HashMap<>();
					map.put("id", chequeBookRequest.getChequebookRequestId());
					map.put("noOfChequeLeaves",chequeBookRequest.getNoOfChequeLeaves());
					map.put("requestdate", chequeBookRequest.getRequestDate());
					map.put("requestMessage", chequeBookRequest.getRequestMessage());
					map.put("responseDate", chequeBookRequest.getResponseDate());
					map.put("responseMessage", chequeBookRequest.getResponseMessage());
					map.put("responsestatus",chequeBookRequest.getResponseStatus());
					map.put("serviceid",chequeBookRequest.getRequest().getServiceRequestId());
					map.put("accountNumber", chequeBookRequest.getAccount().getAccountNumber());
					map.put("customerId", chequeBookRequest.getAccount().getCustomer().getCustomerId());
					list.add(map);
				}
				return list;
			}
		}

			else if(dto.getServiceRequestId()==2)
		{
			if(dto.getStatus()==null)
			{
				List<CreditordebitRequest>credits=cardrequestrepo.findbyAccountNumber(dto.getAccountNumber());
				for(CreditordebitRequest credit:credits)
				{
					Map<String,Object>map=new HashMap<>();
					map.put("id", credit.getCreditdebitRequestId());
			        map.put("cardtype",credit.getCardType());
					map.put("requestdate", credit.getRequestDate());
					map.put("requestMessage", credit.getRequestMessage());
					map.put("responseDate", credit.getResponseDate());
					map.put("responseMessage", credit.getResponseMessage());
					map.put("responsestatus",credit.getResponseStatus());
					map.put("serviceid",credit.getRequest().getServiceRequestId());
					map.put("accountNumber", credit.getAccount().getAccountNumber());
					map.put("customerId", credit.getAccount().getCustomer().getCustomerId());
					list.add(map);
				}
				return list;
			}
			else
			{
				List<CreditordebitRequest>credit1=cardrequestrepo.getstatusandAccountNumber(dto.getStatus(),dto.getAccountNumber());
				for(CreditordebitRequest credit:credit1)
				{
					Map<String,Object>map=new HashMap<>();
					map.put("id", credit.getCreditdebitRequestId());
			        map.put("cardtype",credit.getCardType());
					map.put("requestdate", credit.getRequestDate());
					map.put("requestMessage", credit.getRequestMessage());
					map.put("responseDate", credit.getResponseDate());
					map.put("responseMessage", credit.getResponseMessage());
					map.put("responsestatus",credit.getResponseStatus());
					map.put("serviceid",credit.getRequest().getServiceRequestId());
					map.put("accountNumber", credit.getAccount().getAccountNumber());
					map.put("customerId", credit.getAccount().getCustomer().getCustomerId());
					list.add(map);
				}
				return list;
			}
		}

			else if(dto.getServiceRequestId()==3)
		{
			if(dto.getStatus()==null)
			{
				List<LostorstolenRequest>lost=cardrepo.findbyaccountnumber(dto.getAccountNumber());
				for(LostorstolenRequest LostStolenCard:lost)
				{
					Map<String,Object>map=new HashMap<>();
					map.put("id", LostStolenCard.getLoststolenRequestId());
			        map.put("stolendate",LostStolenCard.getLostorstolenDate());
					map.put("requestdate", LostStolenCard.getRequestDate());
					map.put("requestMessage", LostStolenCard.getRequestMessage());
					map.put("responseDate", LostStolenCard.getResponseDate());
					map.put("responseMessage", LostStolenCard.getResponseMessage());
					map.put("serviceid",LostStolenCard.getRequest().getServiceRequestId());
					map.put("serviceidName",LostStolenCard.getRequest().getRequestType());
					map.put("accountNumber", LostStolenCard.getAccount().getAccountNumber());
					map.put("customerId", LostStolenCard.getAccount().getCustomer().getCustomerId());
					map.put("responsestatus",LostStolenCard.getResponseStatus());
					map.put("cardNumber",LostStolenCard.getCardNumber());

					list.add(map);

				}
				return list;

			}
			else
			{
				List<LostorstolenRequest>lost1=cardrepo.getstatusandAccountNumber(dto.getStatus(),dto.getAccountNumber());
				if(lost1!=null)
				{
					for(LostorstolenRequest LostStolenCard:lost1)
					{
						Map<String,Object>map=new HashMap<>();
						map.put("id", LostStolenCard.getLoststolenRequestId());
				        map.put("stolendate",LostStolenCard.getLostorstolenDate());
						map.put("requestdate", LostStolenCard.getRequestDate());
						map.put("requestMessage", LostStolenCard.getRequestMessage());
						map.put("responseDate", LostStolenCard.getResponseDate());
						map.put("responseMessage", LostStolenCard.getResponseMessage());
						map.put("serviceid",LostStolenCard.getRequest().getServiceRequestId());
						map.put("serviceidName",LostStolenCard.getRequest().getRequestType());
						map.put("accountNumber", LostStolenCard.getAccount().getAccountNumber());
						map.put("customerId", LostStolenCard.getAccount().getCustomer().getCustomerId());
						map.put("responsestatus",LostStolenCard.getResponseStatus());
						map.put("cardNumber",LostStolenCard.getCardNumber());

						list.add(map);

					}
				}
				return list;
			}
		}
			else
			{
				Map<String,Object>responseMap = new HashMap<>();
				List<ChequebookRequest>bookRequest=bookrequestrepo.findByAccountNumber(dto.getAccountNumber());
				if(bookRequest!=null)
				{
					List<Map<String,Object>>chequeBookRequestList = new ArrayList<>();
				for(ChequebookRequest chequeBookRequest:bookRequest)
				{
					Map<String,Object>map=new HashMap<>();
					map.put("id", chequeBookRequest.getChequebookRequestId());
					map.put("noOfChequeLeaves",chequeBookRequest.getNoOfChequeLeaves());
					map.put("requestdate", chequeBookRequest.getRequestDate());
					map.put("requestMessage", chequeBookRequest.getRequestMessage());
					map.put("responseDate", chequeBookRequest.getResponseDate());
					map.put("responseMessage", chequeBookRequest.getResponseMessage());
					map.put("responsestatus",chequeBookRequest.getResponseStatus());
					map.put("serviceid",chequeBookRequest.getRequest().getServiceRequestId());
					map.put("serviceidName",chequeBookRequest.getRequest().getRequestType());
					map.put("accountNumber", chequeBookRequest.getAccount().getAccountNumber());
					map.put("customerId", chequeBookRequest.getAccount().getCustomer().getCustomerId());
					chequeBookRequestList.add(map);
				}
				responseMap.put("CHequeBook",chequeBookRequestList);
				}
				List<CreditordebitRequest>credits=cardrequestrepo.findbyAccountNumber(dto.getAccountNumber());
				if(credits!=null)
				{
					List<Map<String,Object>>creditdebitcardList = new ArrayList<>();
				for(CreditordebitRequest credit:credits)
				{
					Map<String,Object>map=new HashMap<>();
					map.put("id", credit.getCreditdebitRequestId());
			        map.put("cardtype",credit.getCardType());
					map.put("requestdate", credit.getRequestDate());
					map.put("requestMessage", credit.getRequestMessage());
					map.put("responseDate", credit.getResponseDate());
					map.put("responseMessage", credit.getResponseMessage());
					map.put("responsestatus",credit.getResponseStatus());
					map.put("serviceid",credit.getRequest().getServiceRequestId());
					map.put("serviceidName",credit.getRequest().getRequestType());
					map.put("serviceidName",credit.getRequest().getRequestType());
					map.put("accountNumber", credit.getAccount().getAccountNumber());
					map.put("customerId", credit.getAccount().getCustomer().getCustomerId());
					creditdebitcardList.add(map);
				}
				responseMap.put("CreditorDebitCard",creditdebitcardList);
				}
				List<LostorstolenRequest>lost=cardrepo.findbyaccountnumber(dto.getAccountNumber());
				if(lost!=null)
				{
					List<Map<String,Object>>LostStolenCardList = new ArrayList<>();
				    for(LostorstolenRequest LostStolenCard:lost)
				{
					Map<String,Object>map=new HashMap<>();
					map.put("id", LostStolenCard.getLoststolenRequestId());
			        map.put("stolendate",LostStolenCard.getLostorstolenDate());
					map.put("requestdate", LostStolenCard.getRequestDate());
					map.put("requestMessage", LostStolenCard.getRequestMessage());
					map.put("responseDate", LostStolenCard.getResponseDate());
					map.put("responseMessage", LostStolenCard.getResponseMessage());
					map.put("serviceid",LostStolenCard.getRequest().getServiceRequestId());
					map.put("serviceidName",LostStolenCard.getRequest().getRequestType());
					map.put("accountNumber", LostStolenCard.getAccount().getAccountNumber());
					map.put("customerId", LostStolenCard.getAccount().getCustomer().getCustomerId());
					map.put("responsestatus",LostStolenCard.getResponseStatus());
					map.put("cardNumber",LostStolenCard.getCardNumber());

					LostStolenCardList.add(map);

				}
				    responseMap.put("LostorStolen",LostStolenCardList);
				}

			return responseMap;
			}
	}
}

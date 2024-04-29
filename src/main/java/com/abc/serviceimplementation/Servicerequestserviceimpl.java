package com.abc.serviceimplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dto.Servicerequestdto;
import com.abc.model.Account;
import com.abc.model.Chequebookrequest;
import com.abc.model.Creditordebitrequest;
import com.abc.model.Lostorstolenrequest;
import com.abc.repository.Accountrepo;
import com.abc.repository.Chequebookrequestrepo;
import com.abc.repository.Creditordebitrequestrepo;
import com.abc.repository.Lostorstolenrequestrepo;
import com.abc.service.Servicerequestservice;

@Service
public class Servicerequestserviceimpl implements Servicerequestservice {
	
	@Autowired
	private Accountrepo accountrepo;
	@Autowired
	private Creditordebitrequestrepo cardrequestrepo;
	@Autowired
	private Chequebookrequestrepo bookrequestrepo;
	@Autowired
	private Lostorstolenrequestrepo cardrepo;

	@Override
	public Object getbyserviceid(Servicerequestdto dto) {
		Map<String,Object>map=new HashMap<>();
		 if(dto.getServicerequestid()==1)
		{
			if(dto.getStatus()==null)
			{
				List<Chequebookrequest>bookrequest=bookrequestrepo.findAll();
				for(Chequebookrequest chequeBookRequest:bookrequest)
				{
					map.put("id", chequeBookRequest.getChequeBookRequestId());
					map.put("cardType",chequeBookRequest.getNoOfChequeLeaves());
					map.put("requestdate", chequeBookRequest.getRequestDate());
					map.put("responseDate", chequeBookRequest.getResponseDate());
					map.put("responseMessage", chequeBookRequest.getResponseMessage());
					map.put("responsestatus",chequeBookRequest.getResponseStatus());
					map.put("serviceid",chequeBookRequest.getRequest().getServiceRequestId());
					map.put("accountNumber", chequeBookRequest.getAccount().getAccountNumber());
					map.put("customerId", chequeBookRequest.getAccount().getCustomer().getCustomerId());
				}
				return map;
			}
			else
			{
				List<Chequebookrequest>bookrequest=bookrequestrepo.getrequeststatus(dto.getStatus());
				for(Chequebookrequest chequeBookRequest:bookrequest)
				{
					map.put("id", chequeBookRequest.getChequeBookRequestId());
					map.put("cardType",chequeBookRequest.getNoOfChequeLeaves());
					map.put("requestdate", chequeBookRequest.getRequestDate());
					map.put("responseDate", chequeBookRequest.getResponseDate());
					map.put("responseMessage", chequeBookRequest.getResponseMessage());
					map.put("responsestatus",chequeBookRequest.getResponseStatus());
					map.put("serviceid",chequeBookRequest.getRequest().getServiceRequestId());
					map.put("accountNumber", chequeBookRequest.getAccount().getAccountNumber());
					map.put("customerId", chequeBookRequest.getAccount().getCustomer().getCustomerId());
				}
				return map;
			}
		}

			else if(dto.getServicerequestid()==2)
		{
			if(dto.getStatus()==null)
			{
				List<Creditordebitrequest>credits=cardrequestrepo.findAll();
				for(Creditordebitrequest credit:credits)
				{
					map.put("id", credit.getCreditDebitRequestId());
			        map.put("cardtype",credit.getCardNumber());
					map.put("requestdate", credit.getRequestDate());
					map.put("responseDate", credit.getResponseDate());
					map.put("responseMessage", credit.getRequestMessage());
					map.put("responsestatus",credit.getResponseStatus());
					map.put("serviceid",credit.getRequest().getServiceRequestId());
					map.put("accountNumber", credit.getAccount().getAccountNumber());
					map.put("customerId", credit.getAccount().getCustomer().getCustomerId());
				}
				return map;
			}
			else
			{
				List<Creditordebitrequest>credit1=cardrequestrepo.getrequeststatus(dto.getStatus());
				for(Creditordebitrequest credit:credit1)
				{
					map.put("id", credit.getCreditDebitRequestId());
			        map.put("cardtype",credit.getCardType());
					map.put("requestdate", credit.getRequestDate());
					map.put("responseDate", credit.getResponseDate());
					map.put("responseMessage", credit.getRequestMessage());
					map.put("responsestatus",credit.getResponseStatus());
					map.put("serviceid",credit.getRequest().getServiceRequestId());
					map.put("accountNumber", credit.getAccount().getAccountNumber());
					map.put("customerId", credit.getAccount().getCustomer().getCustomerId());
				}
				return map;
			}
		}

			else if(dto.getServicerequestid()==3)
		{
			if(dto.getStatus()==null)
			{
				List<Lostorstolenrequest>lost=cardrepo.findAll();
				for(Lostorstolenrequest LostStolenCard:lost)
				{
					map.put("id", LostStolenCard.getLostorStolenRequestId());
			        map.put("stolendate",LostStolenCard.getLostorStolenDate());
					map.put("requestdate", LostStolenCard.getRequestDate());
					map.put("responseDate", LostStolenCard.getResponseDate());
					map.put("responseMessage", LostStolenCard.getRequestMessage());
//				    map.put("responsestatus",LostStolenCard.getResponseStatus());				
//					map.put("serviceid",LostStolenCard.getServicerequest().getServicerequestid());
//					map.put("accountNumber", LostStolenCard.getAccount().getAccountNumber());
//					map.put("customerId", LostStolenCard.getAccount().getCustomermaster().getCustomerId());
				}
				return map;
			//return lost;
			}
			else
			{
				List<Lostorstolenrequest>lost1=cardrepo.getrequeststatus(dto.getStatus());
				return lost1;
			}
		}
			else
			{
		return null;
			}
	}
	
	@Override
	public Object getaccountalldetails(int customerId) {
		
		List<Map<String, Object>>list=new ArrayList<>();
        List<Account>myaccount=accountrepo.findBycustomerId(customerId);
        if(myaccount!=null)
        {
            for(Account  e:myaccount)
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


	
	}

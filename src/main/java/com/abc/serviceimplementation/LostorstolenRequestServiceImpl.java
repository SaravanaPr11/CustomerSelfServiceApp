package com.abcbankk.serviceImplementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcbankk.dto.LostorstolenRequestDto;
import com.abcbankk.model.Account;
import com.abcbankk.model.CreditordebitRequest;
import com.abcbankk.model.LostorstolenRequest;
import com.abcbankk.model.ServiceRequest;
import com.abcbankk.repository.Accountrepo;
import com.abcbankk.repository.CreditordebitRequestRepo;
import com.abcbankk.repository.LostorstolenRequestRepo;
import com.abcbankk.repository.ServiceRequestRepo;
import com.abcbankk.service.LostorstolenRequestService;

@Service
public class LostorstolenRequestServiceImpl implements LostorstolenRequestService {


	@Autowired
	private LostorstolenRequestRepo lostorstolenRequestRepo;

	@Autowired
    private Accountrepo accountRepo;

    @Autowired
    private ServiceRequestRepo serviceRequestRepo;

    @Autowired
    private CreditordebitRequestRepo creditordebitRequestRepo;

    @Transactional
	@Override
    public Object getbycustomerid(int customer_id) {
        List<Map<String, Object>>list=new ArrayList<>();
        List<Account>account=accountRepo.findByCustomerId(customer_id);
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

    @Transactional
    @Override
    public Object savelostcard(LostorstolenRequestDto dtos) {
        Map<String, Object> map = new HashMap<>();
        
        if (dtos.getAccountNumber() == 0) {
            map.put("status", "Error");
            map.put("msg", "Account number is Empty");
        } else if (dtos.getCardType() == null || dtos.getCardType().isEmpty()) {
            map.put("status", "Error");
            map.put("msg", "Card Type is Empty");
        } else if (dtos.getLosttolenDate() == null) {
            map.put("status", "Error");
            map.put("msg", "Lost or Stolen Date is Empty");
        } else {
            LostorstolenRequest lostorstolenRequest = new LostorstolenRequest();
            lostorstolenRequest.setCardType(dtos.getCardType());
            lostorstolenRequest.setRequestMessage(dtos.getRequestMessage() != null ? dtos.getRequestMessage() : "");
            ServiceRequest request = serviceRequestRepo.findById(3).orElse(null);
            if (request != null) {
                lostorstolenRequest.setRequest(request);
            } else {
                return "No Service Request Id Found";
            }
            Account account = accountRepo.findById(dtos.getAccountNumber()).orElse(null);
            if (account != null) {
                lostorstolenRequest.setAccount(account);
            } else {
                return "No Account Number Found";
            }
            lostorstolenRequest.setRequestDate(new Date());
            
            if (dtos.getCardNumber() != null) {
                CreditordebitRequest creditordebitRequest = creditordebitRequestRepo.findbyCardNumer(dtos.getCardNumber());
                if (creditordebitRequest != null) {
                    lostorstolenRequest.setCardNumber(creditordebitRequest.getCardNumber());
                } else {
                    lostorstolenRequest.setCardNumber(dtos.getCardNumber());
                }
            } else {
                lostorstolenRequest.setCardNumber(null);
            }
            
            lostorstolenRequest.setLostorstolenDate(dtos.getLosttolenDate());
            lostorstolenRequest.setResponseStatus("Pending");
            lostorstolenRequestRepo.save(lostorstolenRequest);
            map.put("status", "Success");
            map.put("msg", "Lost or Stolen Request saved Successfully");
        }

        return map;
    }

    @Transactional
	@Override
	public Object getbyAccountNumber(long accountNumber) {

		List<Map<String,Object>> list = new ArrayList<>();

		List<LostorstolenRequest> requests = lostorstolenRequestRepo.findbyaccountnumber(accountNumber);
		if(requests!=null)
		{
			for(LostorstolenRequest lostorstolenRequest:requests)
			{
				Map<String,Object>map = new HashMap<>();
				map.put("lostorStolenRequestId",lostorstolenRequest.getLoststolenRequestId());
				map.put("accountNumber",lostorstolenRequest.getAccount().getAccountNumber());
				map.put("cardNumber",lostorstolenRequest.getCardNumber());
				map.put("requestDate",lostorstolenRequest.getRequestDate());
				map.put("requestMessage",lostorstolenRequest.getRequestMessage());
				map.put("responseDate",lostorstolenRequest.getResponseDate());
				map.put("responseStatus",lostorstolenRequest.getResponseStatus());
				map.put("serviceRequestID",lostorstolenRequest.getRequest().getServiceRequestId());
				map.put("serviceRequestIDName",lostorstolenRequest.getRequest().getRequestType());
				map.put("lostorStolenDate", lostorstolenRequest.getLostorstolenDate());
				list.add(map);
			}
		}

		return list;
	}


	}








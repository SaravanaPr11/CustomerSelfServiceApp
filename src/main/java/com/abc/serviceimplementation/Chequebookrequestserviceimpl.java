package com.abc.serviceimplementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.dto.ChequebookRequestDto;
import com.abc.model.Account;
import com.abc.model.ChequebookRequest;
import com.abc.model.ServiceRequest;
import com.abc.repository.Accountrepo;
import com.abc.repository.ChequebookRequestRepo;
import com.abc.repository.ServiceRequestRepo;
import com.abc.service.ChequebookRequestService;

@Service
public class ChequebookRequestServiceImpl implements ChequebookRequestService {

	@Autowired
	private ChequebookRequestRepo chequebookRequestRepo;

	@Autowired
	private Accountrepo accountrepo;

	@Autowired
	private ServiceRequestRepo serviceRequestRepo;

	@Transactional
	@Override
	public Object getcardById(long accountNumber) {
		List<Map<String, Object>> list = new ArrayList<>();

		List<ChequebookRequest> chequebookRequest2 = chequebookRequestRepo.findByAccountNumber(accountNumber);

		if (chequebookRequest2 != null) {
			for (ChequebookRequest chequebookRequest : chequebookRequest2) {
				Map<String, Object> map = new HashMap<>();
				map.put("chequebookRequestId", chequebookRequest.getChequebookRequestId());
				map.put("numberOfChequeLeaves", chequebookRequest.getNoOfChequeLeaves());
				map.put("resquestDate", chequebookRequest.getRequestDate());
				map.put("responseDate", chequebookRequest.getResponseDate());
				map.put("responseMessage", chequebookRequest.getResponseMessage());
				map.put("requestMessage", chequebookRequest.getRequestMessage());
				map.put("responseStatus", chequebookRequest.getResponseStatus());
				list.add(map);
			}

		}
		return list;
	}

	@Transactional
	@Override
	public Object saveRequest(ChequebookRequestDto chequebookRequestDto) {

		Map<String, Object> map = new HashMap<>();
		if (chequebookRequestDto.getNoOfChequeLeaves().isEmpty()
				|| chequebookRequestDto.getNoOfChequeLeaves() == null) {
			map.put("status", "error");
			map.put("msg", "give the valid numbers");
		}

		else if (chequebookRequestDto.getAccountNumber() == 0) {
			map.put("status", "error");
			map.put("msg", "give the valid accountNumber");
		} else {
			ChequebookRequest chequeBook = new ChequebookRequest();
			chequeBook.setNoOfChequeLeaves(chequebookRequestDto.getNoOfChequeLeaves());

			Account myAccount = accountrepo.findById(chequebookRequestDto.getAccountNumber()).orElse(null);
			if (myAccount != null) {
				chequeBook.setAccount(myAccount);
			} else {
				return "No account number found";
			}
			chequeBook.setRequestDate(new Date());
			ServiceRequest serviceRequest1 = serviceRequestRepo.findById(1).orElse(null);
			if (serviceRequest1 != null) {
				chequeBook.setRequest(serviceRequest1);
			} else {
				return "No Service Request ID found";
			}
			chequeBook.setRequestMessage(chequebookRequestDto.getRequestMessage());
			chequeBook.setResponseStatus("Pending");
			chequebookRequestRepo.save(chequeBook);

			map.put("status", "success");
			map.put("msg", "ChequeBookRequest saved successfully");

		}
		return map;

	}

}

package com.abcbankk.serviceImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.abcbankk.model.AccountStatement;
import com.abcbankk.repository.Accountstatementrepo;
import com.abcbankk.service.Accountstatementservice;

@Service
public class Accountstatementserviceimpl implements Accountstatementservice {

	@Autowired
	private Accountstatementrepo accountstatementrepo;

	@Transactional
	@Override
	public Object getstatement(Long accountNumber) {
		List<Map<String, Object>> list = new ArrayList<>();
		List<AccountStatement> statements = accountstatementrepo.findByAccountnumber(accountNumber);

		if (!ObjectUtils.isEmpty(statements)) {
			for (AccountStatement b : statements) {
				Map<String, Object> map = new HashMap<>();
				map.put("date", b.getDate());
				map.put("description", b.getDescription());
				map.put("chequeNo", b.getChequeRefNo());
				map.put("closingBalance", b.getClosingBalance());
				map.put("creditOrDebitAmount", b.getCreditordebitAmount());
				map.put("accountNumber", b.getAccount().getAccountBalance());
				list.add(map);
			}

		} else {
			Map<String, Object> map = new HashMap<>();
			map.put("status", "error");
			map.put("msg", "Invalid account number");
			return map;
		}

		return list;

	}

}

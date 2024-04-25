package com.abcbank.model;

import jakarta.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.*;

@Entity
@Table( name = "Account")
public class Account {
	
	@Id
	@Column(name = "accountNumber",length = 17, nullable = false )
	private Long accountNumber;
	
	@Column(name = "accounType",length = 20, nullable = false)
	private String accountType;
	
	@Column(name = "accountBalance",nullable = false )
	private Double accountBalance;
	
	@Column(name = "branchName",length = 45, nullable = false )
	private String branchName;
	
	@Column(name = "ifscCode",length = 11, nullable = false )
	private String ifscCode;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	
	
}

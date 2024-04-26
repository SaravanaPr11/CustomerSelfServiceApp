package com.abc.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "accountStatement")
public class Accountstatement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accountStatementId")
	private int accountStatementId;
	
	@Column(name = "date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "description",length = 30, nullable = false)
	private String description;
	
	@Column(name = "creditAmount", nullable = false)
	private Double creditAmount;
	
	@Column(name = "debitAmount", nullable = false)
	private Double debitAmount;
	
	@Column(name = "chequeRefNo",length = 7, nullable = false)
	private String chequeRefNo;
	
	@Column(name = "closingBalance", nullable = false)
	private Double closingBalance;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountNumber")
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getAccountStatementId() {
		return accountStatementId;
	}
	public void setAccountStatementId(int accountStatementId) {
		this.accountStatementId = accountStatementId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}
	public Double getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}
	public String getChequeRefNo() {
		return chequeRefNo;
	}
	public void setChequeRefNo(String chequeRefNo) {
		this.chequeRefNo = chequeRefNo;
	}
	public Double getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}
	
	
}

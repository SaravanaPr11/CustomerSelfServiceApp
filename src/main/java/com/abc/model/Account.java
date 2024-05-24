package com.abc.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "Account")
public class Account {
	    @Id
	    @Column(name = "accountNumber",length = 17, nullable = false)
		private Long accountNumber;

	    @Column(name = "accountType", length = 20, nullable = false)
		private String accountType;

	    @Column(name = "accountBalance", nullable = false)
		private Double accountBalance;

		@Column(name = "branchName", length = 45, nullable = false)
		private String branchName;

	    @Column(name = "ifscCode", length = 11, nullable = false)
		private String ifscCode;

	    @ManyToOne(fetch = FetchType.LAZY)
	 	@JoinColumn(name = "customerId")
	 	private Customer customer;

	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
		private List<AccountStatement> accountstatements = new ArrayList<>();

		@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
		  private List<ChequebookRequest> chequebookrequests  = new ArrayList<>();

		  @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
		  private List<CreditordebitRequest> creditordebitrequests = new ArrayList<>();

		  @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
		  private List<LostorstolenRequest> lostorstolenrequests = new ArrayList<>();

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

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<AccountStatement> getAccountstatements() {
			return accountstatements;
		}

		public void setAccountstatements(List<AccountStatement> accountstatements) {
			this.accountstatements = accountstatements;
		}

		public List<ChequebookRequest> getChequebookrequests() {
			return chequebookrequests;
		}

		public void setChequebookrequests(List<ChequebookRequest> chequebookrequests) {
			this.chequebookrequests = chequebookrequests;
		}

		public List<CreditordebitRequest> getCreditordebitrequests() {
			return creditordebitrequests;
		}

		public void setCreditordebitrequests(List<CreditordebitRequest> creditordebitrequests) {
			this.creditordebitrequests = creditordebitrequests;
		}

		public List<LostorstolenRequest> getLostorstolenrequests() {
			return lostorstolenrequests;
		}

		public void setLostorstolenrequests(List<LostorstolenRequest> lostorstolenrequests) {
			this.lostorstolenrequests = lostorstolenrequests;
		}

}

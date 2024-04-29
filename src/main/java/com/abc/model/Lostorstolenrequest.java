package com.abc.model;

import java.math.BigInteger;
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
@Table( name = "Lostorstolen_request")
public class Lostorstolenrequest {
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "lostStolenRequestId")
	  private int lostorStolenRequestId;
	
	  @Column(name = "cardType", length = 10, nullable = false)
	  private String cardType;
	  
	  @Column(name = "cardNumber", length = 16)
	  private BigInteger cardNumber;
	  
	  @Column(name = "lostStolenDate", nullable = false)
	  private Date lostorStolenDate;
	  
	  @Column(name = "requestDate", nullable = false)
	  @Temporal(TemporalType.DATE)
	  private Date requestDate;
	  
	  @Column(name = "requestMessage", length = 75, nullable = false)
	  private String requestMessage;
	  
	  @Column(name = "responseDate")
	  @Temporal(TemporalType.DATE)
	  private Date responseDate;
	  
	  @Column(name = "responseMessage", length = 75)
	  private String responseMessage;
	    
	  @Column(name = "responseStatus", length = 10)
	  private String responseStatus;
	  
	  
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "servicerequestid")
	  private Servicerequest request;
	  
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "accountnumber")
	  private Account account;
	  
	  @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "employeeid")
		private Employee employee;
	  
	  

	public Servicerequest getRequest() {
		return request;
	}

	public void setRequest(Servicerequest request) {
		this.request = request;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getLostorStolenRequestId() {
		return lostorStolenRequestId;
	}

	public void setLostorStolenRequestId(int lostStolenRequestId) {
		this.lostorStolenRequestId = lostStolenRequestId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public BigInteger getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(BigInteger cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getLostorStolenDate() {
		return lostorStolenDate;
	}

	public void setLostorStolenDate(Date lostStolenDate) {
		this.lostorStolenDate = lostStolenDate;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestMessage() {
		return requestMessage;
	}

	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponse_date(Date response_date) {
		this.responseDate = response_date;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	  
	  
}

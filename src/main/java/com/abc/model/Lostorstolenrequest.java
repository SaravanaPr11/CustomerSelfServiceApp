package com.abcbankk.model;

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
@Table( name = "LostorstolenRequest")
public class LostorstolenRequest {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "loststolenRequestId")
	  private int loststolenRequestId;

	  @Column(name = "cardType", length = 10, nullable = false)
	  private String cardType;

	  @Column(name = "cardNumber", length = 16)
	  private BigInteger cardNumber;

	  @Column(name = "lostorstolenDate", nullable = false)
	  private Date lostorstolenDate;

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
	  @JoinColumn(name = "serviceRequestId")
	  private ServiceRequest request;

	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "accountNumber")
	  private Account account;

	  @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "employeeId")
		private Employee employee;

	public int getLoststolenRequestId() {
		return loststolenRequestId;
	}

	public void setLoststolenRequestId(int loststolenRequestId) {
		this.loststolenRequestId = loststolenRequestId;
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

	public Date getLostorstolenDate() {
		return lostorstolenDate;
	}

	public void setLostorstolenDate(Date lostorstolenDate) {
		this.lostorstolenDate = lostorstolenDate;
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

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
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

	public ServiceRequest getRequest() {
		return request;
	}

	public void setRequest(ServiceRequest request) {
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


}

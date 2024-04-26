package com.abcbank.model;

import java.util.Date;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "Creditordebitrequest")
public class Creditordebitrequest {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "creditDebitRequestId")
	  private int creditDebitRequestId;
	
	  @Column(name = "cardType", length = 10, nullable = false)
	  private String cardType;
	  
	  @Column(name = "cardNumber", length = 16)
	  private Long cardNumber;
	  
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

	public int getCreditDebitRequestId() {
		return creditDebitRequestId;
	}

	public void setCreditDebitRequestId(int creditDebitRequestId) {
		this.creditDebitRequestId = creditDebitRequestId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
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
	  
	  
}

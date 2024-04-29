package com.abc.dto;

import java.util.*;

public class Lostorstolenrequestdto {

	
	private int serviceRequestId;
    private long accountNumber;
    private String requestMessage;
	private Date lostorStolenDate;
    private long cardNumber;
    private String cardType;
	public int getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getRequestMessage() {
		return requestMessage;
	}
	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}
	public Date getLostorStolenDate() {
		return lostorStolenDate;
	}
	public void setLostorStolenDate(Date lostorStolenDate) {
		this.lostorStolenDate = lostorStolenDate;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}	
	
    
    
    
    
    
    
}

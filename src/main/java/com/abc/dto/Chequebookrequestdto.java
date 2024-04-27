package com.abc.dto;

public class Chequebookrequestdto {
	
	private String noOfChequeLeaves;
	private String requestMessage;
	private int serviceRequestId;
	private Long accountNumber;
	
	public String getNoOfChequeLeaves() {
		return noOfChequeLeaves;
	}
	public void setNoOfChequeLeaves(String noOfChequeLeaves) {
		this.noOfChequeLeaves = noOfChequeLeaves;
	}
	public String getRequestMessage() {
		return requestMessage;
	}
	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}
	public int getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}

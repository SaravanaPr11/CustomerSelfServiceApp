package com.abc.dto;

public class ChequebookRequestDto {


	private String noOfChequeLeaves;
	private String requestMessage;
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
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}



}

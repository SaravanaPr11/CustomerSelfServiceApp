package com.abc.dto;

public class ServiceRequestDto {

	private int serviceRequestId;
	private String status;
	private long accountNumber;



	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



}

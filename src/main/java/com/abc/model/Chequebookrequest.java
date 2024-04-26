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
@Table(name = "chequebookRequest")
public class Chequebookrequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "chequeBookRequestId")
	private int chequeBookRequestId;
	
	@Column(name = "noOfChequeLeaves", length = 3, nullable = false)
	private String noOfChequeLeaves;
	
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
	
	@Column(name ="receivedStatus", length = 10)
	private String receivedStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "serviceRequestId")
	private Servicerequest request;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountNumber")
	private Account account;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId")
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

	public int getChequeBookRequestId() {
		return chequeBookRequestId;
	}

	public void setChequeBookRequestId(int chequeBookRequestId) {
		this.chequeBookRequestId = chequeBookRequestId;
	}

	public String getNoOfChequeLeaves() {
		return noOfChequeLeaves;
	}

	public void setNoOfChequeLeaves(String noOfChequeLeaves) {
		this.noOfChequeLeaves = noOfChequeLeaves;
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

	public String getReceivedStatus() {
		return receivedStatus;
	}

	public void setReceivedStatus(String receivedStatus) {
		this.receivedStatus = receivedStatus;
	}
	
}

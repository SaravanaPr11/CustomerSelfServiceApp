package com.abc.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "ServiceRequest")
public class ServiceRequest {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "serviceRequestId")
	  private int serviceRequestId;

	  @Column(name = "requestType", length = 45, nullable = false)
	  private String requestType;

	  public int getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
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

	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "request")
	  private List<ChequebookRequest> chequebookrequests  = new ArrayList<>();

	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "request")
	  private List<CreditordebitRequest> creditordebitrequests = new ArrayList<>();

	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "request")
	  private List<LostorstolenRequest> lostorstolenrequests = new ArrayList<>();
}

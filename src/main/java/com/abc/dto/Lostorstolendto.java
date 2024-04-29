package com.abc.dto;

import java.util.Date;

public class Lostorstolendto {
	

	private int servicerequestid;
    private long accountnumber;
    private String requestmessage;
	private Date loststolendate;
    private long cardnumber;
    private String cardtype;
    
    public Lostorstolendto(int servicerequestid, long accountnumber, String requestmessage, Date loststolendate,
			long cardnumber, String cardtype) {
		super();
		this.servicerequestid = servicerequestid;
		this.accountnumber = accountnumber;
		this.requestmessage = requestmessage;
		this.loststolendate = loststolendate;
		this.cardnumber = cardnumber;
		this.cardtype = cardtype;
		
		

		
		
}

	public int getServicerequestid() {
		return servicerequestid;
	}

	public void setServicerequestid(int servicerequestid) {
		this.servicerequestid = servicerequestid;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getRequestmessage() {
		return requestmessage;
	}

	public void setRequestmessage(String requestmessage) {
		this.requestmessage = requestmessage;
	}

	public Date getLoststolendate() {
		return loststolendate;
	}

	public void setLoststolendate(Date loststolendate) {
		this.loststolendate = loststolendate;
	}

	public long getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
}

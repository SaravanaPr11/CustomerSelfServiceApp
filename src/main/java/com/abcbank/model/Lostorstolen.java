package com.abcbank.model;

import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table( name = "Lostorstolen_request")
public class Lostorstolen {
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "lost_stolen_request_id")
	  private int lost_stolen_request_id;
	
	  @Column(name = "card_type", length = 10, nullable = false)
	  private String card_type;
	  
	  @Column(name = "card_number", length = 16)
	  private BigInteger card_number;
	  
	  @Column(name = "lost_stolen_date", nullable = false)
	  private Date lost_stolen_date;
	  
	  @Column(name = "request_date", nullable = false)
	  @Temporal(TemporalType.DATE)
	  private Date request_date;
	  
	  @Column(name = "request_message", length = 75, nullable = false)
	  private String request_message;
	  
	  @Column(name = "response_date")
	  @Temporal(TemporalType.DATE)
	  private Date response_date;
	  
	  @Column(name = "response_message", length = 75)
	  private String response_message;
	    
	  @Column(name = "response_status", length = 10)
	  private String response_status;
	  
	  @Column(name = "process_id")
	  private int process_id;
	  
	  @Column(name = "css_request_id")
	  private int css_request_id;

	public int getLost_stolen_request_id() {
		return lost_stolen_request_id;
	}

	public void setLost_stolen_request_id(int lost_stolen_request_id) {
		this.lost_stolen_request_id = lost_stolen_request_id;
	}

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public BigInteger getCard_number() {
		return card_number;
	}

	public void setCard_number(BigInteger card_number) {
		this.card_number = card_number;
	}

	public Date getLost_stolen_date() {
		return lost_stolen_date;
	}

	public void setLost_stolen_date(Date lost_stolen_date) {
		this.lost_stolen_date = lost_stolen_date;
	}

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	public String getRequest_message() {
		return request_message;
	}

	public void setRequest_message(String request_message) {
		this.request_message = request_message;
	}

	public Date getResponse_date() {
		return response_date;
	}

	public void setResponse_date(Date response_date) {
		this.response_date = response_date;
	}

	public String getResponse_message() {
		return response_message;
	}

	public void setResponse_message(String response_message) {
		this.response_message = response_message;
	}

	public String getResponse_status() {
		return response_status;
	}

	public void setResponse_status(String response_status) {
		this.response_status = response_status;
	}

	public int getProcess_id() {
		return process_id;
	}

	public void setProcess_id(int process_id) {
		this.process_id = process_id;
	}

	public int getCss_request_id() {
		return css_request_id;
	}

	public void setCss_request_id(int css_request_id) {
		this.css_request_id = css_request_id;
	}
	  
	  

}

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
@Table(name = "Employee")
public class Employee {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "employeeId")
		 private int employeeId;
	  
	  @Column(name = "userName", length = 25, nullable = false)
		 private String userName;
	
	  @Column(name = "password", length = 15, nullable = false)
		 private String password;
	  
	  
	  
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	  private List<Checkbookrequest> chequebookrequests  = new ArrayList<Checkbookrequest>();
	  
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	  private List<Creditordebitrequest> creditordebitrequests = new ArrayList<Creditordebitrequest>();
	  
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	  private List<Lostorstolenrequest> lostorstolenrequests = new ArrayList<Lostorstolenrequest>();

	  

	public List<Checkbookrequest> getChequebookrequests() {
		return chequebookrequests;
	}

	public void setChequebookrequests(List<Checkbookrequest> chequebookrequests) {
		this.chequebookrequests = chequebookrequests;
	}

	public List<Creditordebitrequest> getCreditordebitrequests() {
		return creditordebitrequests;
	}

	public void setCreditordebitrequests(List<Creditordebitrequest> creditordebitrequests) {
		this.creditordebitrequests = creditordebitrequests;
	}

	public List<Lostorstolenrequest> getLostorstolenrequests() {
		return lostorstolenrequests;
	}

	public void setLostorstolenrequests(List<Lostorstolenrequest> lostorstolenrequests) {
		this.lostorstolenrequests = lostorstolenrequests;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	  

}

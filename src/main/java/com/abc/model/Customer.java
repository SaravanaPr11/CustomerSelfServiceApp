package com.abcbankk.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table( name = "Customer")
public class Customer {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "customerId")
	  private int customerId;

	  @Column(name = "name", length = 30, nullable = false)
	  private String name;

	  @Column(name = "userName", length = 20, nullable = false)
	  private String userName;

	  @Column(name = "password", length = 15, nullable = false)
	  private String password;

	  @Column(name = "dob", nullable = false)
	  @Temporal(TemporalType.DATE)
	  private Date dob;

		  @Column(name = "phoneNo", length = 10, nullable = false)
		  private String phoneNo;

		  @Column(name = "doorStreet", length = 45, nullable = false)
		  private String doorStreet;

		  @Column(name = "city", length = 20, nullable = false)
		  private String city;

		  @Column(name = "pincode", length = 6, nullable = false)
		  private String pincode;

		  @Column(name = "panNo", length = 10, nullable = false)
		  private String panNo;

		  @Column(name = "email", length = 35, nullable = false)
		  private String email;

		  @Column(name = "state", length = 30, nullable = false)
		  private String state;

		  @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
		  private List<Account> accounts = new ArrayList<>();

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		public String getDoorStreet() {
			return doorStreet;
		}

		public void setDoorStreet(String doorStreet) {
			this.doorStreet = doorStreet;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

		public String getPanNo() {
			return panNo;
		}

		public void setPanNo(String panNo) {
			this.panNo = panNo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public List<Account> getAccounts() {
			return accounts;
		}

		public void setAccounts(List<Account> accounts) {
			this.accounts = accounts;
		}


}

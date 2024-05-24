package com.abcbankk.dto;

import java.math.BigInteger;
import java.util.Date;

public class LostorstolenRequestDto {

    private long accountNumber;
    private String requestMessage;
	private Date losttolenDate;
    private BigInteger cardNumber;
    private String cardType;

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
	public Date getLosttolenDate() {
		return losttolenDate;
	}
	public void setLosttolenDate(Date losttolenDate) {
		this.losttolenDate = losttolenDate;
	}

	public BigInteger getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(BigInteger cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}




}

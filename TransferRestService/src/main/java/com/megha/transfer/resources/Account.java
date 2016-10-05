package com.megha.transfer.resources;

import java.io.Serializable;
import java.math.BigDecimal;

public class Account implements Serializable{

	private long accountNumber;
	
	private String name;
	
	private BigDecimal balance;
	
	private int version;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
}

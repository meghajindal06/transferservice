package com.megha.transfer.resources;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionRequest {

	private long orderingAccount;
	
	private long beneficiaryAccount;
	
	private BigDecimal amount;
	
	
	public long getOrderingAccount() {
		return orderingAccount;
	}

	public void setOrderingAccount(long orderingAccount) {
		this.orderingAccount = orderingAccount;
	}

	public long getBeneficiaryAccount() {
		return beneficiaryAccount;
	}

	public void setBeneficiaryAccount(long beneficiaryAccount) {
		this.beneficiaryAccount = beneficiaryAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
	
}

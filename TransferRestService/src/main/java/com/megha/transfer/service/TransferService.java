package com.megha.transfer.service;

import com.megha.transfer.resources.TransactionRequest;

public interface TransferService {
	
	/**
	 * validates if the ordering account has sufficient balance 
	 * updates ordering and beneficiary accounts with updated balance
	 * @param transaction
	 */
	public void transfer(TransactionRequest transaction);
}

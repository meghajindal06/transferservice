package com.megha.transfer.service;

import java.math.BigDecimal;

import com.megha.transfer.entity.Account;



public interface AccountService {
	/**
	 * registers a new account with initial deposit
	 * @param name
	 * @param initialDeposit
	 * @return
	 */
	public Account createAccount(String name , BigDecimal initialDeposit);
	
	/**
	 * retrieves account number from memory based on id
	 * @param id
	 * @return
	 */
	public Account getAccount(Long id);
	
}

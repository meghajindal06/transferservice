package com.megha.transfer.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megha.transfer.entity.Account;
import com.megha.transfer.exception.InvalidInputException;
import com.megha.transfer.repository.AccountRepository;
import com.megha.transfer.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountrepo;
	
	@Override
	public Account createAccount(String name , BigDecimal initialDeposit) {
		Account account = null;
		
		if(name != null && (new BigDecimal(0).compareTo(initialDeposit)) != 1){
			account = new Account();
			account.setAccountHolderName(name);
			account.setBalance(initialDeposit);
			
			account = accountrepo.save(account);
		}else{
			throw new InvalidInputException();
		}
		
		return account;
	}

	@Override
	public Account getAccount(Long id) {
		
		Account account = accountrepo.findOne(id);
		return account;
	}
	
	

}

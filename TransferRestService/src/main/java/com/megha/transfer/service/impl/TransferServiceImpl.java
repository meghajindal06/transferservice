package com.megha.transfer.service.impl;

import static com.megha.transfer.validator.TransactionValidator.isEnoughBalance;

import java.math.BigDecimal;

import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer.AmbiguousBindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megha.transfer.entity.Account;
import com.megha.transfer.exception.LowBalanceException;
import com.megha.transfer.repository.AccountRepository;
import com.megha.transfer.resources.TransactionRequest;
import com.megha.transfer.service.TransferService;;

@Service
@Transactional
public class TransferServiceImpl implements TransferService {

	@Autowired
	AccountRepository accountrepo;
	
	
	@Override
	@Transactional(readOnly = false)
	public void transfer(TransactionRequest transaction) {
		Account fromAccount = accountrepo.findOne(transaction.getOrderingAccount());
		Account toAccount = accountrepo.findOne(transaction.getBeneficiaryAccount());
		
		if(isEnoughBalance(fromAccount, transaction.getAmount())){
			//update from account with the new balance
			BigDecimal newFromAccountBalance = fromAccount.getBalance().subtract(transaction.getAmount());
			fromAccount.setBalance(newFromAccountBalance);
			accountrepo.save(fromAccount);
			
			//update to account with the new balance
			BigDecimal newToAccountBalance = toAccount.getBalance().add(transaction.getAmount());
			toAccount.setBalance(newToAccountBalance);
			accountrepo.save(toAccount);
		}else{
			throw new LowBalanceException();
		}
		
		
	}

}

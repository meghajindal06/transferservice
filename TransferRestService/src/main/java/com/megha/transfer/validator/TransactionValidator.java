package com.megha.transfer.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.megha.transfer.entity.Account;
import com.megha.transfer.exception.InvalidInputException;

@Component
public class TransactionValidator {

	/**
	 * validates if the account has sufficient balance for transfer
	 * @param fromAccount
	 * @param transferAmount
	 * @return
	 */
	public static boolean isEnoughBalance(Account fromAccount , BigDecimal transferAmount){
		
		if(fromAccount !=null 
				&& fromAccount.getBalance()!=null 
				&&  transferAmount !=null) {
			
			BigDecimal currentbalance = fromAccount.getBalance();
			
			BigDecimal balanceAfterTransaction = currentbalance.subtract(transferAmount);
			
			if(balanceAfterTransaction.compareTo(new BigDecimal(0)) != -1){
				return true;
			}
		}else{
			throw new InvalidInputException();
		}
		return false;
	}
	
}

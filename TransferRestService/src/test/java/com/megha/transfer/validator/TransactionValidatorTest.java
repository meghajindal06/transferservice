package com.megha.transfer.validator;

import static com.megha.transfer.validator.TransactionValidator.isEnoughBalance;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.megha.transfer.entity.Account;
import com.megha.transfer.exception.InvalidInputException;
import com.megha.transfer.exception.LowBalanceException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionValidatorTest {

	
	
	
	
	@Test
	public void isEnoughBalance_amountNull(){
		try{
			Account account = new Account();
			account.setBalance(new BigDecimal(150));
			isEnoughBalance(account, null);
		}catch(Exception e){
			Assert.isTrue(e instanceof InvalidInputException);
		}
		
	}
	
	@Test
	public void isEnoughBalance_BalanceNull(){
		
		try{
			Account account = new Account();
			isEnoughBalance(account, new BigDecimal(12));
		}catch(Exception e){
			Assert.isTrue(e instanceof InvalidInputException);
		}
	}
	
	@Test
	public void testgetGameBoard_AccountNull(){
		try{
			isEnoughBalance(null, new BigDecimal(12));
		}catch(Exception e){
			Assert.isTrue(e instanceof InvalidInputException);
		}
	}
	
	@Test
	public void isEnoughBalance_balanceLess(){
		try{
			Account account = new Account();
			account.setBalance(new BigDecimal(150));
			isEnoughBalance(account, new BigDecimal(200));
		}catch(Exception e){
			Assert.isTrue(e instanceof LowBalanceException);
		}
		
	}
	
	@Test
	public void isEnoughBalance_balanceEnough(){
		Account account = new Account();
		account.setBalance(new BigDecimal(150));
		Assert.isTrue(isEnoughBalance(account, new BigDecimal(100)));
	}
	
}


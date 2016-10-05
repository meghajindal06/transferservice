package com.megha.transfer.service;

import static com.megha.transfer.validator.TransactionValidator.isEnoughBalance;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.megha.transfer.entity.Account;
import com.megha.transfer.exception.InvalidInputException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountServiceTest {

	@Autowired
	AccountService accountService;
	
	@Test
	public void createAccount_NameNull(){
		try{
			
			accountService.createAccount(null, new BigDecimal(12));
			
		}catch(Exception e){
			Assert.isTrue(e instanceof InvalidInputException);
		}
		
	}
	
	@Test
	public void createAccount_InitialDeposit0(){
		try{
			
			accountService.createAccount("test", new BigDecimal(0));
			
		}catch(Exception e){
			Assert.isTrue(e instanceof InvalidInputException);
		}
		
	}
	
	
	
}

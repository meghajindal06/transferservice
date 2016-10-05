package com.megha.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megha.transfer.resources.Account;
import com.megha.transfer.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping("accounts")
    @PostMapping
    public HttpEntity<Account> play(@RequestBody Account accountRequest) throws NoSuchMethodException, SecurityException {
      
		com.megha.transfer.entity.Account accountEntity =  accountService.createAccount(accountRequest.getName(), accountRequest.getBalance());

		Account account = populateResource(accountEntity);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
    
    }
	
	@RequestMapping("/accounts/{id}")
    @PostMapping
    public HttpEntity<Account> play(@PathVariable Long id) throws NoSuchMethodException, SecurityException {
      
		com.megha.transfer.entity.Account accountEntity =  accountService.getAccount(id);
		
		Account account = populateResource(accountEntity);
    	return new ResponseEntity<Account>(account, HttpStatus.OK);
    
    }
	
	/**
	 * populate account resource from entity
	 * @param accountEntity
	 * @return
	 */
	private Account populateResource(com.megha.transfer.entity.Account accountEntity){
		Account account = new Account();
		account.setAccountNumber(accountEntity.getId());
		account.setBalance(accountEntity.getBalance());
		account.setName(accountEntity.getAccountHolderName());
		account.setVersion(accountEntity.getVersion());
		return account;
	}
	
}

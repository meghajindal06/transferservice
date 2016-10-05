package com.megha.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megha.transfer.resources.TransactionRequest;
import com.megha.transfer.service.TransferService;

@RestController
public class TransferController {

	
	@Autowired
	TransferService transferService;
	
	@RequestMapping("/transfer")
    @PostMapping
    public HttpEntity transfer(@RequestBody TransactionRequest transactionRequest) throws NoSuchMethodException, SecurityException {
		transferService.transfer(transactionRequest);
		
		return new ResponseEntity( HttpStatus.OK);
    }
    	
    	
     
    	
    }


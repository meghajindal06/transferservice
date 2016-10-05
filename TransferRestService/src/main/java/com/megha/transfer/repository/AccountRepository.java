package com.megha.transfer.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.megha.transfer.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	 @Override
	    @Lock(LockModeType.PESSIMISTIC_WRITE)
	    Account findOne(Long id);
}

 

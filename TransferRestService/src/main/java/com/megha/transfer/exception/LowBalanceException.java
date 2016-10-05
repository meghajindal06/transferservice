package com.megha.transfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Balance is too low")
public class LowBalanceException extends RuntimeException {

}

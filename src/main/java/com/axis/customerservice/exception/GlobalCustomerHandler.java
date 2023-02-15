package com.axis.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalCustomerHandler {
	
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<String> customerNotFoundExceptionHandler(CustomerNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = InsufficientFundException.class)
	public ResponseEntity<String> insufficientFundExceptionHandler(InsufficientFundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = TransferLimitExceededException.class)
	public ResponseEntity<String> transferLimitExceededExceptionHandler(TransferLimitExceededException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(value = TransactionNotFoundException.class)
	public ResponseEntity<String> transactionNotFoundExceptionHandler(TransactionNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.METHOD_NOT_ALLOWED);
	}
}

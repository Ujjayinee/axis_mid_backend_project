package com.axis.customerservice.exception;

public class TransactionNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -465345L;

	public TransactionNotFoundException() {
		super();
	}

	public TransactionNotFoundException(String message) {
		super(message);
	}
	
	

}

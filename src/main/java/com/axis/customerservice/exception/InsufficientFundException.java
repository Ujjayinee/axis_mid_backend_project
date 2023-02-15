package com.axis.customerservice.exception;

public class InsufficientFundException extends RuntimeException{
	
	private static final long serialVersionUID = -465340L;

	public InsufficientFundException() {
		super();
	}

	public InsufficientFundException(String message) {
		super(message);
	}
	
}

package com.axis.customerservice.exception;

public class AccountNumberNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -465344L;

	public AccountNumberNotFoundException() {
		super();
	}

	public AccountNumberNotFoundException(String message) {
		super(message);
	}
	
	
	
}

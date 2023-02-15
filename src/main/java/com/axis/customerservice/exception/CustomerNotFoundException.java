package com.axis.customerservice.exception;

public class CustomerNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -465320L;
	
	public CustomerNotFoundException() {
		super();
		
	}

	public CustomerNotFoundException(String message) {
		super(message);
		
	}

}

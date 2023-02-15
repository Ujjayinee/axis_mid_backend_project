package com.axis.customerservice.exception;

public class TransferLimitExceededException extends RuntimeException{
	private static final long serialVersionUID = -465342L;

	public TransferLimitExceededException() {
		super();
	}

	public TransferLimitExceededException(String message) {
		super(message);
	}

	
}

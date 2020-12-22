package com.ekart.application.exception;

public class InsufficientQuantityException extends Exception {

	private static final long serialVersionUID = 147932938293L;
	
	private final String message;
	
	public InsufficientQuantityException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}

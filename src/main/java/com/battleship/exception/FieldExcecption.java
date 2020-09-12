package com.battleship.exception;

public class FieldExcecption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public FieldExcecption(String message) {
		super();
		this.message = message;
	}

	public FieldExcecption() {
		super();
	}

	public FieldExcecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FieldExcecption(String message, Throwable cause) {
		super(message, cause);
	}

	public FieldExcecption(Throwable cause) {
		super(cause);
	}

	@Override
	public String getMessage() {
		return message;
	}

}
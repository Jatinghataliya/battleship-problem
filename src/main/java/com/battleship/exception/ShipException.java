package com.battleship.exception;

public class ShipException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public ShipException(String message) {
		super();
		this.message = message;
	}

	public ShipException() {
		super();
	}

	public ShipException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ShipException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShipException(Throwable cause) {
		super(cause);
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
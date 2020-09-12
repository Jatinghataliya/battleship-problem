package com.battleship.exception;

public class LocationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public LocationException() {
		super();
	}

	public LocationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LocationException(String message, Throwable cause) {
		super(message, cause);
	}

	public LocationException(Throwable cause) {
		super(cause);
	}

	public LocationException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
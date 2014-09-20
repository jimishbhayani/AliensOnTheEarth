package com.multunus.aliens.exception;

public class AlienManagementException extends Exception {

	private static final long serialVersionUID = 1208983469264773428L;

	public AlienManagementException() {
	}

	public AlienManagementException(String message) {
		super(message);
	}

	public AlienManagementException(Throwable cause) {
		super(cause);
	}

	public AlienManagementException(String message, Throwable cause) {
		super(message, cause);
	}

}

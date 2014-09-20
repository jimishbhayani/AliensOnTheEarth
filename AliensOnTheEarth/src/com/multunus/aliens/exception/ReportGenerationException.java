package com.multunus.aliens.exception;

public class ReportGenerationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8689798841374486079L;

	public ReportGenerationException() {
	}

	public ReportGenerationException(String message) {
		super(message);
	}

	public ReportGenerationException(Throwable cause) {
		super(cause);
	}

	public ReportGenerationException(String message, Throwable cause) {
		super(message, cause);
	}

}

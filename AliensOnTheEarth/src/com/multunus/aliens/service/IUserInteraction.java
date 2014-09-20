package com.multunus.aliens.service;

/**
 * 
 * This interface defines functionalities for User Interaction with Application
 * 
 * @author Jimish
 *
 */
public interface IUserInteraction {
	
	/**
	 * 
	 * Controllers User Actions
	 * 
	 */
	public void driveUserAction();

	/**
	 * 
	 * Prints Available Functions in Applications
	 * 
	 */
	public void printAvailableFunctions();
	
	/**
	 * Captures User Response 
	 */
	public String getUserSelectedFunction();
	
}

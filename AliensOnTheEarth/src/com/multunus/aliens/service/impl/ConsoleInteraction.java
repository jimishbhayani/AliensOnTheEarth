package com.multunus.aliens.service.impl;

import java.io.PrintWriter;
import java.util.Scanner;

import com.multunus.aliens.service.IUserInteraction;

/**
 * Concrete Implementation for IUserInteraction interface.
 * 
 * This implementation is based on Console Input/Output.
 * 
 * @author Jimish
 *
 */
public class ConsoleInteraction implements IUserInteraction {

	AlienRegistrationHandler alienRegistrationHandler;
	ReportGenerationHandler reportGenerationHandler;
	
	private PrintWriter consoleWriter = null;
	private Scanner consoleReader = null;

	/**
	 * 
	 * Initializes consoleWriter and ConsoleReader Objects
	 * 
	 * This will be called through Spring Framework
	 * 
	 */
	
	public void init() {
		consoleWriter = new PrintWriter(System.out, true);
		consoleReader = new Scanner(System.in);
	}

	/* (non-Javadoc)
	 * @see com.multunus.aliens.service.IUserInteraction#userActionController()
	 */
	@Override
	public void driveUserAction() {
		consoleWriter.println("Welcome to Alien Registration System");
		String userInput = null;

		while (!"0".equals(userInput)) {
			this.printAvailableFunctions();
			userInput = getUserSelectedFunction();
			if ("0".equals(userInput)) {
				break;
			} else if ("1".equals(userInput)) {
				userInput = alienRegistrationHandler.handleAlienRegistration();
			} else if ("2".equals(userInput)) {
				userInput = reportGenerationHandler.handleReportGeneration();
			} else {
				consoleWriter.println("Please select valid Option");
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.multunus.aliens.service.IUserInteraction#printAvailableFunctions()
	 */
	@Override
	public void printAvailableFunctions() {
		consoleWriter.println("Kindly Select One of the Function to Perform");
		consoleWriter.println("Press 1 for Alien Registration");
		consoleWriter.println("Press 2 for Report Generation");
		consoleWriter.println("Press 0 to Exit");
	}

	/* (non-Javadoc)
	 * @see com.multunus.aliens.service.IUserInteraction#getUserSelectedFunction()
	 */
	@Override
	public String getUserSelectedFunction() {
		String userInput = consoleReader.nextLine();
		return userInput;
	}

	/**
	 *
	 *Destroys the Reader Writer object
	 *
	 *This method will be called through Spring Framework
	 * 
	 */
	
	public void destroy() {
		consoleReader.close();
		consoleWriter.close();
	}

	/**
	 * @return the alienRegistrationHandler
	 */
	public AlienRegistrationHandler getAlienRegistrationHandler() {
		return alienRegistrationHandler;
	}

	/**
	 * @param alienRegistrationHandler the alienRegistrationHandler to set
	 */
	public void setAlienRegistrationHandler(
			AlienRegistrationHandler alienRegistrationHandler) {
		this.alienRegistrationHandler = alienRegistrationHandler;
	}

	/**
	 * @return the reportGenerationHandler
	 */
	public ReportGenerationHandler getReportGenerationHandler() {
		return reportGenerationHandler;
	}

	/**
	 * @param reportGenerationHandler the reportGenerationHandler to set
	 */
	public void setReportGenerationHandler(
			ReportGenerationHandler reportGenerationHandler) {
		this.reportGenerationHandler = reportGenerationHandler;
	}
}

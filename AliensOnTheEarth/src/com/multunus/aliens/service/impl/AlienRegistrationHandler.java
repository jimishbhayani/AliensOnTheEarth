package com.multunus.aliens.service.impl;

import java.io.PrintWriter;
import java.util.Scanner;

import com.multunus.aliens.dao.oto.AlienOTO;
import com.multunus.aliens.exception.AlienManagementException;
import com.multunus.aliens.service.IAlienRegistrationService;

/**
 * Handler the Requests for Alien Registration.
 * 
 * @author Jimish
 *
 */
public class AlienRegistrationHandler {

	private IAlienRegistrationService alienRegistrationService;
	
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
	
	/**
	 * 
	 * Handles Alien Registration Proocess
	 * 
	 */
	public String handleAlienRegistration(){
		
		String userInput = null;
		while (true) {
			AlienOTO alienOTO = readAlienData();
			try {
				alienRegistrationService.registerAlien(alienOTO);
			} catch (AlienManagementException e) {
				consoleWriter
						.println("Something was not right, Kindly Try after Sometime");
			}
			userInput = handlePostRegistration();
			if ("0".equals(userInput) || "#".equals(userInput)) {
				break;
			}
		}
		return userInput;
	}
	
	/**
	 * 
	 * Read Alien Information from Console.
	 * 
	 */
	private AlienOTO readAlienData(){
		consoleWriter.println("Enter Following Details ");
		AlienOTO alienOTO =new  AlienOTO();
		consoleWriter.println("Enter Code Name : ");
		alienOTO.setCodeName(consoleReader.nextLine());
		
		consoleWriter.println("Enter Blood Color : ");
		alienOTO.setBloodColor(consoleReader.nextLine());
		
		consoleWriter.println("Enter Home Planet : ");
		alienOTO.setHomePlanet(consoleReader.nextLine());
		
		consoleWriter.println("Enter No Of Antennas : ");
		alienOTO.setAntennasCount(consoleReader.nextInt());
		
		consoleWriter.println("Enter No Of Legs : ");
		alienOTO.setLegsCount(consoleReader.nextInt());
		consoleReader.nextLine();
		return alienOTO;
	}

	
	
	/**
	 * 
	 * Handles Post Registration Process Flow
	 * 
	 */
	private String handlePostRegistration() {
		String userInput = null;
		while (true) {
			this.printPostRegistrationOption();
			userInput = this.getUserReponse();
			if (("1".equals(userInput) || "0".equals(userInput) || "#"
					.equals(userInput))) {
				break;
			} else {
				consoleWriter.println("Please select valid Option");
			}
		}
		return userInput;
	}

	/**
	 * 
	 * Retuns the User Response from Console to drive Process Flow
	 * 
	 */
	private String getUserReponse() {
		return consoleReader.nextLine();
	}

	/**
	 * 
	 * Prints Post Registration Options to Console
	 * 
	 */
	private void printPostRegistrationOption() {
		consoleWriter.println("Press 1 to Register Anoter Alien");
		consoleWriter.println("Press # go back to Previous Menu");
		consoleWriter.println("Press 0 to Exit");
	}
	
	/**
	 *
	 *Destroys the Reader Writer object
	 *
	 *This method will be called through Spring Framework
	 * 
	 */
	public void destroy(){
		consoleReader.close();
		consoleWriter.close();
	}

	/**
	 * @return the alienRegistrationService
	 */
	public IAlienRegistrationService getAlienRegistrationService() {
		return alienRegistrationService;
	}

	/**
	 * @param alienRegistrationService the alienRegistrationService to set
	 */
	public void setAlienRegistrationService(
			IAlienRegistrationService alienRegistrationService) {
		this.alienRegistrationService = alienRegistrationService;
	}

}

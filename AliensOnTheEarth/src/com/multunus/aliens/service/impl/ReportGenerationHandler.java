package com.multunus.aliens.service.impl;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import com.multunus.aliens.exception.AlienManagementException;
import com.multunus.aliens.exception.ReportGenerationException;
import com.multunus.aliens.service.IAlienRegistrationService;
import com.multunus.aliens.service.IReportGenerator;

/**
 * Handles Requests for Report Generation
 * 
 * @author Jimish
 *
 */
public class ReportGenerationHandler {

	private ReportGeneratorMapper reportGeneratorMapper;
	private ReportGeneratorFactory reportGeneratorFactory;
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
	 * Handles Report Generation Request
	 * 
	 * @return
	 */
	public String handleReportGeneration() {
		String userInput = null;
		while (!"0".equals(userInput)) {
			this.printAvailableReports();
			userInput = this.getUserPrefferedFormat();
			if ("0".equals(userInput)) {
				break;
			} else if ("#".equals(userInput)) {
				break;
			} else if (reportGeneratorMapper
					.getReportGeneratorRepositoryMappper().containsValue(
							userInput)) {
				generateReport(userInput);
				userInput = this.handlePostReportGeneration();
				if ("#".equals(userInput)) {
					break;
				}
			} else {
				consoleWriter.println("Please select valid Option");
			}
		}
		return userInput;
	}

	/**
	 * 
	 * Prints Available Report Formats 
	 * 
	 */
	private void printAvailableReports() {
		consoleWriter.println("Following Report Formates Available : ");
		Map<String, String> reportFormates = reportGeneratorMapper
				.getReportGeneratorRepositoryMappper();
		for (Map.Entry<String, String> entry : reportFormates.entrySet()) {
			consoleWriter.printf("%s %s %s %s%n", "Press ", entry.getValue(),
					" for ", entry.getKey());
		}
		consoleWriter.println("Press # to go back to Previous Menu");
		consoleWriter.println("Press 0 to got Exit");
	}

	/**
	 * Captures User Selected Option
	 */
	private String getUserPrefferedFormat() {
		String userInput = consoleReader.nextLine();
		return userInput;
	}

	/**
	 * Handles Post Report Generation Process Flow
	 */
	private String handlePostReportGeneration() {
		String userInput = null;
		while (true) {
			this.printPostReportOption();
			userInput = this.getUserPrefferedFormat();
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
	 * Prints Post Report Generation Options
	 * 
	 */
	private void printPostReportOption() {
		consoleWriter.println("Press 1 to Generate another Report");
		consoleWriter.println("Press # go back to Previous Menu");
		consoleWriter.println("Press 0 to Exit");
	}

	/**
	 * Based on the Format Selected by User, this method will get the object of Report Generator From Factory
	 * and call the generateReportMethod
	 * 
	 * @param userSelectedFormat
	 */
	private void generateReport(String userSelectedFormat) {
		IReportGenerator reportGenerator = reportGeneratorFactory
				.getReportGenerator(userSelectedFormat);
		try {
			reportGenerator.generateReport(alienRegistrationService
					.getAllAliens());
		} catch (AlienManagementException e) {
			consoleWriter
					.println("Something was not right, Kindly Try after Sometime");
		} catch (ReportGenerationException e) {
			consoleWriter
					.println("Something was not right, Kindly Try after Sometime");
		}
	}

	/**
	 * 
	 * Destroys the Reader Writer object
	 * 
	 * This method will be called through Spring Framework
	 * 
	 */
	public void destroy() {
		consoleReader.close();
		consoleWriter.close();
	}

	/**
	 * @return the reportGeneratorMapper
	 */
	public ReportGeneratorMapper getReportGeneratorMapper() {
		return reportGeneratorMapper;
	}

	/**
	 * @param reportGeneratorMapper
	 *            the reportGeneratorMapper to set
	 */
	public void setReportGeneratorMapper(
			ReportGeneratorMapper reportGeneratorMapper) {
		this.reportGeneratorMapper = reportGeneratorMapper;
	}

	/**
	 * @return the reportGeneratorFactory
	 */
	public ReportGeneratorFactory getReportGeneratorFactory() {
		return reportGeneratorFactory;
	}

	/**
	 * @param reportGeneratorFactory
	 *            the reportGeneratorFactory to set
	 */
	public void setReportGeneratorFactory(
			ReportGeneratorFactory reportGeneratorFactory) {
		this.reportGeneratorFactory = reportGeneratorFactory;
	}

	/**
	 * @return the alienRegistrationService
	 */
	public IAlienRegistrationService getAlienRegistrationService() {
		return alienRegistrationService;
	}

	/**
	 * @param alienRegistrationService
	 *            the alienRegistrationService to set
	 */
	public void setAlienRegistrationService(
			IAlienRegistrationService alienRegistrationService) {
		this.alienRegistrationService = alienRegistrationService;
	}

}

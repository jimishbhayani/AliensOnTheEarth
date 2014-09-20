package com.multunus.aliens.service.impl;

import java.util.Map;

/**
 * This is actually a Helper Class for ReportGeneratorFactory.
 * 
 * It keeps a HashMap to map the option to be shown to user and corresponding
 * ReportFormat Alias to be used by the ReportGeneratorFactory
 * 
 * @author Jimish
 * 
 */
public class ReportGeneratorMapper {

	/**
	 * 
	 * Populated through Spirng Configuration
	 * 
	 * Based on the Format Available, the corresponding entries to be made in
	 * Spring Configuration.
	 * 
	 */
	private Map<String, String> reportGeneratorRepositoryMappper;

	/**
	 * @return the reportGeneratorRepositoryMappper
	 */
	public Map<String, String> getReportGeneratorRepositoryMappper() {
		return reportGeneratorRepositoryMappper;
	}

	/**
	 * @param reportGeneratorRepositoryMappper
	 *            the reportGeneratorRepositoryMappper to set
	 */
	public void setReportGeneratorRepositoryMappper(
			Map<String, String> reportGeneratorRepositoryMappper) {
		this.reportGeneratorRepositoryMappper = reportGeneratorRepositoryMappper;
	}

}

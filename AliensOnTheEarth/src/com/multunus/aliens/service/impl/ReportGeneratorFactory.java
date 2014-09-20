package com.multunus.aliens.service.impl;

import java.util.Map;

import com.multunus.aliens.service.IReportGenerator;

/**
 * Factory Class to return Object of Selected Report Type.
 * 
 * It Keeps a Map for all the Available Report Format.
 * 
 * This map is populated through Spring Configuration.
 * 
 * To Plug in any new Report Format, Implement the IReportGenerator interface,
 * And make corresponding entry in Spring Configuration file.
 * 
 * @author Jimish
 *
 */
public class ReportGeneratorFactory {

	private Map<String, IReportGenerator> reportGeneratorRepository;
	

	/**
	 *	Produces the Object to generator Reports
	 * 
	 * @param reportFormat
	 * @return Object of IReportGenerator based on the reportFormat Provided
	 */
	public IReportGenerator getReportGenerator(String reportFormat) {
		return this.reportGeneratorRepository.get(reportFormat);
	}


	/**
	 * @return the reportGeneratorRepository
	 */
	public Map<String, IReportGenerator> getReportGeneratorRepository() {
		return reportGeneratorRepository;
	}


	/**
	 * @param reportGeneratorRepository the reportGeneratorRepository to set
	 */
	public void setReportGeneratorRepository(
			Map<String, IReportGenerator> reportGeneratorRepository) {
		this.reportGeneratorRepository = reportGeneratorRepository;
	}
	
}

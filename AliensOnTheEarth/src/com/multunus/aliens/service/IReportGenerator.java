package com.multunus.aliens.service;

import java.util.List;

import com.multunus.aliens.exception.ReportGenerationException;
import com.multunus.aliens.oto.AlienOTO;

/**
 * This Interface defines functionality to Generate Reports
 * 
 * @author Jimish
 *
 */
public interface IReportGenerator {

	/**
	 * This method will have logic to generate the Report.
	 * 
	 * @param dataList
	 * @throws ReportGenerationException
	 */
	public void generateReport(List<AlienOTO> dataList) throws ReportGenerationException;
	
}

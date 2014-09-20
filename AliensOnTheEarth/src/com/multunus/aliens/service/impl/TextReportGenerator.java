package com.multunus.aliens.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.multunus.aliens.dao.oto.AlienOTO;
import com.multunus.aliens.exception.ReportGenerationException;
import com.multunus.aliens.service.IReportGenerator;

/**
 * Concrete Implementation of IReportGenerator to generate Report in Text Format.
 * 
 * This Class Uses Simple Java I/O Api to generate Text File
 * 
 * Currently text file format is Hard Coded inside method logic,
 * 
 * Same can be done through External configuration
 * 
 * @author Jimish
 * 
 */

public class TextReportGenerator implements IReportGenerator {

	/**
	 * Path of the report file to be Generated
	 */
	String reportPath = null;
	
	/* (non-Javadoc)
	 * @see com.multunus.aliens.service.IReportGenerator#generateReport(java.util.List)
	 */
	@Override
	public void generateReport(List<AlienOTO> dataList)
			throws ReportGenerationException {
		FileWriter fw;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("%60s%n%n%n", "Aliens Report"));
			sb.append(String.format("%-20s %-20s %-20s %-20s %-20s %-20s%n",
					"Alien Id", 
					"Code Name", 
					"Blood Color", 
					"No Of Aentennas",
					"No Of Legs", 
					"Home Planet"));
			sb.append(String.format("%-20s %-20s %-20s %-20s %-20s %-20s%n",
					"--------------", "--------------", "--------------",
					"--------------", "--------------", "--------------"));
			for (AlienOTO alienOTO : dataList) {
				sb.append(String.format(
						"%-20s %-20s %-20s %-20s %-20s %-20s%n",
						alienOTO.getAlienId(), 
						alienOTO.getCodeName(),
						alienOTO.getBloodColor(), 
						alienOTO.getAntennasCount(),
						alienOTO.getLegsCount(), 
						alienOTO.getHomePlanet()));
			}
			fw = new FileWriter(reportPath);
			fw.write(sb.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return the reportPath
	 */
	public String getReportPath() {
		return reportPath;
	}

	/**
	 * @param reportPath the reportPath to set
	 */
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}
	
}

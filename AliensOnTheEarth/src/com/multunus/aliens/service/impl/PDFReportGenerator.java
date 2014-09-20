package com.multunus.aliens.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import com.multunus.aliens.dao.oto.AlienOTO;
import com.multunus.aliens.exception.ReportGenerationException;
import com.multunus.aliens.service.IReportGenerator;

/**
 * Concrete Implementation of IReportGenerator to generate Report in PDF Format.
 * 
 * This Class Uses Jasper Reprots {@link JasperReport} to generate PDF File
 * 
 * @author Jimish
 * 
 */
public class PDFReportGenerator implements IReportGenerator {

	/**
	 * 
	 * This is PDF Template file. Jasper Will use this template to populate
	 * Actual Data.
	 * 
	 */
	private String reportTemplatePath;

	/**
	 * Path of the report file to be Generated
	 */
	private String reportPath;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.multunus.aliens.service.IReportGenerator#generateReport(java.util
	 * .List)
	 */
	@Override
	public void generateReport(List<AlienOTO> dataList)
			throws ReportGenerationException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ReportTitle", "Aliens Report");
		try {
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					dataList);
			JasperReport report = (JasperReport) JRLoader
					.loadObjectFromFile(reportTemplatePath);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,
					parameters, beanColDataSource);
			if (jasperPrint != null) {
				byte[] pdfReport = JasperExportManager
						.exportReportToPdf(jasperPrint);
				FileOutputStream fos = new FileOutputStream(reportPath);
				fos.write(pdfReport);
				fos.close();
			}
		} catch (JRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the reportTemplatePath
	 */
	public String getReportTemplatePath() {
		return reportTemplatePath;
	}

	/**
	 * @param reportTemplatePath
	 *            the reportTemplatePath to set
	 */
	public void setReportTemplatePath(String reportTemplatePath) {
		this.reportTemplatePath = reportTemplatePath;
	}

	/**
	 * @return the reportPath
	 */
	public String getReportPath() {
		return reportPath;
	}

	/**
	 * @param reportPath
	 *            the reportPath to set
	 */
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

}

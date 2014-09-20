package com.multunus.aliens.utils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

/**
 * Utility Class for Jasper
 * 
 * @author Jimish
 *
 */
public class JasperUtils {

	/**
	 * 
	 * Currently Application uses Precompiled Jasper Report Template for Better Performance
	 * 
	 * But if template need to be altered then in that case this method can be used to complile
	 * .jrxml file and produce compiled .jasper file
	 * 
	 * @param path
	 * @throws JRException
	 */
	public static void compliePdfReportTemplate(String path) throws JRException{
		JasperCompileManager.compileReportToFile(path);
	}
	
}

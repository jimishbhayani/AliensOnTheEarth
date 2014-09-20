package com.multunus.aliens.dao;

import java.util.List;

import com.multunus.aliens.dao.oto.AlienOTO;
import com.multunus.aliens.exception.AlienManagementException;

/**
 * 
 * Interface to Specify the methods which interacts with the Database Layer.
 * 
 * @author Jimish
 * 
 */
public interface IAlienRegistrationDAO {

	/**
	 * 
	 * This Method is used to save the Alien Data in Database
	 * 
	 * @param alienOTO
	 * @return Unique Alien Id
	 * @throws AlienManagementException
	 */
	public Integer registerAlien(AlienOTO alienOTO)
			throws AlienManagementException;

	/**
	 * 
	 * This method is used to retrieve Alien Data based on Unique Alien Id
	 * 
	 * @param alienId
	 * @return Alien information in Form of {@link AlienOTO}
	 * @throws AlienManagementException
	 */
	public AlienOTO getAlienInfo(Integer alienId)
			throws AlienManagementException;

	/**
	 * 
	 * This method will return all the Aliens Information Stored in Database
	 * 
	 * @return List<AlienOTO>
	 * @throws AlienManagementException
	 */
	public List<AlienOTO> getAllAliens() throws AlienManagementException;

}

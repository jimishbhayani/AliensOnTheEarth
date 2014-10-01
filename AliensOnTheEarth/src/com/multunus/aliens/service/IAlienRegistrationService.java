package com.multunus.aliens.service;

import java.util.List;

import com.multunus.aliens.exception.AlienManagementException;
import com.multunus.aliens.oto.AlienOTO;

/**
 * This is Service Interface that defines the Alien Management functionalities 
 * 
 * @author Jimish
 *
 */
public interface IAlienRegistrationService {

	/**
	 * 
	 * This method will be used to register Alien Information
	 * 
	 * @param alienOTO
	 * @return Unique Alien Id
	 * @throws AlienManagementException
	 */
	public Integer registerAlien(AlienOTO alienOTO) throws AlienManagementException;
	
	/**
	 * This method is used to retrieve Alien Data based on Unique Alien Id
	 * 
	 * @param alienId
	 * @return Alien information in Form of {@link AlienOTO}
	 * @throws AlienManagementException
	 */
	public AlienOTO getAlienInfo(Integer alienId) throws AlienManagementException;
	
	/**
	 * This method will return all the Aliens Information
	 * 
	 * @return
	 * @throws AlienManagementException
	 */
	public List<AlienOTO> getAllAliens() throws AlienManagementException;
	
}

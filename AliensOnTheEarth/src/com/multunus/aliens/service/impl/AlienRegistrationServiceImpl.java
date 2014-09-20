package com.multunus.aliens.service.impl;

import java.util.List;

import com.multunus.aliens.dao.IAlienRegistrationDAO;
import com.multunus.aliens.dao.oto.AlienOTO;
import com.multunus.aliens.exception.AlienManagementException;
import com.multunus.aliens.service.IAlienRegistrationService;

/**
 * 
 * Implementation for IAlienRegistrationService Interface
 * 
 * This will contain business logic for alien Registration if any.
 * 
 * @author Jimish
 *
 */
public class AlienRegistrationServiceImpl implements IAlienRegistrationService {

	private IAlienRegistrationDAO alienRegistrationDAO;
	
	/* (non-Javadoc)
	 * @see com.multunus.aliens.service.IAlienRegistrationService#registerAlien(com.multunus.aliens.dao.oto.AlienOTO)
	 */
	@Override
	public Integer registerAlien(AlienOTO alienOTO)
			throws AlienManagementException {
		return alienRegistrationDAO.registerAlien(alienOTO);
	}

	/* (non-Javadoc)
	 * @see com.multunus.aliens.service.IAlienRegistrationService#getAlienInfo(java.lang.Integer)
	 */
	@Override
	public AlienOTO getAlienInfo(Integer alienId)
			throws AlienManagementException {
		return alienRegistrationDAO.getAlienInfo(alienId);
	}

	/* (non-Javadoc)
	 * @see com.multunus.aliens.service.IAlienRegistrationService#getAllAliens()
	 */
	@Override
	public List<AlienOTO> getAllAliens() throws AlienManagementException {
		return alienRegistrationDAO.getAllAliens();
	}

	/**
	 * @return the alienRegistrationDAO
	 */
	public IAlienRegistrationDAO getAlienRegistrationDAO() {
		return alienRegistrationDAO;
	}

	/**
	 * @param alienRegistrationDAO the alienRegistrationDAO to set
	 */
	public void setAlienRegistrationDAO(IAlienRegistrationDAO alienRegistrationDAO) {
		this.alienRegistrationDAO = alienRegistrationDAO;
	}
	
}

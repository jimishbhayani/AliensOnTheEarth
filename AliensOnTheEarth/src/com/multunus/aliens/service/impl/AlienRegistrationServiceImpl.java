package com.multunus.aliens.service.impl;

import java.util.List;

import com.multunus.aliens.exception.AlienManagementException;
import com.multunus.aliens.oto.AlienOTO;
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

	private List<AlienOTO> alienData;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.multunus.aliens.service.IAlienRegistrationService#registerAlien(com
	 * .multunus.aliens.dao.oto.AlienOTO)
	 */
	@Override
	public Integer registerAlien(AlienOTO alienOTO)
			throws AlienManagementException {
		Integer generatedId = 1;
		if (alienData.isEmpty()) {
			alienOTO.setAlienId(generatedId);
			alienData.add(alienOTO);
		} else {
			Integer maxId = alienData.size();
			generatedId = maxId + 1;
			alienOTO.setAlienId(generatedId);
			alienData.add(alienOTO);
		}
		return generatedId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.multunus.aliens.service.IAlienRegistrationService#getAlienInfo(java
	 * .lang.Integer)
	 */
	@Override
	public AlienOTO getAlienInfo(Integer alienId)
			throws AlienManagementException {
		return alienData.get(alienId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.multunus.aliens.service.IAlienRegistrationService#getAllAliens()
	 */
	@Override
	public List<AlienOTO> getAllAliens() throws AlienManagementException {
		return alienData;
	}

	/**
	 * @param alienData the alienData to set
	 */
	public void setAlienData(List<AlienOTO> alienData) {
		this.alienData = alienData;
	}
}

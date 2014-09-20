package com.multunus.aliens.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.multunus.aliens.dao.IAlienRegistrationDAO;
import com.multunus.aliens.dao.oto.AlienOTO;
import com.multunus.aliens.exception.AlienManagementException;

/**
 * This is the Implementation of {@link IAlienRegistrationDAO} to actually
 * interact with database.
 * 
 * This implementation uses Hibernate {@link Hibernate} for Database Operations
 * 
 * @author Jimish
 * 
 */
public class AlienRegistrationDAOImpl implements IAlienRegistrationDAO {

	/**
	 * Hibernate SessionFactory object
	 * 
	 * This will be injected by Spring at Runtime.
	 * 
	 */
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.multunus.aliens.dao.IAlienRegistrationDAO#registerAlien(com.multunus
	 * .aliens.dao.oto.AlienOTO)
	 */
	@Override
	public Integer registerAlien(AlienOTO alienOTO)
			throws AlienManagementException {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(alienOTO);
		tx.commit();
		session.close();
		return alienOTO.getAlienId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.multunus.aliens.dao.IAlienRegistrationDAO#getAlienInfo(java.lang.
	 * Integer)
	 */
	@Override
	public AlienOTO getAlienInfo(Integer alienId)
			throws AlienManagementException {
		Session session = this.sessionFactory.openSession();
		AlienOTO alienOTO = (AlienOTO) session.get(AlienOTO.class, alienId);
		session.close();
		return alienOTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.multunus.aliens.dao.IAlienRegistrationDAO#getAllAliens()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AlienOTO> getAllAliens() throws AlienManagementException {
		Session session = this.sessionFactory.openSession();
		List<AlienOTO> aliensList = session.createQuery("from AlienOTO").list();
		session.close();
		return aliensList;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

package com.multunus.aliens.dao.oto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Entity Class to represent Alien Data
 * 
 * Annotated with Persistence Annotations to be used by Hibernate to Map Data Table
 * 
 * @author Jimish
 *
 */
@Entity
@Table(name = "T_ALIEN")
public class AlienOTO {

	@Column(name = "ALIEN_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int alienId;

	@Column(name = "CODE_NAME")
	private String codeName;

	@Column(name = "BLOOD_COLOR")
	private String bloodColor;

	@Column(name = "ANTENNAS_CNT")
	private Integer antennasCount;

	@Column(name = "LEGS_CNT")
	private Integer legsCount;

	@Column(name = "HOME_PLANET")
	private String homePlanet;

	/**
	 * @return the alienId
	 */
	public int getAlienId() {
		return alienId;
	}

	/**
	 * @param alienId the alienId to set
	 */
	public void setAlienId(int alienId) {
		this.alienId = alienId;
	}

	/**
	 * @return the codeName
	 */
	public String getCodeName() {
		return codeName;
	}

	/**
	 * @param codeName the codeName to set
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	/**
	 * @return the bloodColor
	 */
	public String getBloodColor() {
		return bloodColor;
	}

	/**
	 * @param bloodColor the bloodColor to set
	 */
	public void setBloodColor(String bloodColor) {
		this.bloodColor = bloodColor;
	}

	/**
	 * @return the antennasCount
	 */
	public Integer getAntennasCount() {
		return antennasCount;
	}

	/**
	 * @param antennasCount the antennasCount to set
	 */
	public void setAntennasCount(Integer antennasCount) {
		this.antennasCount = antennasCount;
	}

	/**
	 * @return the legsCount
	 */
	public Integer getLegsCount() {
		return legsCount;
	}

	/**
	 * @param legsCount the legsCount to set
	 */
	public void setLegsCount(Integer legsCount) {
		this.legsCount = legsCount;
	}

	/**
	 * @return the homePlanet
	 */
	public String getHomePlanet() {
		return homePlanet;
	}

	/**
	 * @param homePlanet the homePlanet to set
	 */
	public void setHomePlanet(String homePlanet) {
		this.homePlanet = homePlanet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alienId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlienOTO other = (AlienOTO) obj;
		if (alienId != other.alienId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(30);
		builder.append("AlienOTO [alienId=");
		builder.append(alienId);
		builder.append(", codeName=");
		builder.append(codeName);
		builder.append("]");
		return builder.toString();
	}

}

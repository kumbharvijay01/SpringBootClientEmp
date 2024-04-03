/**
 * 
 */
package com.org.bhfl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 */
@Entity
//@Data
public class CityMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String cityName;

	public CityMaster() {
		super();
	}

	public CityMaster(Long id, String cityName) {
		super();
		this.id = id;
		this.cityName = cityName;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}

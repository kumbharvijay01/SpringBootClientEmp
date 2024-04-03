/**
 * 
 */
package com.org.bhfl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import lombok.Data;

/**
 * 
 */

@Entity
@Table(name = "Emp_Address")
//@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	private String street;

	private String landmarkLocation;

	public Address(Long id, String street, String landmarkLocation) {
		super();
		this.id = id;
		this.street = street;
		this.landmarkLocation = landmarkLocation;
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
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the landmarkLocation
	 */
	public String getLandmarkLocation() {
		return landmarkLocation;
	}

	/**
	 * @param landmarkLocation the landmarkLocation to set
	 */
	public void setLandmarkLocation(String landmarkLocation) {
		this.landmarkLocation = landmarkLocation;
	}

	public Address() {
		super();
	}
	

}

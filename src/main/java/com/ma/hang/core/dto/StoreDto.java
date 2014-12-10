package com.ma.hang.core.dto;

import java.io.Serializable;
import java.util.Date;

import com.ma.hang.core.entities.User;
/**
 * Bean for store 
 */
public class StoreDto implements Serializable{
	
	/**
	 * Generated UID
	 */
	private static final long serialVersionUID = -4597034067105419524L;

	private String storeName;
	
	private String storeDescription;
	
	private String storeAddressFirstLine;

	private String storeAddressSecondLine;

	private float surface;
	
	private Date modifiedAt;

	private Date createdAt;

	private String country;
	
	private String city;
	
	private Integer postCode;
	
	private User user;

	/**
	 * @return store name
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * @param storeName
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * @return store description
	 */
	public String getStoreDescription() {
		return storeDescription;
	}

	/**
	 * @param storeDescription
	 */
	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}

	/**
	 * @return surface
	 */
	public float getSurface() {
		return surface;
	}

	/**
	 * @param surface
	 */
	public void setSurface(float surface) {
		this.surface = surface;
	}

	/**
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return address line 1
	 */
	public String getStoreAddressFirstLine() {
		return storeAddressFirstLine;
	}

	/**
	 * @param storeAddressFirstLine
	 */
	public void setStoreAddressFirstLine(String storeAddressFirstLine) {
		this.storeAddressFirstLine = storeAddressFirstLine;
	}

	/**
	 * @return adresse line 2
	 */
	public String getStoreAddressSecondLine() {
		return storeAddressSecondLine;
	}

	/**
	 * @param storeAddressSecondLine
	 */
	public void setStoreAddressSecondLine(String storeAddressSecondLine) {
		this.storeAddressSecondLine = storeAddressSecondLine;
	}

	/**
	 * @return modification date
	 */
	public Date getModifiedAt() {
		return modifiedAt;
	}

	/**
	 * @param modifiedAt
	 */
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	/**
	 * @return creation date
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return code
	 */
	public Integer getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode
	 */
	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	
	
	
	
}

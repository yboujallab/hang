package com.ma.hang.web.form;

import java.util.Date;

/**
 * @author yboujallab
 *
 */
public class StoreForm {

private String storeName;
	
	private int idStore;

	private String storeDescription;
	
	private String storeAddressFirstLine;

	private String storeAddressSecondLine;

	private String surface;
	
	private Date modifiedAt;

	private Date createdAt;

	private String country;
	
	private String city;
	
	private Integer postCode;
	
	

	/**
	 * @return id strore
	 */
	public int getIdStore() {
		return idStore;
	}

	/**
	 * @param idStore
	 */
	public void setIdStore(int idStore) {
		this.idStore = idStore;
	}

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
	public String getSurface() {
		return surface;
	}

	/**
	 * @param surface
	 */
	public void setSurface(String surface) {
		this.surface = surface;
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

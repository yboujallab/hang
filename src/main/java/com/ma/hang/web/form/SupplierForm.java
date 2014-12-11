package com.ma.hang.web.form;

import java.util.Date;

/**
 * @author yboujallab
 *
 */
public class SupplierForm {


	private int idSupplier;

	private String name;

	private String description;

	private String activity;

	private String address;
	
	private Date modificationDate;

	private Date creationDate;

	private String country;
	
	private String city;
	
	private String postCode;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	
	public int getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}	
    
}

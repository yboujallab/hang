package com.ma.hang.web.form;

import java.util.Date;
import java.util.Map;

/**
 * @author yboujallab
 *
 */
public class ProductForm {
	
	private int idProduct;
	private String name;
	private String description;
	private String qteMin;
	private String capacity;
	private String unity;
	private String boxCapacity;
	private Date modifiedAt;
	private Date createdAt;
	private String idSupplier;
	
	private Map<Integer,String> mapSup;
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
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
	public String getUnity() {
		return unity;
	}
	public void setUnity(String unity) {
		this.unity = unity;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getQteMin() {
		return qteMin;
	}
	public void setQteMin(String qteMin) {
		this.qteMin = qteMin;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getBoxCapacity() {
		return boxCapacity;
	}
	public void setBoxCapacity(String boxCapacity) {
		this.boxCapacity = boxCapacity;
	}
	public String getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(String idSupplier) {
		this.idSupplier = idSupplier;
	}
	public Map<Integer, String> getMapSup() {
		return mapSup;
	}
	public void setMapSup(Map<Integer, String> mapSup) {
		this.mapSup = mapSup;
	}


}
